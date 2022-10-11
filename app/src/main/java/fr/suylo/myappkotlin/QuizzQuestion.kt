package fr.suylo.myappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.util.StringJoiner

class QuizzQuestion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quizz_v2)

        val question = findViewById<TextView>(R.id.question_title)
        val ans_group = findViewById<RadioGroup>(R.id.radioGroup)
        val questions = listOf("Quelle est la capitale de la France ?","Quelle est la capitale de l'Allemagne ?","Quelle est la capitale de l'Espagne ?","Quelle est la capitale de l'Italie ?",)
        val correct_answers = listOf("Paris","Berlin","Madrid","Rome")

        question.text = questions[0]
        val ans1 = findViewById<RadioButton>(R.id.radioButton)
        val ans2 = findViewById<RadioButton>(R.id.radioButton2)
        val ans3 = findViewById<RadioButton>(R.id.radioButton3)

        ans1.text = correct_answers[0]
        ans2.text = "Londres"
        ans3.text = "Bruxelles"


        fun checkAnswer(ask: String, answer: String, btn_answer: RadioButton) {
            ans_group.setOnCheckedChangeListener { group, checkedId ->
                if (checkedId == btn_answer.id){
                    question.text = ask
                }
            }
        }

        /*
        fun traiterReponse(result: ActivityResult) {
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val message = data?.getStringExtra("reponse")
                answer.text = message
            }
        }
        */
        /*
        val launch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            traiterReponse(result)
        }

        btn.setOnClickListener {
            val i = Intent(this, QuizzAnswers::class.java)
            i.putExtra("question", plainText.text.toString())
            launch.launch(i)
        }
        */
    }
}