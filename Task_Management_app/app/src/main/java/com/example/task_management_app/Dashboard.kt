package com.example.task_management_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dashboard : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recycle_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val tasks = listOf(
            task("Operating System Assignment", "Assignment two comes out soon", 50),
            task("Project Presentation", "Prepare slides for the project presentation", 30),
            task("Read Chapter 5", "Read Chapter 5 of the textbook", 70),
            task("Meeting with Client", "Discuss project requirements with the client", 20)
        )

        val adapter = TaskAdapter(tasks)
        recyclerView.adapter = adapter
    }
}
