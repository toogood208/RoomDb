package com.example.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.contact.adapter.CategoryAdapter
import com.example.contact.data.DataSource
import com.example.contact.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {
    private var _binding : FragmentCategoryBinding? = null
    private val binding get()  = _binding!!
    val myDataset = DataSource().loadCategoryData()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycleView = binding.recycleView
        recycleView.apply{layoutManager = GridLayoutManager(activity, 2)}
        recycleView.adapter = CategoryAdapter(myDataset, this)
    }


}