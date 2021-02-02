package modelo;

import java.time.LocalDate;

public class Articulo implements Comparable<Articulo>{
	private String autor;
	private String codigoPublicacion;
	private LocalDate fechaPublicacion;
	
	public Articulo(String autor, String codigoPublicacion, LocalDate fechaPublicacion) {
		this.autor = autor;
		this.codigoPublicacion = codigoPublicacion;
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public Articulo(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if(o.getClass() != this.getClass()) return false;
		Articulo art = (Articulo)o;
		
		return this.codigoPublicacion == art.getCodigoPublicacion();
	}
	
	@Override
	public int compareTo(Articulo articulo) {
		return this.fechaPublicacion.compareTo(articulo.getFechaPublicacion());
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getCodigoPublicacion() {
		return codigoPublicacion;
	}
	
	public void setCodigoPublicacion(String codigoPublicacion) {
		this.codigoPublicacion = codigoPublicacion;
	}
	
	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	@Override
	public String toString() {
		return "autor=" + autor + ", codigoPublicacion=" + codigoPublicacion + ", fechaPublicacion="
				+ fechaPublicacion.toString();
	}
	
		
}
