package com.example.roomcontactapp


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.roomcontactapp.databinding.ContactDialogBinding

class CreateContact : AppCompatActivity() {
    private lateinit var contactDialogBinding : ContactDialogBinding
    val viewModel : ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        contactDialogBinding = ContactDialogBinding.inflate(layoutInflater)
        setContentView(contactDialogBinding.root)


        contactDialogBinding.btnSave.setOnClickListener {
            createContact()
        }

    }



    private fun createContact(){
        val firstName = contactDialogBinding.etFirstName.text.toString()
        val lastName = contactDialogBinding.etSecondName.text.toString()
        val number = contactDialogBinding.etNumber.text.toString()

        val contact = Contact(firstName, lastName, number)


        viewModel.addContact(contact)

        Toast.makeText(this@CreateContact,"Saved", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this@CreateContact,MainActivity::class.java))





    }
}