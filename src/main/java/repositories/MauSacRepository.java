package repositories;

import entities.MauSac;
import utils.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    private Connection conn;

    public MauSacRepository()
    {
        try {
            this.conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MauSac> findAll()
    {
        List<MauSac> ds = new ArrayList<>();

        try {
            String sql = "SELECT * FROM MauSac";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int trangThai = rs.getInt("TrangThai");
                MauSac ms = new MauSac(id, ma, ten, trangThai);
                ds.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    public void insert(MauSac ms)
    {
        String sql = "INSERT INTO MauSac(Ma, Ten, TrangThai) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
            ps.setInt(3, ms.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id)
    {
        String sql = "DELETE FROM MauSac WHERE ID = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public MauSac findById(int id)
    {
        String sql = "SELECT * FROM MauSac WHERE ID = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            String ma = rs.getString("Ma");
            String ten = rs.getString("Ten");
            int trangThai = rs.getInt("TrangThai");

            MauSac ms = new MauSac(id, ma, ten, trangThai);
            return ms;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(MauSac ms)
    {
        String sql = "UPDATE MauSac SET Ma = ?, Ten = ?, TrangThai = ? WHERE ID = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
            ps.setInt(3, ms.getTrangThai());
            ps.setInt(4, ms.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
