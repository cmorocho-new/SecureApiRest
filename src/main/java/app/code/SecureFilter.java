package app.code;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.code.modelo.UsuarioDTO;

public class SecureFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest reqt = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession sess = reqt.getSession(false);
        
        // Valida que este autenticado
        boolean isAutenticate = false;
        if (sess != null ) {
        	UsuarioDTO usuario = (UsuarioDTO) sess.getAttribute("usuario");
        	if (usuario != null) {
        		isAutenticate = true;
        	}
        }
        
        // Valida el acceso a los recursos
        if(!isAutenticate) {
        	String reqURI = reqt.getRequestURI();
        	if (reqURI.contains("/admin/")) {
        		resp.sendRedirect(reqt.getContextPath() + "/login.jsp");
        	}else if (reqURI.contains("/api/")) {
        		JsonObject resultado = Json.createObjectBuilder()
        				.add("codigo", "100").add("resultado", "No puede consumir esta API sin estar autenticado").build();
        		resp.setContentType("application/json");
        		resp.setCharacterEncoding("utf-8");
        		resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        	    resp.getWriter().write(resultado.toString());
        	    return;
        	}else if (reqURI.contains("/api/mobile/")) {
        		// validar el token
        	}
        		
        }
        
        // Realiza el filtro
        chain.doFilter(reqt, resp);
		
	}

}
