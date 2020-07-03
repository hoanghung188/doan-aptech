/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hoanghung
 */
@Entity
@Table(name = "TypeProduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeProduct.findAll", query = "SELECT t FROM TypeProduct t")
    , @NamedQuery(name = "TypeProduct.findByIdTypeProduct", query = "SELECT t FROM TypeProduct t WHERE t.idTypeProduct = :idTypeProduct")
    , @NamedQuery(name = "TypeProduct.findByNameTypeProduct", query = "SELECT t FROM TypeProduct t WHERE t.nameTypeProduct = :nameTypeProduct")})
public class TypeProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTypeProduct")
    private Integer idTypeProduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "NameTypeProduct")
    private String nameTypeProduct;
    @OneToMany(mappedBy = "idTypeProduct")
    private Collection<Category> categoryCollection;

    public TypeProduct() {
    }

    public TypeProduct(Integer idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public TypeProduct(Integer idTypeProduct, String nameTypeProduct) {
        this.idTypeProduct = idTypeProduct;
        this.nameTypeProduct = nameTypeProduct;
    }

    public Integer getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(Integer idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public String getNameTypeProduct() {
        return nameTypeProduct;
    }

    public void setNameTypeProduct(String nameTypeProduct) {
        this.nameTypeProduct = nameTypeProduct;
    }

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeProduct != null ? idTypeProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeProduct)) {
            return false;
        }
        TypeProduct other = (TypeProduct) object;
        if ((this.idTypeProduct == null && other.idTypeProduct != null) || (this.idTypeProduct != null && !this.idTypeProduct.equals(other.idTypeProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TypeProduct[ idTypeProduct=" + idTypeProduct + " ]";
    }
    
}
