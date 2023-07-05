package com.laboratorio.utilizandobd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registrar extends AppCompatActivity {

    private EditText editTextCed;
    private EditText editTextNombre;
    private EditText editTextCel;
    private EditText editTextPass;
    private Button buttonRegistrars;
    private Button buttonVolver;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        editTextCed = findViewById(R.id.ced);
        editTextNombre = findViewById(R.id.nom);
        editTextCel = findViewById(R.id.phone);
        editTextPass = findViewById(R.id.password);
        buttonRegistrars = findViewById(R.id.btn_registrar);
        buttonVolver = findViewById(R.id.btn_volver);

        databaseHelper = new DatabaseHelper (this);

        buttonRegistrars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cedula = editTextCed.getText().toString();
                String nombre = editTextNombre.getText().toString();
                String celular = editTextCel.getText().toString();
                String contrasena = editTextPass.getText().toString();



                if (cedula.isEmpty() || nombre.isEmpty() || celular.isEmpty() || contrasena.isEmpty()) {
                    Toast.makeText(Registrar.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    long guardadoExitoso = databaseHelper.Registrar(cedula,nombre,celular,contrasena);
                    if (guardadoExitoso != -1 ) {
                        Toast.makeText(Registrar.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                        finish(); // Regresa al MainActivity
                    } else {
                        Toast.makeText(Registrar.this, "No se ha podido guardar correctamente", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
