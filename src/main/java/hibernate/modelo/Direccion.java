package hibernate.modelo;

import javax.persistence.*;

@Entity
@Table(name = "DIRECCION")
public class Direccion {
	
	@Id
	@Column(name = "ID_DIRECCION")
	private Long id;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "CIUDAD")
	private String ciudad;
	
	@Column(name = "DEPARTAMENTO")
	private String departamento;
	
	@Column(name = "PAIS")
	private String pais;

	public Direccion() {
	}

	public Direccion(Long id, String direccion, String ciudad, String departamento, String pais) {
		this.id = id;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", direccion=" + direccion + ", localidad=" + ciudad + ", departamento="
				+ departamento + ", pais=" + pais + "]";
	}
	
	
	
	
	

}
