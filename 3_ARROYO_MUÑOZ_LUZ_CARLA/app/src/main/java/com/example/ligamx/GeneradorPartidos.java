package com.example.ligamx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class GeneradorPartidos {
    private static ArrayList<Partido> partidosGenerados = new ArrayList<>();

    public static ArrayList<Partido> generarPartidos(ArrayList<Equipo> equipos) {
        partidosGenerados.clear(); // Limpiar la lista antes de generar

        // Asegúrate de que la cantidad de equipos sea par
        if (equipos.size() < 2 || equipos.size() % 2 != 0) {
            throw new IllegalArgumentException("La cantidad de equipos debe ser par y al menos dos para generar partidos.");
        }

        Collections.shuffle(equipos); // Mezcla los equipos aleatoriamente

        // Lista de estadios
        String[] estadios = {
                "Estadio Azteca", "Estadio Jalisco", "Estadio Alfonso Lastras",
                "Estadio Akron", "Estadio León", "Estadio BBVA",
                "Estadio Victoria", "Estadio Hidalgo", "Estadio Cuauhtémoc",
                "Estadio Corregidora", "Estadio TSM Corona", "Estadio Caliente",
                "Estadio Nemesio Diez", "Estadio Universitario", "Estadio Kraken",
                "Estadio Olímpico Benito Juárez"
        };

        // Configura el formato de fecha en español
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy", Locale.forLanguageTag("es")); // Formato en español

        for (int i = 0; i < equipos.size(); i += 2) {
            String equipoLocal = equipos.get(i).getNombreOficial(); // Usa getNombreOficial
            String equipoVisitante = equipos.get(i + 1).getNombreOficial();
            String lugar = estadios[(int) (Math.random() * estadios.length)]; // Asigna un estadio aleatorio

            // Generar una fecha aleatoria en el futuro
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, (int) (Math.random() * 30) + 1); // Fecha entre 1 y 30 días en el futuro
            Date fecha = calendar.getTime();

            String hora = "20:00"; // Puedes modificar esto para que sea dinámico
            String estatus = "Pendiente"; // O "Finalizado" si ya ha ocurrido

            partidosGenerados.add(new Partido(equipoLocal, equipoVisitante, lugar, fecha, hora, estatus));
        }

        return partidosGenerados; // Devuelve la lista de partidos generados
    }

    public static ArrayList<Partido> obtenerPartidos() {
        return partidosGenerados;
    }
}
