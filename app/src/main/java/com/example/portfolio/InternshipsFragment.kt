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
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat


class InternshipsFragment : Fragment() {


    var count=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_internships, container, false)

        val samyakParentCard: CardView = view.findViewById(R.id.samyakParentCard)
        val samyakParentIcon: ImageView = view.findViewById(R.id.samyakParentIcon)
        val samyakName: TextView = view.findViewById(R.id.samyakName)
        val samyakRole: TextView = view.findViewById(R.id.samyakRole)
        val samyakChildCard: CardView = view.findViewById(R.id.samyakChildCard)

        samyakChildCard.visibility = View.GONE

        samyakParentCard.setOnClickListener{ _->
            count+=1
            if(count%2!=0){
                var color = "#8c7ce2"
                val colorInt = android.graphics.Color.parseColor(color)
                samyakParentCard.setCardBackgroundColor(colorInt)
                samyakParentIcon.setImageResource(R.drawable.chevron_upwhite)
                samyakName.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.white))
                samyakRole.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.white))
                val samyakChildCardslidein = ObjectAnimator.ofFloat(samyakChildCard,"translationY",-600f,0f)
                samyakChildCardslidein.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator) {
                        samyakChildCard.visibility = View.VISIBLE
                    }
                })
                samyakChildCardslidein.duration=500
                samyakChildCardslidein.start()
            }
            else{
                samyakParentCard.setCardBackgroundColor(ContextCompat.getColor(this.requireContext(), R.color.white))
                samyakParentIcon.setImageResource(R.drawable.chevron_downblack)
                samyakName.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black))
                samyakRole.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black))
                val samyakChildCardslidein = ObjectAnimator.ofFloat(samyakChildCard,"translationY",0f,-1000f)
                samyakChildCardslidein.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator) {
                        samyakChildCard.visibility = View.GONE
                    }
                })
                samyakChildCardslidein.duration=500
                samyakChildCardslidein.start()
            }
        }
        return view
    }
}