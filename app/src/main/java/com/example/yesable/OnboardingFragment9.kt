package com.example.yesable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2  // ViewPager2를 사용

class OnboardingFragment9 : Fragment() {

    private lateinit var educationList: MutableList<Education>
    private lateinit var adapter: EducationAdapter
    private lateinit var educationFormLayout: View
    private lateinit var educationRecyclerView: RecyclerView
    private lateinit var addEducationButton: Button
    private lateinit var obButton: Button  // 새로 추가된 계속하기 버튼

    private fun setSpinner(spinner: Spinner, array: Array<String>) {
        val adapter = object : ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line
        ) {
            override fun getCount(): Int = super.getCount() - 1  // array에서 hint 안 보이게 하기
        }
        adapter.addAll(array.toMutableList())   // 배열 추가
        spinner.adapter = adapter               // 어댑터 달기
        spinner.setSelection(adapter.count)     // 스피너 초기값=hint
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding9, container, false)

        educationList = mutableListOf()
        adapter = EducationAdapter(educationList)

        educationFormLayout = view.findViewById(R.id.educationFormLayout)
        educationRecyclerView = view.findViewById(R.id.educationRecyclerView)
        addEducationButton = view.findViewById(R.id.addEducationButton)
        obButton = view.findViewById(R.id.ob_button)  // 계속하기 버튼 초기화

        educationRecyclerView.layoutManager = LinearLayoutManager(context)
        educationRecyclerView.adapter = adapter
        val degreeSpinner = view.findViewById<Spinner>(R.id.degreeSpinner)
        val statusSpinner = view.findViewById<Spinner>(R.id.statusSpinner)

        val degreeArray = resources.getStringArray(R.array.degree_array) + "학력을 선택해주세요"  // 힌트를 추가한 배열
        val statusArray = resources.getStringArray(R.array.status_array) + "상태를 선택해주세요"  // 힌트를 추가한 배열

        setSpinner(degreeSpinner, degreeArray)
        setSpinner(statusSpinner, statusArray)

        view.findViewById<Button>(R.id.saveButton).setOnClickListener {
            saveEducation()
        }

        view.findViewById<Button>(R.id.cancelButton).setOnClickListener {
            showEducationForm(false)
        }

        addEducationButton.setOnClickListener {
            showEducationForm(true)
        }

        obButton.setOnClickListener {
            // OnboardingActivity의 ViewPager2를 참조하여 다음 페이지로 이동
            val activity = activity as? OnboardingActivity
            val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

            viewPager?.let {
                val currentItem = it.currentItem
                val totalItems = it.adapter?.itemCount ?: 0
                if (currentItem < totalItems - 1) {
                    it.currentItem = currentItem + 1
                } else {
                    // 마지막 페이지일 경우 추가 동작
                }
            }
        }

        updateUI()

        return view
    }

    private fun saveEducation() {
        val degreeSpinner = view?.findViewById<Spinner>(R.id.degreeSpinner)
        val statusSpinner = view?.findViewById<Spinner>(R.id.statusSpinner)
        val schoolName = view?.findViewById<EditText>(R.id.schoolNameEditText)?.text.toString()
        val major = view?.findViewById<EditText>(R.id.majorEditText)?.text.toString()
        val startYear = view?.findViewById<EditText>(R.id.startYearEditText)?.text.toString()
        val endYear = view?.findViewById<EditText>(R.id.endYearEditText)?.text.toString()
        val degree = degreeSpinner?.selectedItem.toString()
        val status = statusSpinner?.selectedItem.toString()

        if (schoolName.isNotEmpty() && major.isNotEmpty() && startYear.isNotEmpty() && endYear.isNotEmpty()) {
            val education = Education(schoolName, major, startYear, endYear, degree, status)
            educationList.add(education)
            adapter.notifyItemInserted(educationList.size - 1)
            showEducationForm(false)
            updateUI()
        }
    }

    private fun showEducationForm(show: Boolean) {
        educationFormLayout.visibility = if (show) View.VISIBLE else View.GONE
        addEducationButton.visibility = if (show) View.GONE else View.VISIBLE
        educationRecyclerView.visibility = if (show) View.GONE else View.VISIBLE
    }

    private fun updateUI() {
        if (educationList.isEmpty()) {
            showEducationForm(true)
        } else {
            showEducationForm(false)
        }
    }
}
