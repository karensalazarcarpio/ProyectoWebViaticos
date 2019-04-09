package bo.com.cognos.java.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import bo.com.cognos.java.proyecto.repositories.UsuarioRepository;
import bo.com.cognos.java.proyecto.services.UsuarioService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="USR_USUARIO")
@Getter
@Setter
@XmlRootElement
@NamedQueries({@NamedQuery(name="Usuario.buscarPorLogin", 
query="select u from Usuario u where u.login = :login and u.fechaBaja is null")
,@NamedQuery(name="Usuario.buscar", 
query = "select u from Usuario u where u.login like :filtro and u.fechaBaja is null")
,@NamedQuery(name="Usuario.buscarPorRangoFecha", 
query = "select u from Usuario u where u.login like :filtro "
		+ " and u.fechaAlta between :fechaInicial and :fechaFinal and u.fechaBaja is null")
})
public class Usuario extends XXXModel<Integer> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="LOGIN", length=25, unique=true, 
			nullable=false, updatable=false)
	private String login;
	
	@Column(name="PASSWORD", length=40, nullable=false)
	private String password;
	
	@Column(name="HABILITADO", nullable=false)
	private boolean habilitado;

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", password=" + password + ", habilitado=" + habilitado + "]";
	}
	
//	public void test() {
//		UsuarioRepository ur;
//		// ur.findByLogin("dviorel");
//		
//	}
	
//	UsuarioService us;
//	ParametroService ps;
//	VentaService vs;
//	
//	public void hacerAlgo() {
//		
//		vs.metodoUno();		
//	}
//	
//	public void hacerOtroAlgo() {
//		us.metodoCero();
//		vs.metodoUno();		
//	}
	
		
	
}
