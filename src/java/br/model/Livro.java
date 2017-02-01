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
@Table(name = "livro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l"),
    @NamedQuery(name = "Livro.findByVolume", query = "SELECT l FROM Livro l WHERE l.volume = :volume"),
    @NamedQuery(name = "Livro.findByEdicao", query = "SELECT l FROM Livro l WHERE l.edicao = :edicao"),
    @NamedQuery(name = "Livro.findByPaginas", query = "SELECT l FROM Livro l WHERE l.paginas = :paginas"),
    @NamedQuery(name = "Livro.findByIdLivro", query = "SELECT l FROM Livro l WHERE l.idLivro = :idLivro")})
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "volume")
    private String volume;
    @Column(name = "edicao")
    private Integer edicao;
    @Column(name = "paginas")
    private Integer paginas;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_livro")
    private Integer idLivro;
    @JoinColumn(name = "id_editora", referencedColumnName = "id_editora")
    @ManyToOne
    private Editora idEditora;
    @JoinColumn(name = "id_autor", referencedColumnName = "id_autor")
    @ManyToOne
    private Autor idAutor;
    @JoinColumn(name = "id_acervo", referencedColumnName = "id_acervo")
    @ManyToOne
    private Acervo idAcervo;

    public Livro() {
    }

    public Livro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public Editora getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Editora idEditora) {
        this.idEditora = idEditora;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
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
        hash += (idLivro != null ? idLivro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.idLivro == null && other.idLivro != null) || (this.idLivro != null && !this.idLivro.equals(other.idLivro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.model.Livro[ idLivro=" + idLivro + " ]";
    }
    
}
