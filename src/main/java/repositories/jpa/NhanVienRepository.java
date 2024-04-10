package repositories.jpa;

import entities.mapping_entities.NhanVien;
import jakarta.persistence.Query;
import org.hibernate.Session;
import utils.DBContext;
import utils.EncryptUtil;
import utils.HibernateUtil;

public class NhanVienRepository extends CrudRepository <NhanVien> {
    private Session hSession;

    @Override
    public String getClassName() {
        return "NhanVien";
    }

    @Override
    public Class<NhanVien> getClassType() {
        return NhanVien.class;
    }

    public NhanVienRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public NhanVien login(String username, String raw)
    {
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.tenDangNhap = :username";
        Query q = this.hSession.createQuery(hql, NhanVien.class);
        q.setParameter("username", username);
        NhanVien nv = (NhanVien) q.getSingleResult();
        return EncryptUtil.verify(raw, nv.getMatKhau()) ? nv : null;
    }
}
