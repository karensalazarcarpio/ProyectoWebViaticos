package bo.com.cognos.java.proyecto.repositories;

import org.springframework.data.repository.query.Param;

import bo.com.cognos.java.proyecto.model.Token;

public interface TokenRepository 
	extends XXXRepository<Token, Long> {

	Token findByToken(@Param("token")String token);
	
	
}
