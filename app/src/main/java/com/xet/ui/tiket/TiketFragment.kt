package com.xet.ui.tiket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.adapter.TicketAdapter
import com.xet.data.TicketData
import com.xet.databinding.FragmentTiketBinding

class TiketFragment : Fragment() {

    private var _binding: FragmentTiketBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterTicket: TicketAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var ticketDataArrayList: ArrayList<TicketData>

    lateinit var img: Array<Int>
    lateinit var img2: Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentTiketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_ticket)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapterTicket = TicketAdapter(ticketDataArrayList)
        recyclerView.adapter = adapterTicket
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dataInitialize(){

        ticketDataArrayList = arrayListOf<TicketData>()

        img = arrayOf(
            R.drawable.ic_ticketimage1
        )

        img2 = arrayOf(
            R.drawable.ic_ticketimage2
        )

        for (i in img.indices){
            val ticketData = TicketData(
                img[i],
                img2[i]
            )
            ticketDataArrayList.add(ticketData)
        }

    }

}