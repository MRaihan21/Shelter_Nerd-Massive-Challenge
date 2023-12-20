package com.xet.Data

import com.xet.Models.MusicModel
import retrofit2.Call

interface ApiInterface {

    fun getData(): Call<List<MusicModel>>

}