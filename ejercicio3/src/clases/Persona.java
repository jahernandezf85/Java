package clases;

public class Persona {

	private String nombre;
	private String direccion;
	private String telefono;
	private int edad;
	private Animal mascota;
	
	public Persona(String nombre, String direccion, String telefono, int edad) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.edad = edad;
	}
	
	public Persona(String nombre, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.edad = 25;
	}
	
	public Persona(String nombre, String direccion, String telefono, int edad, Animal mascota) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.edad = edad;
		this.mascota = mascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Animal getMascota() {
		return mascota;
	}

	public void setMascota(Animal mascota) {
		this.mascota = mascota;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", edad=" + edad
				+ ", mascota=" + mascota + "]";
	}

	
	
	
}
