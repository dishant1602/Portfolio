package com.example.portfolio

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
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
        val ll1: LinearLayout = view.findViewById(R.id.ll1)
        val ll2: LinearLayout = view.findViewById(R.id.ll2)
        val ll3: LinearLayout = view.findViewById(R.id.ll3)
        val ll4: LinearLayout = view.findViewById(R.id.ll4)
        val ll5: LinearLayout = view.findViewById(R.id.ll5)
        val callIcon: ImageView = view.findViewById(R.id.callIcon)
        val mailIcon: ImageView = view.findViewById(R.id.mailIcon)
        val pingIcon: ImageView = view.findViewById(R.id.pingIcon)

        callmeCard.visibility = View.INVISIBLE
        mailmeCard.visibility = View.INVISIBLE
        pingmeCard.visibility = View.INVISIBLE
        ll1.visibility = View.INVISIBLE
        ll2.visibility = View.INVISIBLE
        ll3.visibility = View.INVISIBLE
        ll4.visibility = View.INVISIBLE
        ll5.visibility = View.INVISIBLE

        // Animation for Human Cartoon
        val humanimgslide = ObjectAnimator.ofFloat(humanimg, "translationX", -500f, 0f)
        humanimgslide.duration = 1000
        humanimgslide.start()

        //Animation for 'Dishant' text
        val mainnameAnimator = AnimatorSet()
        val mainnameslide = ObjectAnimator.ofFloat(mainName, "translationX", 300f, 0f)
        val mainnamefade = ObjectAnimator.ofFloat(mainName, "alpha", 0f, 1f)
        mainnameAnimator.playTogether(mainnamefade, mainnameslide)
        mainnameAnimator.addListener(object: AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator) {
                val ll1slide = ObjectAnimator.ofFloat(ll1,"translationX",-1500f,0f)
                ll1slide.addListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator) {
                        ll1.visibility = View.VISIBLE
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        val ll2slide = ObjectAnimator.ofFloat(ll2,"translationX",-1500f,0f)
                        ll2slide.addListener( object : AnimatorListenerAdapter(){
                            override fun onAnimationStart(animation: Animator) {
                                ll2.visibility = View.VISIBLE
                            }

                            override fun onAnimationEnd(animation: Animator) {
                                val ll3slide = ObjectAnimator.ofFloat(ll3,"translationX",-1500f,0f)
                                ll3slide.addListener(object: AnimatorListenerAdapter(){
                                    override fun onAnimationStart(animation: Animator) {
                                        ll3.visibility = View.VISIBLE
                                    }

                                    override fun onAnimationEnd(animation: Animator) {
                                        val ll4slide = ObjectAnimator.ofFloat(ll4,"translationX",-1500f,0f)
                                        ll4slide.addListener(object: AnimatorListenerAdapter(){
                                            override fun onAnimationStart(animation: Animator) {
                                                ll4.visibility = View.VISIBLE
                                            }

                                            override fun onAnimationEnd(animation: Animator) {
                                                val ll5slide = ObjectAnimator.ofFloat(ll5,"translationX",-1500f,0f)
                                                ll5slide.addListener(object: AnimatorListenerAdapter(){
                                                    override fun onAnimationStart(animation: Animator) {
                                                        ll5.visibility=View.VISIBLE
                                                    }

                                                    override fun onAnimationEnd(animation: Animator) {
                                                        val callmeCardFade = ObjectAnimator.ofFloat(callmeCard, "alpha", 0f,1f)
                                                        callmeCardFade.addListener(object: AnimatorListenerAdapter(){
                                                            override fun onAnimationStart(animation: Animator) {
                                                                callmeCard.visibility = View.VISIBLE
                                                            }

                                                            override fun onAnimationEnd(animation: Animator) {
                                                                val mailmeCardFade = ObjectAnimator.ofFloat(mailmeCard, "alpha", 0f,1f)
                                                                mailmeCardFade.addListener(object: AnimatorListenerAdapter(){
                                                                    override fun onAnimationStart(animation: Animator) {
                                                                        mailmeCard.visibility = View.VISIBLE
                                                                    }

                                                                    override fun onAnimationEnd(animation: Animator) {
                                                                        val pingmeCardFade = ObjectAnimator.ofFloat(pingmeCard, "alpha", 0f,1f)
                                                                        pingmeCardFade.addListener(object: AnimatorListenerAdapter(){
                                                                            override fun onAnimationStart(
                                                                                animation: Animator
                                                                            ) {
                                                                                pingmeCard.visibility = View.VISIBLE
                                                                            }
                                                                        })
                                                                        pingmeCardFade.start()
                                                                    }
                                                                })
                                                                mailmeCardFade.start()
                                                            }
                                                        })
                                                        callmeCardFade.start()
                                                    }
                                                })
                                                ll5slide.duration=250
                                                ll5slide.start()
                                            }
                                        })
                                        ll4slide.duration=250
                                        ll4slide.start()
                                    }
                                })
                                ll3slide.duration=250
                                ll3slide.start()
                            }
                        })
                        ll2slide.duration=250
                        ll2slide.start()
                    }
                })
                ll1slide.duration=250
                ll1slide.start()
            }
        })
        mainnameAnimator.duration=1000
        mainnameAnimator.start()

        //Animation for 'Contact Info' things
//        val callmeCardFade = ObjectAnimator.ofFloat(callmeCard, "alpha", 0f,1f)
//        val mailmeCardFade = ObjectAnimator.ofFloat(mailmeCard, "alpha", 0f,1f)


        //Animation for about me



//        val ll4slide = ObjectAnimator.ofFloat(ll4,"translationX",-1500f,0f)
//
//
//        ll2slide.duration=250
//        ll3slide.duration=250
//        ll4slide.duration=250
//        ll5slide.duration=250
//        val sequence = AnimatorSet()
//        sequence.playSequentially(mainnameslide, ll1slide, ll2slide, ll3slide, ll4slide, ll5slide, callmeCardFade, mailmeCardFade, pingmeCardFade)
//        sequence.start()

        //Functionality
        callIcon.setOnClickListener {_ ->
            val phoneNumber = "+919727114477"
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:$phoneNumber")
            startActivity(dialIntent)
        }

        mailIcon.setOnClickListener { _ ->
            val recipientEmail = "dishantsakhida@gmail.com"
            val subject = "Your Subject"
            val body = "Your email body content"
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:$recipientEmail")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            emailIntent.putExtra(Intent.EXTRA_TEXT, body)
            startActivity(emailIntent)
        }

        pingIcon.setOnClickListener { _ ->
            val linkedInProfileUrl = "https://www.linkedin.com/in/dishant-sakhida-4206681b4"
            val linkedInIntent = Intent(Intent.ACTION_VIEW)
            linkedInIntent.data = Uri.parse(linkedInProfileUrl)
            if (linkedInIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(linkedInIntent)
            }
            else {
                Toast.makeText(view.context, "Linkedin app not available", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

}