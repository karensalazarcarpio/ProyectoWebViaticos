package bo.com.cognos.java.proyecto.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bo.com.cognos.java.proyecto.services.ClienteService;
import bo.com.cognos.java.proyecto.model.Cliente;
import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.repositories.ClienteRepository;
import bo.com.cognos.java.proyecto.repositories.XXXRepository;

@Service
@Transactional(readOnly=true)
public class ClienteServiceImpl 
	extends XXXServiceImpl<Cliente, Short>
	implements ClienteService{

	@Autowired
	ClienteRepository repository;
	
	@Override
	XXXRepository<Cliente, Short> getRepository() {
		return repository;
	}

	@Override
	void validarAlta(Cliente obj) throws ProyectoException {
		Cliente existente = repository.findByNit(obj.getNit());
		if(existente != null) {
			throw new ProyectoException(301, "Ya existe un cliente con ese NIT");
		}
		if(obj.getRazonSocial().trim().isEmpty()) {
			throw new ProyectoException(301, "La razón social no puede ser vacía");
		}
	}

	@Override
	void validarModificacion(Cliente objAnterior, Cliente objNuevo) throws ProyectoException {
		if(!objAnterior.getNit().contentEquals(objNuevo.getNit())) {
			throw new ProyectoException(301, "No puede cambiar el NIT");
		}
		if(objNuevo.getRazonSocial().trim().isEmpty()) {
			throw new ProyectoException(301, "La razón social no puede ser vacía");
		}
		
	}

	@Override
	void validarBorrado(Cliente obj) throws ProyectoException {
		// TODO: Cuando se tenga el mapeo de Ventas, 
		// no permitir el borrado de clientes que tengan comrpas
		
	}

}
