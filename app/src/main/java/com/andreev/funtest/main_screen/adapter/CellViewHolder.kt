package com.andreev.funtest.main_screen.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.andreev.funtest.main_screen.models.WorldItem
import kotlinx.android.synthetic.main.cell_view.view.*

class CellViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: WorldItem) {
        view.cell_icon.setImageResource(item.getItemImage())
        view.cell_name.setText(item.getItemName())
        view.cell_description.setText(item.getItemDescription())
    }
}