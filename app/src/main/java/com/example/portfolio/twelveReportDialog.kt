package com.example.portfolio

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.cardview.widget.CardView
import com.airbnb.lottie.LottieAnimationView

class twelveReportDialog(private val fragment: EducationFragment) : Dialog(fragment.requireContext()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.twelve_report_dialog)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window?.setBackgroundDrawable(getDrawable(context, R.drawable.clgreport_background))
        }
        val closeButton: TextView = findViewById(R.id.closeButton)
        val twelveReport3: CardView = findViewById(R.id.twelveReport3)
        val twelveReport7: CardView = findViewById(R.id.twelveReport7)
        val twelveReport8: CardView = findViewById(R.id.twelveReport8)
        val twelveReportDot: CardView = findViewById(R.id.twelveReportDot)
        val twelveReportPercentage: CardView = findViewById(R.id.twelveReportPercentage)
        val twelveReportPurple3: CardView = findViewById(R.id.twelveReportPurple3)
        val twelveReportPurple7: CardView = findViewById(R.id.twelveReportPurple7)
        val twelveReportPurple8: CardView = findViewById(R.id.twelveReportPurple8)
        val twelveReportPurpleDot: CardView = findViewById(R.id.twelveReportPurpleDot)
        val twelveReportPurplePercentage: CardView = findViewById(R.id.twelveReportPurplePercentage)
        val textView3: TextView = findViewById(R.id.textView3)
        val textView12: TextView = findViewById(R.id.textView12)
        val textView13: TextView = findViewById(R.id.textView13)
        val textView14: TextView = findViewById(R.id.textView14)
        val textView15: TextView = findViewById(R.id.textView15)
        val hurray: LottieAnimationView = findViewById(R.id.hurray)
        val cardView7: CardView = findViewById(R.id.cardView7)
        val cardView8: CardView = findViewById(R.id.cardView8)
        val cardViewDot: CardView = findViewById(R.id.cardViewDot)
        val cardView3: CardView = findViewById(R.id.cardView3)
        val cardViewPer: CardView = findViewById(R.id.cardViewPer)
        val cardViewFinal: CardView = findViewById(R.id.cardViewFinal)

        twelveReportPurple3.visibility = View.GONE
        twelveReportPurple7.visibility = View.GONE
        twelveReportPurple8.visibility = View.GONE
        twelveReportPurpleDot.visibility = View.GONE
        twelveReportPurplePercentage.visibility = View.GONE
        textView3.visibility = View.INVISIBLE
        textView12.visibility = View.INVISIBLE
        textView13.visibility = View.INVISIBLE
        textView14.visibility = View.INVISIBLE
        textView15.visibility = View.INVISIBLE
        hurray.visibility = View.GONE

        //% Animation on Load
        twelveReport7.visibility = View.GONE
        val twelveReportPurple7fadeIn = ObjectAnimator.ofFloat(twelveReportPurple7,"alpha",0f,1f)
        twelveReportPurple7fadeIn.addListener(object: AnimatorListenerAdapter(){
            override fun onAnimationStart(animation: Animator) {
                twelveReportPurple7.visibility = View.VISIBLE
                val textView3fadeIn = ObjectAnimator.ofFloat(textView3,"alpha",0f,1f)
                textView3fadeIn.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator) {
                        textView3.visibility = View.VISIBLE
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        twelveReport8.visibility = View.GONE
                        val twelveReportPurple8FadeIn = ObjectAnimator.ofFloat(twelveReportPurple8,"alpha",0f,1f)
                        twelveReportPurple8FadeIn.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationStart(animation: Animator) {
                                twelveReportPurple8.visibility = View.VISIBLE
                                val textView12fadeIn = ObjectAnimator.ofFloat(textView12,"alpha",0f,1f)
                                textView12fadeIn.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        textView12.visibility = View.VISIBLE
                                    }

                                    override fun onAnimationEnd(animation: Animator) {
                                        twelveReportDot.visibility = View.GONE
                                        val twelveReportDotfadeIn = ObjectAnimator.ofFloat(twelveReportDot,"alpha",0f,1f)
                                        twelveReportDotfadeIn.addListener(object: AnimatorListenerAdapter(){
                                            override fun onAnimationStart(animation: Animator) {
                                                twelveReportPurpleDot.visibility = View.VISIBLE
                                                val textView13fadeIn = ObjectAnimator.ofFloat(textView13,"alpha",0f,1f)
                                                textView13fadeIn.addListener(object: AnimatorListenerAdapter(){
                                                    override fun onAnimationStart(animation: Animator) {
                                                        textView13.visibility = View.VISIBLE
                                                    }

                                                    override fun onAnimationEnd(animation: Animator) {
                                                        twelveReport3.visibility=View.GONE
                                                        val twelveReportPurple3fadeIn = ObjectAnimator.ofFloat(twelveReportPurple3,"alpha",0f,1f)
                                                        twelveReportPurple3fadeIn.addListener(object: AnimatorListenerAdapter(){
                                                            override fun onAnimationStart(animation: Animator) {
                                                                twelveReportPurple3.visibility = View.VISIBLE
                                                                val textView14fadeIn = ObjectAnimator.ofFloat(textView14,"alpha",0f,1f)
                                                                textView14fadeIn.addListener(object: AnimatorListenerAdapter(){
                                                                    override fun onAnimationStart(animation: Animator) {
                                                                        textView14.visibility = View.VISIBLE
                                                                    }

                                                                    override fun onAnimationEnd(
                                                                        animation: Animator
                                                                    ) {
                                                                        twelveReportPercentage.visibility = View.GONE
                                                                        val twelveReportPercentagePurpleFadeIn = ObjectAnimator.ofFloat(twelveReportPurplePercentage,"alpha",0f,1f)
                                                                        twelveReportPercentagePurpleFadeIn.addListener(object: AnimatorListenerAdapter(){
                                                                            override fun onAnimationStart(
                                                                                animation: Animator
                                                                            ) {
                                                                                twelveReportPurplePercentage.visibility = View.VISIBLE
                                                                                val textView15fadeIn = ObjectAnimator.ofFloat(textView15,"alpha",0f,1f)
                                                                                textView15fadeIn.addListener(object: AnimatorListenerAdapter(){
                                                                                    override fun onAnimationStart(
                                                                                        animation: Animator
                                                                                    ) {
                                                                                        textView15.visibility = View.VISIBLE
                                                                                    }

                                                                                    override fun onAnimationEnd(
                                                                                        animation: Animator
                                                                                    ) {
                                                                                        cardView7.visibility = View.GONE
                                                                                        cardView8.visibility = View.GONE
                                                                                        cardViewDot.visibility = View.GONE
                                                                                        cardView3.visibility = View.GONE
                                                                                        cardViewPer.visibility = View.GONE
                                                                                        cardViewFinal.visibility = View.VISIBLE

                                                                                    }
                                                                                })
                                                                                textView15fadeIn.duration=500
                                                                                textView15fadeIn.start()
                                                                            }
                                                                        })
                                                                        twelveReportPercentagePurpleFadeIn.duration=500
                                                                        twelveReportPercentagePurpleFadeIn.start()
                                                                    }
                                                                })
                                                                textView14fadeIn.duration=500
                                                                textView14fadeIn.start()
                                                            }
                                                        })
                                                        twelveReportPurple3fadeIn.duration=500
                                                        twelveReportPurple3fadeIn.start()
                                                    }
                                                })
                                                textView13fadeIn.duration=500
                                                textView13fadeIn.start()
                                            }
                                        })
                                        twelveReportDotfadeIn.duration=500
                                        twelveReportDotfadeIn.start()
                                    }
                                })
                                textView12fadeIn.duration=500
                                textView12fadeIn.start()
                            }
                        })
                        twelveReportPurple8FadeIn.duration=500
                        twelveReportPurple8FadeIn.start()
                    }
                })
                textView3fadeIn.duration=500
                textView3fadeIn.start()
            }
        })
        twelveReportPurple7fadeIn.duration=500
        twelveReportPurple7fadeIn.start()


        setCancelable(false)
        val text = "<u>Close</u>"
        closeButton.text = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)

        closeButton.setOnClickListener { _->
            dismiss()
        }
    }


}