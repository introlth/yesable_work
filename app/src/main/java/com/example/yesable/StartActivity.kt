package com.example.yesable

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class StartActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        // 회원가입 버튼 화면 전환 -> 회원가입 유형 선택 화면 이동
        val sign_button = findViewById<TextView>(R.id.sign_button)
        sign_button.setOnClickListener {
            val intent = Intent(this, SignSelectActivity::class.java)
            startActivity(intent)
        }

        // 게스트 버튼 화면 전환 -> 일반회원 메인 화면 이동
        val main_button = findViewById<TextView>(R.id.main_button)
        main_button.setOnClickListener {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
        }

        // yesable 로그인 버튼 화면 전환 -> 로그인 화면 이동
        val g_login_button = findViewById<TextView>(R.id.g_login_button)
        g_login_button.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}