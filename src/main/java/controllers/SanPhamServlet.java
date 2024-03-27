package controllers;

import entities.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.MauSacRepository;
import repositories.SanPhamRepository;

import java.io.IOException;
import java.util.List;

@WebServlet({
    "/san-pham/index",
    "/san-pham/create",
    "/san-pham/store",
    "/san-pham/edit",
    "/san-pham/update",
    "/san-pham/delete",
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository spRepo = new SanPhamRepository();

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
        req.setAttribute("data", this.spRepo.findAll());
        req.getRequestDispatcher("/views/san_pham/index.jsp")
            .forward(req, res);
    }

}
