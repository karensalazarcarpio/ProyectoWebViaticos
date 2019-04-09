/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.cognos.java.proyecto.resources;

/**
 *
 * @author KAREN
 */
import bo.com.cognos.java.proyecto.model.Formulario;
import bo.com.cognos.java.proyecto.model.Funcionario;
import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.services.FormularioService;
import java.util.Date;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

@Path("formulario")
public class FormularioResource {

    @Autowired
    FormularioService formularioService;

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Formulario guardar(Formulario obj) throws ProyectoException {
        obj.setFuncionario(new Funcionario((short) 1));
        obj.setIdUsuarioRegistro(0);
        return formularioService.guardar(obj);

    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Formulario modificar(Formulario obj) throws ProyectoException {
        Formulario f = formularioService.obtener(obj.getId());
        f.setJustificacion(obj.getJustificacion());
        f.setMotivoViaje(obj.getMotivoViaje());
        f.setFuncionario(new Funcionario((short) 1));
        return formularioService.guardar(f);
    }

    @DELETE
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public String borrar(@PathParam("id") Short id) throws ProyectoException {
        System.out.println("Llego el id:" + id);
        formularioService.borrar(id);
        return "OK";
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Formulario> buscar(@QueryParam("filtro") String filtro) throws ProyectoException {
        return formularioService.buscar(filtro);

    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("buscarParametos")
    public List<Formulario> buscarParametros(@QueryParam("filtro") String filtro, @QueryParam("fechaInicial") Date fechaInicial, @QueryParam("fechaFinal") Date fechaFinal) throws ProyectoException {
        return formularioService.buscar(filtro, fechaInicial, fechaFinal);
    }

}
