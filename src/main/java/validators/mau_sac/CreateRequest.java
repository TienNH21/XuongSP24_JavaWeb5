package validators.mau_sac;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
    "/mau-sac/store",
})
public class CreateRequest implements Filter {
    @Override
    public void doFilter(
        ServletRequest servletRequest,
        ServletResponse servletResponse,
        FilterChain filterChain
    ) throws IOException, ServletException {
        String ma = servletRequest.getParameter("ma");
        String ten = servletRequest.getParameter("ten");
        String ttS = servletRequest.getParameter("trangThai");

        if (
            ma == null ||
            ten == null ||
            ttS == null ||
            ma.trim().length() == 0 ||
            ten.trim().length() == 0 ||
            ttS.trim().length() == 0
        ) {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpSession session  = req.getSession();
            session.setAttribute("error", "Không được để trống");
            HttpServletResponse res = (HttpServletResponse) servletResponse;
            res.sendRedirect("/mau-sac/create");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
