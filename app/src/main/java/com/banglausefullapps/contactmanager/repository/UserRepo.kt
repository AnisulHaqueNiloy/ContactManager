package com.banglausefullapps.contactmanager.repository

import androidx.lifecycle.LiveData
import com.banglausefullapps.contactmanager.data.User
import com.banglausefullapps.contactmanager.room.UserDao
import javax.inject.Inject

class UserRepo @Inject constructor(private val db : UserDao) {

    fun getAllUser():LiveData<List<User>>{
        return db.getallUser()
    }

    suspend fun insert(user: User){
        return db.insert(user)
    }

    suspend fun update(user: User){
        return db.update(user)
    }

    suspend fun delete(user: User){
        return db.delete(user)
    }


}