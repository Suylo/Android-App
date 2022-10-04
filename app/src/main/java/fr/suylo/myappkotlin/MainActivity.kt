package fr.suylo.myappkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val answers = arrayOf<String>();
    val question = findViewById<TextView>(R.id.questionText);
    val askOne = findViewById<TextView>(R.id.answer_1);
    val askTwo = findViewById<TextView>(R.id.answer_2);
    val askThree = findViewById<TextView>(R.id.answer_3);
    val pgBar = findViewById<ProgressBar>(R.id.progressBar);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MyApp", "Test des logs")

        askOne.setOnClickListener(View.OnClickListener {
            fun onClick(v: View?) {
                onClickText(v);
            }
        })
    }

    fun onClickText(view: View) {
        Log.d("MyApp", "OnClick Element text");
    }
}