package modelo;

public class TextFormaterBasico implements TextFormater {

	@Override
	public String mayusculas(String entrada) {
		return entrada.toUpperCase();
	}

	@Override
	public String minusculas(String entrada) {
		return entrada.toLowerCase();
	}

	@Override
	public String capitalizar(String entrada) {
		return mayusculasXPalabras(entrada);
	}
	
	private String mayusculasXPalabras(String entrada) {
		String palabras[] = entrada.toLowerCase().split(" ");
		String resultado = "";
		for(String palabra: palabras) {
			 
			 resultado += palabra.substring(0, 1).toUpperCase() + palabra.substring(1) + " ";
		}
		return resultado.trim();
	}

}
