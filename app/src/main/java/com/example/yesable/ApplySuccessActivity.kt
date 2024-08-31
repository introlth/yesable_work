package com.example.yesable

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ApplySuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_apply_success)

        val textViewMessage = findViewById<TextView>(R.id.textViewMessage)
        val text = "지원한 내역은 \n마이페이지>지원내역에서 확인할 수 있어요"

        val spannableString = SpannableString(text)
        val start = text.indexOf("마이페이지>지원내역")
        val end = start + "마이페이지>지원내역".length

        // 스타일 적용
        spannableString.setSpan(StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#061720")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        // TextView에 SpannableString 설정
        textViewMessage.text = spannableString


        val list_return = findViewById<Button>(R.id.button_list_return)
        list_return.setOnClickListener {
            val intent = Intent(this, G_Main_Activity::class.java)
            startActivity(intent)
        }

    }
}