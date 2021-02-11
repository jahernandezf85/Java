package controlador;

import java.util.List;

import modelo.Caliz;
import modelo.Mago;
import modelo.Persona;

public class Controlador {
	Caliz caliz;
	
	public Controlador() {
		caliz = new Caliz();
	}
	
	public void anadirPersona(Persona p) {
		caliz.add(p);
	}
	
	public List<Mago> elegir(){
		return caliz.elegir();
	}
}
