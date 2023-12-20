package com.xet.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JapaneseModel (
    var img: Int,
    var title: String,
    var price: String,

    val imgCreator: Int,
    var creator: String,
    var location: String,
    var desc: String,
    var date: String,
    var time: String,
    var type: String,
): Parcelable