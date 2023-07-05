package com.laboratorio.utilizandobd;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
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
        setContentView(R.layout.informacion_activity);

        informacion = findViewById(R.id.info);
        volver = findViewById(R.id.btn_volver);

        databaseHelper=new DatabaseHelper(this);
        StringBuilder stringBuilder=new StringBuilder();
        Cursor cursor=databaseHelper.VerDatos();

        if(cursor.getCount()==0){
            stringBuilder.append("No hay información registrada.");
        }else{
            while(cursor.moveToNext()){
                String cedula=cursor.getString(0);
                String nombre=cursor.getString(1);
                String celular=cursor.getString(2);
                String contrasena=cursor.getString(3);

                stringBuilder.append("Cédula: ").append(cedula).append("\n");
                stringBuilder.append("Nombre: ").append(nombre).append("\n");
                stringBuilder.append("Celular: ").append(celular).append("\n");
                stringBuilder.append("Contraseña: ").append(contrasena).append("\n");
            }
        }
        informacion.setText(stringBuilder.toString());

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
