package entities.mapping_entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class NhanVien {
    private Integer id;
    private String ten;
    private String ma;
    private String tenDangNhap;
    private String matKhau;
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
    @Column(name = "Ten", nullable = false, length = 255)
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Basic
    @Column(name = "Ma", nullable = false, length = 255)
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    @Basic
    @Column(name = "TenDangNhap", nullable = false, length = 255)
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    @Basic
    @Column(name = "MatKhau", nullable = false, length = 255)
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Basic
    @Column(name = "TrangThai", nullable = true)
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

        NhanVien nhanVien = (NhanVien) o;

        if (id != null ? !id.equals(nhanVien.id) : nhanVien.id != null) return false;
        if (ten != null ? !ten.equals(nhanVien.ten) : nhanVien.ten != null) return false;
        if (ma != null ? !ma.equals(nhanVien.ma) : nhanVien.ma != null) return false;
        if (tenDangNhap != null ? !tenDangNhap.equals(nhanVien.tenDangNhap) : nhanVien.tenDangNhap != null)
            return false;
        if (matKhau != null ? !matKhau.equals(nhanVien.matKhau) : nhanVien.matKhau != null) return false;
        if (trangThai != null ? !trangThai.equals(nhanVien.trangThai) : nhanVien.trangThai != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (ma != null ? ma.hashCode() : 0);
        result = 31 * result + (tenDangNhap != null ? tenDangNhap.hashCode() : 0);
        result = 31 * result + (matKhau != null ? matKhau.hashCode() : 0);
        result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
        return result;
    }
}
