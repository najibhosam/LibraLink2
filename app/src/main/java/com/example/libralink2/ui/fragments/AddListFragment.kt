package com.example.libralink2.ui.fragments

import com.example.libralink2.LibraLinkApplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.libralink2.database.BookList
import com.example.libralink2.databinding.FragmentAddListBinding
import com.example.libralink2.viewmodels.ProfileViewModel
import com.example.libralink2.viewmodels.ProfileViewModelFactory

class AddListFragment : Fragment() {
    private var _binding: FragmentAddListBinding? = null
    private val binding get() = _binding!!

    private val profileViewModel: ProfileViewModel by activityViewModels {
        ProfileViewModelFactory(
            (activity?.application as LibraLinkApplication).database
                .userDao()
        )
    }

    lateinit var list: BookList

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddList.setOnClickListener {
//            addNewList()
        }
    }

//    private fun addNewList() {
//        val nameOfList = binding.etNameOfList.text.toString()
//        if (nameOfList.isNotBlank()) {
//            profileViewModel.addNewList(
//                profileViewModel.getCurrentUser().userId,
//                nameOfList
//            )
//            Toast.makeText(getActivity(), "List added!",
//                Toast.LENGTH_LONG).show()
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
