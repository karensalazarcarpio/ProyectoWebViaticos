/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.cognos.java.proyecto.model;

import java.util.Date;
import javax.persistence.Column;
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
@Table(name="FORMULARIO_DETALLE")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name="FormDetalle.buscar", 
query = "select u from FormDetalle u")
,@NamedQuery(name="FormDetalle.buscarPorRangoFecha", 
query = "select u from FormDetalle u ")
})
/**
 *
 * @author KAREN
 */
public class FormDetalle extends XXXModel<Short>{
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IDFORMDETALLE")
    private Short id;
    
    
    @Column(name="FECHA_PARTIDA",length=25, nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPartida;
  
    @Column(name="FECHA_RETORNO",length=25, nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRetorno;
    
    @Column(name="ID_ORIGEN", length=25, nullable=false)
    private Integer idOrigen;
    @Column(name="ID_DESTINO",length=25, nullable=false)
    private Integer idDestino;
    
    @JoinColumn(name = "IDFORMULARIO", referencedColumnName = "IDFORMULARIO" , nullable = false )
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Formulario idformulario;
    
}
