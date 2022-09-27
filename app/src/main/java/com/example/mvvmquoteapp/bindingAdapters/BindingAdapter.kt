package com.example.mvvmquoteapp.bindingAdapters

import android.widget.Button
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.example.mvvmquoteapp.R
import com.example.mvvmquoteapp.model.Quote

@BindingAdapter("quoteModel")
fun TextView.setQuoteText(quote: LiveData<Quote>) {
// TODO : to set the Text of TextView inside layout when using dataBinding

    val textString = quote.value?.let {
        "${quote.value?.title} : ${quote.value?.author}"
    } ?: ""
    this.text = textString
}


@BindingAdapter("quoteModel")
fun Button.changeButtonColor(quote: LiveData<Quote>){
    if (quote.value == null){
        this.setBackgroundColor(resources.getColor(R.color.orange))
    }else {
        this.setBackgroundColor(resources.getColor(R.color.teal_200))
    }
}