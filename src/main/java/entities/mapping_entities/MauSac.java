package entities.mapping_entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MauSac {
    private Integer id;
    private String ma;
    private String ten;
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
    @Column(name = "Ma", nullable = false, length = 255)
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
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

        MauSac mauSac = (MauSac) o;

        if (id != null ? !id.equals(mauSac.id) : mauSac.id != null) return false;
        if (ma != null ? !ma.equals(mauSac.ma) : mauSac.ma != null) return false;
        if (ten != null ? !ten.equals(mauSac.ten) : mauSac.ten != null) return false;
        if (trangThai != null ? !trangThai.equals(mauSac.trangThai) : mauSac.trangThai != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ma != null ? ma.hashCode() : 0);
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
        return result;
    }
}
