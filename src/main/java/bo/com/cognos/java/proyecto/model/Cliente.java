package bo.com.cognos.java.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CLI_CLIENTE")
@Getter
@Setter
@NamedQueries(
		{
@NamedQuery(name="Cliente.buscar", query="select c from Cliente c where "
		+ "(c.nit like :filtro or c.razonSocial like :filtro or c.telefono like :filtro"
		+ " or c.email like :filtro) and c.fechaBaja is null"),
@NamedQuery(name="Cliente.buscarPorRangoFecha", query="select c from Cliente c where "
		+ "(c.nit like :filtro or c.razonSocial like :filtro or c.telefono like :filtro"
		+ " or c.email like :filtro) and c.fechaAlta between :fechaInicial and :fechaFinal and c.fechaBaja is null"),			
		}
)
public class Cliente extends XXXModel<Short> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Short id;
	
	@Column(name="NIT", unique=true, length=15, nullable=false)
	private String nit;
	
	@Column(name="RAZON_SOCIAL", length=50, nullable=false)
	private String razonSocial;
	
	@Column(name="TELEFONO", length=50)
	private String telefono;
	
	@Column(name="EMAIL", length=50)
	private String email;
	
	@Column(name="OTROS", columnDefinition="TEXT")
	private String otros;

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nit=" + nit + ", razonSocial=" + razonSocial + ", telefono=" + telefono
				+ ", email=" + email + ", otros=" + otros + "]";
	}
	
	
	
	
	
}
