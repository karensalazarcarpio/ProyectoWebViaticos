/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.cognos.java.proyecto.services.impl;

import bo.com.cognos.java.proyecto.model.FormDetalle;
import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.repositories.FormDetalleRepository;
import bo.com.cognos.java.proyecto.repositories.XXXRepository;
import bo.com.cognos.java.proyecto.services.FormDetalleService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KAREN
 */
@Service
@Transactional(readOnly=true)
public class FormDetalleImpl 
extends XXXServiceImpl<FormDetalle, Short>
	implements FormDetalleService{
    @Autowired
    final static String ESTADO_ELABORADO="APROBADO";
    
    @Autowired
    FormDetalleRepository repository;
    
    
    @Override
    XXXRepository<FormDetalle, Short> getRepository() {
       return repository;
    }

    @Override
    void validarAlta(FormDetalle obj) throws ProyectoException {
        validarFechaFormulario(obj.getFechaPartida(),obj.getFechaRetorno() );
    }

    @Override
    void validarModificacion(FormDetalle objAnterior, FormDetalle objNuevo) throws ProyectoException {
        if(objAnterior.getFechaRegistro().equals(objNuevo.getFechaRegistro())){
            throw new ProyectoException(100,"La Fecha de Registro no puede ser editada");
        }
    }

    @Override
    void validarBorrado(FormDetalle obj) throws ProyectoException {
        if(obj.getFechaAlta().before(new Date())){
            throw new ProyectoException(100,"La fecha de alta debe ser mayor a la fecha actual");
        }
    }
    private void validarFechaFormulario(Date fechaPartida, Date fechaRetorno) throws ProyectoException{
    
        if(fechaRetorno.before(fechaPartida)){
            throw new ProyectoException(100,"La fecha de Retorno no puede ser mayor a la fecha patida");
        }
    }
            
}
