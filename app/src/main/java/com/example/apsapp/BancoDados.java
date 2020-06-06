package com.example.apsapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoDados extends SQLiteOpenHelper {
    public static final String nome = "Cursos.db";
    private static final int versao = 1;

    public BancoDados(Context contexto) {
        super(contexto, nome, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE cursos (id INTERGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "nomeCurso VARCHAR (50), salaCurso VARCHAR(50), turmaCurso VARCHAR(50)," +
                "horarioCurso VARCHAR(4), turnoCurso VARCHAR(10) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
