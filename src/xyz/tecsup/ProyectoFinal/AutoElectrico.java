package xyz.tecsup.ProyectoFinal;

public class AutoElectrico extends Vehiculo {
    private double porcentajeBateria;

    public AutoElectrico(String id, double capacidadCargaMax, double porcentajeBateria) {
        super(id, capacidadCargaMax, 45.0); // 45 km/h promedio
        this.porcentajeBateria = porcentajeBateria;
    }

    @Override
    public double calcularTiempoEntrega(double distanciaKm) {
        return (distanciaKm / getVelocidadPromedio()) * 60; // tiempo en minutos
    }

    @Override
    public double calcularCo2Evitado(double distanciaKm) {
        // Un auto convencional mediano emite aprox 150g de CO2 por Km
        return distanciaKm * 150.0;
    }

    public double getPorcentajeBateria() { return porcentajeBateria; }
    public void setPorcentajeBateria(double porcentajeBateria) { this.porcentajeBateria = porcentajeBateria; }
}