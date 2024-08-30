package com.example.yesable

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class OnboardingFragment10 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding10, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 완료하기 버튼 기능
        val btn = view.findViewById<Button>(R.id.ob_button)
        btn.setOnClickListener {
            val activity = activity as? OnboardingActivity
            val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

            if (viewPager == null) {
                Log.e("OnboardingFragment10", "ViewPager is null")
                return@setOnClickListener
            }

            val adapter = viewPager.adapter
            val totalItems = adapter?.itemCount ?: 0

            if (totalItems == 0) {
                Log.e("OnboardingFragment10", "Adapter is not properly initialized or empty")
                return@setOnClickListener
            }

            val currentItem = viewPager.currentItem

            if (currentItem < totalItems - 1) {
                viewPager.currentItem = currentItem + 1
            } else {
                val intent = Intent(activity, G_Login_Activity::class.java)
                startActivity(intent)
                activity.finish()
            }
        }
    }
}
