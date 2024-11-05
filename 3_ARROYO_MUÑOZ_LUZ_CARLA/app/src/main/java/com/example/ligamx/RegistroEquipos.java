package com.example.ligamx;

import java.util.ArrayList;

public class RegistroEquipos {
    public static ArrayList<Equipo> equiposList = new ArrayList<>();

    public static void agregarEquipo(Equipo equipo) {
        equiposList.add(equipo);
    }

    public static ArrayList<Equipo> obtenerEquipos() {
        return equiposList;
    }
}
