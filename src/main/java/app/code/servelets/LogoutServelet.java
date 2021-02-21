package app.code.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
@SuppressWarnings("serial")
public class LogoutServelet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Obtiene la session
		HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // Redirige la peticion
        resp.sendRedirect("login.jsp");
	}
	
}
