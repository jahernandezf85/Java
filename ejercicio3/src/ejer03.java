import java.util.ArrayList;

import clases.*;

public class ejer03 {

	public static void main(String[] args) {
		
		Libro l1 = new Libro("1234", "Cervantes", "El Quijote", "editorial", 1600);
		Libro l2 = new Libro("2345", "Lazarillo", "Anonimo", "editorio2", 1290);
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		libros.add(l1);
		libros.add(l2);
		
		Biblioteca b1 = new Biblioteca("Biblioteca 1", "C/abc", libros);
		
		b1.nuevoLibro(new Libro("34354", "Sanderson", "El camino de los reyes", "Ediciones B", 2010));
		b1.nuevoLibro(new Libro("53942", "Juan Gomez-Jurado", "Rey Blanco", "Anaya", 2020));
		
		System.out.println(b1);
		
		System.out.println("**********************");
		
		b1.eliminarLibro(1);
		
		System.out.println(b1);
	}

}
