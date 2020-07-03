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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hoanghung
 */
@Entity
@Table(name = "OrderDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o")
    , @NamedQuery(name = "OrderDetail.findByIdOrderDetail", query = "SELECT o FROM OrderDetail o WHERE o.idOrderDetail = :idOrderDetail")
    , @NamedQuery(name = "OrderDetail.findBySoLuong", query = "SELECT o FROM OrderDetail o WHERE o.soLuong = :soLuong")
    , @NamedQuery(name = "OrderDetail.findByGia", query = "SELECT o FROM OrderDetail o WHERE o.gia = :gia")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdOrderDetail")
    private Integer idOrderDetail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLuong")
    private int soLuong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gia")
    private double gia;
    @JoinColumn(name = "IdOrder", referencedColumnName = "IdOrder")
    @ManyToOne
    private Orders idOrder;
    @JoinColumn(name = "IdProduct", referencedColumnName = "IdProduct")
    @ManyToOne
    private Product idProduct;

    public OrderDetail() {
    }

    public OrderDetail(Integer idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public OrderDetail(Integer idOrderDetail, int soLuong, double gia) {
        this.idOrderDetail = idOrderDetail;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public Integer getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(Integer idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Orders getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Orders idOrder) {
        this.idOrder = idOrder;
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
        hash += (idOrderDetail != null ? idOrderDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.idOrderDetail == null && other.idOrderDetail != null) || (this.idOrderDetail != null && !this.idOrderDetail.equals(other.idOrderDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderDetail[ idOrderDetail=" + idOrderDetail + " ]";
    }
    
}
