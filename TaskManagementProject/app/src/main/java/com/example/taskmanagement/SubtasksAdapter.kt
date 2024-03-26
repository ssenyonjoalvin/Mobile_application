
package com.example.taskmanagement

// SubtasksAdapter.kt
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubtasksAdapter(private val subtasks: List<Subtask>) : RecyclerView.Adapter<SubtasksAdapter.SubtaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubtaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_subtask, parent, false)
        return SubtaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubtaskViewHolder, position: Int) {
        val subtask = subtasks[position]

        // Log the subtask data
        Log.d("SubtasksAdapter", "Binding subtask at position $position: $subtask")

        holder.bind(subtask)
    }

    override fun getItemCount(): Int {
        return subtasks.size
    }

    inner class SubtaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(subtask: Subtask) {
            itemView.findViewById<CheckBox>(R.id.checkboxSubtask).isChecked = subtask.isChecked
            itemView.findViewById<TextView>(R.id.textViewSubtaskName).text = subtask.name
        }
    }
}
