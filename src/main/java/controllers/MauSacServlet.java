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
        /**
         * Search + Filter
        String s1 = req.getParameter("keyword");
        String s2 = req.getParameter("trangThai");
        System.out.println("-----");
        System.out.println(s2);
        String keyword = s1 == null ? "" : s1.trim();
        Integer trangThai = s2 == null || s2.trim().length() == 0 ? null : Integer.parseInt(s2.trim());
        List<MauSac> ds = this.msRepo.findAll(keyword, trangThai);
        req.setAttribute("data", ds);

        if (keyword.length() != 0) {
            req.setAttribute("keyword", keyword);
        }

        if (trangThai != null) {
            req.setAttribute("trangThai", trangThai);
        }
         */

        String s1 = req.getParameter("page");
        String s2 = req.getParameter("limit");
        int page = (s1 == null || s1.trim().length() == 0) ? 1 : Integer.parseInt(s1.trim());
        int limit = (s2 == null || s2.trim().length() == 0) ? 10 : Integer.parseInt(s2.trim());

        List<MauSac> ds = this.msRepo.findAll(page, limit);
        int totalPage = (this.msRepo.count() / limit) + 1;
        req.setAttribute("data", ds);
        req.setAttribute("page", page);
        req.setAttribute("limit", limit);
        req.setAttribute("totalPage", totalPage);
        req.getRequestDispatcher("/views/mau_sac/index.jsp")
            .forward(req, res);
    }

    protected void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        req.getRequestDispatcher("/views/mau_sac/create.jsp").forward(req, res);
    }

    protected void edit(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
    {
        int id = Integer.parseInt(req.getParameter("id"));
        MauSac ms = this.msRepo.findById(id);
        req.setAttribute("ms", ms);
        req.getRequestDispatcher("/views/mau_sac/edit.jsp").forward(req, res);
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

    protected void update(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        int id = Integer.parseInt(req.getParameter("id"));
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        int trangThai = Integer.parseInt(req.getParameter("trangThai"));
        MauSac ms = new MauSac(id, ma, ten, trangThai);
        this.msRepo.update(ms);
        res.sendRedirect("/mau-sac/index");
    }
}
