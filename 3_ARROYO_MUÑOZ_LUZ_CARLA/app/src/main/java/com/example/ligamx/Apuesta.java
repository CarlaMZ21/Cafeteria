package com.example.ligamx;

public class Apuesta {
    private Partido partido;
    private String resultadoEsperado;
    private double monto;

    public Apuesta(Partido partido, String resultadoEsperado, double monto) {
        this.partido = partido;
        this.resultadoEsperado = resultadoEsperado;
        this.monto = monto;
    }

    // Getters y setters
    public Partido getPartido() {
        return partido;
    }

    public String getResultadoEsperado() {
        return resultadoEsperado;
    }

    public double getMonto() {
        return monto;
    }
}
