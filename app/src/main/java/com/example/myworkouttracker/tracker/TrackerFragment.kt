package com.example.myworkouttracker.tracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myworkouttracker.*
import com.example.myworkouttracker.models.Workout
import kotlinx.android.synthetic.main.fragment_tracker.*

class TrackerFragment : Fragment() {

    private lateinit var workoutAdapter: WorkoutRecyclerAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tracker, container, false)
    }

    private fun addDataSet(){
        val data = createDataSet()
        workoutAdapter.submitList(data)
    }

    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here
        recycler_view.apply {
            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // add a top spacing to separate cardview
            val topSpacingDecoration = TopItemSpacingDecoration(30)
            addItemDecoration(topSpacingDecoration)
            // set the custom adapter to the RecyclerView
            workoutAdapter = WorkoutRecyclerAdapter()
            adapter = workoutAdapter
            addDataSet()
        }
    }

    private fun createDataSet(): ArrayList<Workout>{

        val args = TrackerFragmentArgs.fromBundle(arguments!!)
        val userInputA = args.activityARM
        val userInputB = args.activityBRM
        val workoutType = args.workoutType
        var activityNameA = ""
        var activityNameB = ""
        val activityATrainingMax = 0.9 * userInputA
        val activityBTrainingMax = 0.9 * userInputB

        if (workoutType == "A") {
            activityNameA = "Squat"
            activityNameB = "Bench Press"
        }
        else if (workoutType == "B") {
            activityNameA = "Deadlift"
            activityNameB = "Press"
        }

        val list = ArrayList<Workout>()

        list.add(
            Workout(
                activityNameA,
                "${roundToTwoPointFive(0.65 * activityATrainingMax)}",
                "1",
                "5"
            )
        )
        list.add(
            Workout(
                activityNameA,
                "${roundToTwoPointFive(0.75 * activityATrainingMax)}",
                "1",
                "5"
            )
        )
        list.add(
            Workout(
                activityNameA,
                "${roundToTwoPointFive(0.85 * activityATrainingMax)}",
                "1",
                "5+"
            )
        )
        list.add(
            Workout(
                activityNameA,
                "${roundToTwoPointFive(0.65 * activityATrainingMax)}",
                "5",
                "5"
            )
        )
        list.add(
            Workout(
                activityNameB,
                "${roundToTwoPointFive(0.65 * activityBTrainingMax)}",
                "1",
                "5"
            )
        )
        list.add(
            Workout(
                activityNameB,
                "${roundToTwoPointFive(0.75 * activityBTrainingMax)}",
                "1",
                "5"
            )
        )
        list.add(
            Workout(
                activityNameB,
                "${roundToTwoPointFive(0.85 * activityBTrainingMax)}",
                "1",
                "5+"
            )
        )
        list.add(
            Workout(
                activityNameB,
                "${roundToTwoPointFive(0.65 * activityBTrainingMax)}",
                "5",
                "5"
            )
        )
        return list
    }

}

