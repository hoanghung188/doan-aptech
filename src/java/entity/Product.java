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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByIdProduct", query = "SELECT p FROM Product p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "Product.findByGia", query = "SELECT p FROM Product p WHERE p.gia = :gia")
    , @NamedQuery(name = "Product.findByTrangThai", query = "SELECT p FROM Product p WHERE p.trangThai = :trangThai")
    , @NamedQuery(name = "Product.findByTenSanPham", query = "SELECT p FROM Product p WHERE p.tenSanPham = :tenSanPham")
    , @NamedQuery(name = "Product.findByThongTin", query = "SELECT p FROM Product p WHERE p.thongTin = :thongTin")
    , @NamedQuery(name = "Product.findBySoLuongMua", query = "SELECT p FROM Product p WHERE p.soLuongMua = :soLuongMua")
    , @NamedQuery(name = "Product.findByAnhDaiDien", query = "SELECT p FROM Product p WHERE p.anhDaiDien = :anhDaiDien")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduct")
    private Integer idProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia")
    private double gia;
    @Column(name = "trangThai")
    private Boolean trangThai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "tenSanPham")
    private String tenSanPham;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "thongTin")
    private String thongTin;
    @Column(name = "soLuongMua")
    private Integer soLuongMua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "anhDaiDien")
    private String anhDaiDien;
    @OneToMany(mappedBy = "idProduct")
    private Collection<OrderDetail> orderDetailCollection;
    @OneToMany(mappedBy = "idProduct")
    private Collection<ProductImage> productImageCollection;
    @JoinColumn(name = "idCatagory", referencedColumnName = "idCatagory")
    @ManyToOne
    private Category idCatagory;
    @JoinColumn(name = "idProducer", referencedColumnName = "idProducer")
    @ManyToOne
    private Producer idProducer;

    public Product() {
    }

    public Product(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Product(Integer idProduct, double gia, String tenSanPham, String thongTin, String anhDaiDien) {
        this.idProduct = idProduct;
        this.gia = gia;
        this.tenSanPham = tenSanPham;
        this.thongTin = thongTin;
        this.anhDaiDien = anhDaiDien;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    public Integer getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(Integer soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    @XmlTransient
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    @XmlTransient
    public Collection<ProductImage> getProductImageCollection() {
        return productImageCollection;
    }

    public void setProductImageCollection(Collection<ProductImage> productImageCollection) {
        this.productImageCollection = productImageCollection;
    }

    public Category getIdCatagory() {
        return idCatagory;
    }

    public void setIdCatagory(Category idCatagory) {
        this.idCatagory = idCatagory;
    }

    public Producer getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(Producer idProducer) {
        this.idProducer = idProducer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ idProduct=" + idProduct + " ]";
    }
    
}
