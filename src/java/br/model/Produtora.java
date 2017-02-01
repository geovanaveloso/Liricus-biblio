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
@Table(name = "produtora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtora.findAll", query = "SELECT p FROM Produtora p"),
    @NamedQuery(name = "Produtora.findByIdProdutora", query = "SELECT p FROM Produtora p WHERE p.idProdutora = :idProdutora"),
    @NamedQuery(name = "Produtora.findByNome", query = "SELECT p FROM Produtora p WHERE p.nome = :nome")})
public class Produtora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produtora")
    private Integer idProdutora;
    @Size(max = 25)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "id_contato", referencedColumnName = "id_contato")
    @OneToOne (cascade = CascadeType.ALL)
    Contato idContato;

    public Produtora() {
    }

    public Produtora(Integer idProdutora) {
        this.idProdutora = idProdutora;
    }

    public Integer getIdProdutora() {
        return idProdutora;
    }

    public void setIdProdutora(Integer idProdutora) {
        this.idProdutora = idProdutora;
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
        hash += (idProdutora != null ? idProdutora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtora)) {
            return false;
        }
        Produtora other = (Produtora) object;
        if ((this.idProdutora == null && other.idProdutora != null) || (this.idProdutora != null && !this.idProdutora.equals(other.idProdutora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
