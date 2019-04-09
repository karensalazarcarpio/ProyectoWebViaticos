package bo.com.cognos.java.proyecto.resources;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import bo.com.cognos.java.proyecto.model.ProyectoException;
@Provider
public class XXXExceptionMapper 
	implements ExceptionMapper<ProyectoException> {

	@Override
	public Response toResponse(ProyectoException exception) {
		return Response.status(500).
				entity(exception.getMensajeUsuario()).type(MediaType.TEXT_PLAIN).build();
	}

}
