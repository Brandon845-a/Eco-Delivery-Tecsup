package xyz.tecsup.ProyectoFinal;

import java.util.List;

public interface RepartidorDAO {
    void reclutarRepartidor(Repartidor repartidor);
    List<Repartidor> listarPostulantes();
    void actualizarEstadoReclutamiento(int idRepartidor, String nuevoEstado);
}