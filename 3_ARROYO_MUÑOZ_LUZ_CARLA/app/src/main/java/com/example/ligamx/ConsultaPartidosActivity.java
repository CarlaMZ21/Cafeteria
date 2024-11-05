package com.example.ligamx;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ConsultaPartidosActivity extends AppCompatActivity {

    private ListView listViewPartidos;
    private Button volverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consulta_partidos);

        // Configurar el sistema de insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar los componentes de la interfaz
        listViewPartidos = findViewById(R.id.listViewPartidos);
        volverButton = findViewById(R.id.button1); // Asegúrate de que este ID sea correcto

        // Suponiendo que tienes la lista de equipos en RegistroEquipos
        ArrayList<Equipo> equipos = RegistroEquipos.obtenerEquipos();

        // Generar partidos usando la lista de equipos
        ArrayList<Partido> partidos = GeneradorPartidos.generarPartidos(equipos);

        // Crear el adaptador para mostrar los partidos
        CustomAdapter adapter = new CustomAdapter(partidos);
        listViewPartidos.setAdapter(adapter);

        // Configurar el evento OnClickListener para el botón de volver
        volverButton.setOnClickListener(v -> finish());
    }

    private class CustomAdapter extends ArrayAdapter<Partido> {
        CustomAdapter(ArrayList<Partido> partidos) {
            super(ConsultaPartidosActivity.this, android.R.layout.simple_list_item_1, partidos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(android.R.layout.simple_list_item_2, parent, false);
            }

            // Obtener el partido actual
            Partido partido = getItem(position);

            // Configurar la vista con la información del partido
            TextView text1 = convertView.findViewById(android.R.id.text1);
            TextView text2 = convertView.findViewById(android.R.id.text2);

            // Mostrar los detalles del partido
            text1.setText(partido.getEquipoLocal() + " vs " + partido.getEquipoVisitante());
            text2.setText("Lugar: " + partido.getLugar() +
                    "\nFecha: " + partido.getFecha() +
                    "\nHora: " + partido.getHora() +
                    "\nEstatus: " + partido.getEstatus());

            return convertView;
        }
    }
}
