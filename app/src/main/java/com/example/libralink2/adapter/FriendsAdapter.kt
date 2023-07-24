package com.example.libralink2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.libralink2.R
import com.example.libralink2.recyclerview.FriendsRvClass

class FriendsAdapter(var myClass : MutableList<FriendsRvClass>):
    RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {

    inner class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemNameFriend :TextView = itemView.findViewById(R.id.tvNameFriend)
        //val itemTime :TextView = itemView.findViewById(R.id.tvTime)
        val itemImages:ImageView = itemView.findViewById(R.id.imageViewFriend)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_friends,parent,false)
        return FriendsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        holder.itemView.apply {
            holder.itemNameFriend.text = myClass[position].nameOfFriend
            myClass[position].images?.let { holder.itemImages.setImageResource(it) }
        }
        //holder.itemTime.text=time[position]
        //holder.itemImages.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return  myClass.size
    }
}