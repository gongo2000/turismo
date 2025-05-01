package org.example.dao;

import org.example.model.Actividad;
import java.util.List;

public interface ActividadDAO {
    void insertar(Actividad actividad);
    void eliminar(int id);
    void actualizar(Actividad actividad);
    Actividad obtenerPorId(int id);
    List<Actividad> obtenerTodos();
}