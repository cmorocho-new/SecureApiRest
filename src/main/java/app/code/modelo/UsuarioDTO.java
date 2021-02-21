package app.code.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@SuppressWarnings("serial")
public class UsuarioDTO implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 200)
	private String nombre;
	
	@Column(nullable = false, unique= true, length = 100)
	private String email;
	
	@Column(nullable = false, length = 100)
	private String pssword;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Long id, String nombre, String email, String pssword) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pssword = pssword;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPssword() {
		return pssword;
	}
	public void setPssword(String pssword) {
		this.pssword = pssword;
	}
	
}
