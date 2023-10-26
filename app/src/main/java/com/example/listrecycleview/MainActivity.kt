package com.example.listrecycleview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var recyclerView: RecyclerView
private lateinit var manager: RecyclerView.LayoutManager
private lateinit var myAdapter: RecyclerView.Adapter<*>

class MainActivity : ComponentActivity(), MyAdapter.OnItemClickListener {
    var values :List<String> = arrayListOf<String>("fedi", "gesem" , "amin", "salem", "dadai")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        manager = LinearLayoutManager(this)
        myAdapter = MyAdapter(values,this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            layoutManager = manager
            adapter = myAdapter
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked",
            Toast.LENGTH_SHORT).show()
      //      values[position]="Clicked"
            myAdapter.notifyItemChanged(position)
    }


}


