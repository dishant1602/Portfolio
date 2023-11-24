package com.example.portfolio

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager
class ClgGraphDialog(private val fragment: EducationFragment, private val images: List<Int>) : Dialog(fragment.requireContext()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.clg_graph_dialog)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window?.setBackgroundDrawable(getDrawable(context, R.drawable.clggraph_background))
        }

        val viewPager: ViewPager = findViewById(R.id.dialogViewPager)
        val btnPrevious: CardView = findViewById(R.id.clgReport4)
        val btnNext: CardView = findViewById(R.id.dialogBtnNext)
        val closeButton: TextView = findViewById(R.id.closeButton)

        btnPrevious.visibility = View.INVISIBLE

        setCancelable(false)
        val text = "<u>Close</u>"
        closeButton.text = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)

        closeButton.setOnClickListener { _->
            dismiss()
        }

        val adapter = ImagePagerAdapter(context, images)
        viewPager.adapter = adapter

        btnPrevious.setOnClickListener {
            Log.d("helltest",viewPager.currentItem.toString())
            if(viewPager.currentItem==1){
                btnPrevious.visibility = View.INVISIBLE
            }
            if(viewPager.currentItem==7){
                btnNext.visibility = View.VISIBLE
            }
            if (viewPager.currentItem > 0) {
                viewPager.currentItem = viewPager.currentItem - 1

            }

        }

        btnNext.setOnClickListener {
            Log.d("welltest",viewPager.currentItem.toString())
            if (viewPager.currentItem < images.size - 1) {
                viewPager.currentItem = viewPager.currentItem + 1
            }
            if(viewPager.currentItem==1){
                btnPrevious.visibility = View.VISIBLE
            }
            if(viewPager.currentItem==7){
                btnNext.visibility = View.INVISIBLE
            }
        }
    }


}