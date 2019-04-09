/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.cognos.java.proyecto.services.impl;

import bo.com.cognos.java.proyecto.model.Formulario;
import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.repositories.FormularioRepository;
import bo.com.cognos.java.proyecto.repositories.XXXRepository;
import bo.com.cognos.java.proyecto.services.FormularioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KAREN
 */
@Service
@Transactional(readOnly=true)
public class FormularioServiceImpl 
    extends XXXServiceImpl<Formulario, Short>
	implements FormularioService{
    
    final static String ESTADO_ELABORADO="APROBADO";
    @Autowired
    FormularioRepository repository;

    @Override
    XXXRepository<Formulario, Short> getRepository() {
        return repository;
    }

    @Override
    void validarAlta(Formulario obj) throws ProyectoException {
        validarGestion(obj.getGestion());
    }

    @Override
    void validarModificacion(Formulario objAnterior, Formulario objNuevo) throws ProyectoException {
        if(!objAnterior.getGestion().equals(objNuevo.getGestion())){
            
            throw new ProyectoException(100,"La gestion no puede ser modificada");
        }
    }

    @Override
    void validarBorrado(Formulario obj) throws ProyectoException {
        if(obj.getEstado().equals(ESTADO_ELABORADO)){
            throw new ProyectoException(100,"El formulario no puede ser eliminado debido a que se encuentra en estado APROBADO");
        }
    }

    private void validarGestion(Integer gestion) throws ProyectoException{
        if(gestion==null){
            throw new ProyectoException(100,"La gestion no puede ser nula");
        }
        if(gestion<2000 || gestion>2099){
            throw new ProyectoException(100,"El valor de la gestion no es correcto");
        }
    }

  
}
