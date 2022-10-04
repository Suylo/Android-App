package fr.suylo.myappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    val arrayList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MyApp", "Test des logs")

        this.arrayList.add(1)
        this.arrayList.add(2)
        this.arrayList.add(3)
    }

    fun onClickText(view: View) {
        val answers = arrayOf<String>()
        val question = findViewById<TextView>(R.id.questionText)
        val askOne = findViewById<TextView>(R.id.answer_1)
        val askTwo = findViewById<TextView>(R.id.answer_2)
        val askThree = findViewById<TextView>(R.id.answer_3)
        val pgBar = findViewById<ProgressBar>(R.id.progressBar)


        for (i in 1..this.arrayList.size) {
            // TODO: faut réfléchir un ptit peu là
        }

        Log.d("MyApp", "OnClick Element text");
    }
}