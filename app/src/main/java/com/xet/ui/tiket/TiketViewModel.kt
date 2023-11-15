package com.xet.ui.tiket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TiketViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Tiket Fragment"
    }
    val text: LiveData<String> = _text
}