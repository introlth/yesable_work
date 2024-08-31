package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ApplicationFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_form)

        val backbutton = findViewById<TextView>(R.id.back_button)
        backbutton.setOnClickListener {
            finish()
        }

        val apply_success = findViewById<Button>(R.id.btn_complete)
        apply_success.setOnClickListener {
            val intent = Intent(this, ApplySuccessActivity::class.java)
            startActivity(intent)
        }
    }
}