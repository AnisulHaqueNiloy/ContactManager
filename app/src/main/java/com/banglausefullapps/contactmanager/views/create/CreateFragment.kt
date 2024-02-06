package com.banglausefullapps.contactmanager.views.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.banglausefullapps.contactmanager.R
import com.banglausefullapps.contactmanager.databinding.FragmentCreateBinding
import com.banglausefullapps.contactmanager.data.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateFragment : Fragment() {

lateinit var binding: FragmentCreateBinding
    val viewModel: CreateViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.save.setOnClickListener {
            saveit()


        }


    }

    private fun saveit() {
        if (binding.name.text.isNullOrEmpty()){
            binding.name.error = "Insert the contact name"
        }
        else if (binding.number.text.isNullOrEmpty()){
            binding.number.error = " Insert the contact number"
        }
        else{
            binding.apply {
                var name = name.text.toString()
                var number = number.text.toString()
                val user = User(name = name, number = number)
                viewModel.insert(user)
                findNavController().navigate(R.id.action_createFragment_to_listFragment)
            }
        }


    }


}