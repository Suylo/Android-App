package fr.suylo.myappkotlin.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import fr.suylo.myappkotlin.R

class IntentActivityTwo : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        val q = findViewById<TextView>(R.id.textView2)
        val txt = findViewById<TextView>(R.id.text_ac_2)
        val btn = findViewById<Button>(R.id.btn_ac_2)
        q.text = "La question : " + intent.extras?.getString("question")

        btn.setOnClickListener(){
            val intent = Intent(this, IntentActivityOne::class.java)
            intent.putExtra("reponse", txt.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}