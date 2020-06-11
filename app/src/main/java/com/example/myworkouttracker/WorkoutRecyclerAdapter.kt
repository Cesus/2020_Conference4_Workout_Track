package com.example.myworkouttracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
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
        val oldList = items
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            WorkoutItemDiffCallback(oldList, workoutList)
        )
        items = workoutList
        diffResult.dispatchUpdatesTo(this)
    }

    class WorkoutItemDiffCallback(var oldWorkOutList: List<Workout>, var newWorkOutList: List<Workout>) : DiffUtil.Callback(){

        // calls to decide whether two items represent the same item
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return (oldWorkOutList.get(oldItemPosition).pk == newWorkOutList.get(newItemPosition).pk)
        }

        override fun getOldListSize(): Int {
            return oldWorkOutList.size
        }

        override fun getNewListSize(): Int {
            return newWorkOutList.size
        }

        // calls to check whether two items have the same DATA
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldWorkOutList.get(oldItemPosition).equals(newWorkOutList.get(newItemPosition))
        }

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