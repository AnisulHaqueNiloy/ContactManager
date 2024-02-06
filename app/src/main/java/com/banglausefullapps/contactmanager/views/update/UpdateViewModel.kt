package com.banglausefullapps.contactmanager.views.update


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banglausefullapps.contactmanager.repository.UserRepo
import com.banglausefullapps.contactmanager.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(private val repo: UserRepo): ViewModel() {

        fun update(user: User){
            viewModelScope.launch {
                repo.update(user)
            }
        }

}