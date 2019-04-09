package bo.com.cognos.java.proyecto.soap;

import bo.com.cognos.java.proyecto.model.Formulario;
import bo.com.cognos.java.proyecto.model.Funcionario;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.Token;
import bo.com.cognos.java.proyecto.model.Usuario;
import bo.com.cognos.java.proyecto.services.FormDetalleService;
import bo.com.cognos.java.proyecto.services.FormularioService;
import bo.com.cognos.java.proyecto.services.TokenService;
import bo.com.cognos.java.proyecto.services.UsuarioService;

@WebService
@HandlerChain(file = "handlers.xml")
public class ProyectoService {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    TokenService tokenService;
    @Autowired
    FormularioService formularioService;
    @Autowired
    FormDetalleService formularioDetalleService;
    @Resource
    WebServiceContext wsContext;

    @WebMethod(operationName = "CrearUsuario")
    public Usuario crearUsuario(@WebParam(name = "usuario") @XmlElement(required = true) Usuario usuario)
            throws ProyectoException {
        return usuarioService.guardar(usuario);
    }

    @WebResult(name = "ListarUsuarios")
    public List<Usuario> listarUsuarios(@WebParam(name = "filtro") @XmlElement(required = true) String filtro)
            throws ProyectoException {
        return usuarioService.buscar(filtro);
    }

    @WebResult(name = "BorrarUsuario")
    public String borrarUsuario(@WebParam(name = "idUsuario") @XmlElement(required = true) Integer idUsuario) throws ProyectoException {
        usuarioService.borrar(idUsuario);
        return "OK";
    }

    @WebResult(name = "ActualizarUsuario")
    public Usuario actualizarUsuario(@WebParam(name = "usuario") @XmlElement(required = true) Usuario usuario) throws ProyectoException {
        return usuarioService.guardar(usuario);
    }

    @WebMethod(operationName = "CrearFormulario")
    public Formulario crearFormulario(@WebParam(name = "formulario") @XmlElement(required = true) Formulario obj) throws ProyectoException {

        obj.setFuncionario(new Funcionario((short) 1));
        obj.setIdUsuarioRegistro(0);

        return formularioService.guardar(obj);

    }

    @WebResult(name = "ListarFormularios")
    public List<Formulario> listarFormularios(
            @WebParam(name = "filtro") @XmlElement(required = true) String filtro) throws ProyectoException {

        return formularioService.buscar(filtro);
    }

    @WebResult(name = "BorrarForm")
    public String borrarForm(
            @WebParam(name = "id") @XmlElement(required = true) Short id)
            throws ProyectoException {
        formularioService.borrar(id);
        return "OK";
    }

    @WebResult(name = "ActualizarForm")
    public Formulario actualizarForm(
            @WebParam(name = "form") @XmlElement(required = true) Formulario obj)
            throws ProyectoException {
        Formulario f = formularioService.obtener(obj.getId());
        f.setJustificacion(obj.getJustificacion());
        f.setMotivoViaje(obj.getMotivoViaje());
        f.setFuncionario(new Funcionario((short) 1));
        return formularioService.guardar(f);

    }

    @WebResult(name = "Login")
    public String login(
            @WebParam(name = "login") @XmlElement(required = true) String login,
            @WebParam(name = "password") @XmlElement(required = true) String password) throws ProyectoException {
        Usuario usuario = usuarioService.login(login, password);
        Token token = tokenService.generarToken(usuario);
        return token.getToken();
    }

    @PostConstruct
    @WebMethod(exclude = true)
    public void init() {
        WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext) wsContext.getMessageContext().
                get(MessageContext.SERVLET_CONTEXT)).getAutowireCapableBeanFactory().
                autowireBean(this);
    }

}
