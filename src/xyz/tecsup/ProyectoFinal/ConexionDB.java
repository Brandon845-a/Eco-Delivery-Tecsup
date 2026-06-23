package xyz.tecsup.ProyectoFinal;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionDB {

    private static String url;
    private static String user;
    private static String password;

    // Bloque estatico para leer las credenciales del operador una sola vez
    static {
    	Properties props = new Properties();
  
        try (InputStream input = ConexionDB.class.getClassLoader().getResourceAsStream("database.properties")) {
            
            if (input != null) {
                props.load(input);
                url = props.getProperty("db.url");
                user = props.getProperty("db.user");
                password = props.getProperty("db.password");
            } else {
                System.out.println("Error: No se pudo encontrar el archivo database.properties en resources");
            }
            
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de configuracion de la base de datos.");
            e.printStackTrace();
        }
    }

    
    public static Connection getConexion() throws SQLException {
        try {
            // driver de maven 
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontro el driver de MariaDB en las dependencias de Maven.");
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, user, password);
    }
}