/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author drcj1
 */
@Entity
@Table(name = "medicamentos")
@NamedQueries({
    @NamedQuery(name = "Medicamentos.findAll", query = "SELECT m FROM Medicamentos m"),
    @NamedQuery(name = "Medicamentos.findById", query = "SELECT m FROM Medicamentos m WHERE m.id = :id"),
    @NamedQuery(name = "Medicamentos.findByTipoProduto", query = "SELECT m FROM Medicamentos m WHERE m.tipoProduto = :tipoProduto"),
    @NamedQuery(name = "Medicamentos.findByNomeProduto", query = "SELECT m FROM Medicamentos m WHERE m.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Medicamentos.findByCategoriaRegulatoria", query = "SELECT m FROM Medicamentos m WHERE m.categoriaRegulatoria = :categoriaRegulatoria"),
    @NamedQuery(name = "Medicamentos.findByClasseTerapeutica", query = "SELECT m FROM Medicamentos m WHERE m.classeTerapeutica = :classeTerapeutica"),
    @NamedQuery(name = "Medicamentos.findByEmpresaRegistro", query = "SELECT m FROM Medicamentos m WHERE m.empresaRegistro = :empresaRegistro"),
    @NamedQuery(name = "Medicamentos.findByPrincipioAtivo", query = "SELECT m FROM Medicamentos m WHERE m.principioAtivo = :principioAtivo")})
public class Medicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "TIPO_PRODUTO")
    private String tipoProduto;
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    @Column(name = "CATEGORIA_REGULATORIA")
    private String categoriaRegulatoria;
    @Column(name = "CLASSE_TERAPEUTICA")
    private String classeTerapeutica;
    @Column(name = "EMPRESA_REGISTRO")
    private String empresaRegistro;
    @Column(name = "PRINCIPIO_ATIVO")
    private String principioAtivo;

    public Medicamentos() {
    }

    public Medicamentos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCategoriaRegulatoria() {
        return categoriaRegulatoria;
    }

    public void setCategoriaRegulatoria(String categoriaRegulatoria) {
        this.categoriaRegulatoria = categoriaRegulatoria;
    }

    public String getClasseTerapeutica() {
        return classeTerapeutica;
    }

    public void setClasseTerapeutica(String classeTerapeutica) {
        this.classeTerapeutica = classeTerapeutica;
    }

    public String getEmpresaRegistro() {
        return empresaRegistro;
    }

    public void setEmpresaRegistro(String empresaRegistro) {
        this.empresaRegistro = empresaRegistro;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
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
        if (!(object instanceof Medicamentos)) {
            return false;
        }
        Medicamentos other = (Medicamentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Medicamentos[ id=" + id + " ]";
    }
    
}
