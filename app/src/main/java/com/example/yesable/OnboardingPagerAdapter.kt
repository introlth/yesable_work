package com.example.yesable

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingPagerAdapter(activity: OnboardingActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 10 // 페이지 수 설정
    }

    override fun createFragment(position: Int): Fragment {
        Log.d("OnboardingPagerAdapter", "Creating fragment for position: $position")
        return OnboardingFragment.newInstance(position)
    }
}
