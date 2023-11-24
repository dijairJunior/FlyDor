/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author drcj1
 */
@Entity
@Table(name = "login_users")
@NamedQueries({
    @NamedQuery(name = "LoginUsers.findAll", query = "SELECT l FROM LoginUsers l"),
    @NamedQuery(name = "LoginUsers.findById", query = "SELECT l FROM LoginUsers l WHERE l.id = :id"),
    @NamedQuery(name = "LoginUsers.findByNome", query = "SELECT l FROM LoginUsers l WHERE l.nome = :nome"),
    @NamedQuery(name = "LoginUsers.findBySenha", query = "SELECT l FROM LoginUsers l WHERE l.senha = :senha")})
public class LoginUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;

    public LoginUsers() {
    }

    public LoginUsers(String id) {
        this.id = id;
    }

    public LoginUsers(String id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginUsers)) {
            return false;
        }
        LoginUsers other = (LoginUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.LoginUsers[ id=" + id + " ]";
    }
    
}
