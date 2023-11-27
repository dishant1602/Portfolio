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
                val fm : FragmentManager = supportFragmentManager
                val ft: FragmentTransaction = fm.beginTransaction()


                when(newTab.id)
                {
                    R.id.home -> {
                        val fragmentCurrent: Fragment? = fm.findFragmentById(R.id.container)
                        if(fragmentCurrent!=null){
                            ft.replace(R.id.container,HomeFragment())
                        }
                        else{
                            ft.add(R.id.container, HomeFragment())
                        }
                        ft.replace(R.id.container, HomeFragment())
                    }

                    R.id.education -> {
                        ft.replace(R.id.container, EducationFragment())
                    }

                    R.id.internships -> {
                        ft.replace(R.id.container, InternshipsFragment())
                    }

                    R.id.skills -> {
                        ft.replace(R.id.container, SkillsFragment())
                    }

                    R.id.projects -> {
                        ft.replace(R.id.container, ProjectsFragment())
                    }
                }

                ft.commit()
            }
        })

        navView.selectTabById(R.id.home, true)




    }
}