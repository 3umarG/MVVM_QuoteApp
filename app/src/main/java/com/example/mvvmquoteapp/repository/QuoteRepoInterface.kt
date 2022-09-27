package com.example.mvvmquoteapp.repository

import com.example.mvvmquoteapp.model.Quote

interface QuoteRepoInterface {
    fun getQuote(title : String , author : String) : Quote
}