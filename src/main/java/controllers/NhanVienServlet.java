package controllers;

import entities.MauSac;
import entities.mapping_entities.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.jdbc.MauSacRepository;
import repositories.jpa.NhanVienRepository;
import utils.EncryptUtil;

import java.io.IOException;
import java.util.List;

@WebServlet({
    "/nhan-vien/index",
    "/nhan-vien/create",
    "/nhan-vien/store",
    "/nhan-vien/edit",
    "/nhan-vien/update",
    "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvRepo = new NhanVienRepository();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("create")) {
            this.create(req, res);
        } else if (uri.contains("edit")) {
            this.edit(req, res);
        } else if (uri.contains("delete")) {
            this.delete(req, res);
        } else {
            this.index(req, res);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, res);
        } else if (uri.contains("update")) {
            this.update(req, res);
        } else {
            //
        }
    }

    protected void index(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        //
    }

    protected void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        req.getRequestDispatcher("/views/nhan_vien/create.jsp").forward(req, res);
    }

    protected void edit(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
    {
        //
    }

    protected void delete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //
    }

    protected void store(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hashed = EncryptUtil.encrypt(password);
        NhanVien nv = new NhanVien(null, ma, ten, username, hashed, 1);
        this.nvRepo.create(nv);
        res.sendRedirect("/nhan-vien/index");
    }

    protected void update(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        //
    }
}
