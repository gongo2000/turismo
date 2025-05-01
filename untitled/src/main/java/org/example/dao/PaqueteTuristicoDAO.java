package org.example.dao;

import org.example.model.PaqueteTuristico;
import java.util.List;

public interface PaqueteTuristicoDAO {
    void insertar(PaqueteTuristico paquete);
    void eliminar(int id);
    void actualizar(PaqueteTuristico paquete);
    PaqueteTuristico obtenerPorId(int id);
    List<PaqueteTuristico> obtenerTodos();
}