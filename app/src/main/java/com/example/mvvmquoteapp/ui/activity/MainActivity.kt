package com.example.mvvmquoteapp.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmquoteapp.databinding.ActivityMainBinding
import com.example.mvvmquoteapp.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var quoteViewModel: QuoteViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etTitle = binding.etTitle
        val etAuthor = binding.etAuthor
        val tvQuote = binding.tvQuote

        quoteViewModel = ViewModelProvider(this)[QuoteViewModel::class.java]

        binding.button.setOnClickListener {
            if (etTitle.text.isBlank() || etAuthor.text.isBlank()) {
                Toast.makeText(this, "Please fill all Info !!", Toast.LENGTH_SHORT).show()
            } else {
                quoteViewModel.newQuote(
                    etTitle.text.toString(),
                    etAuthor.text.toString()
                )
            }
        }

        quoteViewModel.data.observe(this) {
            tvQuote.text = "${it.title.trim()} : ${it.author.trim()}"
        }
    }
}