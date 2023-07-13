package com.example.libralink2.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libralink2.AddListActivity
import com.example.libralink2.MyBookActivity
import com.example.libralink2.R
import com.example.libralink2.adapter.ListsAdapter
import com.example.libralink2.database.Listen
import com.example.libralink2.database.ListDataBase
import com.example.libralink2.databinding.FragmentListsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListsFragment : Fragment() {

    private var _binding: FragmentListsBinding? = null
    private val binding get() = _binding!!

    private lateinit var listDb: ListDataBase

    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: ListsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.rvLists
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListsAdapter(requireContext())

        binding.addListButton.setOnClickListener {
            activity?.let {
                val intent = Intent(it, AddListActivity::class.java)
                it.startActivity(intent)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

//        GlobalScope.launch(Dispatchers.IO) {
//            //ListDataBase.getDatabase(applicationContext).ListenDao().insertListen(list)
//
//        }

//        binding.listBu.setOnClickListener {
//            activity?.let{
//                val intent = Intent (it, MyBookActivity::class.java)
//                it.startActivity(intent)
//            }
//        }

        // val intent = Intent (getActivity(), AddListActivity::class.java)
        //getActivity()?.startActivity(intent)


}

