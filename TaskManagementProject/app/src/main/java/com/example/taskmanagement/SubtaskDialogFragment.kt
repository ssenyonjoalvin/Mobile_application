package com.example.taskmanagement


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class SubtaskDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_subtask, container, false)




    }

    //This interface defines a method that is responsible for passing the added subtask from the
    //popup back to the main subtasks page
    interface SubtaskListener {
        fun onSubtaskAdded(subtask: Subtask)
    }

//    private var subtaskListener: SubtaskListener? = null
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Set click listener for the "Add Subtask" button
//        val addButton = view.findViewById<Button>(R.id.buttonAddSubtask)
//        addButton.setOnClickListener {
//            // Create a new subtask object
//            val subtaskName = view.findViewById<EditText>(R.id.editTextSubtaskName).text.toString()
//            val subtask = Subtask(subtaskName)
//
//            // Pass the subtask data back to the activity
//            subtaskListener?.onSubtaskAdded(subtask)
//
//            // Dismiss the dialog
//            dismiss()
//        }

}
