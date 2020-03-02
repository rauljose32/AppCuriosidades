package com.example.appcuriosidades.ui.perguntas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText editTextResposta1;
    private EditText editTextResposta2;
    private EditText editTextResposta3;
    private EditText editTextResposta4;
    private EditText editTextResposta5;
    private SharedPreferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_perguntas, container, false);

        buttonResponder = root.findViewById(R.id.buttonResponder);
        editTextResposta1 = root.findViewById(R.id.edit_query01);
        editTextResposta2 = root.findViewById(R.id.edit_query02);
        editTextResposta3 = root.findViewById(R.id.edit_query03);
        editTextResposta4 = root.findViewById(R.id.edit_query04);
        editTextResposta5 = root.findViewById(R.id.edit_query05);


        buttonResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String r1 = editTextResposta1.getText().toString();
                String r2 = editTextResposta2.getText().toString();
                String r3 = editTextResposta3.getText().toString();
                String r4 = editTextResposta4.getText().toString();
                String r5 = editTextResposta5.getText().toString();
                preferences = getActivity().getSharedPreferences("resultado", Context.MODE_PRIVATE);

                if (r1.isEmpty() || r2.isEmpty() || r3.isEmpty() || r4.isEmpty() || r5.isEmpty()) {
                    Toast.makeText(getActivity(), "Preencha todos os campos por favor", Toast.LENGTH_SHORT).show();
                } else {
                    int pontuacao = verificaRespostas(r1, r2, r3, r4, r5);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("pontuacao", pontuacao);
                    editor.commit();
                    Toast.makeText(getActivity(), "Perguntas Respondidas", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return root;
    }

    private int verificaRespostas(String r1, String r2, String r3, String r4, String r5) {
        int total = 0;

        if (r1.equalsIgnoreCase("Eiichiro Oda")) {
            total++;
        }
        if (r2.equalsIgnoreCase("1997")) {
            total++;
        }
        if ((r3.equalsIgnoreCase("Luffy")) || (r3.equalsIgnoreCase("Monkey D. Luffy"))) {
            total++;
        }
        if (r4.equalsIgnoreCase("Wano")) {
            total++;
        }
        if (r5.equalsIgnoreCase("One Piece")) {
            total++;
        }

        return total;
    }
}