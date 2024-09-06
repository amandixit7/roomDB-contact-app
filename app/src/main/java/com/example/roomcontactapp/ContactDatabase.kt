package com.example.roomcontactapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (
    entities = [Contact::class],
    version = 1
)
abstract class ContactDatabase : RoomDatabase(){

    abstract val dao : ContactDao

    companion object {
        @Volatile
        var instance : ContactDatabase? = null
        fun getDatabaseInstance(context : Context) : ContactDatabase{
            val tempInstance = instance
            if(tempInstance!=null){
                return tempInstance
            }
            // Synchronized block to make sure that
            // only one instance of the database is created
            synchronized(this){
                val roomDatabaseInstance = Room.databaseBuilder(context,ContactDatabase::class.java,"Contacts").build()
                instance = roomDatabaseInstance
                return roomDatabaseInstance
            }
        }
    }
}