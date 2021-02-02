package ejercicio0;

import java.time.LocalDate;

public class Persona implements Comparable<Persona>{

	
	private String nombre;
	private int DNI;
	private LocalDate fecha;
	
	public Persona(String nombre, int dNI, LocalDate fecha) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.fecha = fecha;
	}

	@Override
	public int compareTo(Persona o) {
		return fecha.compareTo(o.fecha);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if(o.getClass() != this.getClass()) return false;
		Persona otra = (Persona)o;
		
		return this.DNI == otra.DNI;
		
		//return this.nombre.equals(otra.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public int getDNI() {
		return DNI;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	@Override
	public String toString() {
		return nombre+"("+DNI+")";
	}
	
	
}
