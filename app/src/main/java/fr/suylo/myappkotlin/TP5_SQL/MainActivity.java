package fr.suylo.myappkotlin.TP5_SQL;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import fr.suylo.myappkotlin.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tp5_sql_activity);

        ((Button) findViewById(R.id.button)).setOnClickListener((view) -> {
            DBConnect.getInstance(this).insertCountryAndCurrency(
                    ((EditText) findViewById(R.id.editTextCountry)).getText().toString(),
                    ((EditText) findViewById(R.id.editTextCurrency)).getText().toString());
            ((EditText) findViewById(R.id.editTextCountry)).setText("");
            ((EditText) findViewById(R.id.editTextCurrency)).setText("");
        });
        ((Button) findViewById(R.id.buttonVisualiser)).setOnClickListener((v) -> {
            startActivity(new Intent(this, ActivityVisualiser.class));
        });
    }
}