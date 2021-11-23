package com.example.draganddrop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.draganddrop.adapters.RvAdapter
import com.example.draganddrop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var list: ArrayList<String>
    lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addItem()
        rvAdapter = RvAdapter(list)

        binding.rv.adapter = rvAdapter
        val callBack = ItemMoveCallBack(rvAdapter)
        val touchHelper=  ItemTouchHelper(callBack)
        touchHelper.attachToRecyclerView(binding.rv)
    }

    private fun addItem() {
        list = ArrayList()

        for (i in 1..10){
            list.add("$i")
        }


    }
}