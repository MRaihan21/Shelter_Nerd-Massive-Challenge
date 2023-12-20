package com.xet.ui.ticket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.Adapter.TicketAdapter
import com.xet.Models.TicketModel
import com.xet.R
import com.xet.databinding.FragmentTicketBinding
import com.xet.ui.home.HomeFragment
import com.xet.ui.ticket.MyTicket.MyTicketActivity

class TiketFragment : Fragment() {

    private var _binding: FragmentTicketBinding? = null
    private val binding get() = _binding!!

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var ticketList : ArrayList<TicketModel>

    private lateinit var recyclerView: RecyclerView

    lateinit var image: Array<Int>

    lateinit var codeBooking: Array<String>
    lateinit var code: Array<String>
    lateinit var username: Array<String>
    lateinit var imgBarcode: Array<Int>
    lateinit var adress: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView = view.findViewById(R.id.rv_ticket)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = TicketAdapter(ticketList){
            val intent = Intent(context, MyTicketActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }


    }

    private fun dataInitialize() {
        ticketList = arrayListOf<TicketModel>()

        image = arrayOf(
            R.drawable.ic_music,
        )

        codeBooking = arrayOf(
            "Y92UFN",
        )

        code = arrayOf(
            "VCJX92JF",
        )
        username = arrayOf(
            "Gatot Triantono",
        )
        imgBarcode = arrayOf(
            R.drawable.barcode,
        )
        adress = arrayOf(
            "Jl Gatot Subroto No.Kav 2-3 RT.1/RW.4,Karet Semanggi, Kecamatan Setia BUdi"
        )


        for (i in imgBarcode.indices){
            val ticket = TicketModel(
                image[i],
                codeBooking[i],
                code[i],
                username[i],
                imgBarcode[i],
                adress[i],
            )
            ticketList.add(ticket)
        }

    }

}