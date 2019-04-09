package bo.com.cognos.java.proyecto.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="WS_TOKEN")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name="Token.buscar", 
query = "select u from Token u")
,@NamedQuery(name="Token.buscarPorRangoFecha", 
query = "select u from Token u ")
})

public class Token extends XXXModel<Long>{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String token;
	@Temporal(TemporalType.TIMESTAMP)
	Date fechaAsignacion;
	@Temporal(TemporalType.TIMESTAMP)
	Date fechaUltimoUso;
	@Temporal(TemporalType.TIMESTAMP)
	Date fechaExpiracion;
	@JoinColumn()
	@ManyToOne(fetch=FetchType.EAGER)
	Usuario usuario;
	
	
	
}
