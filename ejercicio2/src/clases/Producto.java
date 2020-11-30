package clases;

public class Producto {
	
	private String nombre;
	private float precio;
	private int nexistencias;
	private Categoria categoria;
	
	
	public Producto(String nombre, float precio, int stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.nexistencias = stock;
	}
	
	
	
	public Producto(String nombre, float precio, int nexistencias, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.nexistencias = nexistencias;
		this.categoria = categoria;
	}

	public Producto(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.nexistencias = 25;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public int getNexistencias() {
		return nexistencias;
	}
	public void setNexistencias(int stock) {
		this.nexistencias = stock;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", nexistencias=" + nexistencias + ", categoria="
				+ categoria + "]";
	}

	


	
}
