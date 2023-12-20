package com.xet.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TransactionHistoryModel(
    var date: String,
    var orderCode: String,
    var title: String,
    var dateDetail: String,
    var location: String,
    var price: String,
): Parcelable
