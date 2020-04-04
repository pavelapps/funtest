package com.andreev.funtest.main_screen.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreev.funtest.main_screen.models.Life
import com.andreev.funtest.R
import com.andreev.funtest.main_screen.models.WorldItem

class CellAdapter(var cells: ArrayList<WorldItem>) : RecyclerView.Adapter<CellViewHolder>() {

    private var listener: OnScrollDownListener? = null

    fun setScrollDownListener(listener: OnScrollDownListener) {
        this.listener = listener
    }

    fun addCell(cell: WorldItem) {
        Log.d("test", "add ${cell.javaClass.simpleName}")
        cells.add(cell)
        val index = cells.lastIndex
        notifyItemInserted(index)

        checkCombinations()

        listener?.onScroll(index)
    }

    fun removeCell(index: Int) {
        if (index < 0)
            return

        val cell = cells[index]
        Log.d("test", "remove ${cell.javaClass.simpleName}")
        cells.removeAt(index)
        notifyItemRemoved(index)

        listener?.onScroll(cells.lastIndex)
    }

    fun checkCombinations() {
        when (cells.checkCombinations()) {
            Combination.THREE_DIED -> removeCell(cells.getLifeIndexForRemove())
            Combination.THREE_LIVING -> addCell(Life())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_view, parent, false) as View
        return CellViewHolder(view)
    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        val item = cells[position]
        holder.bind(item)
    }

    override fun getItemCount() = cells.size
}

interface OnScrollDownListener {
    fun onScroll(index: Int)
}