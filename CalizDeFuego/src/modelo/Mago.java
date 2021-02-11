package modelo;

public class Mago extends Persona {
	private String escuela;
	
	public Mago(String nombre, int edad, String escuela) {
		super(nombre, edad);
		this.escuela = escuela;
		this.elegible = true;
	}

	public String getEscuela() {
		return escuela;
	}

	@Override
	public String toString() {
		return super.toString() + " Escuela: " + escuela;
	}

	
}
