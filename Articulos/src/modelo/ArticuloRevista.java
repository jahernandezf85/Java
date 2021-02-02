package modelo;

import java.time.LocalDate;

public class ArticuloRevista extends Articulo {
	private int numeroRevista;
	
	public ArticuloRevista(String autor, String codigoPublicacion, LocalDate fechaPublicacion, int numeroRevista) {
		super(autor, codigoPublicacion, fechaPublicacion);
		this.numeroRevista = numeroRevista;
	}

	public int getNumeroRevista() {
		return numeroRevista;
	}

	public void setNumeroRevista(int numeroRevista) {
		this.numeroRevista = numeroRevista;
	}
	
	@Override
	public String toString() {
		return super.toString() + " numeroRevista: " + numeroRevista;
	}
}
