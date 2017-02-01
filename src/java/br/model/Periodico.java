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
@Table(name = "periodico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodico.findAll", query = "SELECT p FROM Periodico p"),
    @NamedQuery(name = "Periodico.findByIdPeriodico", query = "SELECT p FROM Periodico p WHERE p.idPeriodico = :idPeriodico"),
    @NamedQuery(name = "Periodico.findByFolhas", query = "SELECT p FROM Periodico p WHERE p.folhas = :folhas"),
    @NamedQuery(name = "Periodico.findByPeriodicidade", query = "SELECT p FROM Periodico p WHERE p.periodicidade = :periodicidade"),
    @NamedQuery(name = "Periodico.findByDataPublicacao", query = "SELECT p FROM Periodico p WHERE p.dataPublicacao = :dataPublicacao"),
    @NamedQuery(name = "Periodico.findByEdicao", query = "SELECT p FROM Periodico p WHERE p.edicao = :edicao")})
public class Periodico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_periodico")
    private Integer idPeriodico;
    @Column(name = "folhas")
    private Integer folhas;
    @Size(max = 2147483647)
    @Column(name = "periodicidade")
    private String periodicidade;
    @Size(max = 2147483647)
    @Column(name = "data_publicacao")
    private String dataPublicacao;
    @Column(name = "edicao")
    private Integer edicao;
    @JoinColumn(name = "id_editora", referencedColumnName = "id_editora")
    @ManyToOne
    private Editora idEditora;
    @JoinColumn(name = "id_acervo", referencedColumnName = "id_acervo")
    @ManyToOne
    private Acervo idAcervo;

    public Periodico() {
    }

    public Periodico(Integer idPeriodico) {
        this.idPeriodico = idPeriodico;
    }

    public Integer getIdPeriodico() {
        return idPeriodico;
    }

    public void setIdPeriodico(Integer idPeriodico) {
        this.idPeriodico = idPeriodico;
    }

    public Integer getFolhas() {
        return folhas;
    }

    public void setFolhas(Integer folhas) {
        this.folhas = folhas;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public Editora getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Editora idEditora) {
        this.idEditora = idEditora;
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
        hash += (idPeriodico != null ? idPeriodico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodico)) {
            return false;
        }
        Periodico other = (Periodico) object;
        if ((this.idPeriodico == null && other.idPeriodico != null) || (this.idPeriodico != null && !this.idPeriodico.equals(other.idPeriodico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.model.Periodico[ idPeriodico=" + idPeriodico + " ]";
    }
    
}
