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
@Table(name = "contato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c"),
    @NamedQuery(name = "Contato.findByIdContato", query = "SELECT c FROM Contato c WHERE c.idContato = :idContato"),
    @NamedQuery(name = "Contato.findByEmail", query = "SELECT c FROM Contato c WHERE c.email = :email"),
    @NamedQuery(name = "Contato.findByNome", query = "SELECT c FROM Contato c WHERE c.nome = :nome"),
    @NamedQuery(name = "Contato.findBySite", query = "SELECT c FROM Contato c WHERE c.site = :site")})
public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contato")
    private Integer idContato;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Size(max = 2147483647)
    @Column(name = "site")
    private String site;
    @OneToMany(mappedBy = "idContato")
    private Collection<Pessoa> pessoaCollection;
    @OneToOne(mappedBy = "idContato")
    private Collection<Instituicaoacademica> instituicaoacademicaCollection;
    @OneToOne(mappedBy = "idContato")
    private Collection<Produtora> produtoraCollection;
    @OneToMany(mappedBy = "idContato")
    private Collection<Telefone> telefoneCollection;
    @OneToOne(mappedBy = "idContato")
    private Collection<Editora> editoraCollection;

    public Contato() {
    }

    public Contato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @XmlTransient
    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    @XmlTransient
    public Collection<Instituicaoacademica> getInstituicaoacademicaCollection() {
        return instituicaoacademicaCollection;
    }

    public void setInstituicaoacademicaCollection(Collection<Instituicaoacademica> instituicaoacademicaCollection) {
        this.instituicaoacademicaCollection = instituicaoacademicaCollection;
    }

    @XmlTransient
    public Collection<Produtora> getProdutoraCollection() {
        return produtoraCollection;
    }

    public void setProdutoraCollection(Collection<Produtora> produtoraCollection) {
        this.produtoraCollection = produtoraCollection;
    }

    @XmlTransient
    public Collection<Telefone> getTelefoneCollection() {
        return telefoneCollection;
    }

    public void setTelefoneCollection(Collection<Telefone> telefoneCollection) {
        this.telefoneCollection = telefoneCollection;
    }

    @XmlTransient
    public Collection<Editora> getEditoraCollection() {
        return editoraCollection;
    }

    public void setEditoraCollection(Collection<Editora> editoraCollection) {
        this.editoraCollection = editoraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContato != null ? idContato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.idContato == null && other.idContato != null) || (this.idContato != null && !this.idContato.equals(other.idContato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
