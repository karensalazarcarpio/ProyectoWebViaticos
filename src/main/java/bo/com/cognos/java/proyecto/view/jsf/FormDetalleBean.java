/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.cognos.java.proyecto.view.jsf;
import bo.com.cognos.java.proyecto.model.FormDetalle;
import bo.com.cognos.java.proyecto.services.FormDetalleService;
import bo.com.cognos.java.proyecto.services.XXXService;
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
public class FormDetalleBean extends XXXBean<FormDetalle, Short>{
    @ManagedProperty("#{formDetalleServiceImpl}")
    FormDetalleService formDetalleService;

    
    public FormDetalleBean() {
        super(FormDetalle.class);
    }

    @Override
    XXXService<FormDetalle, Short> getService() {
        return formDetalleService;
    }
    
    public void adicionar(){
        items.add(new FormDetalle());
    
    }

}
