package com.example.ligamx;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ApuestaEquiposActivity extends AppCompatActivity {

    private Button volverButton;
    private ListView listViewPartidos;
    private RadioGroup resultadoGroup;
    private EditText editTextMonto;
    private Button botonApostar;
    private Partido partidoSeleccionado; // Variable de instancia para almacenar el partido seleccionado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuesta_equipos);

        // Referencias a los elementos de la interfaz
        volverButton = findViewById(R.id.button3);
        listViewPartidos = findViewById(R.id.listViewPartidos);
        resultadoGroup = findViewById(R.id.radioGroupResultado);
        editTextMonto = findViewById(R.id.editTextMonto);
        botonApostar = findViewById(R.id.botonApostar);

        // Obtener los partidos pendientes
        ArrayList<Partido> partidosPendientes = obtenerPartidosPendientes();

        // Configurar el adaptador para mostrar los partidos pendientes en la lista
        ArrayAdapter<Partido> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, partidosPendientes);
        listViewPartidos.setAdapter(adapter);

        // Seleccionar un partido de la lista
        listViewPartidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                partidoSeleccionado = partidosPendientes.get(position);
                Toast.makeText(ApuestaEquiposActivity.this, "Partido seleccionado: " + partidoSeleccionado.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar el botón de apuesta
        botonApostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarApuesta();
            }
        });

        // Configurar el evento OnClickListener para el botón de volver
        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finaliza la actividad actual y regresa a MainActivity
                finish();
            }
        });
    }

    // Método para obtener solo partidos con estatus "Pendiente"
    private ArrayList<Partido> obtenerPartidosPendientes() {
        ArrayList<Partido> partidosPendientes = new ArrayList<>();
        for (Partido partido : GeneradorPartidos.obtenerPartidos()) {
            if ("Pendiente".equals(partido.getEstatus())) {
                partidosPendientes.add(partido);
            }
        }
        return partidosPendientes;
    }

    // Método para realizar la apuesta
    private void realizarApuesta() {
        if (partidoSeleccionado == null) {
            Toast.makeText(this, "Por favor, selecciona un partido.", Toast.LENGTH_SHORT).show();
            return;
        }

        int seleccionadoId = resultadoGroup.getCheckedRadioButtonId();
        if (seleccionadoId == -1) {
            Toast.makeText(this, "Por favor, selecciona un resultado esperado.", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioButtonSeleccionado = findViewById(seleccionadoId);
        String resultadoEsperado = radioButtonSeleccionado.getText().toString();

        String montoTexto = editTextMonto.getText().toString();
        if (montoTexto.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa un monto para la apuesta.", Toast.LENGTH_SHORT).show();
            return;
        }

        double monto = Double.parseDouble(montoTexto);

        // Guardar o procesar la apuesta
        Apuesta apuesta = new Apuesta(partidoSeleccionado, resultadoEsperado, monto);
        // Aquí podrías añadir lógica para almacenar la apuesta en una lista o base de datos

        Toast.makeText(this, "¡Apuesta realizada!", Toast.LENGTH_SHORT).show();
        finish(); // Cierra la actividad después de realizar la apuesta
    }
}
