package com.xet.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class CreatorModel (
    val img: Int,
    val title: String,
    val desc: String
) : Parcelable