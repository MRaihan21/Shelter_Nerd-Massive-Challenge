package com.xet.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TicketModel(
    val img: Int,

    val codeBooking: String,
    val code: String,
    val username: String,
    val imgBarcode: Int,
    val adress: String

): Parcelable
