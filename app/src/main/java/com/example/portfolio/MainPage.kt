package com.example.portfolio

import android.content.ContentValues
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.airbnb.lottie.LottieAnimationView
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MainPage : AppCompatActivity() {

    var PDF_FILE_NAME = "dishantsakhidaCV.pdf"
    var REQUEST_WRITE_STORAGE = 112
    lateinit var imageView4 : ImageView; lateinit var cvdownload: ImageView; lateinit var imageskills: ImageView; lateinit var imageabout: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        imageView4 = findViewById<ImageView>(R.id.imageView4)
        cvdownload = findViewById<ImageView>(R.id.cvdownload)

        //These are Horizontal View Images at bottom of screen
        //-------------------------------------------------------
        imageskills = findViewById<ImageView>(R.id.imageskills)
        imageabout = findViewById<ImageView>(R.id.imageabout)
        imageabout.visibility = View.GONE
        //--------------------------------------------------------

        // About Me TextView
        //--------------------------------------------------------------
        var skill1 : TextView = findViewById<TextView>(R.id.skill1)
        var skill2: TextView = findViewById<TextView>(R.id.skill2)
        var skill3: TextView = findViewById<TextView>(R.id.skill3)
        var motog: TextView = findViewById<TextView>(R.id.motog)
        var textView14: TextView = findViewById<TextView>(R.id.textView14)
        var glowingText: TextView = findViewById<TextView>(R.id.glowingText)
        var textView15: TextView = findViewById<TextView>(R.id.textView15)

        var aboutmeTextView = ArrayList<TextView>()
        aboutmeTextView.add(skill1)
        aboutmeTextView.add(skill2)
        aboutmeTextView.add(skill3)
        aboutmeTextView.add(motog)
        aboutmeTextView.add(textView14)
        aboutmeTextView.add(glowingText)
        aboutmeTextView.add(textView15)
        //---------------------------------------------------------------

        //About Me LottieAnimations
        //-----------------------------------------------------------------------------------
        var linebottom: LottieAnimationView = findViewById(R.id.linebottom)
        var ofgreen : LottieAnimationView = findViewById(R.id.ofgreen)

        var aboutmeLottie = ArrayList<LottieAnimationView>()
        aboutmeLottie.add(linebottom)
        aboutmeLottie.add(ofgreen)
        //------------------------------------------------------------------------------------

        //Skills CardView
        //------------------------------------------------------------
        var skillsAndroid: CardView = findViewById<CardView>(R.id.skillsAndroid)
        var skillsJava : CardView = findViewById<CardView>(R.id.skillsJava)
        var skillsKotlin: CardView = findViewById<CardView>(R.id.skillsKotlin)
        var skillsPython: CardView = findViewById<CardView>(R.id.skillsPython)
        var skillsDotnet: CardView = findViewById<CardView>(R.id.skillsDotnet)
        var skillsFirebase: CardView = findViewById<CardView>(R.id.skillsFirebase)

        var skillsCard = ArrayList<CardView>()
        skillsCard.add(skillsAndroid)
        skillsCard.add(skillsJava)
        skillsCard.add(skillsKotlin)
        skillsCard.add(skillsFirebase)
        skillsCard.add(skillsDotnet)
        skillsCard.add(skillsPython)
        //-------------------------------------------------------------

        //Skills Lottie
        //------------------------------------------------------------------------------------------
        var androidLoading: LottieAnimationView = findViewById<LottieAnimationView>(R.id.androidLoading)
        var javaLoading: LottieAnimationView = findViewById<LottieAnimationView>(R.id.javaLoading)
        var kotlinLoading: LottieAnimationView = findViewById<LottieAnimationView>(R.id.kotlinLoading)
        var pythonLoading: LottieAnimationView = findViewById<LottieAnimationView>(R.id.pythonLoading)
        var firebaseLoading: LottieAnimationView = findViewById<LottieAnimationView>(R.id.firebaseLoading)
        var dotnetLoading: LottieAnimationView = findViewById<LottieAnimationView>(R.id.dotnetLoading)
        //---------------------------------------------------------------------------------------------

        cvdownload.setOnClickListener { view->
            downloadPdf()
        }

        imageskills.setOnClickListener { view->
            thingstoHideTextView(aboutmeTextView)
            thingstoHideLottieView(aboutmeLottie)
            thingstoShowCardView(skillsCard)
            imageskills.visibility = View.GONE
            imageabout.visibility = View.VISIBLE
            imageView4.setImageResource(R.drawable.skillblue)
            androidLoading.setMinAndMaxProgress(0f, 0.8f)
            androidLoading.playAnimation()

            javaLoading.setMinAndMaxProgress(0f, 0.75f)
            javaLoading.playAnimation()

            kotlinLoading.setMinAndMaxProgress(0f, 0.5f)
            kotlinLoading.playAnimation()

            pythonLoading.setMinAndMaxProgress(0f, 0.5f)
            pythonLoading.playAnimation()

            firebaseLoading.setMinAndMaxProgress(0f, 0.5f)
            firebaseLoading.playAnimation()

            dotnetLoading.setMinAndMaxProgress(0f, 0.5f)
            dotnetLoading.playAnimation()


        }

        imageabout.setOnClickListener { view->
            imageabout.visibility = View.GONE
            imageskills.visibility = View.VISIBLE
            thingstoHideCardView(skillsCard);
            thingstoShowTextView(aboutmeTextView);
            thingstoShowLottieView(aboutmeLottie);
            imageView4.setImageResource(R.drawable.skillblue)
        }
    }

    private fun downloadPdf(): Unit
    {
        var pdfFile: File = File(getExternalFilesDir(null), PDF_FILE_NAME)
        try {
            val `in` = assets.open(PDF_FILE_NAME)
            val out: OutputStream = FileOutputStream(pdfFile)
            val buffer = ByteArray(1024)
            var read: Int
            while (`in`.read(buffer).also { read = it } != -1) {
                out.write(buffer, 0, read)
            }
            `in`.close()
            out.flush()
            out.close()

            // Add the file to MediaStore to make it visible to other apps (Android Q and above)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val contentResolver = contentResolver
                val contentValues = ContentValues()
                contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, PDF_FILE_NAME)
                contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf")
                contentValues.put(
                    MediaStore.MediaColumns.RELATIVE_PATH,
                    Environment.DIRECTORY_DOWNLOADS
                )
                val uri = contentResolver.insert(
                    MediaStore.Downloads.EXTERNAL_CONTENT_URI,
                    contentValues
                )
                if (uri != null) {
                    val outputStream = contentResolver.openOutputStream(uri)
                    if (outputStream != null) {
                        val in2: InputStream = FileInputStream(pdfFile)
                        val buffer2 = ByteArray(1024)
                        var read2: Int
                        while (in2.read(buffer2).also { read2 = it } != -1) {
                            outputStream.write(buffer2, 0, read2)
                        }
                        in2.close()
                        outputStream.close()
                    }
                }
            }
            val s = "File: '" + PDF_FILE_NAME + "' downloaded into Downloads folder"
            Toast.makeText(this, s, Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Failed to download PDF", Toast.LENGTH_SHORT).show()
        }
    }

    fun thingstoHideTextView(a:ArrayList<TextView>):Unit{
        for (i in a.indices) {
            a[i].visibility = View.GONE
        }
    }

    fun thingstoShowTextView(a: ArrayList<TextView>):Unit{
        for(i in a.indices)
        {
            a[i].visibility = View.VISIBLE
        }
    }

    fun thingstoHideLottieView(a: ArrayList<LottieAnimationView>):Unit
    {
        for(i in a.indices)
        {
            a[i].visibility = View.GONE
        }
    }

    fun thingstoShowLottieView(a: ArrayList<LottieAnimationView>):Unit {
        for (i in a.indices) {
            a[i].visibility = View.VISIBLE
        }
    }

    fun thingstoHideCardView(a: ArrayList<CardView>):Unit {
        for (i in a.indices) {
            a[i].visibility = View.GONE
        }
    }

    fun thingstoShowCardView(a: java.util.ArrayList<CardView>) {
        for (i in a.indices) {
            a[i].visibility = View.VISIBLE
        }
    }
}