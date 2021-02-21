package app.code.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;

import app.code.logica.GestionUsuarioON;
import app.code.modelo.UsuarioDTO;
import app.code.trasient.ResultadoREST;

@Path("usuarios")
public class ServicioUsuarioREST {
	
	@Inject
	private GestionUsuarioON gestionUsuario;
	
	@POST
	@Path("crearEditar")
	@Consumes("application/json")
    @Produces("application/json")
	public ResultadoREST guardarEditarUsuario(UsuarioDTO usuario) {
		try {
			gestionUsuario.guardarUsuario(usuario);
			return new ResultadoREST("200", "Usuario guardado");
		}catch (Exception ex) {
			return new ResultadoREST("100", ex.toString());
		}
	}
	
	
	@GET
	@Path("buscar/{idUsuario}")
    @Produces("application/json")
	public ResultadoREST buscarUsuario(@PathParam("idUsuario") Long idUsuario) {
		try {
			UsuarioDTO usuario = gestionUsuario.bucarUsuario(idUsuario);
			return new ResultadoREST("200", usuario);
		}catch (Exception ex) {
			return new ResultadoREST("100", ex.toString());
		}
	}
	
	@DELETE
	@Path("eliminar/{idUsuario}")
    @Produces("application/json")
	public ResultadoREST eliminarUsuario(@PathParam("idUsuario") Long idUsuario) {
		try {
			gestionUsuario.eliminarUsuario(idUsuario);
			return new ResultadoREST("200", "Usuario eliminado");
		}catch (Exception ex) {
			return new ResultadoREST("100", ex.toString());
		}
	}
	
	@GET
	@Path("listar")
	@Produces("application/json")
	public ResultadoREST listarUsario(@QueryParam("criterio") String criterio) {
		try {
			List<UsuarioDTO> usuarios = gestionUsuario.listarUsario(criterio);
			return new ResultadoREST("200", usuarios);
		}catch (Exception ex) {
			return new ResultadoREST("100", ex.toString());
		}
	}
	
}
