package com.example.taskmanagement

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SubtaskActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SubtasksAdapter // Assuming this is your RecyclerView adapter class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subtasks)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewSubtasks)

        // Set click listener for the "Add Subtask" button
        val addButton = findViewById<Button>(R.id.buttonAddSubtask)
        addButton.setOnClickListener {
            // Show the dialog fragment
            val dialogFragment = SubtaskDialogFragment()
            dialogFragment.show(supportFragmentManager, "SubtaskDialogFragment")
        }

//        val dialogFragment = SubtaskDialogFragment()
//        dialogFragment.subtaskListener = this
//        dialogFragment.show(supportFragmentManager, "SubtaskDialogFragment")


        // Create Dummy Subtask Data
        val dummySubtasks = listOf(
            Subtask("Dummy Subtask 1", true),
            Subtask("Dummy Subtask 2", false),
            Subtask("Dummy Subtask 3", true)
        )

        // Create Adapter Instance
        adapter = SubtasksAdapter(dummySubtasks)

        // Set Layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set Adapter on RecyclerView
        recyclerView.adapter = adapter
    }

//        override fun onSubtaskAdded(subtask: Subtask) {
//            // Handle the newly added subtask here
//            // Update your list of subtasks or perform any necessary actions
//        }

    }