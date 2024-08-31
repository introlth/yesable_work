package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class G_Main_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gmain)

        val navi = findViewById<ImageView>(R.id.navi)
        navi.setOnClickListener {
            finish()
        }

        val recruit_list = findViewById<ImageView>(R.id.main_image1)
        recruit_list.setOnClickListener {
            val intent = Intent(this, Recruitment_Detail_Activity::class.java)
            startActivity(intent)
        }

    }
}