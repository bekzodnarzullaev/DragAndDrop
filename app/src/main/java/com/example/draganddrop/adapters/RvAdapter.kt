package com.example.draganddrop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.draganddrop.ItemMoveCallBack
import com.example.draganddrop.databinding.ItemGridBinding
import java.util.*
import kotlin.collections.ArrayList

class RvAdapter(private val list: ArrayList<String>):RecyclerView.Adapter<RvAdapter.Vh>(),ItemMoveCallBack.ItemTouchHelperAdapter {

    inner class Vh(var itemGridBinding: ItemGridBinding):RecyclerView.ViewHolder(itemGridBinding.root){
       fun onBind(text:String){
           itemGridBinding.tv.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemGridBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(list, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(list, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRowSelected(myViewHolder: RecyclerView.ViewHolder?) {

    }

    override fun onRowClear(myViewHolder: RecyclerView.ViewHolder?) {

    }
}