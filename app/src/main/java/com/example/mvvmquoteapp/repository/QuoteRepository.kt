package com.example.mvvmquoteapp.repository

import com.example.mvvmquoteapp.model.Quote

class QuoteRepository private constructor() {
    // TODO : Only the Repository has direct access to Model.
    companion object {
        fun getQuote(title: String, author: String): Quote {
            return Quote(title, author)
        }
    }

}