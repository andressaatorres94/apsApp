package com.example.apsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;


public class Alunos extends Fragment {
    EditText edtTelefone;
    EditText edtNome;
    EditText edteEndereco;
    Spinner spTurma;
    Button btnSalvar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alunos, container, false);

        //Link com a view
        edtTelefone = (EditText) view.findViewById(R.id.etTelefoneAluno);
        edtNome = (EditText) view.findViewById(R.id.etNomeAluno);
        edteEndereco = (EditText) view.findViewById(R.id.etEnderecoAluno);
        spTurma = (Spinner) view.findViewById(R.id.spTurmaAluno);

        btnSalvar = (Button) view.findViewById(R.id.btnSalvarAluno);
        //onclick botao salavar
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"ALUNO SALVO",Toast.LENGTH_LONG).show();
            }
        });

        //Mascara de editText campo telefone
        SimpleMaskFormatter mascara = new SimpleMaskFormatter("(NN)NNNNN - NNNN");
        MaskTextWatcher mascaraText = new MaskTextWatcher(edtTelefone,mascara);
        edtTelefone.addTextChangedListener(mascaraText);

        return (view);

    }
}
