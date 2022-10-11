package fr.suylo.myappkotlin.quizz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import fr.suylo.myappkotlin.R

class QuizzKt : AppCompatActivity() {
    private val qcm = ArrayList<String>()
    companion object {
        private var noQuestion = 1;
        private var goodAnswers = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quizz_main)
        val question = findViewById<TextView>(R.id.questionText)
        val askOne = findViewById<TextView>(R.id.answer_1)
        val askTwo = findViewById<TextView>(R.id.answer_2)
        val askThree = findViewById<TextView>(R.id.answer_3)

        retry(1, question, askOne, askTwo, askThree);
        findViewById<Button>(R.id.retry).setOnClickListener {
            retry(1, question, askOne, askTwo, askThree);
        }
    }

    fun retry(id: Int, question: TextView, askOne: TextView, askTwo: TextView, askThree: TextView) {
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        askTwo.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
        askOne.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
        question.setText("Quel est la capitale de la France ?");
        askOne.setText("1. Paris");
        askTwo.setText("2. Lyon");
        askThree.setText("3. Marseille");
        progressBar.progress = 0
        noQuestion = 1
        goodAnswers = 0
    }

    @SuppressLint("SetTextI18n")
    fun onClickText(view: View) {
        when (noQuestion) {
            1 -> {
                this.qcm.clear()
                this.qcm.add("Quel est la capitale de l'Espagne ?")
                this.qcm.add("1. Madrid")
                this.qcm.add("2. Barcelone")
                this.qcm.add("3. Séville")
                if (view.id == R.id.answer_1){
                    goodAnswers++
                    getAnswers(view, 33, this.qcm, true, R.id.answer_1)
                } else {
                    getAnswers(view, 33, this.qcm, false, R.id.answer_1)
                }
                noQuestion = 2

            }
            2 -> {
                this.qcm.clear()
                this.qcm.add("Quel est la capitale de l'Italie ?")
                this.qcm.add("1. Naples")
                this.qcm.add("2. Milan")
                this.qcm.add("3. Rome")
                if (view.id == R.id.answer_1){
                    goodAnswers++
                    getAnswers(view, 66, this.qcm, true, R.id.answer_1)
                } else {
                    getAnswers(view, 66, this.qcm, false, R.id.answer_1)
                }
                noQuestion = 3
            }
            3 -> {
                if (view.id == R.id.answer_3) {
                    this.qcm.clear()
                    goodAnswers++
                    getAnswers(view, 100, this.qcm, true, R.id.answer_3)
                } else {
                    this.qcm.clear()
                    getAnswers(view, 100, this.qcm, false, R.id.answer_3)
                }
            }
        }
    }

    fun getAnswers(viewId: View, progBar: Int, questions: ArrayList<String>, reussi: Boolean, answer: Int) {
        val question = findViewById<TextView>(R.id.questionText)
        val askOne = findViewById<TextView>(R.id.answer_1)
        val askTwo = findViewById<TextView>(R.id.answer_2)
        val askThree = findViewById<TextView>(R.id.answer_3)
        val pgBar = findViewById<ProgressBar>(R.id.progressBar)

        // if (reussi) {
            if (questions.size > 0) {
                question.setText(this.qcm[0])
                askOne.setText(this.qcm[1])
                askTwo.setText(this.qcm[2])
                askThree.setText(this.qcm[3])
            } else if (this.qcm.size == 0) {
                question.setText("Fin du QCM !")
                askOne.setText("Merci d'avoir participé.")
                askTwo.setText("Vos points : " + goodAnswers + "/3")
                askThree.setText("")

                askTwo.textAlignment = View.TEXT_ALIGNMENT_CENTER
                askOne.textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
            pgBar.progress = progBar
        //}
    }
}