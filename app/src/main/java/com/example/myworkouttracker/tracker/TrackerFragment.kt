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
        // get an instance of the data set, then 'submits' the data to the recyclerview adapter
        val data = createDataSet()
        workoutAdapter.submitList(data)
    }

    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here - .apply implicitly refers to recyclerview inside of apply, increasing readability
        recycler_view.apply {
            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // add a top spacing to separate cardview
            val topSpacingDecoration = TopItemSpacingDecoration(30)
            addItemDecoration(topSpacingDecoration)
            // set the custom adapter to the RecyclerView
            workoutAdapter =
                WorkoutRecyclerAdapter()
            adapter = workoutAdapter
            addDataSet()
        }
    }

    private fun createDataSet(): ArrayList<Workout>{
        // this dataset takes the values from the user (args get data from previous fragment) and transforms it into a training weight
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
                1,
                activityNameA,
                "${roundToTwoPointFive(0.65 * activityATrainingMax)}",
                "1",
                "5"
            )
        )
        list.add(
            Workout(
                2,
                activityNameA,
                "${roundToTwoPointFive(0.75 * activityATrainingMax)}",
                "1",
                "5"
            )
        )
        list.add(
            Workout(
                3,
                activityNameA,
                "${roundToTwoPointFive(0.85 * activityATrainingMax)}",
                "1",
                "5+"
            )
        )
        list.add(
            Workout(
                4,
                activityNameA,
                "${roundToTwoPointFive(0.65 * activityATrainingMax)}",
                "5",
                "5"
            )
        )
        list.add(
            Workout(
                5,
                activityNameB,
                "${roundToTwoPointFive(0.65 * activityBTrainingMax)}",
                "1",
                "5"
            )
        )
        list.add(
            Workout(
                6,
                activityNameB,
                "${roundToTwoPointFive(0.75 * activityBTrainingMax)}",
                "1",
                "5"
            )
        )
        list.add(
            Workout(
                7,
                activityNameB,
                "${roundToTwoPointFive(0.85 * activityBTrainingMax)}",
                "1",
                "5+"
            )
        )
        list.add(
            Workout(
                8,
                activityNameB,
                "${roundToTwoPointFive(0.65 * activityBTrainingMax)}",
                "5",
                "5"
            )
        )
        return list
    }

}