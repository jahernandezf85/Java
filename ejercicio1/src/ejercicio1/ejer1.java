package ejercicio1;

public class ejer1 {

	public static void main(String[] args) {

		String cadena = "Hola como estais";
		int edad = 45;
		float salario = 1234.45f;
		boolean  que = true;
		
		
		System.out.println("Hola Mundo");
		System.out.println(cadena);
		System.out.println(edad);
		System.out.println(salario);
		System.out.println(que);
		
		edad+=10;
		salario = salario*1.20f; //salario*=1.20f;
		
		System.out.println(edad);
		System.out.println(salario);
		
	}

}
