package com.example.myworkouttracker.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WorkoutAViewModel : ViewModel() {

    // Event which triggers the navigation
    private val _navigateToTracker = MutableLiveData<Boolean>()
    val navigateToTracker: LiveData<Boolean>
        get() = _navigateToTracker

    fun onStartTracking() {
        _navigateToTracker.value = true
    }

    // function to stop navigating
    fun doneNavigating() {
        _navigateToTracker.value = null
    }
}