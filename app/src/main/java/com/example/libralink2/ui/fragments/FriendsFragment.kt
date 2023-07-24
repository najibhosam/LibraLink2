package com.example.libralink2.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libralink2.adapter.FriendsAdapter
import com.example.libralink2.databinding.FragmentFriendsBinding
import com.example.libralink2.recyclerview.FriendsRvClass

class FriendsFragment : Fragment() {
    private var _binding: FragmentFriendsBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    var todoList: MutableList<FriendsRvClass> = mutableListOf()

    init {
        todoList = mutableListOf(
            FriendsRvClass("john",null),
            FriendsRvClass("Sahra",null),
            FriendsRvClass("Moh",null)
        )
    }
    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFriendsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.rvFriend
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = FriendsAdapter(todoList)

    }
}