package com.example.myworkouttracker.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.myworkouttracker.R
import com.example.myworkouttracker.databinding.FragmentHomeBinding
import com.example.myworkouttracker.tracker.WorkoutRecyclerAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Get reference to binding object and inflate all fragment views
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false)

        // Get reference to ViewModel
        val homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)

        binding.homeViewModel = homeViewModel

        // Sets up event listening to navigate the player when the user wants to navigates to workout A
        homeViewModel.navigateToWorkoutA.observe(this, Observer {
            if (it == true) {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToWorkoutFragmentA())
                homeViewModel.doneNavigatingA()
            }
        })

        // Sets up event listening to navigate the player when the user wants to navigates to workout B
        homeViewModel.navigateToWorkoutB.observe(this, Observer {
            if (it == true) {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToWorkoutFragmentB())
                homeViewModel.doneNavigatingB()
            }
        })

        return binding.root
    }
}