package com.example.libralink2.ui.fragments

import android.content.ClipData
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import com.example.libralink2.LibraLinkApplication
import com.example.libralink2.database.User
import com.example.libralink2.databinding.FragmentListsBinding
import com.example.libralink2.databinding.FragmentLoginBinding
import com.example.libralink2.viewmodels.ProfileViewModel
import com.example.libralink2.viewmodels.ProfileViewModelFactory

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    lateinit var username: String
    lateinit var password: String

    private val profileViewModel: ProfileViewModel by activityViewModels {
        ProfileViewModelFactory(
            (activity?.application as LibraLinkApplication).database
                .userDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


//    private fun validateData() {
//        username = binding.etUsername.text.toString()
//        password = binding.passwordEt.text.toString()
//
//        else if (password.isEmpty()){
//            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show()
//        }
//        else
//            checkUser(username)
//    }

//    private fun loginUser() {
//        val user = profileViewModel.retrieveUser()
//
//    }

//    private fun checkUser(username: String) : Boolean {
//        var userId = profileViewModel.getUserId(username)
//        if()
//    }
}