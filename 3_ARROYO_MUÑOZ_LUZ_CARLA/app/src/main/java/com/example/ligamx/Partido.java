package com.example.ligamx;

import java.util.Date;

public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private String lugar;
    private Date fecha;
    private String hora;
    private String estatus; // "Pendiente" o "Finalizado"

    public Partido(String equipoLocal, String equipoVisitante, String lugar, Date fecha, String hora, String estatus) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.estatus = estatus;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public String getLugar() {
        return lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getEstatus() {
        return estatus;
    }

    @Override
    public String toString() {
        return equipoLocal + " vs " + equipoVisitante + " en " + lugar + " el " + fecha + " a las " + hora + " - " + estatus;
    }
}
