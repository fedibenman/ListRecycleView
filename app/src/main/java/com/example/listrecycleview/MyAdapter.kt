package com.example.listrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class MyAdapter(private var myDataSet: List<String>,val listener: OnItemClickListener):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val vh = LayoutInflater.from(parent.context).inflate(R.layout.lign,parent,false)
        return ViewHolder(vh)
    }

    override fun getItemCount(): Int {
        return myDataSet.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //fontion pour afficher les donnee selon la position du curseur
        var current = myDataSet[position]
        holder.vText.text = current.toString()
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }



  inner  class ViewHolder(val itemview: View):
        RecyclerView.ViewHolder(itemview), View.OnClickListener {
        val vText = itemView.findViewById(R.id.word) as TextView

        init {
            itemView.setOnClickListener(this)

        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }




    }

}



