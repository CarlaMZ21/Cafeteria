package com.example.ligamx;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.AdapterView;

public class RegistroEquipoActivity extends AppCompatActivity {

    private Button volverButton;
    private Spinner spinnerNombreOficial, spinnerAlias, spinnerEscudo, spinnerCiudad, spinnerEstadio;
    private Button btnRegistrar;
    private ImageView imageViewEscudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_equipo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar los Spinners
        spinnerNombreOficial = findViewById(R.id.spinner_nombre_oficial);
        spinnerAlias = findViewById(R.id.spinner_alias);
        spinnerEscudo = findViewById(R.id.spinner_escudo);
        spinnerCiudad = findViewById(R.id.spinner_ciudad);
        spinnerEstadio = findViewById(R.id.spinner_estadio);
        btnRegistrar = findViewById(R.id.button5);
        volverButton = findViewById(R.id.button);
        imageViewEscudo = findViewById(R.id.imageViewEscudo);

        // Crear listas de datos
        String[] equipos = {"Seleccione equipo", "América", "Atlas", "Atlético San Luis", "Cruz Azul", "Guadalajara", "León", "Monterrey", "Necaxa", "Pachuca", "Puebla", "Querétaro", "Santos Laguna", "Tijuana", "Toluca", "Tigres UANL", "Pumas UNAM", "Mazatlán", "Juárez"};
        String[] alias = {"Seleccione alias", "Águilas", "Rojinegros", "Rojiblancos", "La Máquina", "Chivas", "La Fiera", "Rayados", "Rayos", "Tuzos", "La Franja", "Gallos Blancos", "Guerreros", "Xolos", "Diablos Rojos", "Universitarios", "Cañoneros", "Bravos"};
        String[] escudos = {"Seleccione escudo", "escudo_america", "escudo_atlas", "escudo_atletico_san_luis", "escudo_cruz_azul", "escudo_guadalajara", "escudo_leon", "escudo_monterrey", "escudo_necaxa", "escudo_pachuca", "escudo_puebla", "escudo_queretaro", "escudo_santos_laguna", "escudo_tijuana", "escudo_toluca", "escudo_tigres", "escudo_pumas", "escudo_mazatlan", "escudo_juarez"};
        String[] ciudades = {"Seleccione ciudad", "CDMX", "Guadalajara, Jal", "San Luis Potosí", "León, Gto", "Monterrey, N. L.", "Aguascalientes", "Pachuca, Hidalgo", "Puebla", "Querétaro", "Torreón, Coahuila", "Tijuana, BC.", "Toluca, Edo. México", "San Nicolás de los Garza, N. L.", "Mazatlán, Sinaloa", "Ciudad Juárez, Chihuahua"};
        String[] estadios = {"Seleccione estadio", "Estadio Azteca", "Estadio Jalisco", "Estadio Alfonso Lastras", "Estadio Akron", "Estadio León", "Estadio BBVA", "Estadio Victoria", "Estadio Hidalgo", "Estadio Cuauhtémoc", "Estadio Corregidora", "Estadio TSM Corona", "Estadio Caliente", "Estadio Nemesio Diez", "Estadio Universitario", "Estadio Kraken", "Estadio Olímpico Benito Juárez"};

        // Adaptadores para los Spinners
        ArrayAdapter<String> adapterEquipos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, equipos);
        adapterEquipos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNombreOficial.setAdapter(adapterEquipos);

        ArrayAdapter<String> adapterAlias = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, alias);
        adapterAlias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAlias.setAdapter(adapterAlias);

        ArrayAdapter<String> adapterEscudos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, escudos);
        adapterEscudos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEscudo.setAdapter(adapterEscudos);

        ArrayAdapter<String> adapterCiudades = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ciudades);
        adapterCiudades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCiudad.setAdapter(adapterCiudades);

        // Adaptador para los estadios
        ArrayAdapter<String> adapterEstadios = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, estadios);
        adapterEstadios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstadio.setAdapter(adapterEstadios);

        // Listener para cambiar el escudo cuando se seleccione un equipo
        spinnerNombreOficial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) { // Ignora la opción "Seleccione equipo"
                    String escudoSeleccionado = escudos[position];
                    int resourceId = getResources().getIdentifier(escudoSeleccionado, "drawable", getPackageName());
                    imageViewEscudo.setImageResource(resourceId);
                } else {
                    imageViewEscudo.setImageResource(0); // Limpia el escudo si no hay selección
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                imageViewEscudo.setImageResource(0); // Limpia el escudo si no hay selección
            }
        });

        // Acciones para el botón de registrar
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validar que todos los campos estén seleccionados
                if (spinnerNombreOficial.getSelectedItem().toString().equals("Seleccione equipo") ||
                        spinnerAlias.getSelectedItem().toString().equals("Seleccione alias") ||
                        spinnerEscudo.getSelectedItem().toString().equals("Seleccione escudo") ||
                        spinnerCiudad.getSelectedItem().toString().equals("Seleccione ciudad") ||
                        spinnerEstadio.getSelectedItem().toString().equals("Seleccione estadio")) {
                    Toast.makeText(RegistroEquipoActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Crear un nuevo equipo y agregarlo a la lista estática
                    Equipo nuevoEquipo = new Equipo(
                            spinnerNombreOficial.getSelectedItem().toString(),
                            spinnerAlias.getSelectedItem().toString(),
                            spinnerEscudo.getSelectedItem().toString(),
                            spinnerCiudad.getSelectedItem().toString(),
                            spinnerEstadio.getSelectedItem().toString()
                    );

                    // Registrar el equipo
                    RegistroEquipos.agregarEquipo(nuevoEquipo);
                    Toast.makeText(RegistroEquipoActivity.this, "Equipo registrado correctamente", Toast.LENGTH_SHORT).show();

                    // Limpiar los spinners y el escudo
                    spinnerNombreOficial.setSelection(0);
                    spinnerAlias.setSelection(0);
                    spinnerEscudo.setSelection(0);
                    spinnerCiudad.setSelection(0);
                    spinnerEstadio.setSelection(0);
                    imageViewEscudo.setImageResource(0); // Limpia el escudo
                }
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
}
