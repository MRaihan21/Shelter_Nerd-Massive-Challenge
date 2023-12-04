package com.xet.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoriesEventData(
    var title: String,
    var seeAll: String,
    var imageCategories1: Int,
    var titleEvent1: String,
    var price1: String,
    var imageCategories2: Int,
    var titleEvent2: String,
    var price2: String,

//    var creator: String,
//    var location: String,
//    var desc: String,
//    var date: String,
//    var time: String,
//    var type: String,

) : Parcelable
