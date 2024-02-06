package com.banglausefullapps.contactmanager.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.banglausefullapps.contactmanager.data.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getDao() : UserDao

}