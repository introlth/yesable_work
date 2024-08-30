package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.yesable.ui.theme.YesableTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        // 타이머가 끝나면 실행
        Handler().postDelayed(Runnable {
            // StartUI로 이동
            val start_ui = Intent(this@SplashActivity, StartActivity::class.java)
            startActivity(start_ui)
            // 현재 액티비티 닫기
            finish()
        }, 2000) // 2초
    }
}