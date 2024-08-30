package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

class Recruitment_Detail_Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recruitment_detail)

        val logoImageView1 = findViewById<ImageView>(R.id.imageView1)
        logoImageView1.setImageResource(R.drawable.logo)

        val logoImageView2 = findViewById<ImageView>(R.id.imageView2)
        logoImageView2.setImageResource(R.drawable.apply1)

        val logoImageView3 = findViewById<ImageView>(R.id.imageView3)
        logoImageView3.setImageResource(R.drawable.apply2)

        val logoImageView4 = findViewById<ImageView>(R.id.imageView4)
        logoImageView4.setImageResource(R.drawable.apply3)

        val logoImageView5 = findViewById<ImageView>(R.id.imageView5)
        logoImageView5.setImageResource(R.drawable.apply4)

        val logoImageView6 = findViewById<ImageView>(R.id.imageView6)
        logoImageView6.setImageResource(R.drawable.apply5)

        val logoImageView7 = findViewById<ImageView>(R.id.imageView7)
        logoImageView7.setImageResource(R.drawable.apply6)

        val sign_button = findViewById<Button>(R.id.sign_button)
        sign_button.setOnClickListener {
            val intent = Intent(this, Apply_List_Activity::class.java)
            startActivity(intent)
        }

    }
}

