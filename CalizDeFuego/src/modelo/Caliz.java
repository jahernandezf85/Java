package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Caliz {
	private HashSet<Persona> apuntados;
	private HashMap<String, List<Mago>> elegibles;
	
	public Caliz() {
		apuntados = new HashSet<Persona>();
		elegibles = new HashMap<String, List<Mago>>();
	}
	
	public boolean add(Persona p) {
		if(apuntados.contains(p)) return false;
		if(p.getClass() == Mago.class && p.getEdad() > 16) {
			Mago m = (Mago)p;
			List<Mago> magosEscuela;
			if(elegibles.containsKey(m.getEscuela())) {
				magosEscuela = elegibles.get(m.getEscuela());
				magosEscuela.add(m);
			} else {
				magosEscuela = new ArrayList<Mago>();
				magosEscuela.add(m);
			}
			elegibles.put(m.getEscuela(), magosEscuela);
		} 
		apuntados.add(p);
		return true;
	}
	
	public List<Mago> elegir() {
		List<Mago> elegidos = new ArrayList<Mago>();
		for(List<Mago> magosEscuela : elegibles.values()) {
			int indexElegido =  new Random().nextInt(magosEscuela.size());
			elegidos.add(magosEscuela.get(indexElegido));
		}
		return elegidos;
	}
}
