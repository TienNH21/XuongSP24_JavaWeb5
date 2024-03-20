package controllers;

import entities.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.MauSacRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
    "/mau-sac/index",
    "/mau-sac/create",
    "/mau-sac/store",
    "/mau-sac/edit",
    "/mau-sac/update",
    "/mau-sac/delete",
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepo = new MauSacRepository();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("URL:" + req.getRequestURL().toString());
        System.out.println("URI:" + req.getRequestURI());
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
        List<MauSac> ds = this.msRepo.findAll();
        req.setAttribute("data", ds);
        req.getRequestDispatcher("/views/mau_sac/index.jsp")
            .forward(req, res);
    }

    protected void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        req.getRequestDispatcher("/views/mau_sac/create.jsp").forward(req, res);
    }

    protected void edit(HttpServletRequest req, HttpServletResponse res)
    {

    }

    protected void delete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.msRepo.deleteById(id);
        res.sendRedirect("/mau-sac/index");
    }

    protected void store(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        int trangThai = Integer.parseInt(req.getParameter("trangThai"));
        MauSac ms = new MauSac(null, ma, ten, trangThai);
        this.msRepo.insert(ms);
        res.sendRedirect("/mau-sac/index");
    }

    protected void update(HttpServletRequest req, HttpServletResponse res)
    {

    }
}
