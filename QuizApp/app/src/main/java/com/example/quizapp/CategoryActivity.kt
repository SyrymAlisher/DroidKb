package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.quizapp.models.Category
import com.example.quizapp.models.Question
import kotlinx.android.synthetic.main.activity_category.*
import android.content.Intent

class CategoryActivity : AppCompatActivity() {

    fun listMaker(s1:String, s2:String, s3:String, s4:String ): ArrayList<String>
    {
        var list: ArrayList<String> = ArrayList()
        list.add(s1)
        list.add(s2)
        list.add(s3)
        list.add(s4)
        return list
    }
    fun listMakerQ(q1:Question, q2:Question, q3:Question, q4:Question ): ArrayList<Question>

    {
        var list: ArrayList<Question> = ArrayList()
        list.add(q1)
        list.add(q2)
        list.add(q3)
        list.add(q4)
        return list
    }
    fun questionMaker(body:String, answers:ArrayList<String>, rightAnswersIndex:Int):Question
    {
        var question:Question=Question(body, answers, rightAnswersIndex)
        return question
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        var userName = intent.getStringExtra("userName") as String
        Log.d("USER_DATA", userName)
        welcomeText.text = userName.toUpperCase()+", Please choose a category"

        var math: Category= Category(userName,"KBTU", listMakerQ(
            questionMaker("What is the minimum grade needed to get scholarships?", listMaker("B-", "B+", "C", "C+"), 3),
            questionMaker("Who is the Dean of FIT", listMaker("A.Akshabayev", "F.Hajiyev", "Baisakov", "no correct answer"), 1),
            questionMaker("When was the university founded", listMaker("2002", "1998", "2001", "2011"), 2),
            questionMaker("Who is the President of KBTU", listMaker("Kenzhebek Ibrashev", "Fuad Hajiyev", "Nursultan Nazarbayev", "Anthony Stark"), 0)
        ))
        var sport: Category=Category(userName,"Marvel Cinematic Universe", listMakerQ(
            questionMaker("First film in this universe", listMaker("Iron Man ", "The Avengers ", "Batman", "The Incredible Hulk"), 0),
            questionMaker("What is the true name of Captain America?", listMaker("Anthony Stark","Bruce Banner","Steve Rogers", "Clint Barton"), 2),
            questionMaker("Which MCU movie featured Spider-Man’s first appearance?", listMaker("Spider-Man: Homecoming", "Avengers: Age of Ultron", "Iron Man 3", "Captain America:Civil war"), 3),
            questionMaker("What does Stark Industries manufacture in Iron Man 1?", listMaker("Weapons", "Pharmaceuticals", "Chemicals","Buildings"), 0)
        ))
        var celebreties:Category= Category(userName,"Sherlock", listMakerQ(
            questionMaker("Who first tells John about Sherlock?", listMaker("Mrs Hudson, Sherlock's landlady", "Mike Stamford, an old friend", "Molly Hooper, a scientist","Lestrade, a policeman"),1),
            questionMaker("Who plays John Watson?", listMaker("Martin Freeman","Andrew Scott",
                    "Rupert Graves", "Jonathon Aris" ), 0),
            questionMaker("Who is Mycroft?", listMaker(
                    "John's Friend", "Sherlock's arch enemy", "A policeman", "Sherlock's brother"), 3),
            questionMaker("What is Lestrade's first name?", listMaker("Cavin","Wayne", "Greg", "Jeff"), 2)
        ))
//        var n:Int=0
        MathCategoryBtn.setOnClickListener {
            var intent2 = Intent(this, GameActivity::class.java)
                .putExtra("category", math)
                .putExtra("correctCount", "0")
                .putExtra("count" , "0")
            startActivity(intent2)
        }
        sportCategoryBtn.setOnClickListener {
            var intent2 = Intent(this, GameActivity::class.java)
                .putExtra("category", sport)
                .putExtra("correctCount", "0")
                .putExtra("count" , "0")
            startActivity(intent2)
        }
        celebritiesCategoryBtn.setOnClickListener {
            var intent2 = Intent(this, GameActivity::class.java)
                .putExtra("category", celebreties)
                .putExtra("correctCount", "0")
                .putExtra("count" , "0")
            startActivity(intent2)
        }
    }
}
