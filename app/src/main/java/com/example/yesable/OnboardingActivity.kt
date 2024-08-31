package com.example.yesable

<<<<<<< HEAD

import android.content.Intent

=======
import android.content.Intent
>>>>>>> e68715f3cafc505dd1b8580c622e1fe7aee76642
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class OnboardingActivity : AppCompatActivity() {
    lateinit var viewPager2: ViewPager2
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        // ViewPager2와 ProgressBar 초기화
        viewPager2 = findViewById(R.id.viewPager)
        progressBar = findViewById(R.id.progressBar)

        // PagerAdapter 설정
        val adapter = OnboardingPagerAdapter(this)
        viewPager2.adapter = adapter

        // 페이지 이동에 따른 진행바 업데이트
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val totalPages = adapter.itemCount
                progressBar.progress = (position + 1) * 100 / totalPages
            }
        })

        val backbutton = findViewById<TextView>(R.id.back_button)
        val closebutton = findViewById<TextView>(R.id.close_button)

        backbutton.setOnClickListener {
            // 현재 페이지가 첫 페이지가 아닐 경우 이전 페이지로 이동
            val currentPage = viewPager2.currentItem
            if (currentPage > 0) {
                viewPager2.currentItem = currentPage - 1
            } else {
                // 첫 페이지에서는 액티비티 종료
                finish()
            }
        }

        closebutton.setOnClickListener {
            showAlert()
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("그만하고 싶으신가요?")
        builder.setMessage("지금까지 입력된 정보는 저장되지 않아요.\n마이페이지>이력서 관리에서\n다시 이용하실 수 있습니다.")
        builder.setPositiveButton("확인") { dialog, _ ->

            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)

            finish()

        }
        builder.setNegativeButton("취소") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
}
