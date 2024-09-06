package com.example.roomcontactapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomcontactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel : ContactViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        var contacts : List<Contact> = emptyList()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btnAdd.setOnClickListener {
           val intent = Intent(this, CreateContact::class.java)
           startActivity(intent)
       }

        viewModel.getAllContacts().observe(this, Observer {
                list ->
            binding.rvContact.layoutManager = LinearLayoutManager(applicationContext)
            binding.rvContact.adapter = ContactAdapter(this, list)
        })

        binding.rgButtons.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.rbFirst -> {
                    viewModel.getbyFirstName().observe(this, Observer { list ->
                        contacts = list
                        binding.rvContact.adapter = ContactAdapter(this, contacts)
                        binding.rvContact.layoutManager = LinearLayoutManager(applicationContext)
                    })
                }

                R.id.rbSecond -> {
                    viewModel.getbyLastName().observe(this, Observer { list ->
                        contacts = list
                        binding.rvContact.adapter = ContactAdapter(this, contacts)
                        binding.rvContact.layoutManager = LinearLayoutManager(applicationContext)
                    })
                }

                R.id.rbNumber -> {
                    viewModel.getbyPhone().observe(this, Observer { list ->
                        contacts = list
                        binding.rvContact.adapter = ContactAdapter(this, contacts)
                        binding.rvContact.layoutManager = LinearLayoutManager(applicationContext)
                    })
                }
            }


            }
        }
        
}

