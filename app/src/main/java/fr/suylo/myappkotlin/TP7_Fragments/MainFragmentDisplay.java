package fr.suylo.myappkotlin.TP7_Fragments;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fr.suylo.myappkotlin.R;

public class MainFragmentDisplay extends Fragment {

    public static final String ARG_TEXTE  = "le_texte";
    public static final String ARG_TAILLE = "la_taille";

    private String le_texte  = "...waiting";
    private int    la_taille = 14;

    public MainFragmentDisplay() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            le_texte  = getArguments().getString( ARG_TEXTE  );
            la_taille = getArguments().getInt(    ARG_TAILLE );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tp7_fragment_display, container, false);
        TextView tv = v.findViewById(R.id.textView_display);
        tv.setText(le_texte);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,la_taille);
        return v;
    }
}