package org.example.daoImpl;

import org.example.dao.ConexionBD;
import org.example.dao.PaqueteTuristicoDAO;
import org.example.model.PaqueteTuristico;
import org.example.dao.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaqueteTuristicoDAOImpl implements PaqueteTuristicoDAO {

    @Override
    public void insertar(PaqueteTuristico paquete) {
        String sql = "INSERT INTO paquetes_turisticos (nombre, destino, precio, duracionDias) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paquete.getNombre());
            stmt.setString(2, paquete.getDestino());
            stmt.setDouble(3, paquete.getPrecio());
            stmt.setInt(4, paquete.getDuracionDias());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM paquetes_turisticos WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(PaqueteTuristico paquete) {
        String sql = "UPDATE paquetes_turisticos SET nombre = ?, destino = ?, precio = ?, duracionDias = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paquete.getNombre());
            stmt.setString(2, paquete.getDestino());
            stmt.setDouble(3, paquete.getPrecio());
            stmt.setInt(4, paquete.getDuracionDias());
            stmt.setInt(5, paquete.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PaqueteTuristico obtenerPorId(int id) {
        String sql = "SELECT * FROM paquetes_turisticos WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new PaqueteTuristico(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("destino"),
                        rs.getDouble("precio"),
                        rs.getInt("duracionDias")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PaqueteTuristico> obtenerTodos() {
        List<PaqueteTuristico> paquetes = new ArrayList<>();
        String sql = "SELECT * FROM paquetes_turisticos";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                paquetes.add(new PaqueteTuristico(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("destino"),
                        rs.getDouble("precio"),
                        rs.getInt("duracionDias")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paquetes;
    }

    public List<String> rankingDestinos() {
        List<String> ranking = new ArrayList<>();
        String sql = "SELECT p.destino, COUNT(r.id) AS total_reservas " +
                "FROM reservas r " +
                "JOIN paquetes p ON r.idPaquete = p.id " +
                "GROUP BY p.destino " +
                "ORDER BY total_reservas DESC";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ranking.add(rs.getString("destino") + " - " + rs.getInt("total_reservas") + " reservas");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ranking;
    }
}