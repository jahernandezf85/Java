package modelo;

import java.time.LocalDate;

public class Producto implements Comparable<Producto>{
	private String nombre;
	private int codigo;
	private int cantidad;
	private LocalDate fechaCaducidad;
	
	public Producto(String nombre,int codigo,int cantidad,LocalDate fechaCaducidad) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.fechaCaducidad = fechaCaducidad;
	}
	
	Producto() {
	}
	
	public int vender(int cantidad) {
		int faltaXvender = cantidad;
		if (this.cantidad < cantidad) {
			faltaXvender = faltaXvender - this.cantidad;
			this.cantidad = 0;
		} else {
			this.cantidad = this.cantidad - faltaXvender;
			faltaXvender = 0;
		}
		return faltaXvender;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", cantidad=" + cantidad + ", fechaCaducidad="
				+ fechaCaducidad + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if(o.getClass() != this.getClass()) return false;
		Producto p = (Producto)o;
		
		return this.codigo == p.codigo;
	}

	@Override
	public int compareTo(Producto p) {
		
		return this.codigo - p.codigo;
	}

	
}
