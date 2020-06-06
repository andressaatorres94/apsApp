package com.example.apsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CursoDAO  {

    public static void inserir(Context context,CadastroCurso curso){
        BancoDados bancoDados = new BancoDados(context);

        ContentValues valores = new ContentValues();

        valores.put("nomeCurso", curso.getNomeCurso());
        valores.put("turnoCurso", curso.getTurnoCurso());
        valores.put("turmaCurso", curso.getTurmaCurso());
        valores.put("horarioCurso", curso.getHorarioCurso());
        valores.put("salaCurso", curso.getSalaCurso());

        SQLiteDatabase bd = bancoDados.getWritableDatabase();

        bd.insert("cursos", null, valores);
    }

    public static void editar(Context context, CadastroCurso curso){
        BancoDados bancoDados = new BancoDados(context);

        ContentValues valores = new ContentValues();

        valores.put("nomeCurso", curso.getNomeCurso());
        valores.put("turnoCurso", curso.getTurnoCurso());
        valores.put("turmaCurso", curso.getTurmaCurso());
        valores.put("horarioCurso", curso.getHorarioCurso());
        valores.put("salaCurso", curso.getSalaCurso());

        SQLiteDatabase bd = bancoDados.getWritableDatabase();
        bd.update("cursos", valores, "id =" +curso.getIdCurso(),null);
    }

    public static void excluir(Context context, int idCursos, CadastroCurso curso){
        BancoDados bancoDados = new BancoDados(context);
        SQLiteDatabase bd = bancoDados.getWritableDatabase();
        bd.execSQL("DELETE FROM cursos WHERE id = " + idCursos);

        //bd.delete("cursos","id = ? ", new String[]{curso.getIdCurso().toString()});
    }

}
