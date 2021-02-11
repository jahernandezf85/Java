package vista;


import java.util.List;

import controlador.Controlador;
import modelo.Mago;
import modelo.Persona;

public class Vista {
	Controlador controlador;
	
	Vista() {
		controlador = new Controlador();
	}
	public void ejecutar() {
		controlador.anadirPersona(new Persona("Pepe", 23));
		controlador.anadirPersona(new Mago("Harry", 23, "Hogwarts"));
		controlador.anadirPersona(new Mago("Hermione", 15, "Hogwarts"));
		controlador.anadirPersona(new Persona("Juan", 12));
		controlador.anadirPersona(new Mago("Lili", 21, "España"));
		controlador.anadirPersona(new Mago("Fer", 32, "España"));
		controlador.anadirPersona(new Mago("Juan", 32, "España"));
		controlador.anadirPersona(new Mago("A", 32, "España"));
		controlador.anadirPersona(new Mago("B", 32, "España"));
		controlador.anadirPersona(new Mago("c", 32, "España"));
		controlador.anadirPersona(new Mago("D", 32, "España"));
		controlador.anadirPersona(new Mago("E", 32, "España"));
		controlador.anadirPersona(new Mago("F", 32, "España"));
		controlador.anadirPersona(new Mago("G", 32, "España"));
		controlador.anadirPersona(new Mago("H", 32, "España"));
		controlador.anadirPersona(new Mago("I", 32, "España"));
		
		
		List<Mago> elegidos = controlador.elegir();
		
		System.out.println("ELEGIDOS:");
		for (Mago m : elegidos) {
			System.out.println(m.toString());
		}
	}
	
	public static void main(String[] args) {
		new Vista().ejecutar();
	}
}
