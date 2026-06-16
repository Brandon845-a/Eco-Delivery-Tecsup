package xyz.tecsup.ProyectoFinal;

// Esta es la clase padre
public abstract class Vehiculo {
  
    private String id;
    private double capacidadCargaMax;
    private double velocidadPromedio;

   
    public Vehiculo(String id, double capacidadCargaMax, double velocidadPromedio) {
        this.id = id;
        this.capacidadCargaMax = capacidadCargaMax;
        this.velocidadPromedio = velocidadPromedio;
    }

   // Estos son los metodos no los cambien 
    public abstract double calcularTiempoEntrega(double distanciaKm);
    public abstract double calcularCo2Evitado(double distanciaKm);

   
    public String getId() {
        return id;
    }

    public double getCapacidadCargaMax() {
        return capacidadCargaMax;
    }

    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }
}