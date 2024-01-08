package com.example.firstapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)

        registerButtonClicked()
    }

    private fun registerButtonClicked() {
        val registerButton: Button = findViewById(R.id.registerButton)
        val emailEditText: EditText = findViewById(R.id.emailEditText)

        registerButton.setOnClickListener {
            clickAnimation(registerButton)

            val email = emailEditText.text.toString()

            val enterSlideAnimation = R.anim.slide_in_collapse
            val exitSlideAnimation = R.anim.slide_out_expand
            val activityOptions = ActivityOptions.makeCustomAnimation(this, enterSlideAnimation, exitSlideAnimation)

            val intent = Intent(this@AuthActivity, MainActivity::class.java)
            intent.putExtra("user_email", email)
            startActivity(intent, activityOptions.toBundle())
        }
    }

    private fun clickAnimation(registerButton : Button) {
        val scaleAnimation = ScaleAnimation(
            1f, 0.9f,  // before and after size by width
            1f, 0.9f,  // before and after size by height
            Animation.RELATIVE_TO_SELF, 0.5f,  // horizontal center
            Animation.RELATIVE_TO_SELF, 0.5f  // vertical center
        )
        scaleAnimation.duration = 200 // animation duration in milliseconds
        scaleAnimation.repeatMode = Animation.REVERSE
        scaleAnimation.repeatCount = 1

        registerButton.startAnimation(scaleAnimation)
    }
}