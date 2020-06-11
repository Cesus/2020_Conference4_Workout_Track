package com.example.myworkouttracker

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Workout (

    @Expose
    @SerializedName("pk")
    val pk: Int? = null,

    @Expose
    @SerializedName("title")
    var activity: String,

    @Expose
    @SerializedName("weight")
    var weight: String,

    @Expose
    @SerializedName("sets")
    var sets: String,

    @Expose
    @SerializedName("reps")
    var reps: String

) {
    override fun equals(other: Any?): Boolean {
        if (javaClass != other?.javaClass) return false

        other as Workout

        if (pk != other.pk) return false
        if (activity != other.activity) return false
        if (weight != other.weight) return false
        if (sets != other.sets) return false
        if (reps != other.reps) return false


        return true
    }
}
