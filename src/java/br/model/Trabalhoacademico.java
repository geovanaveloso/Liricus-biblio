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
@Table(name = "trabalhoacademico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabalhoacademico.findAll", query = "SELECT t FROM Trabalhoacademico t"),
    @NamedQuery(name = "Trabalhoacademico.findByIdTrab", query = "SELECT t FROM Trabalhoacademico t WHERE t.idTrab = :idTrab"),
    @NamedQuery(name = "Trabalhoacademico.findByOrientador", query = "SELECT t FROM Trabalhoacademico t WHERE t.orientador = :orientador"),
    @NamedQuery(name = "Trabalhoacademico.findByAluno", query = "SELECT t FROM Trabalhoacademico t WHERE t.aluno = :aluno"),
    @NamedQuery(name = "Trabalhoacademico.findByCurso", query = "SELECT t FROM Trabalhoacademico t WHERE t.curso = :curso"),
    @NamedQuery(name = "Trabalhoacademico.findByFolhas", query = "SELECT t FROM Trabalhoacademico t WHERE t.folhas = :folhas")})
public class Trabalhoacademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trab")
    private Integer idTrab;
    @Size(max = 2147483647)
    @Column(name = "orientador")
    private String orientador;
    @Size(max = 2147483647)
    @Column(name = "aluno")
    private String aluno;
    @Size(max = 2147483647)
    @Column(name = "curso")
    private String curso;
    @Column(name = "folhas")
    private Integer folhas;
    @JoinColumn(name = "id_inst", referencedColumnName = "id_inst")
    @ManyToOne
    private Instituicaoacademica idInst;
    @JoinColumn(name = "id_acervo", referencedColumnName = "id_acervo")
    @ManyToOne
    private Acervo idAcervo;

    public Trabalhoacademico() {
    }

    public Trabalhoacademico(Integer idTrab) {
        this.idTrab = idTrab;
    }

    public Integer getIdTrab() {
        return idTrab;
    }

    public void setIdTrab(Integer idTrab) {
        this.idTrab = idTrab;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getFolhas() {
        return folhas;
    }

    public void setFolhas(Integer folhas) {
        this.folhas = folhas;
    }

    public Instituicaoacademica getIdInst() {
        return idInst;
    }

    public void setIdInst(Instituicaoacademica idInst) {
        this.idInst = idInst;
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
        hash += (idTrab != null ? idTrab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabalhoacademico)) {
            return false;
        }
        Trabalhoacademico other = (Trabalhoacademico) object;
        if ((this.idTrab == null && other.idTrab != null) || (this.idTrab != null && !this.idTrab.equals(other.idTrab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.model.Trabalhoacademico[ idTrab=" + idTrab + " ]";
    }
    
}
