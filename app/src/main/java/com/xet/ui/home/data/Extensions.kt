//package com.xet.ui.home.data
//
//import android.content.Context
//import android.widget.ImageView
//import androidx.core.content.ContextCompat
//import com.bumptech.glide.Glide
//import com.xet.R
//import java.text.SimpleDateFormat
//import java.util.Date
//import java.util.Locale
//import com.xet.BuildConfig
//
//object Extensions {
//    fun ImageView.showImageInto(context: Context, url: String?) {
//        Glide.with(context)
//            .load("${BuildConfig.BASE_URL_IMAGE}$url")
//            .placeholder(ContextCompat.getDrawable(context, R.color.red))
//            .into(this)
//    }
//
//    fun String.toAnotherDate(): String =
//        try {
//            val df = SimpleDateFormat("yyyy-MM-dd", Locale.US)
//            val date = df.parse(this) as Date
//            SimpleDateFormat("yyyy", Locale.US).format(date)
//        } catch (e: Exception) {
//            "-"
//        }
//}