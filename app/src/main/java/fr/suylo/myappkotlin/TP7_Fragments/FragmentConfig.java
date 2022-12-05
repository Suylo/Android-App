package fr.suylo.myappkotlin.TP7_Fragments;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import fr.suylo.myappkotlin.R;

public class FragmentConfig extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private static int MIN_SIZE = 12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tp7_fragment_config, container, false);
        v.findViewById(R.id.button).setOnClickListener((view) -> {
            Bundle b = new Bundle();
            b.putString(
                    MainFragmentDisplay.ARG_TEXTE,
                    ((EditText)v.findViewById(R.id.config_editText)).getText().toString()
            );
            b.putInt(
                    MainFragmentDisplay.ARG_TAILLE,
                    ((SeekBar)v.findViewById(R.id.config_seekBar)).getProgress() + MIN_SIZE
            );
            Navigation.findNavController(view).navigate(
                    R.id.action_fragmentConfiguration_to_fragmentDisplay,
                    b
            );
        });
        return v;
    }

}