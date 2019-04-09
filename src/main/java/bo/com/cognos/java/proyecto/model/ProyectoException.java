package bo.com.cognos.java.proyecto.model;

import lombok.Getter;

@Getter
public class ProyectoException extends Exception {

	private Integer codigoError;
	private String mensajeUsuario;
	public ProyectoException(Integer codigoError, String mensajeUsuario,
			String mensajeSistema) {
		super(mensajeSistema);
		this.codigoError = codigoError;
		this.mensajeUsuario = mensajeUsuario;
	}
	public ProyectoException(Integer codigoError, String mensajeUsuario) {
		super(mensajeUsuario);
		this.codigoError = codigoError;
		this.mensajeUsuario = mensajeUsuario;
	}
	public ProyectoException(Integer codigoError, String mensajeUsuario,
			Exception e) {
		super(e);
		this.codigoError = codigoError;
		this.mensajeUsuario = mensajeUsuario;
	}
	
}
