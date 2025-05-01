package org.example.daoImpl;

import org.example.dao.ActividadDAO;
import org.example.model.Actividad;
import org.example.dao.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActividadDAOImpl implements ActividadDAO {

    @Override
    public void insertar(Actividad actividad) {
        String sql = "INSERT INTO actividades (idPaquete, nombre, descripcion, costoAdicional) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, actividad.getIdPaquete());
            stmt.setString(2, actividad.getNombre());
            stmt.setString(3, actividad.getDescripcion());
            stmt.setDouble(4, actividad.getCostoAdicional());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM actividades WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Actividad actividad) {
        String sql = "UPDATE actividades SET idPaquete = ?, nombre = ?, descripcion = ?, costoAdicional = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, actividad.getIdPaquete());
            stmt.setString(2, actividad.getNombre());
            stmt.setString(3, actividad.getDescripcion());
            stmt.setDouble(4, actividad.getCostoAdicional());
            stmt.setInt(5, actividad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Actividad obtenerPorId(int id) {
        String sql = "SELECT * FROM actividades WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Actividad(
                        rs.getInt("id"),
                        rs.getInt("idPaquete"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("costoAdicional")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Actividad> obtenerTodos() {
        List<Actividad> actividades = new ArrayList<>();
        String sql = "SELECT * FROM actividades";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                actividades.add(new Actividad(
                        rs.getInt("id"),
                        rs.getInt("idPaquete"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("costoAdicional")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actividades;
    }
}