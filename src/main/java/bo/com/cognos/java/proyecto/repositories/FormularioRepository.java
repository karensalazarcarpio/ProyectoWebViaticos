/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.cognos.java.proyecto.repositories;

import bo.com.cognos.java.proyecto.model.Formulario;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author KAREN
 */
public interface FormularioRepository extends XXXRepository<Formulario, Short>  {
    //Formulario findByIDFormularioGestion(@Param("id")Short id);
}
