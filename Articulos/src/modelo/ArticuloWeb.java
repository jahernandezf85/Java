package modelo;

import java.time.LocalDate;

public class ArticuloWeb extends Articulo {
	private String url;
	
	public ArticuloWeb(String autor, String codigoPublicacion, LocalDate fechaPublicacion, String url) {
		super(autor, codigoPublicacion, fechaPublicacion);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return super.toString() + " url: " + url;
	}
}
