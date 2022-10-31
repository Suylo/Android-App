package fr.suylo.myappkotlin.TP4_Services;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import fr.suylo.myappkotlin.R;

public class MainActivityServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_services);
        startService(new Intent(this, MusiqueService.class));

        findViewById(R.id.play).setOnClickListener(v -> {
            startService(new Intent(this, MusiqueService.class));
        });
        findViewById(R.id.stop).setOnClickListener(v -> {
            stopService(new Intent(this, MusiqueService.class));
        });
    }
}