/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hoanghung
 */
@Entity
@Table(name = "Product_Image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductImage.findAll", query = "SELECT p FROM ProductImage p")
    , @NamedQuery(name = "ProductImage.findByIdImage", query = "SELECT p FROM ProductImage p WHERE p.idImage = :idImage")
    , @NamedQuery(name = "ProductImage.findByUrl", query = "SELECT p FROM ProductImage p WHERE p.url = :url")})
public class ProductImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idImage")
    private Integer idImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "idProduct", referencedColumnName = "idProduct")
    @ManyToOne
    private Product idProduct;

    public ProductImage() {
    }

    public ProductImage(Integer idImage) {
        this.idImage = idImage;
    }

    public ProductImage(Integer idImage, String url) {
        this.idImage = idImage;
        this.url = url;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImage != null ? idImage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductImage)) {
            return false;
        }
        ProductImage other = (ProductImage) object;
        if ((this.idImage == null && other.idImage != null) || (this.idImage != null && !this.idImage.equals(other.idImage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProductImage[ idImage=" + idImage + " ]";
    }
    
}
