
public class Producto implements Comparable<Producto>{
	private String nombre;
	private int cantidad;
	
	
	public Producto(String nombre, int cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", cantidad=" + cantidad + "]";
	}


	@Override
	public int compareTo(Producto o) {
		String nombre1 = o.getNombre().toLowerCase();
		String nombre2 = this.nombre.toLowerCase();
		
		int n = nombre2.compareTo(nombre1);
		if(n!=0) return n;
				
		return this.cantidad - o.getCantidad();
		
	}
	
	

}
