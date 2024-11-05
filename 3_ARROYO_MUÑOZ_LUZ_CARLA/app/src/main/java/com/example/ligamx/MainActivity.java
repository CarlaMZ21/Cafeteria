package com.example.ligamx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declarar botones
    private Button btnRegistro;
    private Button btnConsultaEquipo;
    private Button btnConsultaPartido;
    private Button btnApuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Asignar los botones a sus IDs
        btnRegistro = findViewById(R.id.btn_registro);
        btnConsultaEquipo = findViewById(R.id.btn_consulta_equipo);
        btnConsultaPartido = findViewById(R.id.btn_consulta_partido);
        btnApuesta = findViewById(R.id.btn_apuesta);

        // Configurar los eventos OnClickListener para cada botón usando lambdas
        btnRegistro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegistroEquipoActivity.class);
            startActivity(intent);
        });

        btnConsultaEquipo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConsultaEquiposActivity.class);
            startActivity(intent);
        });

        btnConsultaPartido.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConsultaPartidosActivity.class);
            startActivity(intent);
        });

        btnApuesta.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ApuestaEquiposActivity.class);
            startActivity(intent);
        });

        // No deshabilitar ningún botón
    }
}
