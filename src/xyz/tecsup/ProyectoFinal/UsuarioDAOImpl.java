package xyz.tecsup.ProyectoFinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, password_hash, nombres, apellidos) VALUES (?, ?, ?, ?)";
        
        // con el try con recursos se cierra la conexion automatica 
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, usuario.getUsername());
            pstmt.setString(2, usuario.getPasswordHash()); // aqui va el hash, yo despues lo hago 
            pstmt.setString(3, usuario.getNombres());
            pstmt.setString(4, usuario.getApellidos());
            
            pstmt.executeUpdate();
            System.out.println("Usuario registrado correctamente en MariaDB.");
            
        } catch (SQLException e) {
            System.out.println("Error al intentar registrar el usuario.");
            e.printStackTrace();
        }
    }

    @Override
    public Usuario buscarPorUsername(String username) {
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setPasswordHash(rs.getString("password_hash"));
                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setRol(rs.getString("rol"));
                    usuario.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el usuario por username.");
            e.printStackTrace();
        }
        return null; 
    }
}