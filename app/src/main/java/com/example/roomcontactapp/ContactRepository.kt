package com.example.roomcontactapp

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactRepository(val dao: ContactDao) {
    fun insertContact(contact: Contact) {
    CoroutineScope(Dispatchers.IO).launch {
        dao.upsertContact(contact)
    }
    }

    fun getAllContacts() : LiveData<List<Contact>> = dao.getAllContacts()


    fun getbyFirstName() : LiveData<List<Contact>> = dao.getOrderedbyFirstName()


    fun getbylastName() :LiveData<List<Contact>> = dao.getOrderedbylastName()


    fun getbyphone() : LiveData<List<Contact>> = dao.getOrderedbyphone()


}