/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elias
 */
@Entity
@Table(name = "acervo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acervo.findAll", query = "SELECT a FROM Acervo a"),
    @NamedQuery(name = "Acervo.findByIdAcervo", query = "SELECT a FROM Acervo a WHERE a.idAcervo = :idAcervo"),
    @NamedQuery(name = "Acervo.findByGenero", query = "SELECT a FROM Acervo a WHERE a.genero = :genero"),
    @NamedQuery(name = "Acervo.findBySituacao", query = "SELECT a FROM Acervo a WHERE a.situacao = :situacao"),
    @NamedQuery(name = "Acervo.findByTitulo", query = "SELECT a FROM Acervo a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Acervo.findByResumo", query = "SELECT a FROM Acervo a WHERE a.resumo = :resumo"),
    @NamedQuery(name = "Acervo.findByTipo", query = "SELECT a FROM Acervo a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "Acervo.findByAno", query = "SELECT a FROM Acervo a WHERE a.ano = :ano")})
public class Acervo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acervo")
    private Integer idAcervo;
    @Size(max = 2147483647)
    @Column(name = "genero")
    private String genero;
    @Size(max = 2147483647)
    @Column(name = "situacao")
    private String situacao;
    @Size(max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 2147483647)
    @Column(name = "resumo")
    private String resumo;
    @Size(max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "ano")
    private Integer ano;
    @OneToMany(mappedBy = "idAcervo")
    private Collection<Trabalhoacademico> trabalhoacademicoCollection;
    @OneToMany(mappedBy = "idAcervo")
    private Collection<Periodico> periodicoCollection;
    @OneToMany(mappedBy = "idAcervo")
    private Collection<Midia> midiaCollection;
    @OneToMany(mappedBy = "idAcervo")
    private Collection<Livro> livroCollection;
    @OneToOne(mappedBy = "idAcervo")
    private Collection<Emprestimo> emprestimoCollection;
    @OneToMany(mappedBy = "idAcervo")
    private Collection<Reserva> reservaCollection;

    public Acervo() {
    }

    public Acervo(Integer idAcervo) {
        this.idAcervo = idAcervo;
    }

    public Integer getIdAcervo() {
        return idAcervo;
    }

    public void setIdAcervo(Integer idAcervo) {
        this.idAcervo = idAcervo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @XmlTransient
    public Collection<Trabalhoacademico> getTrabalhoacademicoCollection() {
        return trabalhoacademicoCollection;
    }

    public void setTrabalhoacademicoCollection(Collection<Trabalhoacademico> trabalhoacademicoCollection) {
        this.trabalhoacademicoCollection = trabalhoacademicoCollection;
    }

    @XmlTransient
    public Collection<Periodico> getPeriodicoCollection() {
        return periodicoCollection;
    }

    public void setPeriodicoCollection(Collection<Periodico> periodicoCollection) {
        this.periodicoCollection = periodicoCollection;
    }

    @XmlTransient
    public Collection<Midia> getMidiaCollection() {
        return midiaCollection;
    }

    public void setMidiaCollection(Collection<Midia> midiaCollection) {
        this.midiaCollection = midiaCollection;
    }

    @XmlTransient
    public Collection<Livro> getLivroCollection() {
        return livroCollection;
    }

    public void setLivroCollection(Collection<Livro> livroCollection) {
        this.livroCollection = livroCollection;
    }

    @XmlTransient
    public Collection<Emprestimo> getEmprestimoCollection() {
        return emprestimoCollection;
    }

    public void setEmprestimoCollection(Collection<Emprestimo> emprestimoCollection) {
        this.emprestimoCollection = emprestimoCollection;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcervo != null ? idAcervo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acervo)) {
            return false;
        }
        Acervo other = (Acervo) object;
        if ((this.idAcervo == null && other.idAcervo != null) || (this.idAcervo != null && !this.idAcervo.equals(other.idAcervo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (idAcervo + " - " + titulo + " - " + situacao);
    }
    
}
