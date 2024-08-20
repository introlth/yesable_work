package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Spinner
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

class CorporateMemberRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.corporate_member_registration)

        // 뒤로 가기 버튼 클릭 리스너
        val back_button = findViewById<TextView>(R.id.back_button)
        back_button.setOnClickListener {
            finish() // 현재 액티비티를 종료하고 이전 화면으로 돌아갑니다.
        }

        // 회원가입 버튼 클릭 리스너
        val register_button = findViewById<Button>(R.id.sign_button)
        register_button.setOnClickListener {
            val intent = Intent(this, RegistrationSuccessActivity::class.java)
            startActivity(intent)
        }

        // 기업 형태 Spinner 설정
        val spinnerCompanyType: Spinner = findViewById(R.id.spinnerCompanyType)
        ArrayAdapter.createFromResource(
            this,
            R.array.company_types, // 이 배열 리소스를 직접 정의해야 함
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCompanyType.adapter = adapter
        }

        // 사업 분야 Spinner 설정
        val spinnerBusinessArea: Spinner = findViewById(R.id.spinnerBusinessArea)
        ArrayAdapter.createFromResource(
            this,
            R.array.business_areas, // 이 배열 리소스를 직접 정의해야 함
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerBusinessArea.adapter = adapter
        }
    }
}
