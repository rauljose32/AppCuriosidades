package com.example.appcuriosidades.ui.resultado;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appcuriosidades.R;

public class ResultadoFragment extends Fragment {

    private SharedPreferences preferences;
    private TextView textViewResult;
    private ImageView imageViewResult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_resultado, container, false);

        textViewResult = root.findViewById(R.id.textResultado);
        imageViewResult = root.findViewById(R.id.imageResultado);

        preferences = getActivity().getSharedPreferences("resultado", Context.MODE_PRIVATE);
        int pontuacao = preferences.getInt("pontuacao", 0);

        if ((pontuacao < 3) & (pontuacao > 0)) {

            textViewResult.setText("Assista ou leia mais One Piece");
            imageViewResult.setImageResource(R.drawable.emoticonsad);

        } else if (pontuacao < 5) {

            textViewResult.setText("Você tem um bom conhecimento sobre One Piece");
            imageViewResult.setImageResource(R.drawable.emoticonneutral);

        } else {

            textViewResult.setText("Você sabe muito sobre One Piece");
            imageViewResult.setImageResource(R.drawable.emoticonsmile);

        }

        return root;
    }
}