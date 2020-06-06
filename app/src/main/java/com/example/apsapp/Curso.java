package com.example.apsapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class Curso extends Fragment {
    private EditText edtHorario;
    private EditText edtNome;
    private EditText edtSala;
    private EditText edtTurma;
    private Spinner spTurno;
    private Button btnSalvar;
    private CadastroCurso cursoCad;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_curso, container, false);

        // Link dos componentes com a view
        edtHorario = (EditText) view.findViewById(R.id.etHorario);
        edtNome = (EditText) view.findViewById(R.id.etNomeCurso);
        edtSala = (EditText) view.findViewById(R.id.etSala);
        edtTurma = (EditText) view.findViewById(R.id.etTurmaCurso);
        spTurno = (Spinner) view.findViewById(R.id.spTurno);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(), R.array.spTurnos, android.R.layout.simple_spinner_item);
        spTurno.setAdapter(adapter);

        btnSalvar = (Button) view.findViewById(R.id.btnSalvarAluno);

        //Mascara de editText campo horas
        SimpleMaskFormatter mascara = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher mascaraText = new MaskTextWatcher(edtHorario,mascara);
        edtHorario.addTextChangedListener(mascaraText);

        //onClick botao salvaar.

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

        return (view);
    }

    private void salvar(){
        cursoCad = new CadastroCurso();

        String nomeCurso = edtNome.getText().toString();
        String turnoCurso = spTurno.getSelectedItem().toString();
        String turmaCurso = edtTurma.getText().toString();
        String salaCurso = edtSala.getText().toString();
        String horarioCurso = edtHorario.getText().toString();

        if(nomeCurso.isEmpty() && turnoCurso.isEmpty() && turmaCurso.isEmpty() && salaCurso.isEmpty() && horarioCurso.isEmpty()){

            AlertDialog.Builder alerta = new AlertDialog.Builder(getActivity().getApplicationContext());
            alerta.setTitle("Atenção!");
            alerta.setIcon(android.R.drawable.ic_dialog_alert);
            alerta.setMessage("Preencha todos os campos corretamente.");
            alerta.setNeutralButton("OK",null);
            alerta.show();

        } else{

            cursoCad.setNomeCurso(nomeCurso);
            cursoCad.setTurnoCurso(turnoCurso);
            cursoCad.setTurmaCurso(turmaCurso);
            cursoCad.setSalaCurso(salaCurso);
            cursoCad.setHorarioCurso(horarioCurso);
            CursoDAO.inserir(getActivity().getApplicationContext(), cursoCad);

            AlertDialog.Builder alerta = new AlertDialog.Builder(getActivity().getApplicationContext());
            alerta.setIcon(android.R.drawable.ic_dialog_info);
            alerta.setMessage("Novo curso cadastrado com sucesso.");
            alerta.setNeutralButton("OK",null);
            alerta.show();
        }
    }

}
