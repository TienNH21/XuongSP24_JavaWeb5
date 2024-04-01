package entities.mapping_entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class HoaDon {
    private Integer id;
    private Integer idKh;
    private Integer idNv;
    private Date ngayMuaHang;
    private Integer trangThai;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IdKH", nullable = true)
    public Integer getIdKh() {
        return idKh;
    }

    public void setIdKh(Integer idKh) {
        this.idKh = idKh;
    }

    @Basic
    @Column(name = "IdNV", nullable = true)
    public Integer getIdNv() {
        return idNv;
    }

    public void setIdNv(Integer idNv) {
        this.idNv = idNv;
    }

    @Basic
    @Column(name = "NgayMuaHang", nullable = false)
    public Date getNgayMuaHang() {
        return ngayMuaHang;
    }

    public void setNgayMuaHang(Date ngayMuaHang) {
        this.ngayMuaHang = ngayMuaHang;
    }

    @Basic
    @Column(name = "TrangThai", nullable = false)
    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HoaDon hoaDon = (HoaDon) o;

        if (id != null ? !id.equals(hoaDon.id) : hoaDon.id != null) return false;
        if (idKh != null ? !idKh.equals(hoaDon.idKh) : hoaDon.idKh != null) return false;
        if (idNv != null ? !idNv.equals(hoaDon.idNv) : hoaDon.idNv != null) return false;
        if (ngayMuaHang != null ? !ngayMuaHang.equals(hoaDon.ngayMuaHang) : hoaDon.ngayMuaHang != null) return false;
        if (trangThai != null ? !trangThai.equals(hoaDon.trangThai) : hoaDon.trangThai != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idKh != null ? idKh.hashCode() : 0);
        result = 31 * result + (idNv != null ? idNv.hashCode() : 0);
        result = 31 * result + (ngayMuaHang != null ? ngayMuaHang.hashCode() : 0);
        result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
        return result;
    }
}
