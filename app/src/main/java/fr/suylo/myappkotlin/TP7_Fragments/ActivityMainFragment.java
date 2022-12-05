package fr.suylo.myappkotlin.TP7_Fragments;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import fr.suylo.myappkotlin.R;

public class ActivityMainFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tp7_fragment_display);
    }
}