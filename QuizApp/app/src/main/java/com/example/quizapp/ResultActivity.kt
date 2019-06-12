package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.models.Category
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var category = intent.getSerializableExtra("category") as Category
        var n = intent.getStringExtra("correctCount") as String
        var c = intent.getStringExtra("count") as String
        textView.text = category.username.toUpperCase()+", "+ " you got "+n+" out of "+c




}}



