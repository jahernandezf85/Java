package clases;

import java.util.ArrayList;

public class Biblioteca {
	private String nombre;
	private String direccion;
	ArrayList<Libro> fondo = new ArrayList<Libro>();
	public Biblioteca(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
	}
	public Biblioteca(String nombre, String direccion, ArrayList<Libro> fondo) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.fondo = fondo;
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
	public ArrayList<Libro> getFondo() {
		return fondo;
	}
	public void setFondo(ArrayList<Libro> fondo) {
		this.fondo = fondo;
	}
	public void nuevoLibro(Libro libro) {
		fondo.add(libro);
	}
	public void eliminarLibro(int pos) {
		fondo.remove(pos);
	}
	
	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + ", fondo=" + fondo + "]";
	}
	
	
}
