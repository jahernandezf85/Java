import java.io.Serializable;

public class Empleado implements Serializable {
	private int id;
	private String nombre;
	private String apelllidos;
	public Empleado(int id, String nombre, String apelllidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apelllidos = apelllidos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApelllidos() {
		return apelllidos;
	}
	public void setApelllidos(String apelllidos) {
		this.apelllidos = apelllidos;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apelllidos=" + apelllidos + "]";
	}
	
	
}
