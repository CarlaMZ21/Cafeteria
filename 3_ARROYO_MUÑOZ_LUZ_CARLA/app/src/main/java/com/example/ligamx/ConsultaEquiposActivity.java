package com.example.ligamx;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConsultaEquiposActivity extends AppCompatActivity {

    private Button volverButton;
    private ListView listViewEquipos;
    private TextView textViewNoEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consulta_equipos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewEquipos = findViewById(R.id.listViewEquipos);
        volverButton = findViewById(R.id.button2);
        textViewNoEquipos = findViewById(R.id.textViewNoEquipos);

        // Si no hay equipos registrados, mostrar el mensaje correspondiente
        if (RegistroEquipos.equiposList.isEmpty()) {
            listViewEquipos.setVisibility(View.GONE);
            textViewNoEquipos.setVisibility(View.VISIBLE);
        } else {
            // Crear un adaptador personalizado para la lista
            CustomAdapter adapter = new CustomAdapter();
            listViewEquipos.setAdapter(adapter);
            textViewNoEquipos.setVisibility(View.GONE);
        }

        // Configurar el evento OnClickListener para el botón de volver
        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finaliza la actividad actual y regresa a MainActivity
                finish();
            }
        });
    }

    private class CustomAdapter extends ArrayAdapter<Equipo> {
        CustomAdapter() {
            super(ConsultaEquiposActivity.this, R.layout.list_item_equipo, RegistroEquipos.equiposList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_equipo, parent, false);
            }

            ImageView imageViewEscudo = convertView.findViewById(R.id.imageViewEscudo);
            TextView textViewAlias = convertView.findViewById(R.id.textViewAlias);

            // Obtener el equipo actual
            Equipo equipo = getItem(position);
            if (equipo != null) {
                textViewAlias.setText(equipo.getAlias());
                int resourceId = getResources().getIdentifier(equipo.getEscudo(), "drawable", getPackageName());
                imageViewEscudo.setImageResource(resourceId);
            }

            return convertView;
        }
    }
}
