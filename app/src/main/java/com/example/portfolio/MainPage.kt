package com.example.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainPage : AppCompatActivity() {

    lateinit var navView:AnimatedBottomBar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        navView = findViewById<AnimatedBottomBar>(R.id.bottom_bar)



        navView.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener
        {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                var fm : FragmentManager = supportFragmentManager
                var ft: FragmentTransaction = fm.beginTransaction()
                var fragmentCurrent: Fragment? = fm.findFragmentById(R.id.container)
                if(fragmentCurrent!=null){
                    ft.remove(fragmentCurrent)
                }


                when(newTab.id)
                {
                    R.id.home -> {
                        ft.add(R.id.container, HomeFragment())
                    }

                    R.id.education -> {
                        ft.add(R.id.container, EducationFragment())
                    }

                    R.id.internships -> {
                        ft.add(R.id.container, InternshipsFragment())
                    }

                    R.id.skills -> {
                        ft.add(R.id.container, SkillsFragment())
                    }

                    R.id.projects -> {
                        ft.add(R.id.container, ProjectsFragment())
                    }
                }

                ft.commit()
            }
        })

        navView.selectTabById(R.id.home, true)




    }
}