package com.sriyank.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private var listItem:ArrayList<ItemData>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: onItemClickListener){

        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.listitem,
        parent,false)

        return ViewHolder(myView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = listItem[position]

        holder.image.setImageResource(currentItem.titleImage)
        holder.head.text = currentItem.heading

    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    class ViewHolder(itemView: View,listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {

        var image: ShapeableImageView = itemView.findViewById(R.id.title_image)
        var head: TextView = itemView.findViewById(R.id.tvHeading)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }

    }

    fun setData(newList:ArrayList<ItemData>){

        val diffUtil = MyDiffUtil(listItem,newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)

        listItem = newList

        diffResult.dispatchUpdatesTo(this)
    }


}