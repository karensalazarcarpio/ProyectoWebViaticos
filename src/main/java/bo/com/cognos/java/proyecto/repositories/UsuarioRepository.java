package bo.com.cognos.java.proyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bo.com.cognos.java.proyecto.model.Usuario;

public interface UsuarioRepository 
	// extends JpaRepository<Usuario, Integer> {
	extends XXXRepository<Usuario, Integer> {

	List<Usuario> findByLoginAndPasswordOrderByIdDesc(
			@Param("login") String login,
			@Param("password")String password);
	
	Usuario buscarPorLogin(@Param("login") String login);
	
	// List<Usuario> buscar(@Param("filtro") String filtro);
	
	@Query("select u from Usuario u where login = :login")
	Usuario buscarPorLogin2(@Param("login") String login);
	
}
