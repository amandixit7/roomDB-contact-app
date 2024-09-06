package com.example.roomcontactapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    val repository : ContactRepository
    init {
        val dao = ContactDatabase.getDatabaseInstance(application).dao
        repository = ContactRepository(dao)
    }

    fun addContact(contact: Contact)
    {
        repository.insertContact(contact)
    }

    fun getbyFirstName() : LiveData<List<Contact>> = repository.getbyFirstName()
    fun getbyLastName() : LiveData<List<Contact>> = repository.getbylastName()
    fun getbyPhone() : LiveData<List<Contact>> = repository.getbyphone()
    fun getAllContacts() : LiveData<List<Contact>> = repository.getAllContacts()



}

