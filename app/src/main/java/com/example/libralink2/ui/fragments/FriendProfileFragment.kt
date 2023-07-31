package com.example.libralink2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.libralink2.LibraLinkApplication
import com.example.libralink2.databinding.FragmentFriendProfileBinding
import com.example.libralink2.databinding.FragmentProfileBinding
import com.example.libralink2.viewmodels.ProfileViewModel
import com.example.libralink2.viewmodels.ProfileViewModelFactory

class FriendProfileFragment : Fragment() {
    private var _binding: FragmentFriendProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProfileViewModel by activityViewModels {
        ProfileViewModelFactory(
            (activity?.application as LibraLinkApplication).database.userDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentFriendProfileBinding.inflate(inflater, container, false)
        _binding = fragmentBinding
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}