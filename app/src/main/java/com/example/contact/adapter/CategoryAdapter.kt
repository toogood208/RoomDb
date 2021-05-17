package com.example.contact.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.contact.CategoryFragment
import com.example.contact.CategoryFragmentDirections
import com.example.contact.R
import com.example.contact.model.CategoryData

class CategoryAdapter(private val dataset:List<CategoryData>,
                      private val context: CategoryFragment
):RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    class CategoryViewHolder(view: View):RecyclerView.ViewHolder(view){
        val categoryText = view.findViewById<TextView>(R.id.category_title)
        val categoryImage = view.findViewById<ImageView>(R.id.category_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryAdapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.category_list,parent,false)
        return CategoryViewHolder(categoryAdapterLayout)
    }

    override fun getItemCount()= dataset.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val contact = dataset[position]
        holder.categoryText.text = contact.name
        holder.categoryImage.setImageResource(contact.imageR)

        holder.categoryText.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToContactFragment(
                category = holder.categoryText.text.toString()
            )

            holder.itemView.findNavController().navigate(action)
        }

    }


}