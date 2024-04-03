package controllers;

import entities.SanPham;
import entities.mapping_entities.custom.SanPhamChiTietCustom;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import request.spct.IndexRequest;
import repositories.jdbc.MauSacRepository;
//import repositories.jdbc.SanPhamChiTietRepository;
//import entities.custom.SanPhamChiTietCustom;
import repositories.jdbc.SanPhamRepository;
import repositories.jpa.SanPhamChiTietRepository;

import java.io.IOException;
import java.util.List;

@WebServlet({
    "/san-pham-chi-tiet/index",
    "/san-pham-chi-tiet/create",
    "/san-pham-chi-tiet/store",
    "/san-pham-chi-tiet/edit",
    "/san-pham-chi-tiet/update",
    "/san-pham-chi-tiet/delete",
})
public class SanPhamChiTietServlet extends HttpServlet {
    private SanPhamChiTietRepository spctRepo = new SanPhamChiTietRepository();
    private SanPhamRepository spRepo = new SanPhamRepository();
    private MauSacRepository msRepo = new MauSacRepository();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("create")) {
//            this.create(req, res);
        } else if (uri.contains("edit")) {
//            this.edit(req, res);
        } else if (uri.contains("delete")) {
//            this.delete(req, res);
        } else {
            this.index(req, res);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
//            this.store(req, res);
        } else if (uri.contains("update")) {
//            this.update(req, res);
        } else {
            //
        }
    }

    protected void index(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        try {
            IndexRequest params = IndexRequest.make(req.getParameterMap());
            SanPham sp = this.spRepo.findByID(params.getIdSanPham());
            List<SanPhamChiTietCustom> listSPCT = this.spctRepo.findByIdSP(params);

            req.setAttribute("sanPham", sp);
            req.setAttribute("data", listSPCT);
            req.getRequestDispatcher("/views/san_pham_chi_tiet/index.jsp").forward(req, res);
        } catch (Exception e) {
            res.sendRedirect("/san-pham/index");
        }
    }

}
