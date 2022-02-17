package com.circularapk.exercise10.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.circularapk.exercise10.Data.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao():ContactDao
}