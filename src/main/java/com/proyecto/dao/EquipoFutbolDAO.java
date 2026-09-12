package com.proyecto.dao;

import com.proyecto.conexion.ConexionBD;
import com.proyecto.modelo.EquipoFutbol;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoFutbolDAO {

    public void insertar(EquipoFutbol equipo) {
        String sql = "INSERT INTO equipo_futbol (nombre, eslogan, tecnico, pais, ciudad, categoria, numGoles, numPartidosJugados, numPartidosGanados, numCampeonatos, numExpulsiones, numEmpates) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, equipo.getNombre());
            ps.setString(2, equipo.getEslogan());
            ps.setString(3, equipo.getTecnico());
            ps.setString(4, equipo.getPais());
            ps.setString(5, equipo.getCiudad());
            ps.setString(6, equipo.getCategoria());
            ps.setInt(7, equipo.getNumGoles());
            ps.setInt(8, equipo.getNumPartidosJugados());
            ps.setInt(9, equipo.getNumPartidosGanados());
            ps.setInt(10, equipo.getNumCampeonatos());
            ps.setInt(11, equipo.getNumExpulsiones());
            ps.setInt(12, equipo.getNumEmpates());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<EquipoFutbol> listarTodos() {
        List<EquipoFutbol> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipo_futbol";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(extraerEquipo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizar(EquipoFutbol equipo) {
        String sql = "UPDATE equipo_futbol SET nombre=?, eslogan=?, tecnico=?, pais=?, ciudad=?, categoria=?, numGoles=?, numPartidosJugados=?, numPartidosGanados=?, numCampeonatos=?, numExpulsiones=?, numEmpates=? WHERE id=?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, equipo.getNombre());
            ps.setString(2, equipo.getEslogan());
            ps.setString(3, equipo.getTecnico());
            ps.setString(4, equipo.getPais());
            ps.setString(5, equipo.getCiudad());
            ps.setString(6, equipo.getCategoria());
            ps.setInt(7, equipo.getNumGoles());
            ps.setInt(8, equipo.getNumPartidosJugados());
            ps.setInt(9, equipo.getNumPartidosGanados());
            ps.setInt(10, equipo.getNumCampeonatos());
            ps.setInt(11, equipo.getNumExpulsiones());
            ps.setInt(12, equipo.getNumEmpates());
            ps.setInt(13, equipo.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM equipo_futbol WHERE id=?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EquipoFutbol obtenerPorId(int id) {
        EquipoFutbol equipo = null;
        String sql = "SELECT * FROM equipo_futbol WHERE id=?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    equipo = extraerEquipo(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipo;
    }

    // Reporte 1: Filtrar por País y Categoría.
    public List<EquipoFutbol> reportePaisCategoria(String pais, String categoria) {
        List<EquipoFutbol> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipo_futbol WHERE pais=? AND categoria=?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pais);
            ps.setString(2, categoria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(extraerEquipo(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Reporte 2: Filtrar por Mínimo de Campeonatos y Mínimo de Partidos Ganados.
    public List<EquipoFutbol> reporteMinCampeonatosPartidos(int minCampeonatos, int minPartidosGanados) {
        List<EquipoFutbol> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipo_futbol WHERE numCampeonatos >= ? AND numPartidosGanados >= ?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, minCampeonatos);
            ps.setInt(2, minPartidosGanados);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(extraerEquipo(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private EquipoFutbol extraerEquipo(ResultSet rs) throws SQLException {
        return new EquipoFutbol(
            rs.getInt("id"), rs.getString("nombre"), rs.getString("eslogan"),
            rs.getString("tecnico"), rs.getString("pais"), rs.getString("ciudad"),
            rs.getString("categoria"), rs.getInt("numGoles"), rs.getInt("numPartidosJugados"),
            rs.getInt("numPartidosGanados"), rs.getInt("numCampeonatos"),
            rs.getInt("numExpulsiones"), rs.getInt("numEmpates")
        );
    }
}
