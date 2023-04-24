package com.example.navigationdrawer.ui.highlights

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HighlightsViewModel: ViewModel(){

    private val _text = MutableLiveData<String>().apply {
        value = "This is highlight Fragment"
    }
    val text: LiveData<String> = _text
}