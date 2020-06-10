package com.example.myworkouttracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tracker.*

class MainActivity : AppCompatActivity() {

    private lateinit var workoutAdapter: WorkoutRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        // just inflates activity main
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}