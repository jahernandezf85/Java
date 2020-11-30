import java.util.ArrayList;

import clases.*;

public class ejer01 {
	
	public static void imprimir(ArrayList<Persona> p) {
		System.out.println("Imprimiendo...\n");
		for(Persona item : p) {
			System.out.println(item);
		}
	}
	
	public static void imprimir_detalle(ArrayList<Persona> p) {
		for(Persona item : p) {
			System.out.println(item.getNombre() + " - " + item.getMascota().getRaza());
		}
	}

	public static void main(String[] args) {

		Animal a1 = new Animal("Perro", 8);
		Animal a2 = new Animal("Gato", 7);
		
		ArrayList<Persona> familiares = new ArrayList<Persona>();
		
		familiares.add(new Persona("Jose", "C/abc", "1234", 25, a1));
		familiares.add(new Persona("Ana", "C/nueva", "2234", 35, a2));
		
		familiares.add(new Persona("Mercedes", "C/otra", "3234", 55, new Animal("otro", 9)));
		
		imprimir(familiares);
		
		imprimir_detalle(familiares);
	}

}
