package com.banglausefullapps.contactmanager.views.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banglausefullapps.contactmanager.repository.UserRepo
import com.banglausefullapps.contactmanager.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(private val repo: UserRepo): ViewModel() {

        fun insert(user: User){
            viewModelScope.launch {
                repo.insert(user)
            }
        }

}