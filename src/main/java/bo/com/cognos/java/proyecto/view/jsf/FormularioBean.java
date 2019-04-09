/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.cognos.java.proyecto.view.jsf;

import bo.com.cognos.java.proyecto.model.FormDetalle;
import bo.com.cognos.java.proyecto.model.Formulario;
import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.services.FormularioService;
import bo.com.cognos.java.proyecto.services.XXXService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Getter
@Setter
/**
 *
 * @author KAREN
 */
public class FormularioBean {

    @ManagedProperty("#{formularioServiceImpl}")
    FormularioService formularioService;

    private List<FormDetalle> itemsDetalle = new ArrayList();
    private Formulario formulario = new Formulario();


    public void adicionar() {
        itemsDetalle.add(new FormDetalle());

    }
    public void guardar() throws ProyectoException{
        //this.formularioService.guardar(formulario);
        System.out.println(formulario.toString());
        
    }
}
