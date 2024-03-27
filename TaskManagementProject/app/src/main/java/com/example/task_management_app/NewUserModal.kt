package com.example.task_management_app

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class NewUserModal : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.newusermodal, null)

        // Setup views and handle actions (e.g., button clicks) here

        builder.setView(dialogView)
//            .setTitle("Welcome to the App!")
//            .setPositiveButton("Submit") { _, _ ->
//                // Handle form submission
//            }
//            .setNegativeButton("Cancel") { _, _ ->
//                // Handle cancellation
          //  }

        return builder.create()
    }
}

