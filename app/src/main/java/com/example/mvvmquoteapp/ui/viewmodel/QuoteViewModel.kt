package com.example.mvvmquoteapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmquoteapp.model.Quote
import com.example.mvvmquoteapp.repository.QuoteRepository

class QuoteViewModel : ViewModel() {
    // TODO : receive data from Repository .
    // TODO : get the data from view & interact with it .
    // TODO : update the live data to Observe on it in View .

    // TODO : Only View Model has direct access to Repository .

    private val _data = MutableLiveData<Quote>()
    val data = _data as LiveData<Quote>

    fun newQuote(title: String, author: String) {
        _data.value = QuoteRepository.getQuote(title , author)
    }
}