package xyz.tecsup.ProyectoFinal;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {

	public static void main(String[] args) {
		System.out.println("###### Iniciando pruebas ######");
		
		try (Connection conn = ConexionDB.getConexion()){
			if (conn != null && !conn.isClosed()) {
				System.out.println("Conexión exitosa \n Usuario operador Funcional!");
			}
			
		} catch (SQLException e) {
			System.out.println("Ocurrio un error al conectar//////n");
			e.printStackTrace();
		}
	}
}
