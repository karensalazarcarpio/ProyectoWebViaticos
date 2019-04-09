package bo.com.cognos.java.proyecto.soap;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.ProtocolException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.Token;
import bo.com.cognos.java.proyecto.services.TokenService;

public class ProyectoServiceHandler
	implements SOAPHandler<SOAPMessageContext>{

	Logger log = Logger.getLogger(ProyectoServiceHandler.class);
	
	@Autowired
	TokenService tokenService;
	
	@Override
	public boolean handleMessage(SOAPMessageContext smc) {
		Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		log.info("Outbound: " + outboundProperty);
		// String ip = ((HttpServletRequest)smc.get(MessageContext.SERVLET_REQUEST)).getRemoteAddr();
		SOAPMessage soap = smc.getMessage();
		ByteArrayOutputStream baosBody = new ByteArrayOutputStream();
		try {
		soap.writeTo(baosBody);
		} catch (Exception ignored) {
		}
		String data = baosBody.toString();
		
		log.info("Data...: " + data);
		if(data.contains("login>")) {
			return true;
		}
		if(outboundProperty) {
			return true;
		}
		
		
		
		// Verificación de token...
		Map<String, List<String>> headers = (Map<String, List<String>>) smc.get(MessageContext.HTTP_REQUEST_HEADERS);
		List<String> cadenas = headers.get("Authorization");
		if(cadenas == null || cadenas.isEmpty()) {
			throw new ProtocolException("Debe agregar el token de autenticación");
		}
		String token = cadenas.get(0); 
		log.info("Dato cabecera Authorization: " + token);
		
		try {
			WebApplicationContextUtils.getRequiredWebApplicationContext(
					((HttpServletRequest)smc.get(MessageContext.SERVLET_REQUEST)).
					getServletContext()).getAutowireCapableBeanFactory().
					autowireBean(this);
			Token tk = tokenService.obtenerPorToken(token);
		} catch (ProyectoException e) {
			throw new ProtocolException(e.getMensajeUsuario());
		}
		
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		
		return true;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
