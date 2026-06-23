package xyz.tecsup.ProyectoFinal;

import java.sql.Timestamp;

public class Usuario {
    private int idUsuario;
    private String username;
    private String passwordHash;
    private String nombres;
    private String apellidos;
    private String rol;
    private Timestamp fechaRegistro;

    // Constructor vacio
    public Usuario() {}

    // Constructor para registrar nuevos usuarios
    public Usuario(String username, String passwordHash, String nombres, String apellidos) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    // Getters y Setters para el encapsulamiento
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public Timestamp getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Timestamp fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}