package xyz.tecsup.ProyectoFinal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UsuarioVista extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton btnCargar;
    private UsuarioDAO dao; 

    public UsuarioVista() {
        // 1. Configuración básica de la ventana
        setTitle("Eco-Vehículos: Gestión de Usuarios");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 2. Inicializar tu DAO Real
        dao = new UsuarioDAOImpl();

        // 3. Crear el modelo de la tabla basado en tus atributos de la BD
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Correo Electrónico");
        modelo.addColumn("Rol");
        
        tabla = new JTable(modelo);

        // 4. Panel superior estético con un botón
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(46, 204, 113)); // Verde Eco
        btnCargar = new JButton("Actualizar desde Base de Datos");
        panelSuperior.add(btnCargar);

        // 5. Agregar componentes a la ventana principal
        add(panelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // 6. Lógica del botón para recargar
        btnCargar.addActionListener(e -> cargarUsuarios());

        // Carga inicial automática al abrir el programa
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        try {
            // 1. Limpiamos las filas existentes para evitar duplicados
            modelo.setRowCount(0);
            
            // 2. Llamamos al método que acabamos de declarar en tu interfaz
            List<Usuario> lista = dao.listar(); 
            
            // 3. Recorremos usando TUS getters reales de la captura (image_c921a0.png)
            for (Usuario u : lista) {
                modelo.addRow(new Object[]{
                    u.getIdUsuario(),    // En tu clase es getIdUsuario()
                    u.getUsername(),     // En tu clase es getUsername()
                    u.getNombres(),      // En tu clase es getNombres()
                    u.getApellidos(),    // En tu clase es getApellidos()
                    u.getRol()           // En tu clase es getRol()
                });
            }
            
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La tabla 'usuarios' está vacía en MariaDB.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejecución segura de Swing
        SwingUtilities.invokeLater(() -> {
            new UsuarioVista().setVisible(true);
        });
    }
}