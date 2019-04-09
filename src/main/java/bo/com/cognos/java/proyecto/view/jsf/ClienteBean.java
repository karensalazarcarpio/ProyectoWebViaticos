package bo.com.cognos.java.proyecto.view.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import bo.com.cognos.java.proyecto.model.Cliente;
import bo.com.cognos.java.proyecto.services.ClienteService;
import bo.com.cognos.java.proyecto.services.XXXService;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class ClienteBean extends XXXBean<Cliente, Short> {

	@ManagedProperty("#{clienteServiceImpl}")
	ClienteService clienteService;
	
	public ClienteBean() {
		super(Cliente.class);
	}

	@Override
	XXXService<Cliente, Short> getService() {
		return clienteService;
	}

}
