package repositories.jpa;

import entities.mapping_entities.custom.SanPhamChiTietCustom;
import jakarta.persistence.Query;
import org.hibernate.Session;
import request.spct.IndexRequest;
import utils.HibernateUtil;

import java.util.List;

public class SanPhamChiTietRepository {
    private Session hSession;

    public SanPhamChiTietRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }


    public List<SanPhamChiTietCustom> findByIdSP(int idSP)
    {
        String hql = "SELECT new SanPhamChiTietCustom(spct.id, spct.maSpct, " +
            "ms.ten, kt.ten, spct.soLuong, spct.donGia, spct.trangThai) " +
            "FROM SanPhamChiTiet spct " +
            "JOIN MauSac ms ON spct.idMauSac = ms.id " +
            "JOIN KichThuoc kt ON spct.idKichThuoc = kt.id " +
            "WHERE spct.idSanPham = ?1";

        Query q = this.hSession.createQuery(hql, SanPhamChiTietCustom.class);
        q.setParameter(1, idSP);
        return q.getResultList();
    }

    public List<SanPhamChiTietCustom> findByIdSP(IndexRequest params)
    {
        String hql = "SELECT new SanPhamChiTietCustom(spct.id, spct.maSpct, " +
                "ms.ten, kt.ten, spct.soLuong, spct.donGia, spct.trangThai) " +
                "FROM SanPhamChiTiet spct " +
                "JOIN MauSac ms ON spct.idMauSac = ms.id " +
                "JOIN KichThuoc kt ON spct.idKichThuoc = kt.id " +
                "WHERE spct.idSanPham = :idSP";
        if (params.getKeyword() != null) {
            hql += " AND ( spct.maSpct LIKE :keyword OR ms.ten LIKE :keyword OR kt.ten LIKE :keyword ) ";
        }

        if (params.getTrangThai() != null) {
            hql += " AND spct.trangThai = :trangThai ";
        }

        Query q = this.hSession.createQuery(hql, SanPhamChiTietCustom.class);
        q.setParameter("idSP", params.getIdSanPham());
        if (params.getKeyword() != null) {
            q.setParameter("keyword", "%" + params.getKeyword() + "%");
        }

        if (params.getTrangThai() != null) {
            q.setParameter("trangThai", params.getTrangThai());
        }

        return q.getResultList();
    }
}
