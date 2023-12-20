package com.xet.Activity.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.xet.Activity.MainActivity
import com.xet.R
import com.xet.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.pass.text.toString()

            if (email.isEmpty()){
                binding.email.error = "Email harus diisi"
                binding.email.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.email.error = "Email tidak valid"
                binding.email.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                binding.pass.error = "Password harus diisi"
                binding.pass.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 8){
                binding.pass.error = "Password minimal 8 karakter"
                binding.pass.requestFocus()
                return@setOnClickListener
            }
            LoginFirebase(email,password)}

        binding.tvForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.tvRegis.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this@LoginActivity, "Berhasil Login", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}