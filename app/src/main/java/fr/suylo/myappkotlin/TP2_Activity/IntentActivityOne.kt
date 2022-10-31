package fr.suylo.myappkotlin.TP2_Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import fr.suylo.myappkotlin.R

class IntentActivityOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val btn = findViewById<Button>(R.id.btn_ac_1);
        val plainText = findViewById<TextView>(R.id.text_ac_1)
        val answer = findViewById<TextView>(R.id.textView3)

        fun traiterReponse(result: ActivityResult) {
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val message = data?.getStringExtra("reponse")
                answer.text = message
            }
        }

        val launch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            traiterReponse(result)
        }

        btn.setOnClickListener {
            val i = Intent(this, IntentActivityTwo::class.java)
            i.putExtra("question", plainText.text.toString())
            launch.launch(i)
        }



    }

}