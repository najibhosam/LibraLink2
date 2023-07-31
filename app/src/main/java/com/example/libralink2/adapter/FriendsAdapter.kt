package com.example.libralink2.adapter

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.libralink2.R
import com.example.libralink2.database.User
//import com.example.libralink2.database.UserWithFriends
import com.example.libralink2.databinding.FriendListItemBinding

class FriendsAdapter(private val onItemClicked: (User) -> Unit) :
    ListAdapter<User, FriendsAdapter.FriendsViewHolder>(DiffCallback) {

    class FriendsViewHolder(private var binding: FriendListItemBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(friend: User) {
            binding.apply {
                tvNameFriend.text = friend.userName
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        return FriendsViewHolder(
            FriendListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.userName == newItem.userName
            }
        }
    }
}