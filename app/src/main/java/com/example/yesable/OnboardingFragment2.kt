package com.example.yesable

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager

class OnboardingFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 버튼 관련 기능
        val btn = view.findViewById<Button>(R.id.ob_button)
        btn.setOnClickListener {
            val activity = activity as? OnboardingActivity
            val viewPager = activity?.findViewById<ViewPager>(R.id.viewPager)

            if (viewPager == null) {
                Log.e("OnboardingFragment1", "ViewPager is null")
                return@setOnClickListener
            }

            val adapter = viewPager.adapter
            val totalItems = adapter?.count ?: 0

            if (totalItems == 0) {
                Log.e("OnboardingFragment1", "Adapter is not properly initialized or empty")
                return@setOnClickListener
            }

            val currentItem = viewPager.currentItem

            if (currentItem < totalItems - 1) {
                viewPager.currentItem = currentItem + 1
            } else {
                // 마지막 페이지인 경우 추가 동작을 여기에 작성
            }
        }
    }
}
