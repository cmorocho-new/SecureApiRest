package app.code.servelets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.code.logica.GestionUsuarioON;
import app.code.modelo.UsuarioDTO;

@WebServlet("/login")
@SuppressWarnings("serial")
public class LoginServelet extends HttpServlet {
	
	@Inject
	private GestionUsuarioON gestionUsuarioON;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Obtengo los datos
		String email = req.getParameter("email");
        String password = req.getParameter("password");
         
    	// Valida el usuario
        UsuarioDTO usuario = gestionUsuarioON.validarLogin(email, password);
        if (usuario != null) {
        	// Crea la session
        	 req.getSession().setAttribute("usuario", usuario);
        	 resp.sendRedirect(req.getContextPath() + "/admin/crud_usuarios.jsp");
        } else {
            req.setAttribute("mensaje", "Invalid email/password");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
       
	}
	
}
