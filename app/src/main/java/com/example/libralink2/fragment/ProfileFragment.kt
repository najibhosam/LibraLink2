package com.example.libralink2.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.libralink2.AddListActivity
import com.example.libralink2.FriendsActivity
import com.example.libralink2.R
import com.example.libralink2.databinding.FragmentOptionsBinding
import com.example.libralink2.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var _binding: FragmentProfileBinding? =null
    private val binding get() =_binding!!



    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnData.setOnClickListener {

        }

        binding.btnFriends.setOnClickListener {
            activity?.let{
                val intent = Intent (it, FriendsActivity::class.java)
                it.startActivity(intent)
            }

        }
        binding.btnMyProgress.setOnClickListener {

        }
        binding.btnHelp.setOnClickListener {

        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}