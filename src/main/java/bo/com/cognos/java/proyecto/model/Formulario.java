    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.cognos.java.proyecto.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FORMULARIO")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Formulario.buscar",
            query = "select u from  Formulario u")
    ,@NamedQuery(name = "Formulario.buscarPorRangoFecha",
            query = "select u from Formulario u ")
})
/**
 *
 * @author KAREN
 */
public class Formulario extends XXXModel<Short> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDFORMULARIO")
    private Short id;

    @Column(name = "MOTIVO_VIAJE", length = 255)
    private String motivoViaje;

    @Column(name = "JUSTIFICACION", length = 255)
    private String justificacion;

    @Column(name = "ESTADO", length = 25, nullable = false)
    private String estado;

    @Column(name = "GESTION", nullable = false)
    private Integer gestion;
    @JoinColumn(name="IDFUNCIONARIO", referencedColumnName = "IDFUNCIONARIO", updatable = false)
    @ManyToOne( fetch = FetchType.LAZY)
    private Funcionario funcionario;
    
    @Override
    public String toString() {
        return "Formulario{" + "id=" + id + ", motivoViaje=" + motivoViaje + ", justificacion=" + justificacion + ", estado=" + estado + ", gestion=" + gestion + ", funcionario=" + funcionario + '}';
    }

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "idformulario", fetch = FetchType.LAZY)
    private List<FormDetalle> formDetalleList;

    

    public Formulario(Short id, String motivoViaje, String justificacion, String estado, Integer gestion, List<FormDetalle> formDetalleList, Funcionario funcionario) {
        this.id = id;
        this.motivoViaje = motivoViaje;
        this.justificacion = justificacion;
        this.estado = estado;
        this.gestion = gestion;
        this.formDetalleList = formDetalleList;
        this.funcionario = funcionario;
    }
    
    public Formulario(){
        
    }

    @XmlTransient
    public List<FormDetalle> getFormDetalleList() {
        return formDetalleList;
    }

    public void setFormDetalleList(List<FormDetalle> formDetalleList) {
        this.formDetalleList = formDetalleList;
    }
    @XmlTransient
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    
    
}
