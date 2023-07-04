package com.laboratorio.utilizandobd;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Informacion extends AppCompatActivity {

    private TextView informacion;
    private Button volver;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        informacion = findViewById(R.id.info);
        volver = findViewById(R.id.btn_volver);

        databaseHelper=new DatabaseHelper(this);
        StringBuilder stringBuilder=new StringBuilder();
        Cursor cursor=databaseHelper.VerDatos();
    }

    public void Volver() { finish();} // Regresa al MainActivity }
}
