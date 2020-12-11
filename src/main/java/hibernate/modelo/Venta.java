package hibernate.modelo;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "VENTA")
public class Venta {
	
	@Id
	@Column(name = "IDVENTA")
	private Long idVenta;
	
	@Column(name = "PRODUCTO")
	private String producto;
	
	@Column(name = "FECHAVENTA")
	private LocalDate fechaVenta;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_EMPLEADO")
	private Empleado empleado;
	
	public Venta() {
		
	}

	public Venta(Long idVenta, String producto, LocalDate fechaVenta, Empleado empleado) {
		this.idVenta = idVenta;
		this.producto = producto;
		this.fechaVenta = fechaVenta;
		this.empleado = empleado;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "venta [idVenta=" + idVenta + ", producto=" + producto + ", fechaVenta=" + fechaVenta + ", empleado="
				+ empleado + "]";
	}
	
	
	
	
}
