package bo.com.cognos.java.proyecto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class XXXModel<ID extends Number>{

	public abstract ID getId();
	public abstract void setId(ID id);
	
	@Column(name="FECHA_REGISTRO", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	Date fechaRegistro;
	@Column(name="IDUSUARIOREGISTRO", nullable=false)
	Integer idUsuarioRegistro;
	
        @Column(name="FECHA_ALTA", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	Date fechaAlta;
	@Column(name="FECHA_MODIFICACION", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	Date fechaModificacion;
	@Column(name="FECHA_BAJA", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	Date fechaBaja;
}
