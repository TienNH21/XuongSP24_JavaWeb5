package repositories.jpa;

import entities.mapping_entities.NhanVien;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.DBContext;
import utils.HibernateUtil;

public class NhanVienRepository {
    private Session hSession;

    public NhanVienRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public NhanVien login(String username, String password)
    {
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.tenDangNhap = :username AND nv.matKhau = :pwd";
        Query q = this.hSession.createQuery(hql, NhanVien.class);
        q.setParameter("username", username);
        q.setParameter("pwd", password);

        return (NhanVien) q.getSingleResult();
    }
}
