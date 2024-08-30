package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegistrationSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_success)

        val loginButton: Button = findViewById(R.id.button_login)  // 로그인 버튼 참조

        // 로그인 버튼 클릭 시 LoginActivity로 이동하는 로직
        loginButton.setOnClickListener {
            // LoginActivity로 이동하는 Intent 생성
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
