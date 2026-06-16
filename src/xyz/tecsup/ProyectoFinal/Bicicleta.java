package xyz.tecsup.ProyectoFinal;


public class Bicicleta extends Vehiculo {

    
    public Bicicleta(String id, double capacidadCargaMax) {
        super(id, capacidadCargaMax, 15.0); 
    }

    // No quiten el override 
    @Override
    public double calcularTiempoEntrega(double distanciaKm) {
  
        return (distanciaKm / getVelocidadPromedio()) * 60; 
    }

    @Override
    public double calcularCo2Evitado(double distanciaKm) {
      
        return distanciaKm * 120.0; 
    }
}