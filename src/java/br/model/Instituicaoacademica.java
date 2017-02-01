/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elias
 */
@Entity
@Table(name = "instituicaoacademica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instituicaoacademica.findAll", query = "SELECT i FROM Instituicaoacademica i"),
    @NamedQuery(name = "Instituicaoacademica.findByIdInst", query = "SELECT i FROM Instituicaoacademica i WHERE i.idInst = :idInst"),
    @NamedQuery(name = "Instituicaoacademica.findByNome", query = "SELECT i FROM Instituicaoacademica i WHERE i.nome = :nome")})
public class Instituicaoacademica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inst")
    private Integer idInst;
    @Size(max = 25)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "id_contato", referencedColumnName = "id_contato")
    @OneToOne (cascade = CascadeType.ALL)
    private Contato idContato;

    public Instituicaoacademica() {
    }

    public Instituicaoacademica(Integer idInst) {
        this.idInst = idInst;
    }

    public Integer getIdInst() {
        return idInst;
    }

    public void setIdInst(Integer idInst) {
        this.idInst = idInst;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato getIdContato() {
        return idContato;
    }

    public void setIdContato(Contato idContato) {
        this.idContato = idContato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInst != null ? idInst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituicaoacademica)) {
            return false;
        }
        Instituicaoacademica other = (Instituicaoacademica) object;
        if ((this.idInst == null && other.idInst != null) || (this.idInst != null && !this.idInst.equals(other.idInst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
