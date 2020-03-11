package com.example.localstorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// sqlite ?? que es
// manejador de bases de datos relaciones
// se guarda en un archivo local
// utiliza queries

// 1ra estrategia - utilizar una base de datos local
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_FILE = "Database.db";
    private static final String TABLE = "Estudiantes";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "nombre";
    private static final String FIELD_GRADE = "calificacion";

    public DBHelper(Context context){

        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID + "INTEGER PRIMARY KEY, "+
                FIELD_NAME + "TEXT, " +
                FIELD_GRADE + "INTEGER)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Si cambiamos de version
        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};
        db.execSQL(query, params);
    }
}
