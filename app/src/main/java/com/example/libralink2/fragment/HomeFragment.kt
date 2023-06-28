package com.example.libralink2.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.libralink2.AddListActivity
import com.example.libralink2.BookActivity
import com.example.libralink2.MyBookActivity
import com.example.libralink2.R
import com.example.libralink2.databinding.FragmentHomeBinding
import com.example.libralink2.databinding.FragmentOptionsBinding
import com.loopj.android.http.AsyncHttpClient

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding:FragmentHomeBinding? = null
    private val binding get() =_binding!!
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSearch.setOnClickListener {
            activity?.let{
                val intent = Intent (it, BookActivity::class.java)
                it.startActivity(intent)
            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}