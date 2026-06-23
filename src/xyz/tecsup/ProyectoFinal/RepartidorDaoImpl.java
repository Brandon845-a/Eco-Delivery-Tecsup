package xyz.tecsup.ProyectoFinal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import xyz.tecsup.ProyectoFinal.ConexionDB; 

public class RepartidorDaoImpl implements RepartidorDAO {

    @Override
    public void reclutarRepartidor(Repartidor repartidor) {
       
        String sqlVehiculo = "{call sp_registrar_vehiculo(?, ?, ?)}"; // 
        
   
        String sqlRepartidor = "{call sp_reclutar_repartidor(?, ?, ?, ?, ?)}";
        
        try (Connection conn = ConexionDB.getConexion()) {
         
            System.out.println("Repartidor registrado en proceso de evaluacion.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Repartidor> listarPostulantes() {
        List<Repartidor> lista = new ArrayList<>();
    
        return lista;
    }

    @Override
    public void actualizarEstadoReclutamiento(int idRepartidor, String nuevoEstado) {
        String sql = "{call sp_actualizar_estado_repartidor(?, ?)}";
        
    }
}