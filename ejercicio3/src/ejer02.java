import java.util.ArrayList;

import clases.*;

public class ejer02 {
	
	public static void imprimir(Familia f) {
		if(f.getPadre()!=null) {
		System.out.println("Padre: " + f.getPadre());
		}
		if(f.getMadre()!= null) {
		System.out.println("Madre: " + f.getMadre());
		}
		if(f.getHijos() != null) {
			for(Persona hijo: f.getHijos()) {
				System.out.println("   Hijo: " + hijo);
			}
		}
	}

	public static void main(String[] args) {
		
		
		ArrayList<Persona> hijos1= new ArrayList<Persona>();
		
		hijos1.add(new Persona("Jose", "C/ABC", "3456", 23, null));
		hijos1.add(new Persona("Maria", "C/ABC", "4567", 21, null));
		
		Familia perez = new Familia(new Persona("Juan", "c/abc", "1234", 54, new Animal("Perro", 10)), new Persona("Maria", "c/abc", "2345", 50, null), hijos1);
		
		System.out.println(perez);
		
		perez.nacimiento(new Persona("Pepe", "c/abc", "5678", 1, null));
		
		System.out.println(perez);
		
		if(perez.fallecimiento(0)) {
			System.out.println("Eliminado");
		}else {
			System.out.println("No se ha podido eliminar");
		}
		
		if(perez.fallecimiento(5)) {
			System.out.println("Eliminado");
		}else {
			System.out.println("No se ha podido eliminar");
		}
		
		System.out.println(perez);
		System.out.println("=============================\n\n");
		imprimir(perez);
	}

}
