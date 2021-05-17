package com.example.contact.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contact.R
import com.example.contact.databinding.ContactListItemBinding
import com.example.contact.model.ContactData

class ContactAdapter:RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val contacts = mutableListOf<ContactData>()

    class ContactViewHolder(private val binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bindItems(contact:ContactData){
            binding.nameTv.text = contact.name
            binding.numerTv.text = contact.number
        }

    }


    fun setUpcontact(contacts: List<ContactData>){
            this.contacts.addAll(contacts)
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount()= contacts.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
       val contact = contacts[position]
        holder.bindItems(contact)

    }
}