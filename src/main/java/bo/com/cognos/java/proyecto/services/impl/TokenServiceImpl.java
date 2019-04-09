package bo.com.cognos.java.proyecto.services.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.Token;
import bo.com.cognos.java.proyecto.model.Usuario;
import bo.com.cognos.java.proyecto.repositories.TokenRepository;
import bo.com.cognos.java.proyecto.repositories.XXXRepository;
import bo.com.cognos.java.proyecto.services.TokenService;

@Service
@Transactional(readOnly=true)
public class TokenServiceImpl 
	extends XXXServiceImpl<Token, Long> 
	implements TokenService{

	@Autowired
	TokenRepository repository;
	
	@Override
	public Token obtenerPorToken(String token) throws ProyectoException{
		Token tk = repository.findByToken(token);
		if(tk == null) {
			throw new ProyectoException(401, "Token no existe");
		}
		if(tk.getFechaExpiracion().before(new Date())) {
			throw new ProyectoException(402, "Sesión expirada");
		}
		return tk;
	}

	@Override
	XXXRepository<Token, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Override
	void validarAlta(Token obj) throws ProyectoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	void validarModificacion(Token objAnterior, Token objNuevo) throws ProyectoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	void validarBorrado(Token obj) throws ProyectoException {
		// TODO Auto-generated method stub
		
	}

	@Override
        @Transactional(rollbackFor=ProyectoException.class)
	public Token generarToken(Usuario usuario) {
		Token t = new Token();
		t.setUsuario(usuario);
                
		t.setFechaAsignacion(new Date());
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, 3);
		t.setFechaExpiracion(cal.getTime());
		t.setFechaUltimoUso(new Date());
		t.setToken(UUID.randomUUID().toString());
                t.setFechaAlta(new Date());
                t.setFechaModificacion(new Date());
                t.setFechaRegistro(new Date());
                t.setIdUsuarioRegistro(usuario.getId());
		return repository.saveAndFlush(t);
	}

}
