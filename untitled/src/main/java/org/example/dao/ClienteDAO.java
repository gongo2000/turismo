package org.example.dao;

import org.example.model.Cliente;
import java.util.List;

public interface ClienteDAO {
    void insertar(Cliente cliente);
    void eliminar(int id);
    void actualizar(Cliente cliente);
    Cliente obtenerPorId(int id);
    List<Cliente> obtenerTodos();
}