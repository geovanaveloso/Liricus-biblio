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
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByIdPessoa", query = "SELECT p FROM Pessoa p WHERE p.idPessoa = :idPessoa"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findBySexo", query = "SELECT p FROM Pessoa p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Pessoa.findByRua", query = "SELECT p FROM Pessoa p WHERE p.rua = :rua"),
    @NamedQuery(name = "Pessoa.findByNumero", query = "SELECT p FROM Pessoa p WHERE p.numero = :numero"),
    @NamedQuery(name = "Pessoa.findByBairro", query = "SELECT p FROM Pessoa p WHERE p.bairro = :bairro"),
    @NamedQuery(name = "Pessoa.findByCep", query = "SELECT p FROM Pessoa p WHERE p.cep = :cep"),
    @NamedQuery(name = "Pessoa.findByComplemento", query = "SELECT p FROM Pessoa p WHERE p.complemento = :complemento"),
    @NamedQuery(name = "Pessoa.findByCelular", query = "SELECT p FROM Pessoa p WHERE p.celular = :celular"),
    @NamedQuery(name = "Pessoa.findByHierarquia", query = "SELECT p FROM Pessoa p WHERE p.hierarquia = :hierarquia"),
    @NamedQuery(name = "Pessoa.findByPastoral", query = "SELECT p FROM Pessoa p WHERE p.pastoral = :pastoral"),
    @NamedQuery(name = "Pessoa.findBySenha", query = "SELECT p FROM Pessoa p WHERE p.senha = :senha"),
    @NamedQuery(name = "Pessoa.findByLogon", query = "SELECT p FROM Pessoa p WHERE p.logon = :logon"),
    @NamedQuery(name = "Pessoa.findByDatanascimento", query = "SELECT p FROM Pessoa p WHERE p.datanascimento = :datanascimento")})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pessoa")
    private Integer idPessoa;
    @Size(max = 30)
    @Column(name = "nome")
    private String nome;
    @Size(max = 10)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 50)
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 30)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 2147483647)
    @Column(name = "cep")
    private String cep;
    @Size(max = 2147483647)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 15)
    @Column(name = "celular")
    private String celular;
    @Column(name = "hierarquia")
    private Integer hierarquia;
    @Size(max = 2147483647)
    @Column(name = "pastoral")
    private String pastoral;
    @Column(name = "senha")
    private Integer senha;
    @Size(max = 2147483647)
    @Column(name = "logon")
    private String logon;
    @Size(max = 10)
    @Column(name = "datanascimento")
    private String datanascimento;
    @JoinColumn(name = "id_contato", referencedColumnName = "id_contato")
    @ManyToOne
    private Contato idContato;
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade")
    @ManyToOne
    private Cidade idCidade;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getHierarquia() {
        return hierarquia;
    }

    public void setHierarquia(Integer hierarquia) {
        this.hierarquia = hierarquia;
    }

    public String getPastoral() {
        return pastoral;
    }

    public void setPastoral(String pastoral) {
        this.pastoral = pastoral;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public String getLogon() {
        return logon;
    }

    public void setLogon(String logon) {
        this.logon = logon;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Contato getIdContato() {
        return idContato;
    }

    public void setIdContato(Contato idContato) {
        this.idContato = idContato;
    }

    public Cidade getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Cidade idCidade) {
        this.idCidade = idCidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoa != null ? idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.idPessoa == null && other.idPessoa != null) || (this.idPessoa != null && !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
