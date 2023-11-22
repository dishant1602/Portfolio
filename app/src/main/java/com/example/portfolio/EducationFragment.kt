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

        //Animation for CardViews
        val sequence = AnimatorSet()
        val clgParentCardslide = ObjectAnimator.ofFloat(clgParentCard, "translationX", -1500f, 0f)
        val twelveParentCardslide = ObjectAnimator.ofFloat(twelveParentCard, "translationX", -1500f, 0f)
        val tenParentCardslide = ObjectAnimator.ofFloat(tenParentCard, "translationX", -1500f, 0f)
        sequence.playSequentially(clgParentCardslide, twelveParentCardslide, tenParentCardslide)
        sequence.start()


        clgParentIcon.setOnClickListener{ _->
            val clgParentCardAnimator = ObjectAnimator.ofFloat(clgParentCard,"alpha",1f,0f)
            clgParentCardAnimator.addListener(object: AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    clgParentCard.visibility = View.GONE
                }
            })
            clgParentCardAnimator.duration = 1000
            clgParentCardAnimator.start()
        }

        return view
    }

}