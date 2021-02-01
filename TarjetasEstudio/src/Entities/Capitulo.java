package Entities;

import java.util.ArrayList;
import java.util.List;

public class Capitulo {
	private int nCapitulo;
	private String nombre;
	private List<Tarjeta> tarjetas;
	
	public Capitulo(int nCapitulo, String nombre) {
		super();
		this.nCapitulo = nCapitulo;
		this.nombre = nombre;
		this.tarjetas = new ArrayList<Tarjeta>();
	}
	
	public Capitulo addTarjeta(Tarjeta tarjeta) {
		this.tarjetas.add(tarjeta);
		return this;
	}

	public int getnCapitulo() {
		return nCapitulo;
	}

	public void setnCapitulo(int nCapitulo) {
		this.nCapitulo = nCapitulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	
	
	
	
}
