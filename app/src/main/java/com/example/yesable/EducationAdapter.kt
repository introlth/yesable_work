package com.example.yesable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EducationAdapter(private val educationList: List<Education>) :
    RecyclerView.Adapter<EducationAdapter.EducationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_education, parent, false)
        return EducationViewHolder(view)
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        val education = educationList[position]
        holder.bind(education)
    }

    override fun getItemCount() = educationList.size

    class EducationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val schoolTextView: TextView = itemView.findViewById(R.id.schoolTextView)
        private val majorTextView: TextView = itemView.findViewById(R.id.majorTextView)
        private val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)

        fun bind(education: Education) {
            schoolTextView.text = "${education.schoolName} ${education.degree} (${education.status})"
            majorTextView.text = education.major
            dateTextView.text = "${education.startYear} ~ ${education.endYear}"
        }
    }
}
