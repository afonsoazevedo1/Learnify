package com.projetos.learnify.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.projetos.learnify.model.Items

class Repository {
    private val database = FirebaseDatabase.getInstance().reference

    fun getPopularCourses(callback: (List<Items>) -> Unit) {

        database.child("Items").addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val itemsList = mutableListOf<Items>()

                for (itemSnapshot in dataSnapshot.children) {
                    val item = itemSnapshot.getValue(Items::class.java)
                    item?.let { itemsList.add(it) }
                }
                callback(itemsList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Tratar erro
            }
        })
    }
}
