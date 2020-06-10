package com.example.myworkouttracker.form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.myworkouttracker.R
import com.example.myworkouttracker.databinding.FragmentWorkoutABinding
import com.example.myworkouttracker.home.HomeFragmentDirections
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_workout_a.*

class WorkoutFragmentA : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Get reference to binding object and inflate all fragment views
        val binding: FragmentWorkoutABinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_workout_a, container, false)

        // Get reference to ViewModel
        val workoutAViewModel =
            ViewModelProviders.of(this).get(WorkoutAViewModel::class.java)

        binding.workoutAViewModel = workoutAViewModel

        // Sets up event listening to navigate the player when the user wants to navigates
        workoutAViewModel.navigateToTracker.observe(this, Observer {
            if (it == true) {
                val userSquat = editTextSquatNum.text.toString()
                val userBench = editTextBenchNum.text.toString()
                if (userSquat == "" || userBench == "") {
                    Toast.makeText(activity, "Please enter a value for both 1RM", Toast.LENGTH_SHORT).show()
                }
                else {
                    view?.findNavController()?.navigate(
                        WorkoutFragmentADirections.actionWorkoutFragmentAToTrackerFragment(
                            userSquat.toFloat(),
                            userBench.toFloat(),
                            "A"
                        )
                    )
                    workoutAViewModel.doneNavigating()
                }
            }
        })

        return binding.root
    }

}