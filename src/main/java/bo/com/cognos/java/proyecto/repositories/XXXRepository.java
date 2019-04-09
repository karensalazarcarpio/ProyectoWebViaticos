package bo.com.cognos.java.proyecto.repositories;import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import bo.com.cognos.java.proyecto.model.XXXModel;

@NoRepositoryBean
public interface XXXRepository<T extends XXXModel, ID extends Number> 
	extends JpaRepository<T, ID>{

	Optional<T> findById(@Param("id")ID id);
	List<T> buscar(@Param("filtro")String filtro);
	List<T> buscarPorRangoFecha(@Param("filtro")String filtro,
			@Param("fechaInicial")Date fechaInicial, @Param("fechaFinal")Date fechaFinal);
	
	
}
