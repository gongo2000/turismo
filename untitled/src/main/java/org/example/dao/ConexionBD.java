package org.example.dao;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConexionBD {
    private static Connection conn;

    public static Connection getConnection() {
        // Si ya existe una conexión activa, reutilizarla
        if (conn != null) {
            return conn;
        }

        try (InputStream input = ConexionBD.class.getClassLoader().getResourceAsStream("db.properties")) {
            // Cargar propiedades desde el archivo
            Properties prop = new Properties();
            prop.load(input);

            // Construir la URL de conexión según las propiedades
            String url = "jdbc:mysql://" + prop.getProperty("host") + ":" +
                    prop.getProperty("port") + "/" +
                    prop.getProperty("database") +
                    "?useUnicode=" + prop.getProperty("useUnicode") +
                    "&useJDBCCompliantTimezoneShift=" + prop.getProperty("useJDBCCompliantTimezoneShift");

            // Obtener las credenciales y el driver
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            String driver = prop.getProperty("driver");

            // Validar el driver
            if (!"MySQL".equalsIgnoreCase(driver)) {
                System.err.println("Driver no soportado: " + driver);
                return null;
            }

            // Establecer la conexión
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión a la base de datos establecida exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión a la base de datos: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo db.properties: " + e.getMessage());
        }

        return conn;
    }

    /**
     * Cierra la conexión actual si está abierta.
     */
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
                System.out.println("Conexión a la base de datos cerrada exitosamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
            }
        }
    }

    // Metodo que crea el trigger
    public static void MakeTrigger(){
        String sql = "DROP TRIGGER IF EXISTS `comprobar_cantidad_negativa`";
        try(Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);

            String trigger=  "CREATE TRIGGER comprobar_cantidad_negativa\n" +
                    "BEFORE INSERT ON Produccion\n" +
                    "FOR EACH ROW\n" +
                    "BEGIN\n" +
                    "    IF NEW.cantidadRecolectada < 0 THEN\n" +
                    "    SIGNAL SQLSTATE '45000' \n" +
                    "    SET MESSAGE_TEXT = 'Error: La cantidad recolectada NO puede ser negativa';\n" +
                    "    END IF;\n" +
                    "END\n";

            statement.execute(trigger);

            System.out.println("El Trigger ha sido creado exitosamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}