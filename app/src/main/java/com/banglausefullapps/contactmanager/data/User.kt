package com.banglausefullapps.contactmanager.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "user")
@Parcelize
data class User(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name : String?,
    var number : String?

): Parcelable
