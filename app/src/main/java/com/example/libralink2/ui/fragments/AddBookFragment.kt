package com.example.libralink2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.libralink2.databinding.FragmentListsBinding
import com.example.libralink2.viewmodels.AddBookViewModel

class AddBookFragment : Fragment() {
    private var _binding: FragmentListsBinding? =null
    private val binding get() =_binding!!

    private lateinit var viewModel: AddBookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListsBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}