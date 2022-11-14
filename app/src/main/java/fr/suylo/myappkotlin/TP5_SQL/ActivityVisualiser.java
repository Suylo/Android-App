package fr.suylo.myappkotlin.TP5_SQL;

import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import fr.suylo.myappkotlin.R;

public class ActivityVisualiser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tp5_activity_visualiser);

        ((TextView) findViewById(R.id.textList)).setMovementMethod(
                new ScrollingMovementMethod()
        );
        ((TextView) findViewById(R.id.textList)).setText(
                String.join("\n", DBConnect.getInstance(this).getAllCountriesAndCurrencies())
        );
        findViewById(R.id.back).setOnClickListener((v) -> {
            finish();
        });
        findViewById(R.id.buttonDelete).setOnClickListener((ac) -> {
            DBConnect.getInstance(this).dropAllValues();
            ((TextView) findViewById(R.id.textList)).setText("");
        });
    }
}