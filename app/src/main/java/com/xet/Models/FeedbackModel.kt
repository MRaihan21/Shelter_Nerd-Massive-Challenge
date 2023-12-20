package com.xet.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FeedbackModel(
    val date: String,
    val name: String,
    val image: Int,
    val rating: Float,
    val comment: String
) : Parcelable
