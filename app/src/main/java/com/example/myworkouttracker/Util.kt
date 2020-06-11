package com.example.myworkouttracker

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

fun convertToStringWeight(weight: String) : String = "$weight lbs"

fun convertToStringSets(sets: String) : String = "$sets sets"

fun convertToStringReps(reps: String) : String = "$reps reps"

// Rounds to the nearest 2.5 (matches the minimum weight of plates)
fun roundToTwoPointFive(d : Double) : Double {
    return (d * 0.4).roundToInt() / 0.4
}
