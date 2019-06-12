package com.example.quizapp.models

import java.io.Serializable

class Question(
    var body:String,
    var answers: ArrayList<String>,
    var rightAnswerIndex:Int
    )
: Serializable{

}
class Category(
    var username: String,
    var title: String,
    var questions : ArrayList<Question>
):Serializable{

}