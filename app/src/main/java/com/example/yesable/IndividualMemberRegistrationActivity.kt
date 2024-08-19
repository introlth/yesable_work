package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IndividualMemberRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.individual_member_registration)

        // 뒤로 가기 버튼 클릭 리스너
        val back_button = findViewById<TextView>(R.id.back_button)
        back_button.setOnClickListener {
            finish() // 현재 액티비티를 종료하고 이전 화면으로 돌아갑니다.
        }

        // 회원가입 버튼 클릭 리스너
        val signUpButton = findViewById<Button>(R.id.buttonSignUp)
        signUpButton.setOnClickListener {
            // 회원가입 성공 화면으로 이동
            val intent = Intent(this, RegistrationSuccessActivity::class.java)
            startActivity(intent)
        }
    }
}
