package xyz.tecsup.ProyectoFinal;

public class Repartidor {
    private int id;
    private String nombre;
    private String dni;
    private String telefono;
    private String estadoReclutamiento; // "POSTULANTE", "APROBADO", "RECHAZADO"
    private Vehiculo vehiculo; // Asociacion con el vehiculo ecologico

    public Repartidor() {}

    public Repartidor(String nombre, String dni, String telefono, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.estadoReclutamiento = "POSTULANTE"; // Estado por defecto al reclutar
        this.vehiculo = vehiculo;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEstadoReclutamiento() { return estadoReclutamiento; }
    public void setEstadoReclutamiento(String estadoReclutamiento) { this.estadoReclutamiento = estadoReclutamiento; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
}