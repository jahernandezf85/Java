
public class Producto {
	private String nombre;
	private int nExistencias;
	private double precio;
	public Producto(String nombre, int unidades, double precio) {
		super();
		this.nombre = nombre;
		this.nExistencias = unidades;
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getUnidades() {
		return nExistencias;
	}
	public void setUnidades(int unidades) {
		this.nExistencias = unidades;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", nExistencias=" + nExistencias + ", precio=" + precio + "]";
	}
	
	
}
