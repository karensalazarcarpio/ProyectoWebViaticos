package bo.com.cognos.java.proyecto.view.jsf;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.Usuario;
import bo.com.cognos.java.proyecto.services.UsuarioService;
import bo.com.cognos.java.proyecto.services.XXXService;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Getter
@Setter
// public class UsuarioBean {
public class UsuarioBean extends XXXBean<Usuario, Integer> {
	public UsuarioBean() {
		super(Usuario.class);
	}
	@ManagedProperty("#{usuarioServiceImpl}")
	UsuarioService usuarioService;
	@Override
	XXXService<Usuario, Integer> getService() {
		return usuarioService;
	}
	// Logger log = Logger.getLogger(UsuarioBean.class);
	
	
//	private boolean muestraDetalle;
//	private boolean editando;
//	private boolean nuevo;
//	private String filtro;
//	private List<Usuario> usuarios;
//	private Usuario usuario;
//	
//	public void cancelar() {
//		this.muestraDetalle = false;
//	}
//	public void mostrar(Usuario usuario) {
//		log.trace("Mostrará usuario: " + usuario);
//		this.usuario = usuario;
//		this.muestraDetalle = true;
//		this.editando = false;
//	}
//	public void editar(Usuario usuario) {
//		this.usuario = usuario;
//		this.muestraDetalle = true;
//		this.editando = true;
//		this.nuevo = false;
//	}
//	public void crearNuevo() {
//		this.usuario = new Usuario();
//		this.muestraDetalle = true;
//		this.editando = true;
//		this.nuevo = true;
//	}
//	public void buscar() {
//		try {
//			this.usuarios = usuarioService.buscar(filtro);
//		} catch (ProyectoException e) {
//			log.error("Error al guardar usuario", e);
//			FacesContext.getCurrentInstance().
//			addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
//					e.getMensajeUsuario(), e.getMensajeUsuario()));
//		}		
//	}
//	public void eliminar() {
//		try {
//			usuarioService.borrar(this.usuario.getId());
//			FacesContext.getCurrentInstance().
//			addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
//					"Borrado exitoso", "Borrado exitoso"));
//			this.editando = false;
//			this.muestraDetalle = false;
//			this.buscar();
//		} catch (ProyectoException e) {
//			log.error("Error al eliminar el usuario", e);
//			FacesContext.getCurrentInstance().
//			addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
//					e.getMensajeUsuario(), e.getMensajeUsuario()));
//		}		
//	}
//	
//	public void guardar() {
//		try {
//			if(log.isDebugEnabled()) {
//				log.debug("Intentará guardar: " + this.usuario);	
//			}
//			usuarioService.guardar(this.usuario);
//			FacesContext.getCurrentInstance().
//			addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
//					"Operación exitosa", "Operación exitosa"));
//			this.editando = false;
//			this.muestraDetalle = false;
//			this.buscar();
//		} catch (ProyectoException e) {
//			log.error("Error al guardar usuario", e);
//			FacesContext.getCurrentInstance().
//			addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
//					e.getMensajeUsuario(), e.getMensajeUsuario()));
//		}
//	}
	
	
}
