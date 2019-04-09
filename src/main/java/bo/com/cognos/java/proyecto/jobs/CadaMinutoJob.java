package bo.com.cognos.java.proyecto.jobs;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.Usuario;
import bo.com.cognos.java.proyecto.services.UsuarioService;

public class CadaMinutoJob implements Job {

	@Autowired
	UsuarioService usuarioService;
	
	Logger log = Logger.getLogger(CadaMinutoJob.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("Se ejecuta el job de cada minuto");
		try {
			List<Usuario> usuarios = usuarioService.buscar("");
			log.info("Usuarios obtenidos: " + usuarios.size());
		} catch (ProyectoException e) {
			log.error("Error al consultar usuarios", e);
		}
		
	}
	
}
