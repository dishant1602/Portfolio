package com.example.portfolio

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView


class EducationFragment : Fragment() {

    private val images = listOf(
        R.drawable.semester1,
        R.drawable.semester2,
        R.drawable.semester3,
        R.drawable.semester4,
        R.drawable.semester5,
        R.drawable.semester6,
        R.drawable.semester7,
        R.drawable.semester8
        // Add more image resources as needed
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_education, container, false)

        val clgParentCard: CardView = view.findViewById(R.id.clgParentCard)
        val clgParentIcon: ImageView = view.findViewById(R.id.clgParentIcon)
        val twelveParentCard: CardView = view.findViewById(R.id.twelveParentCard)
        val twelveParentIcon: ImageView = view.findViewById(R.id.twelveParentIcon)
        val tenParentCard: CardView = view.findViewById(R.id.tenParentCard)
        val tenParentIcon: ImageView = view.findViewById(R.id.tenParentIcon)
        val clgChildCard: CardView = view.findViewById(R.id.clgChildCard)
        val twelveChildCard: CardView = view.findViewById(R.id.twelveChildCard)
        val tenChildCard: CardView = view.findViewById(R.id.tenChildCard)
        val clgGraphImg: CardView = view.findViewById(R.id.clgGraphImg)
        val twelveGraphImg: CardView = view.findViewById(R.id.twelveGraphImg)
        val tenGraphImg: CardView = view.findViewById(R.id.tenGraphImg)
        val clgReportImg: CardView = view.findViewById(R.id.clgReportImg)
        val twelveReportImg: CardView = view.findViewById(R.id.twelveReportImg)
        val tenReportImg: CardView = view.findViewById(R.id.tenReportImg)
        var clgParentClicked = false
        var twelveParentClicked=false
        var tenParentClicked=false

        clgParentCard.visibility = View.INVISIBLE
        twelveParentCard.visibility = View.INVISIBLE
        tenParentCard.visibility = View.INVISIBLE

        val clgParentCardslide = ObjectAnimator.ofFloat(clgParentCard, "translationX", -1500f, 0f)
        clgParentCardslide.addListener(object: AnimatorListenerAdapter(){
            override fun onAnimationStart(animation: Animator) {
                clgParentCard.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animator) {
                val twelveParentCardslide = ObjectAnimator.ofFloat(twelveParentCard, "translationX", -1500f, 0f)
                twelveParentCardslide.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator) {
                        twelveParentCard.visibility = View.VISIBLE
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        val tenParentCardslide = ObjectAnimator.ofFloat(tenParentCard, "translationX", -1500f, 0f)
                        tenParentCardslide.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationStart(animation: Animator) {
                                tenParentCard.visibility = View.VISIBLE
                            }
                        })
                        tenParentCardslide.start()
                    }
                })
                twelveParentCardslide.start()
            }
        })
        clgParentCardslide.start()
