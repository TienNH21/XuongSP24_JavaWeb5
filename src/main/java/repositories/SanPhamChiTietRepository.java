package repositories;

import entities.SanPham;
import entities.SanPhamChiTiet;
import utils.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamChiTietRepository {
    private Connection conn;

    public SanPhamChiTietRepository()
    {
        try {
            this.conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SanPhamChiTiet> findAll()
    {
        List<SanPhamChiTiet> ds = new ArrayList<>();

        try {
            String sql = "SELECT * FROM SanPhamChiTiet";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("MaSPCT");
                int idMS = rs.getInt("IdMauSac");
                int idKT = rs.getInt("IdKichThuoc");
                int idSP = rs.getInt("IdSanPham");
                int soLuong = rs.getInt("SoLuong");
                double donGia = rs.getDouble("DonGia");
                int trangThai = rs.getInt("TrangThai");
                SanPhamChiTiet sp = new SanPhamChiTiet(id, ma, idMS, idKT, idSP, soLuong, donGia, trangThai);
                ds.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    public List<SanPhamChiTiet> findByIdSP(int idSP)
    {
        ArrayList<SanPhamChiTiet> result = new ArrayList<>();

        try {
            String sql = "SELECT * FROM SanPhamChiTiet WHERE IdSanPham = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, idSP);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("MaSPCT");
                int idMS = rs.getInt("IdMauSac");
                int idKT = rs.getInt("IdKichThuoc");
                int soLuong = rs.getInt("SoLuong");
                double donGia = rs.getDouble("DonGia");
                int trangThai = rs.getInt("TrangThai");
                SanPhamChiTiet sp = new SanPhamChiTiet(id, ma, idMS, idKT, idSP, soLuong, donGia, trangThai);
                result.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
