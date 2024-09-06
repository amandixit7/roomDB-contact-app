package com.example.roomcontactapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomcontactapp.databinding.ItemContactBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ContactAdapter(val context: Context, var contacts : List<Contact>) :
    RecyclerView.Adapter<ContactAdapter
    .ContactViewHolder>
    () {


    private val dao = ContactDatabase.getDatabaseInstance(context).dao

    inner class ContactViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder
        (binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
       return ContactViewHolder(ItemContactBinding.inflate(LayoutInflater.from(parent.context),
           parent, false))
    }


    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.binding.apply {
            tvName.text = contact.firstName + " " + contact.lastName
            tvPhone.text = contact.phoneNumber
            btnDeleteContact.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
                dao.deleteContact(contact)

            }
                notifyItemRemoved(position)

            }
        }


    }

    override fun getItemCount(): Int {
       return contacts.size
    }




}