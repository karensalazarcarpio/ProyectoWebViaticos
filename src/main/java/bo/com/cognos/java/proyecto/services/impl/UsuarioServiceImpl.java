package bo.com.cognos.java.proyecto.services.impl;

import bo.com.cognos.java.proyecto.model.Formulario;
import bo.com.cognos.java.proyecto.model.Funcionario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.Usuario;
import bo.com.cognos.java.proyecto.repositories.FormularioRepository;
import bo.com.cognos.java.proyecto.repositories.UsuarioRepository;
import bo.com.cognos.java.proyecto.repositories.XXXRepository;
import bo.com.cognos.java.proyecto.services.UsuarioService;

@Service
@Transactional(readOnly=true)
// public class UsuarioServiceImpl implements UsuarioService {
public class UsuarioServiceImpl extends XXXServiceImpl<Usuario, Integer> 
	implements UsuarioService {

	@Autowired
	UsuarioRepository repository;
        

	public Usuario login(String login, String password) throws ProyectoException {
		Usuario usuario = repository.buscarPorLogin(login);
		if(usuario == null) {
			throw new ProyectoException(1001, "Usuario no existe");
		}
		if(!usuario.isHabilitado()) {
			throw new ProyectoException(1002, "Usuario bloqueado");
		}
		// if(!usuario.getPassword().contentEquals(password)) {
		if(!usuario.getPassword().contentEquals(this.transformarPassword(login, password))) {
			throw new ProyectoException(1003, "Contraseña incorrecta");
		}
		return usuario;
	}

//	public List<Usuario> buscar(String filtro) throws ProyectoException {
//		filtro = "%" + filtro + "%";
//		return repository.buscar(filtro);
//	}

//	public Usuario obtener(Integer id) throws ProyectoException {
//		return repository.findById(id).orElse(null);
//	}

//	// @Transactional(rollbackFor=ProyectoException.class, propagation=Propagation.REQUIRED)
//	@Transactional(rollbackFor=ProyectoException.class)
//	public void guardar(Usuario usuario) throws ProyectoException {
//		// Validaciones antes guardar...
//		Usuario usuarioExistente = repository.buscarPorLogin(usuario.getLogin());
//		if(usuarioExistente != null && !usuarioExistente.getId().equals(usuario.getId())) {
//			throw new ProyectoException(1100, "Ya existe un usuario con ese login.");
//		}
//		// Fin validaciones...
//		if(usuario.getId() == null) {
//			usuario.setFechaAlta(new Date());
//		}
//		usuario.setFechaModificacion(new Date());
//		repository.saveAndFlush(usuario);
//	}

//	@Override
//	@Transactional(rollbackFor=ProyectoException.class)
//	public void eliminar(Integer id) throws ProyectoException {
//		// TODO Auto-generated method stub
//		Usuario usuario = this.obtener(id);
//		// Agregra validaciones...
//		
//		
//		usuario.setFechaBaja(new Date());
//		repository.saveAndFlush(usuario);
//	}
	
	private String obtenerHash(String textoOriginal, String algoritmo) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(algoritmo);
			md.update(textoOriginal.getBytes());
			byte[] bytes = md.digest();
			String hash = new BigInteger(1,bytes).toString(16);
			return hash;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	private String transformarPassword(String login, String password) {
		String hash1 = this.obtenerHash(login + password, "MD5");
		String hash2 = this.obtenerHash(hash1, "SHA1");
		return hash2;
	}
	
	public static void main(String[] args) throws ProyectoException {
		FormularioServiceImpl x=new FormularioServiceImpl();
                Formulario item=new Formulario();
                Funcionario funcionario=new Funcionario((short)1);
                item.setId((short)1);
                item.setMotivoViaje("Presentacion");
                item.setJustificacion("Justificacion");
                item.setEstado("AP");
                item.setGestion(2019);
                item.setFuncionario(funcionario);
                x.guardar(item);
                
                
        }

	@Override
	XXXRepository<Usuario, Integer> getRepository() {
		return repository;
	}

	@Override
	void validarAlta(Usuario obj) throws ProyectoException {
		Usuario existente = repository.buscarPorLogin(obj.getLogin());
		if(existente != null) {
			throw new ProyectoException(523, "Ya existe un usuario con ese login.");
		}
		
		// después de pasar tooodas las validaciones, transforma el password
		obj.setPassword(this.transformarPassword(obj.getLogin(), obj.getPassword()));
	}

	@Override
	void validarModificacion(Usuario objAnterior, Usuario objNuevo) throws ProyectoException {
		if(!objAnterior.getLogin().equals(objNuevo.getLogin())) {
			throw new ProyectoException(305, "No puede cambiar el login de un usuario existente.");
		}		
	}

	@Override
	void validarBorrado(Usuario obj) throws ProyectoException {
		// .....	
		
	}
	
	
	

}
