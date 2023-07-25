package com.example.libralink2.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.libralink2.LibraLinkApplication
import com.example.libralink2.database.User
import com.example.libralink2.databinding.FragmentRegisterBinding
import com.example.libralink2.viewmodels.ProfileViewModel
import com.example.libralink2.viewmodels.ProfileViewModelFactory

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val profileViewModel: ProfileViewModel by activityViewModels {
        ProfileViewModelFactory(
            (activity?.application as LibraLinkApplication).database
                .userDao()
        )
    }

    lateinit var user: User
    private var inputEmail = binding.etEmail
    private var password = binding.etCpassword
    private var vPassword = binding.etPassword

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun isEntryValid(): Boolean {
        return profileViewModel.isUserEntryValid(
            binding.etName.text.toString(),
            binding.etLastName.text.toString(),
            binding.etUsername.text.toString(),
            inputEmail.text.toString(),
            binding.etPassword.text.toString()
        )
    }

    fun isValidEmail(email: String) : Boolean {
        if(!email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true
        }
        inputEmail.setError("Please enter a valid email")
        return false
    }

    fun arePasswordsMatching(password: String, secondPassword: String) : Boolean {
        if(password.isBlank() || secondPassword.isBlank() || password != secondPassword) {
            return false
        }
        return true
    }

    private fun addNewUser() {
        if (isEntryValid()) {
            profileViewModel.addNewUser(
                binding.etName.text.toString(),
                binding.etLastName.text.toString(),
                binding.etUsername.text.toString(),
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            )
            Toast.makeText(getActivity(), "User added!",
                Toast.LENGTH_LONG).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSend.setOnClickListener {
            addNewUser()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Hide keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binding = null
    }
}

