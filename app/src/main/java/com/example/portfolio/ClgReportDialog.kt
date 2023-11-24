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

class ClgReportDialog(private val fragment: EducationFragment) : Dialog(fragment.requireContext()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.clg_report_dialog)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window?.setBackgroundDrawable(getDrawable(context, R.drawable.clgreport_background))
        }
        val closeButton: TextView = findViewById(R.id.closeButton)
        val clgReport3: CardView = findViewById(R.id.clgReport3)
        val clgReport4: CardView = findViewById(R.id.clgReport4)
        val clgReport8: CardView = findViewById(R.id.clgReport8)
        val clgReport6: CardView = findViewById(R.id.clgReport6)
        val clgReportDot: CardView = findViewById(R.id.clgReportDot)
        val clgReportPurple3: CardView = findViewById(R.id.clgReportPurple3)
        val clgReportPurple4: CardView = findViewById(R.id.clgReportPurple4)
        val clgReportPurple8: CardView = findViewById(R.id.clgReportPurple8)
        val clgReportPurple6: CardView = findViewById(R.id.clgReportPurple6)
        val clgReportPurpleDot: CardView = findViewById(R.id.clgReportPurpleDot)
        val clgReportChange: CardView = findViewById(R.id.clgReportChange)
        val clgReportChangeTxt: TextView = findViewById(R.id.clgReportChangeText)
        val textView3: TextView = findViewById(R.id.textView3)
        val textView12: TextView = findViewById(R.id.textView12)
        val textView13: TextView = findViewById(R.id.textView13)
        val textView14: TextView = findViewById(R.id.textView14)
        val textView15: TextView = findViewById(R.id.textView15)
        val hurray: LottieAnimationView = findViewById(R.id.hurray)

        clgReportPurple3.visibility = View.GONE
        clgReportPurple4.visibility = View.GONE
        clgReportPurple8.visibility = View.GONE
        clgReportPurpleDot.visibility = View.GONE
        clgReportPurple6.visibility = View.GONE
        textView12.visibility = View.INVISIBLE
        textView13.visibility = View.INVISIBLE
        textView14.visibility = View.INVISIBLE
        textView15.visibility = View.INVISIBLE
        hurray.visibility = View.GONE

        //CGPA Animation on Load

        val clgReportPurple8fadeIn = ObjectAnimator.ofFloat(clgReportPurple8, "alpha",0f,1f)
        clgReportPurple8fadeIn.addListener(object: AnimatorListenerAdapter(){
            override fun onAnimationStart(animation: Animator) {
                clgReport8.visibility = View.GONE
                clgReportPurple8.visibility = View.VISIBLE
                val textView12fadeIn = ObjectAnimator.ofFloat(textView12, "alpha", 0f,1f)
                textView12fadeIn.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator) {
                        textView12.visibility = View.VISIBLE
                    }
                })
                textView12fadeIn.duration=500
                textView12fadeIn.start()

            }

            override fun onAnimationEnd(animation: Animator) {
                clgReportDot.visibility=View.GONE
                val clgReportPurpleDotfadeIn = ObjectAnimator.ofFloat(clgReportPurpleDot,"alpha",0f,1f)
                clgReportPurpleDotfadeIn.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator) {
                        clgReportPurpleDot.visibility = View.VISIBLE
                        val textView13fadeIn = ObjectAnimator.ofFloat(textView13, "alpha", 0f,1f)
                        textView13fadeIn.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationStart(animation: Animator) {
                                textView13.visibility = View.VISIBLE
                            }
                        })
                        textView13fadeIn.duration=500
                        textView13fadeIn.start()
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        clgReportPurple8.visibility=View.INVISIBLE
                        val clgReportPurplefadeInagain = ObjectAnimator.ofFloat(clgReportPurple8,"alpha",0f,1f)
                        clgReportPurplefadeInagain.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationStart(animation: Animator) {
                                clgReportPurple8.visibility=View.VISIBLE
                                val textView14fadeIn = ObjectAnimator.ofFloat(textView14,"alpha",0f,1f)
                                textView14fadeIn.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        textView14.visibility = View.VISIBLE
                                        textView14.text="8"
                                    }

                                    override fun onAnimationEnd(animation: Animator) {
                                        clgReport3.visibility = View.GONE
                                        val clgReportPurple3fadeIn = ObjectAnimator.ofFloat(clgReportPurple3, "alpha",0f,1f)
                                        clgReportPurple3fadeIn.addListener(object: AnimatorListenerAdapter(){
                                            override fun onAnimationStart(animation: Animator) {

                                                clgReportPurple3.visibility = View.VISIBLE
                                                val textView15fadeIn = ObjectAnimator.ofFloat(textView15,"alpha",0f,1f)
                                                textView15fadeIn.addListener(object: AnimatorListenerAdapter(){
                                                    override fun onAnimationStart(animation: Animator) {
                                                        textView15.visibility=View.VISIBLE
                                                        textView15.text="3"
                                                    }

                                                    override fun onAnimationEnd(animation: Animator) {
                                                        hurray.visibility = View.VISIBLE
                                                        hurray.playAnimation()
                                                    }
                                                })
                                                textView15fadeIn.duration=500
                                                textView15fadeIn.start()
                                            }
                                        })
                                        clgReportPurple3fadeIn.duration=500
                                        clgReportPurple3fadeIn.start()
                                    }
                                })
                                textView14fadeIn.duration=500
                                textView14fadeIn.start()
                            }
                        })
                        clgReportPurplefadeInagain.duration=500
                        clgReportPurplefadeInagain.start()
                    }
                })
                clgReportPurpleDotfadeIn.duration=500
                clgReportPurpleDotfadeIn.start()
            }
        })
        clgReportPurple8fadeIn.duration=500
        clgReportPurple8fadeIn.start()

        clgReportChange.setOnClickListener{ _->
            clgReportPurple3.visibility = View.GONE; clgReportPurple4.visibility = View.GONE; clgReportPurple8.visibility = View.GONE; clgReportPurpleDot.visibility = View.GONE; clgReportPurple6.visibility = View.GONE
            textView12.visibility = View.INVISIBLE; textView13.visibility = View.INVISIBLE; textView14.visibility = View.INVISIBLE; textView15.visibility = View.INVISIBLE
            clgReport3.visibility = View.VISIBLE; clgReport4.visibility = View.VISIBLE; clgReport8.visibility = View.VISIBLE; clgReportDot.visibility = View.VISIBLE; clgReport6.visibility = View.VISIBLE
            if(clgReportChangeTxt.text=="CPI"){
                textView3.text="CPI"
                clgReportChangeTxt.text="CGPA"


                val clgReportPurple8fadeIn = ObjectAnimator.ofFloat(clgReportPurple8, "alpha",0f,1f)
                clgReportPurple8fadeIn.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator) {
                        clgReport8.visibility = View.GONE
                        clgReportPurple8.visibility = View.VISIBLE
                        val textView12fadeIn = ObjectAnimator.ofFloat(textView12, "alpha", 0f,1f)
                        textView12fadeIn.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationStart(animation: Animator) {
                                textView12.visibility = View.VISIBLE
                            }
                        })
                        textView12fadeIn.duration=500
                        textView12fadeIn.start()

                    }

                    override fun onAnimationEnd(animation: Animator) {
                        clgReportDot.visibility=View.GONE
                        val clgReportPurpleDotfadeIn = ObjectAnimator.ofFloat(clgReportPurpleDot,"alpha",0f,1f)
                        clgReportPurpleDotfadeIn.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationStart(animation: Animator) {
                                clgReportPurpleDot.visibility = View.VISIBLE
                                val textView13fadeIn = ObjectAnimator.ofFloat(textView13, "alpha", 0f,1f)
                                textView13fadeIn.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        textView13.visibility = View.VISIBLE
                                    }
                                })
                                textView13fadeIn.duration=500
                                textView13fadeIn.start()
                            }

                            override fun onAnimationEnd(animation: Animator) {
                                clgReport4.visibility=View.GONE
                                val clgReportPurple4fadeIn = ObjectAnimator.ofFloat(clgReportPurple4,"alpha",0f,1f)
                                clgReportPurple4fadeIn.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        clgReportPurple4.visibility=View.VISIBLE
                                        val textView14fadeIn = ObjectAnimator.ofFloat(textView14,"alpha",0f,1f)
                                        textView14fadeIn.addListener(object: AnimatorListenerAdapter(){
                                            override fun onAnimationStart(animation: Animator) {
                                                textView14.visibility = View.VISIBLE
                                                textView14.text="4"
                                            }

                                            override fun onAnimationEnd(animation: Animator) {
                                                clgReport6.visibility = View.GONE
                                                val clgReportPurple6fadeIn = ObjectAnimator.ofFloat(clgReportPurple6, "alpha",0f,1f)
                                                clgReportPurple6fadeIn.addListener(object: AnimatorListenerAdapter(){
                                                    override fun onAnimationStart(animation: Animator) {

                                                        clgReportPurple6.visibility = View.VISIBLE
                                                        val textView15fadeIn = ObjectAnimator.ofFloat(textView15,"alpha",0f,1f)
                                                        textView15fadeIn.addListener(object: AnimatorListenerAdapter(){
                                                            override fun onAnimationStart(animation: Animator) {
                                                                textView15.visibility=View.VISIBLE
                                                                textView15.text="6"
                                                            }

                                                            override fun onAnimationEnd(animation: Animator) {
                                                                hurray.playAnimation()
                                                            }
                                                        })
                                                        textView15fadeIn.duration=500
                                                        textView15fadeIn.start()
                                                    }
                                                })
                                                clgReportPurple6fadeIn.duration=500
                                                clgReportPurple6fadeIn.start()
                                            }
                                        })
                                        textView14fadeIn.duration=500
                                        textView14fadeIn.start()
                                    }
                                })
                                clgReportPurple4fadeIn.duration=500
                                clgReportPurple4fadeIn.start()
                            }
                        })
                        clgReportPurpleDotfadeIn.duration=500
                        clgReportPurpleDotfadeIn.start()
                    }
                })
                clgReportPurple8fadeIn.duration=500
                clgReportPurple8fadeIn.start()
            }
            else{
                textView3.text="CGPA"
                clgReportChangeTxt.text="CPI"

                val clgReportPurple8fadeIn = ObjectAnimator.ofFloat(clgReportPurple8, "alpha",0f,1f)
                clgReportPurple8fadeIn.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator) {
                        clgReport8.visibility = View.GONE
                        clgReportPurple8.visibility = View.VISIBLE
                        val textView12fadeIn = ObjectAnimator.ofFloat(textView12, "alpha", 0f,1f)
                        textView12fadeIn.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationStart(animation: Animator) {
                                textView12.visibility = View.VISIBLE
                            }
                        })
                        textView12fadeIn.duration=500
                        textView12fadeIn.start()

                    }

                    override fun onAnimationEnd(animation: Animator) {
                        clgReportDot.visibility=View.GONE
                        val clgReportPurpleDotfadeIn = ObjectAnimator.ofFloat(clgReportPurpleDot,"alpha",0f,1f)
                        clgReportPurpleDotfadeIn.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationStart(animation: Animator) {
                                clgReportPurpleDot.visibility = View.VISIBLE
                                val textView13fadeIn = ObjectAnimator.ofFloat(textView13, "alpha", 0f,1f)
                                textView13fadeIn.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        textView13.visibility = View.VISIBLE
                                    }
                                })
                                textView13fadeIn.duration=500
                                textView13fadeIn.start()
                            }

                            override fun onAnimationEnd(animation: Animator) {
                                clgReportPurple8.visibility=View.INVISIBLE
                                val clgReportPurplefadeInagain = ObjectAnimator.ofFloat(clgReportPurple8,"alpha",0f,1f)
                                clgReportPurplefadeInagain.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        clgReportPurple8.visibility=View.VISIBLE
                                        val textView14fadeIn = ObjectAnimator.ofFloat(textView14,"alpha",0f,1f)
                                        textView14fadeIn.addListener(object: AnimatorListenerAdapter(){
                                            override fun onAnimationStart(animation: Animator) {
                                                textView14.visibility = View.VISIBLE
                                                textView14.text="8"
                                            }

                                            override fun onAnimationEnd(animation: Animator) {
                                                clgReport3.visibility = View.GONE
                                                val clgReportPurple3fadeIn = ObjectAnimator.ofFloat(clgReportPurple3, "alpha",0f,1f)
                                                clgReportPurple3fadeIn.addListener(object: AnimatorListenerAdapter(){
                                                    override fun onAnimationStart(animation: Animator) {

                                                        clgReportPurple3.visibility = View.VISIBLE
                                                        val textView15fadeIn = ObjectAnimator.ofFloat(textView15,"alpha",0f,1f)
                                                        textView15fadeIn.addListener(object: AnimatorListenerAdapter(){
                                                            override fun onAnimationStart(animation: Animator) {
                                                                textView15.visibility=View.VISIBLE
                                                                textView15.text="3"
                                                            }

                                                            override fun onAnimationEnd(animation: Animator) {
                                                                hurray.playAnimation()
                                                            }
                                                        })
                                                        textView15fadeIn.duration=500
                                                        textView15fadeIn.start()
                                                    }
                                                })
                                                clgReportPurple3fadeIn.duration=500
                                                clgReportPurple3fadeIn.start()
                                            }
                                        })
                                        textView14fadeIn.duration=500
                                        textView14fadeIn.start()
                                    }
                                })
                                clgReportPurplefadeInagain.duration=500
                                clgReportPurplefadeInagain.start()
                            }
                        })
                        clgReportPurpleDotfadeIn.duration=500
                        clgReportPurpleDotfadeIn.start()
                    }
                })
                clgReportPurple8fadeIn.duration=500
                clgReportPurple8fadeIn.start()


            }
        }

        setCancelable(false)
        val text = "<u>Close</u>"
        closeButton.text = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)

        closeButton.setOnClickListener { _->
            dismiss()
        }
    }


}