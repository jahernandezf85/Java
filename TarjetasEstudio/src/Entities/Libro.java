package Entities;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	private String nombre;
	private List<Capitulo> capitulos;
	
	public Libro(String nombre) {
		super();
		this.nombre = nombre;
		this.capitulos = new ArrayList<Capitulo>();
	}
	
	public void addCapitulo(Capitulo cap) {
		this.capitulos.add(cap);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	
	
	
}
