/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.cognos.java.proyecto.model;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table (name="FUNCIONARIO")
@XmlRootElement

@Getter
@Setter
@NamedQueries({
    @NamedQuery(name="Funcionario.buscar", 
query = "select u from  Funcionario u")
,@NamedQuery(name="Funcionario.buscarPorRangoFecha", 
query = "select u from Funcionario u ")
})

/**
 *
 * @author KAREN
 */
public class Funcionario extends XXXModel <Short> implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IDFUNCIONARIO")
    private Short id;
    @Column(name="NOMBRES",length=255, nullable=true)
    private String nombres;
    @Column(name="PATERNO",length=255, nullable=true)
    private String paterno;
    @Column(name="MATERNO",length=255, nullable=true)
    private String materno;
    
    @Column(name="NUMERODOCUMENTO", nullable=false)
    private Integer numeroDocumento;
    
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "funcionario", fetch = FetchType.LAZY)
    private List<Formulario> formularios;
    
    public Funcionario(Short id){
        this.id=id;
    }
    public Funcionario(){
    
    }
}
