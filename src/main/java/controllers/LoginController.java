package controllers;

import entities.mapping_entities.NhanVien;
import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.NonUniqueResultException;
import repositories.jpa.NhanVienRepository;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private NhanVienRepository nvRepo;

    public LoginController()
    {
        this.nvRepo = new NhanVienRepository();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp")
                .forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String username = req.getParameter("tenDangNhap");
        String pwd = req.getParameter("matKhau");
        HttpSession session = req.getSession();
        try {
            NhanVien nv = this.nvRepo.login(username, pwd);
            session.setAttribute("nv", nv);
            res.sendRedirect("/mau-sac/index");
        } catch (NoResultException | NonUniqueResultException e) {
            session.setAttribute("error", "Sai ten dang nhap/mat khau");
            res.sendRedirect("/login");
        }
    }
}
