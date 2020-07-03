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
import javax.persistence.Lob;
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
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByTaiKhoan", query = "SELECT u FROM Users u WHERE u.taiKhoan = :taiKhoan")
    , @NamedQuery(name = "Users.findByHoVaTen", query = "SELECT u FROM Users u WHERE u.hoVaTen = :hoVaTen")
    , @NamedQuery(name = "Users.findByDiaChi", query = "SELECT u FROM Users u WHERE u.diaChi = :diaChi")
    , @NamedQuery(name = "Users.findBySoDienThoai", query = "SELECT u FROM Users u WHERE u.soDienThoai = :soDienThoai")
    , @NamedQuery(name = "Users.findByAvatar", query = "SELECT u FROM Users u WHERE u.avatar = :avatar")
    , @NamedQuery(name = "Users.findByStatus", query = "SELECT u FROM Users u WHERE u.status = :status")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TaiKhoan")
    private String taiKhoan;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "MatKhau")
    private String matKhau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "HoVaTen")
    private String hoVaTen;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Gmail")
    private String gmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "DiaChi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Size(max = 1073741823)
    @Column(name = "Avatar")
    private String avatar;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "taiKhoan")
    private Collection<Orders> ordersCollection;

    public Users() {
    }

    public Users(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public Users(String taiKhoan, String matKhau, String hoVaTen, String gmail, String diaChi, String soDienThoai) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.hoVaTen = hoVaTen;
        this.gmail = gmail;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taiKhoan != null ? taiKhoan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.taiKhoan == null && other.taiKhoan != null) || (this.taiKhoan != null && !this.taiKhoan.equals(other.taiKhoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Users[ taiKhoan=" + taiKhoan + " ]";
    }
    
}
