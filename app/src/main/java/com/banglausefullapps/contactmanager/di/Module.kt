package com.banglausefullapps.contactmanager.di

import android.content.Context
import androidx.room.Room
import com.banglausefullapps.contactmanager.room.UserDao
import com.banglausefullapps.contactmanager.room.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext

import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : UserDatabase{
        return Room.databaseBuilder(context,UserDatabase::class.java,"user!!").build()

    }
    @Provides
    @Singleton
    fun provideDao(db: UserDatabase): UserDao{
        return db.getDao()
    }




}