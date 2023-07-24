package com.example.libralink2.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libralink2.AddListActivity
import com.example.libralink2.adapter.ListsAdapter
import com.example.libralink2.databinding.FragmentListsBinding
import com.example.libralink2.viewmodels.ListsViewModel

class ListsFragment : Fragment() {

    private var _binding: FragmentListsBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: ListsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.rvLists
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListsAdapter(requireContext())

        binding.addListButton.setOnClickListener {
            activity?.let {
                val intent = Intent(it, AddListActivity::class.java)
                it.startActivity(intent)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

