package com.example.portfolio

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val humanimg: ImageView = view.findViewById(R.id.imageView)
        val mainName: TextView = view.findViewById(R.id.mainNameplate)
        val callmeCard: CardView = view.findViewById(R.id.callmeCard)
        val mailmeCard: CardView = view.findViewById(R.id.mailmeCard)
        val pingmeCard: CardView = view.findViewById(R.id.pingmeCard)

        // Animation for Human Cartoon
        val humanimgslide = ObjectAnimator.ofFloat(humanimg, "translationX", -500f, 0f)
        humanimgslide.duration = 1000
        humanimgslide.start()
        //Animation for 'Dishant' text
        val mainnameslide = ObjectAnimator.ofFloat(mainName, "translationX", 300f, 0f)
        val mainnamefade = ObjectAnimator.ofFloat(mainName, "alpha", 0f, 1f)
        AnimatorSet().playTogether(mainnamefade, mainnameslide)
        AnimatorSet().duration=1000
        AnimatorSet().start()
        //Animation for 'Contact Info' things
        val callmeCardFade = ObjectAnimator.ofFloat(callmeCard, "alpha", 0f,1f)
        val mailmeCardFade = ObjectAnimator.ofFloat(mailmeCard, "alpha", 0f,1f)
        val pingmeCardFade = ObjectAnimator.ofFloat(pingmeCard, "alpha", 0f,1f)
        AnimatorSet().playTogether(callmeCardFade, mailmeCardFade, pingmeCardFade)
        AnimatorSet().duration = 1000
        val sequence = AnimatorSet()
        sequence.playSequentially(mainnameslide, callmeCardFade)
        sequence.start()


        return view
    }

}