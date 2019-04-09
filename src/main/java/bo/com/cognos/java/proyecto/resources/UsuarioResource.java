package bo.com.cognos.java.proyecto.resources;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.Token;
import bo.com.cognos.java.proyecto.model.Usuario;
import bo.com.cognos.java.proyecto.services.TokenService;
import bo.com.cognos.java.proyecto.services.UsuarioService;

@Path("usuario")
public class UsuarioResource {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	TokenService tokenService;
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Usuario> listarTodos() throws ProyectoException{
		return usuarioService.buscar("");		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/{id}")
	public Usuario obtener(@PathParam("id")Integer id) throws ProyectoException{
		return usuarioService.obtener(id);		
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Usuario crear(Usuario usuario) throws ProyectoException {
		return usuarioService.guardar(usuario);
	}
	
	@POST
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/login")
	public String login(Usuario usuario) throws ProyectoException {
		Usuario usrAutenticado = usuarioService.login(usuario.getLogin(), usuario.getPassword());
		Token token = tokenService.generarToken(usrAutenticado);		
		return token.getToken();
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, 
		MediaType.TEXT_PLAIN})
	public Usuario actualizar(Usuario usuario) throws ProyectoException {
		return usuarioService.guardar(usuario);
	}
	
	
	
	@DELETE
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/{id}")
	public String borrar(@PathParam("id")Integer id) throws ProyectoException {
		usuarioService.borrar(id);
		return "OK";
	}
	
	
	
	
	
}
