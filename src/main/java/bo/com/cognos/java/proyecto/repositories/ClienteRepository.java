package bo.com.cognos.java.proyecto.repositories;

import org.springframework.data.repository.query.Param;

import bo.com.cognos.java.proyecto.model.Cliente;

public interface ClienteRepository extends XXXRepository<Cliente, Short> {

	Cliente findByNit(@Param("nit")String nit);
	
}
