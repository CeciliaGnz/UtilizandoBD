package com.laboratorio.utilizandobd;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "Ejemplo_BD";
    private static final String TABLE_NAME = "Usuarios";
    private static final String COL_CED = "CedBD";
    private static final String COL_NOMBRE = "Nombre";
    private static final String COL_CELULAR = "Celular";
    private static final String COL_CONTRASENA = "Contrasena";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String createTableQuery="CREATE TABLE "+TABLE_NAME+" ("+
              COL_CED+"TEXT PRIMARY KEY,"+
              COL_NOMBRE+"TEXT,"+
              COL_CELULAR+"TEXT,"+
              COL_CONTRASENA+"TEXT)";
      db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate (db);
    }

    public boolean Registrar (String cedula, String nombre, String celular, String contrasena) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CED, cedula);
        contentValues.put(COL_NOMBRE, nombre);
        contentValues.put(COL_CELULAR, celular);
        contentValues.put(COL_CONTRASENA, contrasena);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor VerDatos() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        return db.rawQuery (query,null); //E
    }

}
