package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputText.text
        startBtn.setOnClickListener{
            if(inputText.text!!.isNotEmpty())
            {
                var intent = Intent(this, CategoryActivity::class.java)
                    .putExtra("userName", inputText.text.toString())
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Fill the field", Toast.LENGTH_LONG).show()
            }
        }
    }
}
