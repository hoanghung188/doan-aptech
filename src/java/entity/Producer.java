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
@Table(name = "Producer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producer.findAll", query = "SELECT p FROM Producer p")
    , @NamedQuery(name = "Producer.findByIdProducer", query = "SELECT p FROM Producer p WHERE p.idProducer = :idProducer")
    , @NamedQuery(name = "Producer.findByNameProducer", query = "SELECT p FROM Producer p WHERE p.nameProducer = :nameProducer")
    , @NamedQuery(name = "Producer.findByDiaChi", query = "SELECT p FROM Producer p WHERE p.diaChi = :diaChi")
    , @NamedQuery(name = "Producer.findBySoDienThoai", query = "SELECT p FROM Producer p WHERE p.soDienThoai = :soDienThoai")})
public class Producer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdProducer")
    private Integer idProducer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "NameProducer")
    private String nameProducer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "DiaChi")
    private String diaChi;
    @Size(max = 12)
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @OneToMany(mappedBy = "idProducer")
    private Collection<Product> productCollection;

    public Producer() {
    }

    public Producer(Integer idProducer) {
        this.idProducer = idProducer;
    }

    public Producer(Integer idProducer, String nameProducer, String diaChi) {
        this.idProducer = idProducer;
        this.nameProducer = nameProducer;
        this.diaChi = diaChi;
    }

    public Integer getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(Integer idProducer) {
        this.idProducer = idProducer;
    }

    public String getNameProducer() {
        return nameProducer;
    }

    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
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
        hash += (idProducer != null ? idProducer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producer)) {
            return false;
        }
        Producer other = (Producer) object;
        if ((this.idProducer == null && other.idProducer != null) || (this.idProducer != null && !this.idProducer.equals(other.idProducer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Producer[ idProducer=" + idProducer + " ]";
    }
    
}
