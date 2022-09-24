package com.sriyank.recyclerviewkotlin

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(
    private val oldList:ArrayList<ItemData>,
    private val newList:ArrayList<ItemData>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> false
            oldList[oldItemPosition].titleImage != newList[newItemPosition].titleImage -> false
            oldList[oldItemPosition].heading != newList[newItemPosition].heading -> false
            else -> true
        }
    }
}