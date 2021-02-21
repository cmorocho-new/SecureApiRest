package app.code.logica;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import app.code.controller.UsuarioDAO;
import app.code.modelo.UsuarioDTO;

@Stateless
public class GestionUsuarioON{
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public UsuarioDTO validarLogin(String email, String password) {
		try {
			UsuarioDTO usuario = usuarioDAO.bucarUsuario(email);
			if(usuario.getPssword().equals(password)) {
				return usuario;
			}
		}catch (Exception e) {}
		return null;
	}
	
	public void guardarUsuario(UsuarioDTO usuario) {
		if (usuario.getId() == null) {
			usuarioDAO.guardarUsuario(usuario);
		}else {
			usuarioDAO.editarUsuario(usuario);
		}
	}
	
	public UsuarioDTO bucarUsuario(Long idUsuario) {
		return usuarioDAO.bucarUsuario(idUsuario);
	}
	
	public void eliminarUsuario(Long idUsuario) {
		usuarioDAO.eliminarUsuario(idUsuario);
	}
	
	public List<UsuarioDTO> listarUsario(String criterio) {
		return usuarioDAO.listarUsuario(criterio);
	}
	
}
