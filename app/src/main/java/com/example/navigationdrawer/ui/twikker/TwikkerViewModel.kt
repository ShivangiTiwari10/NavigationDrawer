package com.example.navigationdrawer.ui.twikker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwikkerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Twwiker Fragment"
    }
    val text: LiveData<String> = _text
}