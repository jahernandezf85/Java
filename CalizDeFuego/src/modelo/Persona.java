package modelo;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private int edad;
	protected boolean elegible;
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		this.elegible = false;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public boolean isElegible() {
		return elegible;
	}

	@Override
	public String toString() {
		return  nombre + " "  + edad + " años";
	}

	@Override
	public int compareTo(Persona p) {
		return this.nombre.compareTo(p.getNombre());
	}
	
	
}
