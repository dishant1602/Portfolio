package com.example.portfolio

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
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
        val clgGraphImg: CardView = view.findViewById(R.id.clgGraphImg)

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
            val clgParentCardAnimator = ObjectAnimator.ofFloat(clgParentCard,"alpha",1f,0f)
            clgParentCardAnimator.addListener(object: AnimatorListenerAdapter() {
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

        clgGraphImg.setOnClickListener{ _->
            val customDialog = CustomDialog(this, images)
            customDialog.show()

        }

        return view
    }

}