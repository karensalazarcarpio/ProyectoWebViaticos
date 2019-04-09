package bo.com.cognos.java.proyecto.services;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.Token;
import bo.com.cognos.java.proyecto.model.Usuario;

public interface TokenService extends XXXService<Token, Long> {

	Token obtenerPorToken(String token) throws ProyectoException;
	Token generarToken(Usuario usuario);
	
}
