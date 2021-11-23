package com.example.draganddrop

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class ItemMoveCallBack(private val adapter: ItemTouchHelperAdapter):ItemTouchHelper.Callback() {


    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return false

    }


    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags =
            ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlags, 0)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.onRowMoved(viewHolder.adapterPosition, target.adapterPosition);
        return true;
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)

        if (actionState !== ItemTouchHelper.ACTION_STATE_IDLE) {
            if (viewHolder is RecyclerView.ViewHolder) {
                val myViewHolder: RecyclerView.ViewHolder =
                    viewHolder as RecyclerView.ViewHolder
                adapter.onRowSelected(myViewHolder)
            }
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        if (viewHolder is RecyclerView.ViewHolder) {
            val myViewHolder: RecyclerView.ViewHolder =
                viewHolder as RecyclerView.ViewHolder
            adapter.onRowClear(myViewHolder)
        }
    }

    interface ItemTouchHelperAdapter {
        fun onRowMoved(fromPosition: Int, toPosition: Int)
        fun onRowSelected(myViewHolder: RecyclerView.ViewHolder?)
        fun onRowClear(myViewHolder: RecyclerView.ViewHolder?)
    }

}