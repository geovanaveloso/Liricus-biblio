/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elias
 */
@Entity
@Table(name = "midia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Midia.findAll", query = "SELECT m FROM Midia m"),
    @NamedQuery(name = "Midia.findByIdMidia", query = "SELECT m FROM Midia m WHERE m.idMidia = :idMidia"),
    @NamedQuery(name = "Midia.findByDuracao", query = "SELECT m FROM Midia m WHERE m.duracao = :duracao"),
    @NamedQuery(name = "Midia.findByAtores", query = "SELECT m FROM Midia m WHERE m.atores = :atores"),
    @NamedQuery(name = "Midia.findByDiretor", query = "SELECT m FROM Midia m WHERE m.diretor = :diretor")})
public class Midia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_midia")
    private Integer idMidia;
    @Column(name = "duracao")
    private Integer duracao;
    @Size(max = 2147483647)
    @Column(name = "atores")
    private String atores;
    @Size(max = 2147483647)
    @Column(name = "diretor")
    private String diretor;
    @JoinColumn(name = "id_prod", referencedColumnName = "id_produtora")
    @ManyToOne
    private Produtora idProd;
    @JoinColumn(name = "id_acervo", referencedColumnName = "id_acervo")
    @ManyToOne
    private Acervo idAcervo;

    public Midia() {
    }

    public Midia(Integer idMidia) {
        this.idMidia = idMidia;
    }

    public Integer getIdMidia() {
        return idMidia;
    }

    public void setIdMidia(Integer idMidia) {
        this.idMidia = idMidia;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Produtora getIdProd() {
        return idProd;
    }

    public void setIdProd(Produtora idProd) {
        this.idProd = idProd;
    }

    public Acervo getIdAcervo() {
        return idAcervo;
    }

    public void setIdAcervo(Acervo idAcervo) {
        this.idAcervo = idAcervo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMidia != null ? idMidia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Midia)) {
            return false;
        }
        Midia other = (Midia) object;
        if ((this.idMidia == null && other.idMidia != null) || (this.idMidia != null && !this.idMidia.equals(other.idMidia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.model.Midia[ idMidia=" + idMidia + " ]";
    }
    
}
