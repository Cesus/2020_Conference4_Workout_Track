package com.example.myworkouttracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myworkouttracker.models.Workout
import kotlinx.android.synthetic.main.layout_workout_list_item.view.*

class WorkoutRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Workout> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WorkoutViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_workout_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is WorkoutViewHolder ->{
                holder.bind(items[position])
            }
        }
    }

    fun submitList(workoutList: List<Workout>) {
        items = workoutList
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class WorkoutViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){

        val activity = itemView.activity_title
        val weight = itemView.weight_title
        val sets = itemView.sets_title
        val reps = itemView.reps_title

        fun bind(workout: Workout){

            activity.text = workout.activity
            weight.text = convertToStringWeight(workout.weight)
            sets.text = convertToStringSets(workout.sets)
            reps.text = convertToStringReps(workout.reps)

        }

    }

}