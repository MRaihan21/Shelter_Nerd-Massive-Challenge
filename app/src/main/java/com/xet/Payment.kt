package com.xet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.xet.databinding.ActivityPaymentBinding

class Payment : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding
    private lateinit var builder : AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        builder = AlertDialog.Builder(this)

        binding.btnPay.setOnClickListener{
            builder.setTitle("Order Success!")
                .setMessage("Next ?")
                .setCancelable(true)

                .setPositiveButton("Yes"){dialogInterface,it ->
                    finish() // close the app when yes clicked
                }
                .setNegativeButton("No"){dialogInterface,it ->

                    dialogInterface.cancel()
                }
                .setNeutralButton("Help"){dialogInterface,it ->

                    Toast.makeText(this@Payment,"Help Clicked",Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}