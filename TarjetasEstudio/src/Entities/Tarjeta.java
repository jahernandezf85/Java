package Entities;

public class Tarjeta {
	private String pregunta;
	private String respuesta;
	private int pagina;
	
	public Tarjeta(String pregunta, String respuesta, int pagina) {
		super();
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.pagina = pagina;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
}
