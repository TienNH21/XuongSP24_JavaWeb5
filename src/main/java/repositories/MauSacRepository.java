package repositories;

import entities.MauSac;
import utils.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
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
            rs.next();
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

    public List<MauSac> findAll(String keyword, Integer trangThai)
    {
        List<MauSac> ds = new ArrayList<>();

        /**
         * Tìm kiếm theo:
         *      (Ma Like ?) OR (Ten Like ?)
         *      TrangThai = ?
         *
         * Trường hợp 1: Người dùng nhập đủ keyword và trangThai
         * SELECT * FROM MauSac WHERE ( (Ma Like ?) OR (Ten Like ?) ) AND TrangThai = ?
         *
         * Trường hợp 2: Người dùng chỉ nhập keyword
         * SELECT * FROM MauSac WHERE ( (Ma Like ?) OR (Ten Like ?) )
         *
         * Trường hợp 3: Người dùng chỉ chọn trangThai
         * SELECT * FROM MauSac WHERE TrangThai = ?
         *
         * Trường hợp 4: Người dùng KHÔNG chọn gì
         * SELECT * FROM MauSac
         */
        int i = 1;
        String sql = "SELECT * FROM MauSac";

        if (keyword.length() != 0 || trangThai != null) {
            sql += " WHERE ";
        }

        if (keyword.length() != 0) {
            i = 3;
            sql += " ( (Ma Like ?) OR (Ten Like ?) ) ";
        }

        if (trangThai != null) {
            sql += keyword.length() != 0 ? " AND " : "";
            sql += " TrangThai = ? ";
        }


        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            if (keyword.length() != 0) {
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
            }

            if (trangThai != null) {
                ps.setInt(i, trangThai);
            }
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int tt = rs.getInt("TrangThai");
                MauSac ms = new MauSac(id, ma, ten, tt);
                ds.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    public List<MauSac> findAll(int page, int limit)
    {
        List<MauSac> ds = new ArrayList<>();

        try {
            String sql = "SELECT * FROM MauSac ORDER BY ID " +
                    " OFFSET ? ROWS " + // bỏ qua ? bản ghi
                    " FETCH NEXT ? ROWS ONLY"; // lấy ? bản ghi
            PreparedStatement ps = this.conn.prepareStatement(sql);
            int offset = (page - 1) * limit;
            ps.setInt(1, offset);
            ps.setInt(2, limit);
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

    public int count()
    {
        try {
            String sql = "SELECT COUNT(ID) Total FROM MauSac";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            rs.next();
            return rs.getInt("Total");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<MauSac> findAll(int page, int limit, String keyword, Integer trangThai)
    {
        List<MauSac> ds = new ArrayList<>();
        int paramIndex = 1;
        String sql = "SELECT * FROM MauSac";

        if (keyword.length() != 0 || trangThai != null) {
            sql += " WHERE ";
        }

        if (keyword.length() != 0) {
            sql += " ( (Ma Like ?) OR (Ten Like ?) ) ";
        }

        if (trangThai != null) {
            sql += keyword.length() != 0 ? " AND " : "";
            sql += " TrangThai = ? ";
        }

        sql += " ORDER BY ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            if (keyword.length() != 0) {
                ps.setString(paramIndex++, "%" + keyword + "%");
                ps.setString(paramIndex++, "%" + keyword + "%");
            }

            if (trangThai != null) {
                ps.setInt(paramIndex++, trangThai);
            }

            int offset = (page - 1) * limit;
            ps.setInt(paramIndex++, offset);
            ps.setInt(paramIndex++, limit);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int tt = rs.getInt("TrangThai");
                MauSac ms = new MauSac(id, ma, ten, tt);
                ds.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    public HashMap<Integer, MauSac> findByIds(List<Integer> listId)
    {
        HashMap<Integer, MauSac> result = new HashMap<>();

        String sql = "SELECT * FROM MauSac WHERE ID IN (";

        for (int i = 0; i < listId.size(); i++) {
            sql += "?";
            if (i != listId.size()-1) {
                sql += ",";
            }
        }

        sql += ")";
        System.out.println("----------------------");
        System.out.println("SQL: ");
        System.out.println(sql);
        System.out.println("----------------------");
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            for (int i = 0; i < listId.size(); i++) {
                ps.setInt(i+1, listId.get(i));
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int trangThai = rs.getInt("TrangThai");

                MauSac ms = new MauSac(id, ma, ten, trangThai);
                result.put(id, ms);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
