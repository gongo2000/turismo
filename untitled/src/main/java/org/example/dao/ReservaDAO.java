package org.example.dao;

import org.example.model.Reserva;
import java.util.List;

public interface ReservaDAO {
    void insertar(Reserva reserva);
    void eliminar(int id);
    void actualizar(Reserva reserva);
    Reserva obtenerPorId(int id);
    List<Reserva> obtenerTodos();
    List<Reserva> obtenerReservasPorCliente(int idCliente); // Declaración del método

}