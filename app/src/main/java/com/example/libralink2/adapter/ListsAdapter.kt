package com.example.libralink2.adapter

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.*
import com.example.libralink2.R
import com.example.libralink2.database.BookList
import com.example.libralink2.databinding.ListItemViewBinding

class ListsAdapter(private val onItemClicked: (BookList) -> Unit) :
    ListAdapter<BookList, ListsAdapter.ListsViewHolder>(DiffCallback) {

//    val res: Resources = resources
//    private var defaultList = res.getStringArray(R.array.lists).toList()
//
//    override fun getItemCount(): Int = list.size

    class ListsViewHolder(private var binding: ListItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bookList: BookList) {
            binding.apply {
                listButtonItem.text = bookList.listName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListsViewHolder {
        return ListsViewHolder(
            ListItemViewBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ListsViewHolder, position: Int) {
//        var listItem = defaultList[position]
//        holder.binding.listButtonItem.text = listItem

//        val listItem: String = bookLists[position].listName.toString()

//
//        holder.listButton.setOnClickListener {
//
//        }

    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<ClipData.Item>() {
            override fun areListItemsTheSame(oldItem: BookList, newItem: BookList): Boolean {
                return oldItem == newItem
            }

            override fun areListContentsTheSame(oldItem: BookList, newItem: BookList): Boolean {
                return oldItem.listName == newItem.listName
            }
        }
    }

}