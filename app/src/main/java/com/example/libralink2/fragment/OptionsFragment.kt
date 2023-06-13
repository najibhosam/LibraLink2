package com.example.libralink2.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.libralink2.AddListActivity
import com.example.libralink2.MyBookActivity
import com.example.libralink2.R
import com.example.libralink2.databinding.FragmentOptionsBinding

class OptionsFragment : Fragment(R.layout.fragment_options) {

    private var _binding:FragmentOptionsBinding? =null
    private val binding get() =_binding!!


    private lateinit var viewModel: OptionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOptionsBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMyBooks.setOnClickListener {
            activity?.let{
                val intent = Intent (it, MyBookActivity::class.java)
                it.startActivity(intent)
            }
        }
        binding.btnWishList.setOnClickListener {
            activity?.let{
                val intent = Intent (it, AddListActivity::class.java)
                it.startActivity(intent)
            }
        }
        binding.btnBorrowedBooks.setOnClickListener {
            activity?.let{
                val intent = Intent (it, AddListActivity::class.java)
                it.startActivity(intent)
            }
        }
        binding.btnFavoriteBooks.setOnClickListener {
            activity?.let{
                val intent = Intent (it, AddListActivity::class.java)
                it.startActivity(intent)
            }
        }
        binding.btnAddList.setOnClickListener {
            activity?.let{
                val intent = Intent (it, AddListActivity::class.java)
                it.startActivity(intent)
            }
           // val intent = Intent (getActivity(), AddListActivity::class.java)
            //getActivity()?.startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}