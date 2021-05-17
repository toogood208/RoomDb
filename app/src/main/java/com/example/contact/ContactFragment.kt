package com.example.contact

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.contact.adapter.ContactAdapter
import com.example.contact.databinding.FragmentContactBinding
import com.example.contact.model.ContactData

class ContactFragment : Fragment() {
    companion object{
        const val CATEGORY = "Category"
    }
    private var _binding : FragmentContactBinding? = null
    private val binding get()  = _binding!!
    private lateinit var categoryId :String
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { categoryId = it.getString(CATEGORY).toString() }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpData(binding)


    }

    private fun setUpData(binding: FragmentContactBinding){
        // alert dialog codes
        val builder = AlertDialog.Builder(requireContext())
        val view = layoutInflater.inflate(R.layout.add_contact_dialog, null)
        builder.setView(view)
        val alertDialog = builder.create()

        // plug the adapter into  the relative layout
        binding.contactRv.adapter = adapter
        binding.contactRv.addItemDecoration(
            DividerItemDecoration(context,DividerItemDecoration.VERTICAL)
        )

        binding.fab.setOnClickListener { alertDialog.show() }

        // codes to save data
        val name = view.findViewById<TextView>(R.id.nameEt)
        val number = view.findViewById<TextView>(R.id.numberEt)
        val saveButton = view.findViewById<TextView>(R.id.save_button)

        number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveButton.isEnabled = s?.length == 11
            }
        })

        saveButton.setOnClickListener {
            val contact = ContactData(name.text.toString(),number.text.toString())
            val contacts = mutableListOf(contact)
            adapter.setUpcontact(contacts)

            alertDialog.dismiss()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}