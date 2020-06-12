package com.example.myworkouttracker

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

// This creates a padding for each viewholder
class TopItemSpacingDecoration(private val padding: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = padding
    }
}