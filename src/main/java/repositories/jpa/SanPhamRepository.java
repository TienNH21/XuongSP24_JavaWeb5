package repositories.jpa;

import entities.SanPham;

public class SanPhamRepository extends CrudRepository<SanPham> {
    @Override
    public String getClassName() {
        return "SanPham";
    }

    @Override
    public Class<SanPham> getClassType() {
        return SanPham.class;
    }
}
