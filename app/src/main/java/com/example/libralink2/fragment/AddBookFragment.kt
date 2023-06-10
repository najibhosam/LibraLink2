package com.example.libralink2.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.libralink2.R
import com.example.libralink2.databinding.FragmentOptionsBinding

class AddBookFragment : Fragment(R.layout.fragment_add_book) {
    private var _binding: FragmentOptionsBinding? =null
    private val binding get() =_binding!!



    private lateinit var viewModel: AddBookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOptionsBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}