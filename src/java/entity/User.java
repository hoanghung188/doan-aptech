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
@Table(name = "User")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByTaiKhoan", query = "SELECT u FROM User u WHERE u.taiKhoan = :taiKhoan")
    , @NamedQuery(name = "User.findByHoVaTen", query = "SELECT u FROM User u WHERE u.hoVaTen = :hoVaTen")
    , @NamedQuery(name = "User.findByDiaChi", query = "SELECT u FROM User u WHERE u.diaChi = :diaChi")
    , @NamedQuery(name = "User.findBySoDienThoai", query = "SELECT u FROM User u WHERE u.soDienThoai = :soDienThoai")
    , @NamedQuery(name = "User.findByAvatar", query = "SELECT u FROM User u WHERE u.avatar = :avatar")
    , @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "taiKhoan")
    private String taiKhoan;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "matKhau")
    private String matKhau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "hoVaTen")
    private String hoVaTen;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "gmail")
    private String gmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "diaChi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "soDienThoai")
    private String soDienThoai;
    @Size(max = 1073741823)
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "taiKhoan")
    private Collection<Order1> order1Collection;

    public User() {
    }

    public User(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public User(String taiKhoan, String matKhau, String hoVaTen, String gmail, String diaChi, String soDienThoai) {
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
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.taiKhoan == null && other.taiKhoan != null) || (this.taiKhoan != null && !this.taiKhoan.equals(other.taiKhoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ taiKhoan=" + taiKhoan + " ]";
    }
    
}
