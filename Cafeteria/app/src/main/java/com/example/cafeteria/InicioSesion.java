package com.example.cafeteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class InicioSesion extends AppCompatActivity {

    private EditText etUsuario, etContrasena;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        etUsuario = findViewById(R.id.editTextText);
        etContrasena = findViewById(R.id.editTextText2);
        btnIniciar = findViewById(R.id.button);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String contrasena = etContrasena.getText().toString();

                if (usuario.equals("carla") && contrasena.equals("123456")) {
                    Toast.makeText(InicioSesion.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                    // Iniciar MainActivity y finalizar InicioSesion
                    Intent intent = new Intent(InicioSesion.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(InicioSesion.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
