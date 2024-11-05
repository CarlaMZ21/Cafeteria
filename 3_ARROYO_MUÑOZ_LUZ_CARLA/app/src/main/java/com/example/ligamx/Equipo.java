package com.example.ligamx;

public class Equipo {
    private String nombreOficial;
    private String alias;
    private String escudo;
    private String ciudad;
    private String estadio;

    public Equipo(String nombreOficial, String alias, String escudo, String ciudad, String estadio) {
        this.nombreOficial = nombreOficial;
        this.alias = alias;
        this.escudo = escudo;
        this.ciudad = ciudad;
        this.estadio = estadio;
    }

    public String getNombreOficial() {
        return nombreOficial;
    }

    public String getAlias() {
        return alias;
    }

    public String getEscudo() {
        return escudo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstadio() {
        return estadio;
    }
}
