package com.example.libralink2.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libralink2.LibraLinkApplication
import com.example.libralink2.adapter.ListsAdapter
import com.example.libralink2.databinding.FragmentListsBinding
import com.example.libralink2.viewmodels.ListsViewModel
import com.example.libralink2.viewmodels.ProfileViewModel
import com.example.libralink2.viewmodels.ProfileViewModelFactory

class ListsFragment : Fragment() {

    private var _binding: FragmentListsBinding? = null
    private val binding get() = _binding!!

    private val profileViewModel: ProfileViewModel by activityViewModels {
        ProfileViewModelFactory(
            (activity?.application as LibraLinkApplication).database
                .userDao()
        )
    }

//    init {
//        profileViewModel.createDefaultUser()
//    }

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
        super.onViewCreated(view, savedInstanceState)
        val adapter = ListsAdapter {
            val action = ListsFragmentDirections.actionListsFragmentToBookListFragment()
            this.findNavController().navigate(action)
        }
        binding.rvLists.adapter = adapter
        binding.rvLists.layoutManager = LinearLayoutManager(this.context)
        binding.addListButton.setOnClickListener {
            val action = ListsFragmentDirections.actionListsFragmentToAddListFragment()
            findNavController().navigate(action)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

