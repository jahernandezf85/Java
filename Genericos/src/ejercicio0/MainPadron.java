package ejercicio0;

import java.time.LocalDate;

public class MainPadron {

	
	public static void main(String[] args) {
		Padron lista = new Padron();
		lista.add(new Persona("Pepe", 1111, LocalDate.of(2000, 10, 20)));
		lista.add(new Persona("Juan", 2222, LocalDate.of(2001, 10, 20)));
		lista.add(new Persona("Lucas", 3333, LocalDate.of(2000, 9, 20)));
		lista.add(new Persona("Jose", 4444, LocalDate.of(1999, 10, 20)));
		System.out.println("Inicial:");
		System.out.println(lista);
		System.out.println("por nombre:");
		lista.ordenar(Padron.NOMBRE);
		System.out.println(lista);
		System.out.println("por DNI:");
		lista.ordenar(Padron.DNI);
		System.out.println(lista);
		System.out.println("por fecha:");
		lista.ordenar(Padron.EDAD);
		System.out.println(lista);
	}
}
