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
@Table(name = "Category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
    , @NamedQuery(name = "Category.findByIdCatagory", query = "SELECT c FROM Category c WHERE c.idCatagory = :idCatagory")
    , @NamedQuery(name = "Category.findByNameCatagory", query = "SELECT c FROM Category c WHERE c.nameCatagory = :nameCatagory")
    , @NamedQuery(name = "Category.findByIcon", query = "SELECT c FROM Category c WHERE c.icon = :icon")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCatagory")
    private Integer idCatagory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "nameCatagory")
    private String nameCatagory;
    @Size(max = 1073741823)
    @Column(name = "icon")
    private String icon;
    @OneToMany(mappedBy = "idCatagory")
    private Collection<Product> productCollection;

    public Category() {
    }

    public Category(Integer idCatagory) {
        this.idCatagory = idCatagory;
    }

    public Category(Integer idCatagory, String nameCatagory) {
        this.idCatagory = idCatagory;
        this.nameCatagory = nameCatagory;
    }

    public Integer getIdCatagory() {
        return idCatagory;
    }

    public void setIdCatagory(Integer idCatagory) {
        this.idCatagory = idCatagory;
    }

    public String getNameCatagory() {
        return nameCatagory;
    }

    public void setNameCatagory(String nameCatagory) {
        this.nameCatagory = nameCatagory;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatagory != null ? idCatagory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.idCatagory == null && other.idCatagory != null) || (this.idCatagory != null && !this.idCatagory.equals(other.idCatagory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Category[ idCatagory=" + idCatagory + " ]";
    }
    
}
