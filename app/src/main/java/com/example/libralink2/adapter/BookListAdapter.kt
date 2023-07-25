package com.example.libralink2.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.libralink2.database.Book
import com.example.libralink2.database.BookList
import com.example.libralink2.databinding.BookListItemBinding
import java.text.SimpleDateFormat

class BookListAdapter(
    private val onItemClicked: (Book) -> Unit
) : ListAdapter<Book, BookListAdapter.BookListViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.bookId == newItem.bookId
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem == newItem
            }
        }
    }

    class BookListViewHolder(private var binding: BookListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
//            binding.stopNameTextView.text = schedule.stopName
//            binding.arrivalTimeTextView.text = SimpleDateFormat(
//                "h:mm a").format(Date(schedule.arrivalTime.toLong() * 1000))
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val viewHolder = BookListViewHolder(
            BookListItemBinding.inflate(
                LayoutInflater.from( parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}