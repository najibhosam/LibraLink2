package com.example.libralink2.adapter

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libralink2.AddListActivity
import com.example.libralink2.R

class ListsAdapter(context: Context):
    RecyclerView.Adapter<ListsAdapter.ListsViewHolder>() {

    private var list = context.resources.getStringArray(R.array.lists).toList()

    class ListsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val listButton = view.findViewById<Button>(R.id.list_button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListsViewHolder {
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item_view, parent, false)

        return ListsViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ListsViewHolder, position: Int) {
//        val listItem: String = bookLists[position].listName.toString()

        var listItem = list[position]
        holder.listButton.text = listItem
//        holder.listButton.setOnClickListener {
//
//        }

    }

    override fun getItemCount(): Int = list.size

}