package org.example.model;

public class Reserva {
    private int id;
    private int idCliente;
    private int idPaquete;
    private String fechaReserva;
    private String estado; // PENDIENTE, CONFIRMADA, CANCELADA

    // Constructor vacío
    public Reserva() {}

    // Constructor con parámetros
    public Reserva(int id, int idCliente, int idPaquete, String fechaReserva, String estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.idPaquete = idPaquete;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idPaquete=" + idPaquete +
                ", fechaReserva='" + fechaReserva + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}