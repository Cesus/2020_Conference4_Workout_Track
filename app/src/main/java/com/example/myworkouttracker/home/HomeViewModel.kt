package com.example.myworkouttracker.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    // Event which triggers the navigation
    private val _navigateToWorkoutB = MutableLiveData<Boolean>()
    val navigateToWorkoutB: LiveData<Boolean>
        get() = _navigateToWorkoutB

    fun onStartTrackingB() {
        _navigateToWorkoutB.value = true
    }

    // function to stop navigating
    fun doneNavigatingB() {
        _navigateToWorkoutB.value = null
    }

    // Event which triggers the navigation
    private val _navigateToWorkoutA = MutableLiveData<Boolean>()
    val navigateToWorkoutA: LiveData<Boolean>
        get() = _navigateToWorkoutA

    fun onStartTrackingA() {
        _navigateToWorkoutA.value = true
    }

    // function to stop navigating
    fun doneNavigatingA() {
        _navigateToWorkoutA.value = null
    }
}