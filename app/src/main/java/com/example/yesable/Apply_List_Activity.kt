package com.example.yesable

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.yesable.ui.theme.YesableTheme
import com.example.yesable.R


class Apply_List_Activity : ComponentActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.apply_list)

        val apply_button = findViewById<ImageButton>(R.id.apply_button)
        apply_button.setOnClickListener {
            val intent = Intent(this, Recruitment_Detail_Activity::class.java)
            startActivity(intent)
        }
    }
}