//
//        //Animation for CardViews
//        val sequence = AnimatorSet()
//        val clgParentCardslide = ObjectAnimator.ofFloat(clgParentCard, "translationX", -1500f, 0f)
//        val twelveParentCardslide = ObjectAnimator.ofFloat(twelveParentCard, "translationX", -1500f, 0f)
//        val tenParentCardslide = ObjectAnimator.ofFloat(tenParentCard, "translationX", -1500f, 0f)
//        sequence.playSequentially(clgParentCardslide, twelveParentCardslide, tenParentCardslide)
//        sequence.start()


        clgParentIcon.setOnClickListener{ _->
            clgParentClicked = true
            val clgParentCardAnimator = ObjectAnimator.ofFloat(clgParentCard,"alpha",1f,0f)
            clgParentCardAnimator.addListener(object: AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator) {
                    if(twelveParentClicked){
                        val twelveChildCardAnimator = ObjectAnimator.ofFloat(twelveChildCard,"alpha",1f,0f)
                        twelveChildCardAnimator.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationEnd(animation: Animator) {
                                twelveChildCard.visibility = View.GONE
                                val twelveParentCardAnimator = ObjectAnimator.ofFloat(twelveParentCard,"alpha",0f,1f)
                                twelveParentCardAnimator.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        twelveParentCard.visibility = View.VISIBLE
                                    }
                                })
                                twelveParentCardAnimator.duration=1000
                                twelveParentCardAnimator.start()
                            }
                        })
                        twelveChildCardAnimator.duration=1000
                        twelveChildCardAnimator.start()

                        twelveParentClicked = false

                    }

                    if(tenParentClicked){
                        val tenChildCardAnimator = ObjectAnimator.ofFloat(tenChildCard,"alpha",1f,0f)
                        tenChildCardAnimator.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationEnd(animation: Animator) {
                                tenChildCard.visibility = View.GONE
                                val tenParentCardAnimator = ObjectAnimator.ofFloat(tenParentCard,"alpha",0f,1f)
                                tenParentCardAnimator.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        tenParentCard.visibility = View.VISIBLE
                                    }
                                })
                                tenParentCardAnimator.duration=1000
                                tenParentCardAnimator.start()
                            }
                        })
                        tenChildCardAnimator.duration=1000
                        tenChildCardAnimator.start()

                        tenParentClicked = false

                    }
                }
                override fun onAnimationEnd(animation: Animator) {
                    clgParentCard.visibility = View.GONE
                    val clgChildCardAnimator = ObjectAnimator.ofFloat(clgChildCard,"alpha",0f,1f)
                    clgChildCardAnimator.addListener(object: AnimatorListenerAdapter()
                    {
                        override fun onAnimationStart(animation: Animator) {
                            clgChildCard.visibility = View.VISIBLE
                        }
                    })
                    clgChildCardAnimator.duration=1000
                    clgChildCardAnimator.start()

                }
            })
            clgParentCardAnimator.duration = 1000
            clgParentCardAnimator.start()
        }

        twelveParentIcon.setOnClickListener { _->
            twelveParentClicked = true
            val twelveParentCardAnimator = ObjectAnimator.ofFloat(twelveParentCard,"alpha",1f,0f)
            twelveParentCardAnimator.addListener(object: AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator) {
                    if(tenParentClicked){
                        val tenChildCardAnimator = ObjectAnimator.ofFloat(tenChildCard,"alpha",1f,0f)
                        tenChildCardAnimator.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationEnd(animation: Animator) {
                                tenChildCard.visibility = View.GONE
                                val tenParentCardAnimator = ObjectAnimator.ofFloat(tenParentCard,"alpha",0f,1f)
                                tenParentCardAnimator.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        tenParentCard.visibility = View.VISIBLE
                                    }
                                })
                                tenParentCardAnimator.duration=1000
                                tenParentCardAnimator.start()
                            }
                        })
                        tenChildCardAnimator.duration=1000
                        tenChildCardAnimator.start()

                        tenParentClicked = false

                    }

                    if(clgParentClicked){
                        val clgChildCardAnimator = ObjectAnimator.ofFloat(clgChildCard,"alpha",1f,0f)
                        clgChildCardAnimator.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationEnd(animation: Animator) {
                                clgChildCard.visibility = View.GONE
                                val clgParentCardAnimator = ObjectAnimator.ofFloat(clgParentCard,"alpha",0f,1f)
                                clgParentCardAnimator.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        clgParentCard.visibility = View.VISIBLE
                                    }
                                })
                                clgParentCardAnimator.duration=1000
                                clgParentCardAnimator.start()
                            }
                        })
                        clgChildCardAnimator.duration=1000
                        clgChildCardAnimator.start()

                        clgParentClicked = false

                    }
                }
                override fun onAnimationEnd(animation: Animator) {
                    twelveParentCard.visibility = View.GONE
                    val twelveChildCardAnimator = ObjectAnimator.ofFloat(twelveChildCard,"alpha",0f,1f)
                    twelveChildCardAnimator.addListener(object: AnimatorListenerAdapter()
                    {
                        override fun onAnimationStart(animation: Animator) {
                            twelveChildCard.visibility = View.VISIBLE
                        }
                    })
                    twelveChildCardAnimator.duration=1000
                    twelveChildCardAnimator.start()

                }
            })
            twelveParentCardAnimator.duration = 1000
            twelveParentCardAnimator.start()
        }

        tenParentIcon.setOnClickListener{ _->
            tenParentClicked = true
            val tenParentCardAnimator = ObjectAnimator.ofFloat(tenParentCard,"alpha",1f,0f)
            tenParentCardAnimator.addListener(object: AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator) {
                    if(twelveParentClicked){
                        val twelveChildCardAnimator = ObjectAnimator.ofFloat(twelveChildCard,"alpha",1f,0f)
                        twelveChildCardAnimator.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationEnd(animation: Animator) {
                                twelveChildCard.visibility = View.GONE
                                val twelveParentCardAnimator = ObjectAnimator.ofFloat(twelveParentCard,"alpha",0f,1f)
                                twelveParentCardAnimator.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        twelveParentCard.visibility = View.VISIBLE
                                    }
                                })
                                twelveParentCardAnimator.duration=1000
                                twelveParentCardAnimator.start()
                            }
                        })
                        twelveChildCardAnimator.duration=1000
                        twelveChildCardAnimator.start()

                        twelveParentClicked = false

                    }

                    if(clgParentClicked){
                        val clgChildCardAnimator = ObjectAnimator.ofFloat(clgChildCard,"alpha",1f,0f)
                        clgChildCardAnimator.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationEnd(animation: Animator) {
                                clgChildCard.visibility = View.GONE
                                val clgParentCardAnimator = ObjectAnimator.ofFloat(clgParentCard,"alpha",0f,1f)
                                clgParentCardAnimator.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        clgParentCard.visibility = View.VISIBLE
                                    }
                                })
                                clgParentCardAnimator.duration=1000
                                clgParentCardAnimator.start()
                            }
                        })
                        clgChildCardAnimator.duration=1000
                        clgChildCardAnimator.start()

                        clgParentClicked = false

                    }
                }
                override fun onAnimationEnd(animation: Animator) {
                    tenParentCard.visibility = View.GONE
                    val tenChildCardAnimator = ObjectAnimator.ofFloat(tenChildCard,"alpha",0f,1f)
                    tenChildCardAnimator.addListener(object: AnimatorListenerAdapter()
                    {
                        override fun onAnimationStart(animation: Animator) {
                            tenChildCard.visibility = View.VISIBLE
                        }
                    })
                    tenChildCardAnimator.duration=1000
                    tenChildCardAnimator.start()

                }
            })
            tenParentCardAnimator.duration = 1000
            tenParentCardAnimator.start()
        }

        clgGraphImg.setOnClickListener{ _->
            val clgGraphDialog = ClgGraphDialog(this, images)
            clgGraphDialog.show()

        }

        clgReportImg.setOnClickListener{ _->
            val clgReportDialog = ClgReportDialog(this)
            clgReportDialog.show()
        }

        twelveGraphImg.setOnClickListener{ _->
            val twelveGraphDialog = twelveGraphDialog(this)
            twelveGraphDialog.show()
        }

        twelveReportImg.setOnClickListener { _->
            val twelveReportDialog = twelveReportDialog(this)
            twelveReportDialog.show()
        }

        return view
    }

}