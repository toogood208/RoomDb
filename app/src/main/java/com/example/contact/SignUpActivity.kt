package com.example.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.contact.databinding.ActivitySignUpBinding
import com.example.contact.model.Users
import com.example.contact.model.UsersDataBase
import com.example.contact.repository.UsersRepository

class SignUpActivity : AppCompatActivity() {
    private lateinit var repository: UsersRepository
    private lateinit var binding:ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = UsersRepository(this)
        binding.saveButton.setOnClickListener { addToDb() }
    }

    fun addToDb(){
        with(binding){
            val fullName = fullnameText.text.toString()
            val email = emailText.text.toString()
            val password = passwordText.text.toString()
            val confirmPassword = confirmButtonText.text.toString()

            if (fullnameText.text.isNullOrEmpty() && emailText.text.isNullOrEmpty()
                && binding.passwordText.text.isNullOrEmpty() && binding.confirmButtonText.text.isNullOrEmpty()){
                Toast.makeText(this@SignUpActivity, "All Field are required", Toast.LENGTH_SHORT).show()
            }else{
                val userEntity = Users(fullName,email,password,confirmPassword)
                repository.insert(userEntity)
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()


            }



        }



    }

}