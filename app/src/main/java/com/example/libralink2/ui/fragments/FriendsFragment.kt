package com.example.libralink2.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libralink2.LibraLinkApplication
import com.example.libralink2.adapter.FriendsAdapter
import com.example.libralink2.databinding.FragmentFriendsBinding
import com.example.libralink2.viewmodels.ProfileViewModel
import com.example.libralink2.viewmodels.ProfileViewModelFactory

class FriendsFragment : Fragment() {

    private var _binding: FragmentFriendsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProfileViewModel by activityViewModels {
        ProfileViewModelFactory(
            (activity?.application as LibraLinkApplication).database.userDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFriendsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val adapter = FriendsAdapter {
//            val action = FriendsFragmentDirections.actionFriendsFragmentToFriendProfileFragment()
//            this.findNavController().navigate(action)
//        }
//        binding.rvFriend.adapter = adapter
//        viewModel.

    }
}