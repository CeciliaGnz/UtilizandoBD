package com.laboratorio.utilizandobd;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
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
    }

    public void Registrars() {
        String cedula = editTextCed.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String celular = editTextCel.getText().toString();
        String contrasena = editTextPass.getText().toString();

        boolean guardadoExitoso = databaseHelper.Registrar (cedula, nombre, celular, contrasena);
        if (guardadoExitoso) {
            Toast.makeText(Registrar.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
            finish(); // Regresa al MainActivity
        } else {
            Toast.makeText( Registrar.this,"No se ha podido guardar correctamente", Toast.LENGTH_SHORT).show();
        }
    }

    public void Volver() { finish();} // Regresa al MainActivity }
}
