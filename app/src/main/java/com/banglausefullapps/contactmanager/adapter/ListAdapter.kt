package com.banglausefullapps.contactmanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.banglausefullapps.contactmanager.R
import com.banglausefullapps.contactmanager.databinding.ItemRowBinding
import com.banglausefullapps.contactmanager.data.User
import com.banglausefullapps.contactmanager.repository.UserRepo
import com.banglausefullapps.contactmanager.room.UserDao
import com.banglausefullapps.contactmanager.room.UserDatabase
import com.banglausefullapps.contactmanager.views.list.DeleteViewModel
import com.banglausefullapps.contactmanager.views.list.ListFragmentDirections
import kotlinx.coroutines.launch


class ListAdapter (val list: List<User>,
                   private val view : DeleteViewModel) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(val binding: ItemRowBinding, ) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        return ListViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ListAdapter.ListViewHolder, position: Int) {
        val user = list[position]

        user.let {
            holder.binding.apply {
                name.text = it.name
                number.text = it.number

                edit.setOnClickListener {
                    val context = holder.itemView.context
                    val popupMenu = PopupMenu(context, it) // 'it' refers to the edit button
                    popupMenu.menuInflater.inflate(R.menu.delete_menu, popupMenu.menu)

                    // Set click listener for menu items
                    popupMenu.setOnMenuItemClickListener { menuItem ->
                        when (menuItem.itemId) {
                            R.id.delete -> {

                                view.delete(user)
                                true

                            }
                            else -> false
                        }
                    }

                    // Show the popup menu
                    popupMenu.show()
                }

            }
        }
        holder.binding.data.setOnClickListener {
            val act = ListFragmentDirections.actionListFragmentToUpdateFragment(user)
            holder.itemView.findNavController().navigate(act)
        }


    }

    override fun getItemCount(): Int {
       return list.size
    }
}