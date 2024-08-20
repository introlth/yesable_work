package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_select)

        // 직전 화면 전환
        val back_button = findViewById<TextView>(R.id.back_button)
        back_button.setOnClickListener {
            finish()
        }

        // 일반회원가입 화면 전환
        val g_sign = findViewById<Button>(R.id.g_sign_button)
        g_sign.setOnClickListener {
            val intent = Intent(this, IndividualMemberRegistrationActivity::class.java)
            startActivity(intent)
        }


        // 기업회원가입 화면 전환
        val c_sign = findViewById<Button>(R.id.c_sign_button)
        c_sign.setOnClickListener {
            val intent = Intent(this, CorporateMemberRegistrationActivity::class.java)
            startActivity(intent)
        }


    }
}