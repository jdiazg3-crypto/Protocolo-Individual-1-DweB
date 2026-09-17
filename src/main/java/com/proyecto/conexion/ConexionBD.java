package com.proyecto.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Lee las credenciales desde variables de entorno del sistema (Render, etc.)
    // Si no existen, usa los valores de localhost como fallback para desarrollo local
    private static final String URL = System.getenv("DB_URL") != null
            ? System.getenv("DB_URL")
            : "jdbc:mysql://localhost:3306/gestion_futbol?useSSL=false&serverTimezone=UTC";

    private static final String USER = System.getenv("DB_USER") != null
            ? System.getenv("DB_USER")
            : "root";

    private static final String PASSWORD = System.getenv("DB_PASSWORD") != null
            ? System.getenv("DB_PASSWORD")
            : "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
