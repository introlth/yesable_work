package com.example.yesable

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager

class OnboardingFragment8 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding8, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Spinner 설정
        val spinner: Spinner = view.findViewById(R.id.year_spinner)
        val yearArray = resources.getStringArray(R.array.year_array)

        val adapter = object : ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_item,
            yearArray
        ) {
            override fun isEnabled(position: Int): Boolean {
                // 첫 번째 항목 ("취득년도")은 선택 불가능하게 설정
                return position != 0
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position == 0) {
                    // 사용자가 "취득년도"를 선택한 경우, 다시 첫 번째 항목으로 돌립니다.
                    spinner.setSelection(0)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 아무것도 선택되지 않았을 때의 동작 (필요한 경우 추가)
            }
        }

        // 버튼 관련 기능
        val btn = view.findViewById<Button>(R.id.ob_button)
        btn.setOnClickListener {
            val activity = activity as? OnboardingActivity
            val viewPager = activity?.findViewById<ViewPager>(R.id.viewPager)

            if (viewPager == null) {
                Log.e("OnboardingFragment8", "ViewPager is null")
                return@setOnClickListener
            }

            val adapter = viewPager.adapter
            val totalItems = adapter?.count ?: 0

            if (totalItems == 0) {
                Log.e("OnboardingFragment8", "Adapter is not properly initialized or empty")
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
