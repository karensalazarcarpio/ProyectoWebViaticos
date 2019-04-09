package bo.com.cognos.java.proyecto.services;

import java.util.List;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.Usuario;

// public interface UsuarioService {
public interface UsuarioService extends XXXService<Usuario, Integer> {

	Usuario login(String login, String password) throws ProyectoException;
	// List<Usuario> buscar(String filtro) throws ProyectoException;
	// Usuario obtener(Integer id) throws ProyectoException;
	// void guardar(Usuario usuario) throws ProyectoException;
	// void eliminar(Integer id) throws ProyectoException;
	
}
