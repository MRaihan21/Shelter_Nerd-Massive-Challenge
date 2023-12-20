package com.xet.Activity.Detail.other

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.xet.Activity.MainActivity
import com.xet.R
import com.xet.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }

        binding.btNPay.setOnClickListener {
            onBackPressed()
            startActivity(Intent(this, MainActivity::class.java))
        }

        val spinner = findViewById<Spinner>(R.id.spinner)
        val txtRes = findViewById<TextView>(R.id.tv_result)

        val options = arrayOf("E-Wallet","Dana","GoPay","Ovo")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,options)

        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                txtRes.text = "You selected:  ${ options.get(p2).toString()}"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                txtRes.text = "Payment"
            }

        }


    }
}