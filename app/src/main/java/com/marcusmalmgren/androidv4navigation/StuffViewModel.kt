package com.marcusmalmgren.androidv4navigation

import androidx.lifecycle.ViewModel

class StuffViewModel : ViewModel() {

    var someText = "XXX"

    fun loadSome() {
        someText = "Hej"
    }

}