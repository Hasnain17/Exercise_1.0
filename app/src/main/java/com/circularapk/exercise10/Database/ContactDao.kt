package com.circularapk.exercise10.Database
import androidx.lifecycle.LiveData
import androidx.room.*
import com.circularapk.exercise10.Data.Contact

@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact: Contact)
    @Update
    suspend fun updateContact(contact: Contact)
    @Delete
    suspend fun deleteContact(contact: Contact)
    @Query("Select * from contacts")
    fun getContact(): LiveData<List<Contact>>

    //Android wishes to run these Queries on background threads not on main threads, So coroutines are used for this purpose
}