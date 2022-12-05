package fr.suylo.myappkotlin.TP6_Interfaces;

import android.graphics.Color;
import android.text.Layout;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import fr.suylo.myappkotlin.R;

public class MainActivityInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tp6_activity_main_interface);
        configureLayout();
    }

    public void configureLayout(){
        Button btn = new Button(this);
        btn.setText("ALLEZ CLIQUE MOI ALLER");

        ConstraintLayout myLayout = new ConstraintLayout(this);
        myLayout.addView(btn);
        setContentView(myLayout);

        myLayout.setBackgroundColor(Color.BLUE);

    }
}