package com.example.yesable

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingPagerAdapter(activity: OnboardingActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 8 // 페이지 수 설정
    }

    override fun createFragment(position: Int): Fragment {
        return OnboardingFragment.newInstance(position)
    }
}
