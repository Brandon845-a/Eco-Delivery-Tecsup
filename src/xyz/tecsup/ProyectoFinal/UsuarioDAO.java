package xyz.tecsup.ProyectoFinal;
import java.util.List;
public interface UsuarioDAO {
	void registrarUsuario(Usuario usuario);
	Usuario buscarPorUsername(String username);
}
