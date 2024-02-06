package com.banglausefullapps.contactmanager.views.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.banglausefullapps.contactmanager.R
import com.banglausefullapps.contactmanager.adapter.ListAdapter
import com.banglausefullapps.contactmanager.databinding.FragmentListBinding
import com.banglausefullapps.contactmanager.data.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    lateinit var adapter: ListAdapter
    val viewModel: ListViewModel by viewModels()
    val viewModel1: DeleteViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.create.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_createFragment)
        }


        viewModel.getAllUser().observe(viewLifecycleOwner){
            adapter = ListAdapter(it as List<User>,viewModel1)
            binding.rcv.adapter = adapter
        }

    }


}