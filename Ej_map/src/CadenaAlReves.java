
public class CadenaAlReves {
	public static void imprimir_alreves(String cadena) {
		String cadenaInvertida = "";
		for(int i=cadena.length()-1;i>=0;i--) {
			cadenaInvertida += cadena.charAt(i);
		}
		
		System.out.println(cadenaInvertida);
	}
	public static boolean palindromo(String cadena) {
		String cadenaInvertida = "";
		for(int i=cadena.length()-1;i>=0;i--) {
			cadenaInvertida += cadena.charAt(i);
		}
		
		return cadena.equals(cadenaInvertida);
	}
	public static void main(String[] args) {
		String cadena = "Hola buenas tardes";
		imprimir_alreves(cadena);
		
		String palin = "Buenos dias said soneuB";
		imprimir_alreves(palin);
		System.out.println("las cadena es un palindromo: " + palindromo(palin));
	}
}
