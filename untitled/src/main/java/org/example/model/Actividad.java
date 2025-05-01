package org.example.model;

public class Actividad {
    private int id;
    private int idPaquete;
    private String nombre;
    private String descripcion;
    private double costoAdicional;

    // Constructor vacío
    public Actividad() {}

    // Constructor con parámetros
    public Actividad(int id, int idPaquete, String nombre, String descripcion, double costoAdicional) {
        this.id = id;
        this.idPaquete = idPaquete;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoAdicional = costoAdicional;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(double costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", idPaquete=" + idPaquete +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", costoAdicional=" + costoAdicional +
                '}';
    }
}

