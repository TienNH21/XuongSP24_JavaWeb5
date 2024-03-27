package controllers;

import entities.MauSac;
import entities.SanPham;
import entities.SanPhamChiTiet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.MauSacRepository;
import repositories.SanPhamChiTietRepository;
import repositories.SanPhamRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
        String idS = req.getParameter("idSanPham");
        if (idS != null && idS.trim().length() != 0) {
            int idSP = Integer.parseInt(idS.trim());
            SanPham sp = this.spRepo.findByID(idSP);
            List<SanPhamChiTiet> listSPCT = this.spctRepo.findByIdSP(idSP);
            List<Integer> listIdMS = new ArrayList<>();
            for (SanPhamChiTiet spct: listSPCT) {
                listIdMS.add(spct.getIdMauSac());
            }
            HashMap<Integer, MauSac> listMS = this.msRepo.findByIds(listIdMS);

            req.setAttribute("sanPham", sp);
            req.setAttribute("listMS", listMS);
            req.setAttribute("data", listSPCT);
            req.getRequestDispatcher("/views/san_pham_chi_tiet/index.jsp")
                .forward(req, res);
        } else {
            res.sendRedirect("/san-pham/index");
        }
    }

}
