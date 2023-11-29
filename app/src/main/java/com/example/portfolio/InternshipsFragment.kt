package com.example.portfolio

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.animation.addListener
import androidx.core.content.ContextCompat


class InternshipsFragment : Fragment() {


    var countSam=0; var countInfo=0; var countBotx=0
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
        val samyakCerti: CardView = view.findViewById(R.id.samyakCerti)

        val einfoParentCard: CardView = view.findViewById(R.id.einfoParentCard)
        val einfoParentIcon: ImageView = view.findViewById(R.id.einfoParentIcon)
        val einfoName: TextView = view.findViewById(R.id.einfoName)
        val einfoRole: TextView = view.findViewById(R.id.einfoRole)
        val einfoChildCard: CardView = view.findViewById(R.id.einfoChildCard)

        val botxParentCard: CardView = view.findViewById(R.id.botxParentCard)
        val botxParentIcon: ImageView = view.findViewById(R.id.botxParentIcon)
        val botxName: TextView = view.findViewById(R.id.botxName)
        val botxRole: TextView = view.findViewById(R.id.botxRole)
        val botxChildCard: CardView = view.findViewById(R.id.botxChildCard)

        samyakChildCard.visibility = View.GONE
        einfoChildCard.visibility = View.GONE
        botxChildCard.visibility = View.GONE
        samyakParentCard.visibility = View.GONE
        einfoParentCard.visibility = View.GONE
        botxParentCard.visibility = View.GONE

        val samyakParentCardslideIn = ObjectAnimator.ofFloat(samyakParentCard,"translationX",-500f,0f)
        samyakParentCardslideIn.addListener(object: AnimatorListenerAdapter(){
            override fun onAnimationStart(animation: Animator) {
                samyakParentCard.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animator) {
                val einfoParentCardslideIn = ObjectAnimator.ofFloat(einfoParentCard,"translationX",-500f,0f)
                einfoParentCardslideIn.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator) {
                        einfoParentCard.visibility = View.VISIBLE
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        val botxParentCardslideIn = ObjectAnimator.ofFloat(botxParentCard,"translationX",-500f,0f)
                        botxParentCardslideIn.addListener(object: AnimatorListenerAdapter(){
                            override fun onAnimationStart(animation: Animator) {
                                botxParentCard.visibility = View.VISIBLE
                            }
                        })
                        botxParentCardslideIn.duration=250
                        botxParentCardslideIn.start()
                    }
                })
                einfoParentCardslideIn.duration=250
                einfoParentCardslideIn.start()
            }
        })
        samyakParentCardslideIn.duration=250
        samyakParentCardslideIn.start()

        samyakParentCard.setOnClickListener{ _->
            countSam+=1
            if(countSam%2!=0){
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

        einfoParentCard.setOnClickListener{ _->
            countInfo+=1
            if(countInfo%2!=0){
                var color = "#8c7ce2"
                val colorInt = android.graphics.Color.parseColor(color)
                einfoParentCard.setCardBackgroundColor(colorInt)
                einfoParentIcon.setImageResource(R.drawable.chevron_upwhite)
                einfoName.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.white))
                einfoRole.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.white))
                val einfoChildCardslidein = ObjectAnimator.ofFloat(einfoChildCard,"translationY",-600f,0f)
                einfoChildCardslidein.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator) {
                        einfoChildCard.visibility = View.VISIBLE
                    }
                })
                einfoChildCardslidein.duration=500
                einfoChildCardslidein.start()
            }
            else{
                einfoParentCard.setCardBackgroundColor(ContextCompat.getColor(this.requireContext(), R.color.white))
                einfoParentIcon.setImageResource(R.drawable.chevron_downblack)
                einfoName.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black))
                einfoRole.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black))
                val einfoChildCardslidein = ObjectAnimator.ofFloat(einfoChildCard,"translationY",0f,-1000f)
                einfoChildCardslidein.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator) {
                        einfoChildCard.visibility = View.GONE
                    }
                })
                einfoChildCardslidein.duration=500
                einfoChildCardslidein.start()
            }
        }

        botxParentCard.setOnClickListener{ _->
            countBotx+=1
            if(countBotx%2!=0){
                var color = "#8c7ce2"
                val colorInt = android.graphics.Color.parseColor(color)
                botxParentCard.setCardBackgroundColor(colorInt)
                botxParentIcon.setImageResource(R.drawable.chevron_upwhite)
                botxName.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.white))
                botxRole.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.white))
                val botxChildCardslidein = ObjectAnimator.ofFloat(botxChildCard,"translationY",-600f,0f)
                botxChildCardslidein.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator) {
                        botxChildCard.visibility = View.VISIBLE
                    }
                })
                botxChildCardslidein.duration=500
                botxChildCardslidein.start()
            }
            else{
                botxParentCard.setCardBackgroundColor(ContextCompat.getColor(this.requireContext(), R.color.white))
                botxParentIcon.setImageResource(R.drawable.chevron_downblack)
                botxName.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black))
                botxRole.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.black))
                val botxChildCardslidein = ObjectAnimator.ofFloat(botxChildCard,"translationY",0f,-1000f)
                botxChildCardslidein.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator) {
                        botxChildCard.visibility = View.GONE
                    }
                })
                botxChildCardslidein.duration=500
                botxChildCardslidein.start()
            }
        }

        samyakCerti.setOnClickListener{ _->
            var intent = Intent(activity, PdfViewActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}