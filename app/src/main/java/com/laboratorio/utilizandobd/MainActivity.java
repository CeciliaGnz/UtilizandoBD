package com.laboratorio.utilizandobd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_register, btn_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_register=(Button) findViewById(R.id.register);
        btn_info=(Button) findViewById(R.id.information);
    }

    public void setBtn_register(){
        Intent intent=new Intent(MainActivity.this, Registrar.class);
        startActivity(intent);
    }

    public void setBtn_info(){
        Intent intent=new Intent(MainActivity.this, Informacion.class);
        startActivity(intent);
    }
}