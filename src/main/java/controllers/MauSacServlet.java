package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({
    "/mau-sac/index",
    "/mau-sac/create",
    "/mau-sac/store",
    "/mau-sac/edit",
    "/mau-sac/update",
    "/mau-sac/delete",
})
public class MauSacServlet extends HttpServlet {
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

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
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
        req.getRequestDispatcher("/views/mau_sac/index.jsp")
            .forward(req, res);
    }

    protected void create(HttpServletRequest req, HttpServletResponse res)
    {

    }

    protected void edit(HttpServletRequest req, HttpServletResponse res)
    {

    }

    protected void delete(HttpServletRequest req, HttpServletResponse res)
    {

    }

    protected void store(HttpServletRequest req, HttpServletResponse res)
    {

    }

    protected void update(HttpServletRequest req, HttpServletResponse res)
    {

    }
}
