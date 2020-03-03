package com.example.appcuriosidades.ui.perguntas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appcuriosidades.MainActivity;
import com.example.appcuriosidades.R;

public class PerguntasFragment extends Fragment {

    private Button buttonResponder;
    private RadioGroup radioGroup01;
    private RadioGroup radioGroup02;
    private RadioGroup radioGroup03;
    private RadioGroup radioGroup04;
    private RadioGroup radioGroup05;
    private RadioButton radioButton01;
    private RadioButton radioButton02;
    private RadioButton radioButton03;
    private RadioButton radioButton04;
    private RadioButton radioButton05;
    private SharedPreferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_perguntas, container, false);

        buttonResponder = root.findViewById(R.id.buttonResponder);
        radioButton01 = root.findViewById(R.id.certa01);
        radioButton02 = root.findViewById(R.id.certa02);
        radioButton03 = root.findViewById(R.id.certa03);
        radioButton04 = root.findViewById(R.id.certa04);
        radioButton05 = root.findViewById(R.id.certa05);

        buttonResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pontuacao = 0;
                preferences = getActivity().getSharedPreferences("resultado", Context.MODE_PRIVATE);
                pontuacao = verificaRespostas();
                System.out.println(pontuacao);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("pontuacao", pontuacao);
                editor.commit();
                Toast.makeText(getActivity(), "Perguntas Respondidas", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private int verificaRespostas() {
        int total = 0;

        if (radioButton01.isChecked()) {
            total++;
        }
        if (radioButton02.isChecked()) {
            total++;
        }
        if (radioButton03.isChecked()) {
            total++;
        }
        if (radioButton04.isChecked()) {
            total++;
        }
        if (radioButton05.isChecked()) {
            total++;
        }

        return total;
    }
}