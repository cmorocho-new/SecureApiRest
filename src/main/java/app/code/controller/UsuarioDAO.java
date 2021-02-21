package app.code.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import app.code.modelo.UsuarioDTO;

@Stateless
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void guardarUsuario(UsuarioDTO usuario) {
		em.persist(usuario);
	}
	
	public void editarUsuario(UsuarioDTO usuario) {
		em.merge(usuario);
	}
	
	public void eliminarUsuario(Long idUsuario) {
		em.remove(em.find(UsuarioDTO.class, idUsuario));
	}
	
	public UsuarioDTO bucarUsuario(Long idUsuario) {
		return em.createQuery("SELECT u FROM UsuarioDTO u WHERE u.id = :idUsuario", UsuarioDTO.class)
				 .setParameter("idUsuario", idUsuario)
				 .getSingleResult();
	}
	
	public UsuarioDTO bucarUsuario(String email) {
		return em.createQuery("SELECT u FROM UsuarioDTO u WHERE u.email = :email", UsuarioDTO.class)
				 .setParameter("email", email)
				 .getSingleResult();
	}

	public List<UsuarioDTO> listarUsuario(String criterio) {
		return em.createQuery("SELECT u FROM UsuarioDTO u WHERE u.email LIKE :criterio OR u.nombre LIKE :criterio", UsuarioDTO.class)
				 .setParameter("criterio", "%" + criterio + "%")
				 .getResultList();
	}
	
}
