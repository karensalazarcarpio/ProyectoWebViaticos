package bo.com.cognos.java.proyecto.view.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.Usuario;
import bo.com.cognos.java.proyecto.services.UsuarioService;
import bo.com.cognos.java.proyecto.services.XXXService;
import bo.com.cognos.java.proyecto.services.impl.UsuarioServiceImpl;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class LoginBean extends XXXBean<Usuario, Integer> {

	@ManagedProperty("#{usuarioServiceImpl}")
	UsuarioService usuarioService;
	
	public LoginBean() {
		super(Usuario.class);
	}

	@Override
	XXXService<Usuario, Integer> getService() {
		return usuarioService;
	}
	
	String login;
	String password;

	public String ingresar() {
		try {
			Usuario usuarioSesion = usuarioService.login(this.login, this.password);
			((HttpSession)(FacesContext.getCurrentInstance().getExternalContext().getSession(true))).setAttribute("usuariosesion", usuarioSesion);
			return "cliente?faces-redirect=true";
		}
		catch (ProyectoException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMensajeUsuario(), e.getMensajeUsuario()));
			return null;
		}
	}
	
	
}
