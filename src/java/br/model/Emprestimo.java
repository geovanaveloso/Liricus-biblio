/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.CascadeType;

/**
 *
 * @author elias
 */
@Entity
@Table(name = "emprestimo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprestimo.findAll", query = "SELECT e FROM Emprestimo e"),
    @NamedQuery(name = "Emprestimo.findByIdEmprestimo", query = "SELECT e FROM Emprestimo e WHERE e.idEmprestimo = :idEmprestimo"),
    @NamedQuery(name = "Emprestimo.findByRenovacao", query = "SELECT e FROM Emprestimo e WHERE e.renovacao = :renovacao"),
    @NamedQuery(name = "Emprestimo.findByDataEmprestimo", query = "SELECT e FROM Emprestimo e WHERE e.dataEmprestimo = :dataEmprestimo"),
    @NamedQuery(name = "Emprestimo.findByDataDevolucao", query = "SELECT e FROM Emprestimo e WHERE e.dataDevolucao = :dataDevolucao"),
    @NamedQuery(name = "Emprestimo.findByDevolucaoPrevista", query = "SELECT e FROM Emprestimo e WHERE e.devolucaoPrevista = :devolucaoPrevista")})
public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_emprestimo")
    private Integer idEmprestimo;
    @Column(name = "renovacao")
    private Integer renovacao;
    @Column(name = "data_emprestimo")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmprestimo;
    @Column(name = "data_devolucao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDevolucao;
    @Column(name = "devolucao_prevista")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date devolucaoPrevista;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    @ManyToOne
    private Pessoa idPessoa;
    @JoinColumn(name = "id_acervo", referencedColumnName = "id_acervo")
    @OneToOne (cascade = CascadeType.ALL)
    Acervo idAcervo;

    public Emprestimo() {;
    }

    public Emprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Integer getRenovacao() {
        return renovacao;
    }

    public void setRenovacao(Integer renovacao) {
        this.renovacao = renovacao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDevolucaoPrevista() {
        return devolucaoPrevista;
    }

    public void setDevolucaoPrevista(Date devolucaoPrevista) {
        this.devolucaoPrevista = devolucaoPrevista;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
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
        hash += (idEmprestimo != null ? idEmprestimo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo) object;
        if ((this.idEmprestimo == null && other.idEmprestimo != null) || (this.idEmprestimo != null && !this.idEmprestimo.equals(other.idEmprestimo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.model.Emprestimo[ idEmprestimo=" + idEmprestimo + " ]";
    }
    
}
