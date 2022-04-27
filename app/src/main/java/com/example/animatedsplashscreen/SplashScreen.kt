package com.example.animatedsplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // HERE WE ARE TAKING THE REFERENCE OF OUR IMAGE
        // SO THAT WE CAN PERFORM ANIMATION USING THAT IMAGE
        val imgSplashScreen: ImageView = findViewById(R.id.imgSplashScreen)
        val txtSplashScreen: TextView = findViewById(R.id.txtSplashScreen)
        val slideAnimation1 = AnimationUtils.loadAnimation(this, R.anim.side_slide_left)
        val slideAnimation2 = AnimationUtils.loadAnimation(this, R.anim.side_slide_right)
        imgSplashScreen.startAnimation(slideAnimation1)
        txtSplashScreen.startAnimation(slideAnimation2)

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000) // 5000 is the delayed time in milliseconds.
    }
}