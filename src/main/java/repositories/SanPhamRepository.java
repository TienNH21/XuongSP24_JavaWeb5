package repositories;

import entities.MauSac;
import entities.SanPham;
import utils.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {
    private Connection conn;

    public SanPhamRepository()
    {
        try {
            this.conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SanPham> findAll()
    {
        List<SanPham> ds = new ArrayList<>();

        try {
            String sql = "SELECT * FROM SanPham";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int trangThai = rs.getInt("TrangThai");
                SanPham sp = new SanPham(id, ma, ten, trangThai);
                ds.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }


    public SanPham findByID(int id)
    {
        try {
            String sql = "SELECT * FROM SanPham WHERE ID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            rs.next();
            String ma = rs.getString("Ma");
            String ten = rs.getString("Ten");
            int trangThai = rs.getInt("TrangThai");
            return new SanPham(id, ma, ten, trangThai);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
