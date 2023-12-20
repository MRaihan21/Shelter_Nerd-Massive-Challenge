package com.xet.Activity.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.xet.R
import com.xet.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()


        binding.btnRegis.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.pass.text.toString()
            val confpass = binding.konfPass.text.toString()

            if (email.isEmpty()){
                binding.email.error = "Email Tidak Berhasil"
                binding.email.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.email.error = "Email Tidak Valid"
                binding.email.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                binding.pass.error = "Email Harus Diisi"
                binding.pass.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 8){
                binding.pass.error = "Password Minimal 8 Karakter"
                binding.pass.requestFocus()
                return@setOnClickListener
            }
            if (confpass.isEmpty()){
                binding.konfPass.error = "Password Tidak Sama"
                binding.konfPass.requestFocus()
                return@setOnClickListener
            }
            if (password != confpass){
                binding.konfPass.error = "Password Tidak Sama"
                binding.konfPass.requestFocus()
                return@setOnClickListener
            }
            RegiterFirebase(email,password,confpass)}

        binding.ivArrowBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.ivArrowBack.setOnClickListener {
            finish()
        }
    }

    private fun RegiterFirebase(email: String, password: String, confpass: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}