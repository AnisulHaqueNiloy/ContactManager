package com.banglausefullapps.contactmanager.views.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.banglausefullapps.contactmanager.R
import com.banglausefullapps.contactmanager.data.User

import com.banglausefullapps.contactmanager.databinding.FragmentUpdateBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : Fragment() {
    lateinit var binding : FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()
    val viewModel: UpdateViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.apply {
            name.setText(args.user.name)
            number.setText(args.user.number)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.update.setOnClickListener {
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
                val user = User(args.user.id,name = name, number = number)
                viewModel.update(user)
                findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            }
        }


    }


}