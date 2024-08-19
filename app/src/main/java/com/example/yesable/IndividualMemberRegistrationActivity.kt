package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IndividualMemberRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.individual_member_registration)


        // 뒤로 가기 버튼 클릭 리스너
        val back_button = findViewById<TextView>(R.id.back_button)
        back_button.setOnClickListener {
            finish() // 현재 액티비티를 종료하고 이전 화면으로 돌아갑니다.
        }

        val sign_button = findViewById<Button>(R.id.sign_button)
        sign_button.setOnClickListener {
            val intent = Intent(this, RegistrationSuccessActivity::class.java)
            startActivity(intent)
        }
    }
}
