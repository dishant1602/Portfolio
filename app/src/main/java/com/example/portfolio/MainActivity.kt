package com.example.portfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    lateinit var preparing : LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preparing = findViewById<LottieAnimationView>(R.id.preparing)
        val handler : Handler = Handler()

        handler.postDelayed(
            {
                var intent: Intent = Intent(this@MainActivity, MainPage::class.java)
                startActivity(intent)
                finish()
            },10000
        )
    }
}