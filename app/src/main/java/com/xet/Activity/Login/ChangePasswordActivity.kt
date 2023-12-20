package com.xet.Activity.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.xet.R
import com.xet.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        auth = FirebaseAuth.getInstance()

        setContentView(binding.root)

        val user = auth.currentUser

        binding.btnChangePassword.setOnClickListener {
            val newpass = binding.newPassword.text.toString()
            val confirmpass = binding.confirmpass.text.toString()

            if (newpass.isEmpty()) {
                binding.newPassword.error = "Password Tidak Boleh Kosong"
                binding.newPassword.requestFocus()
                return@setOnClickListener
            }
            if (confirmpass.isEmpty()) {
                binding.confirmpass.error = "Password Tidak Sama"
                binding.confirmpass.requestFocus()
                return@setOnClickListener
            }
            if (newpass.length < 8) {
                binding.newPassword.error = "Password Minimal 8 Karakter"
                binding.newPassword.requestFocus()
                return@setOnClickListener
            }
            if (confirmpass.length < 8) {
                binding.confirmpass.error = "Password Minimal 8 Karakter"
                binding.confirmpass.requestFocus()
                return@setOnClickListener
            }
            if (newpass != confirmpass) {
                binding.confirmpass.error = "Password Minimal 8 Karakter"
                binding.confirmpass.requestFocus()
                return@setOnClickListener
            }
            user.let {
                val userCredential = EmailAuthProvider.getCredential(it?.email!!, newpass)
                it.reauthenticate(userCredential).addOnCompleteListener { task ->
                    when {
                        task.isSuccessful -> {
                            binding.newPassword.visibility = View.GONE
                            binding.confirmpass.visibility = View.GONE
                        }

                    }
                }

            }
            user?.let {
                user.updatePassword(newpass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(
                            this@ChangePasswordActivity,
                            "Anda Berhasil Mengganti Password",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()

                    }
                }

            }
            binding.ivArrowBack.setOnClickListener {
                finish()
            }

        }
    }
}