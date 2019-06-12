package com.example.quizapp

import android.content.Intent
import android.graphics.Color.GREEN
import android.graphics.Color.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.models.Question
import kotlinx.android.synthetic.main.activity_game.*
import android.widget.Toast
import com.example.quizapp.models.Category

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        var category = intent.getSerializableExtra("category") as Category
        var n = intent.getStringExtra("correctCount") as String
        var c = intent.getStringExtra("count") as String
        var c1 = c.toInt()
        c1++
        if(c1<=category.questions.size) {
            var t: Int = n.toInt()
            var w: Int = n.toInt()
            questionText.text = category.questions[c1-1].body
            scoreText.text = "Score: " + n
            answer0.text = category.questions[c1 - 1].answers[0]
            answer1.text = category.questions[c1 - 1].answers[1]
            answer2.text = category.questions[c1 - 1].answers[2]
            answer3.text = category.questions[c1 - 1].answers[3]
            answer0.setOnClickListener {
                if (t == w) {
                    if (category.questions[c1 - 1].rightAnswerIndex == 0) {
                        t++
                        answer0.setBackgroundColor(GREEN)
                        scoreText.text = "Score: " + t
                    } else {
                        w--
                        answer0.setBackgroundColor(RED)
                    }
                } else
                    Toast.makeText(this, "You have chosen an answer", Toast.LENGTH_LONG).show()

            }
            answer1.setOnClickListener {
                if (t == w) {
                    if (category.questions[c1 - 1].rightAnswerIndex == 1) {
                        t++
                        answer1.setBackgroundColor(GREEN)
                        scoreText.text = "Score: " + t
                    } else {
                        w--
                        answer1.setBackgroundColor(RED)
                    }
                } else
                    Toast.makeText(this, "You have chosen an answer", Toast.LENGTH_LONG).show()

            }
            answer2.setOnClickListener {
                if (t == w) {
                    if (category.questions[c1 - 1].rightAnswerIndex == 2) {
                        t++
                        answer2.setBackgroundColor(GREEN)
                        scoreText.text = "Score: " + t
                    } else {
                        w--
                        answer2.setBackgroundColor(RED)
                    }
                } else
                    Toast.makeText(this, "You have chosen an answer", Toast.LENGTH_LONG).show()

            }
            answer3.setOnClickListener {
                if (t == w) {
                    if (category.questions[c1 - 1].rightAnswerIndex == 3) {
                        t++
                        answer3.setBackgroundColor(GREEN)
                        scoreText.text = "Score: " + t
                    } else {
                        w--
                        answer3.setBackgroundColor(RED)
                    }
                } else
                    Toast.makeText(this, "You have chosen an answer", Toast.LENGTH_LONG).show()

            }
            nextBtn.setOnClickListener {
                var intent = Intent(this, GameActivity::class.java)
                    .putExtra("category", category)
                    .putExtra("correctCount", t.toString())
                    .putExtra("count", c1.toString())
                startActivity(intent)
            }

        }
        else {
            c1--
            var intent = Intent(this, ResultActivity::class.java)
                .putExtra("category", category)
                .putExtra("correctCount", n)
                .putExtra("count", c1.toString())
            startActivity(intent)
        }
    }
}
