package com.example.myworkouttracker.tracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myworkouttracker.*
import com.example.myworkouttracker.models.Workout
import kotlinx.android.synthetic.main.layout_workout_list_item.view.*

// this class extends recyclerview adapter and passes the generic viewholder
class WorkoutRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // initialize the dataset
    private var items: List<Workout> = ArrayList()

    // boilerplate code - creates a viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WorkoutViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_workout_list_item,
                parent,
                false
            )
        )
    }

    // the actual binding of viewholder
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            // normally there are other types of viewholders, but this is a basic project so there's only 1
            // when the viewholder is of type WorkoutViewHolder, it will bind (method below) the list of data (items) to the particular
            // viewholder that is visible
            is WorkoutViewHolder ->{
                holder.bind(items[position])
            }
        }
    }

    // this submit method submits a new list of data using the most efficient method (DiffUtil)
    fun submitList(workoutList: List<Workout>) {
        // old list is equal to current list
        val oldList = items
        // pass the old list and the new list through the object created below
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            WorkoutItemDiffCallback(
                oldList,
                workoutList
            )
        )
        // set current list to new list
        items = workoutList
        // using the callback, it updates recyclerview
        diffResult.dispatchUpdatesTo(this)
    }

    class WorkoutItemDiffCallback(var oldWorkOutList: List<Workout>, var newWorkOutList: List<Workout>) : DiffUtil.Callback(){

        // calls to decide whether two items represent the same item
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return (oldWorkOutList.get(oldItemPosition).pk == newWorkOutList.get(newItemPosition).pk)
        }

        // get the size of the old list
        override fun getOldListSize(): Int {
            return oldWorkOutList.size
        }

        // get size of new list
        override fun getNewListSize(): Int {
            return newWorkOutList.size
        }

        // calls to check whether two items have the same DATA
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldWorkOutList.get(oldItemPosition).equals(newWorkOutList.get(newItemPosition))
        }

    }

    // returns the size of dataset
    override fun getItemCount(): Int {
        return items.size
    }

    // custom viewholder class - takes data from dataset and set it to a viewholder
    class WorkoutViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){

        // these parameters (activity) refer to the data set id's, while the right side refer to the template xml file id's
        val activity = itemView.activity_title
        val weight = itemView.weight_title
        val sets = itemView.sets_title
        val reps = itemView.reps_title

        // this bind method is responsible for taking each object and binding them to the views in the layout
        fun bind(workout: Workout){

            activity.text = workout.activity
            weight.text =
                convertToStringWeight(workout.weight)
            sets.text =
                convertToStringSets(workout.sets)
            reps.text =
                convertToStringReps(workout.reps)

        }

    }

}