package com.example.roomcontactapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

   @Query("SELECT * FROM Contact ORDER by firstName ASC")
   fun getOrderedbyFirstName() : LiveData<List<Contact>>

    @Query("SELECT * FROM Contact ORDER by lastName ASC")
   fun getOrderedbylastName() :LiveData<List<Contact>>

    @Query("SELECT * FROM Contact ORDER by phoneNumber ASC")
   fun getOrderedbyphone() : LiveData<List<Contact>>

    @Query("SELECT * FROM Contact")
    fun getAllContacts() : LiveData<List<Contact>>
}