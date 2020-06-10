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
import com.example.myworkouttracker.databinding.FragmentWorkoutBBinding
import com.example.myworkouttracker.home.HomeFragmentDirections
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_workout_a.*
import kotlinx.android.synthetic.main.fragment_workout_b.*

class WorkoutFragmentB : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Get reference to binding object and inflate all fragment views
        val binding: FragmentWorkoutBBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_workout_b, container, false)

        // Get reference to ViewModel
        val workoutBViewModel =
            ViewModelProviders.of(this).get(WorkoutBViewModel::class.java)

        binding.workoutBViewModel = workoutBViewModel

        // Sets up event listening to navigate the player when the user wants to navigates
        workoutBViewModel.navigateToTracker.observe(this, Observer {
            if (it == true) {
                val userDL = editTextDeadliftNum.text.toString()
                val userPress = editTextPressNum.text.toString()
                if (userDL == "" || userPress == "") {
                    Toast.makeText(activity, "Please enter a value for both 1RM", Toast.LENGTH_SHORT).show()
                }
                else {
                    view?.findNavController()?.navigate(
                        WorkoutFragmentBDirections.actionWorkoutFragmentBToTrackerFragment(
                            userDL.toFloat(),
                            userPress.toFloat(),
                            "B"
                        )
                    )
                    workoutBViewModel.doneNavigating()
                }
            }
        })

        return binding.root
    }

}