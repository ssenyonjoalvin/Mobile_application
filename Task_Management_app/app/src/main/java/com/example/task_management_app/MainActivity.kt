package com.example.task_management_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler // Import Handler class
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var topanimation:Animation
    private lateinit var bottomanimation:Animation
    private var SPLASHSCREEN: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set fullscreen flags using Kotlin style
        window?.run {
            addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }

        setContentView(R.layout.activity_main)

        // Load animations
        topanimation = AnimationUtils.loadAnimation(this, R.anim.topanimation)
        bottomanimation = AnimationUtils.loadAnimation(this, R.anim.bottomanimation)

        // Find your views
        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val imageView =findViewById<ImageView>(R.id.imageView)

        // Apply animations to views
        textView.startAnimation(bottomanimation)
        textView2.startAnimation(bottomanimation)
        imageView.startAnimation(topanimation)

        Handler(mainLooper).postDelayed({
            val intent = Intent(this@MainActivity, Dashboard::class.java)
            startActivity(intent)
            finish()
        }, SPLASHSCREEN)

    }
}
