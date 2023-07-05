package com.laboratorio.utilizandobd;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "Ejemplo_BD";

    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Usuarios";
    private static final String COLUMN_CED = "Cedula";
    private static final String COLUMN_NOMBRE = "Nombre";
    private static final String COLUMN_CELULAR = "Celular";
    private static final String COLUMN_CONTRASENA = "Contrasena";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_CED + " TEXT PRIMARY KEY, " +
                COLUMN_NOMBRE + " TEXT, " +
                COLUMN_CELULAR + " TEXT, " +
                COLUMN_CONTRASENA + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate (db);
    }

    public long Registrar (String cedula, String nombre, String celular, String contrasena) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CED, cedula);
        values.put(COLUMN_NOMBRE, nombre);
        values.put(COLUMN_CELULAR, celular);
        values.put(COLUMN_CONTRASENA, contrasena);
        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result;
    }

    public Cursor VerDatos() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        return db.rawQuery (query,null); //E
    }

}
