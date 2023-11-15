package com.xet.ui.explorer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExplorerViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Explorer Fragment"
    }

    val text: LiveData<String> = _text

}