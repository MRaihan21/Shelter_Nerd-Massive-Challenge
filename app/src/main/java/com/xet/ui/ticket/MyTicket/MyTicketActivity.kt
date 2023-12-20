package com.xet.ui.ticket.MyTicket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.xet.Models.TicketModel
import com.xet.R
import com.xet.databinding.ActivityMyTicketBinding
import com.xet.ui.ticket.TiketFragment

class MyTicketActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_ticket)

        binding = ActivityMyTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }

        val myTicket = intent.getParcelableExtra<TicketModel>(TiketFragment.INTENT_PARCELABLE)

        val codeBooking: TextView = findViewById(R.id.tv_code_booking)
        val username: TextView = findViewById(R.id.tv_username_ticket)
        val imgBarcode: ImageView = findViewById(R.id.iv_barcode)
        val code: TextView = findViewById(R.id.tv_code_barcode)
        val adress: TextView = findViewById(R.id.tv_adress_ticket)

        codeBooking.text = myTicket?.codeBooking!!
        username.text = myTicket.username
        code.text = myTicket.code
        imgBarcode.setImageResource(myTicket.imgBarcode)
        adress.text = myTicket.adress

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}