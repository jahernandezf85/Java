package ejercicio0.agregado;

import java.util.ArrayList;
import java.util.Comparator;

import ejercicio0.Persona;

public class PadronAgregado {

	
	private ArrayList<Persona> lista;
	
	public PadronAgregado() {
		lista = new ArrayList<Persona>();
	}
	
	public boolean add(Persona nueva) {
		if(lista.contains(nueva)) return false;
		return lista.add(nueva);
	}
	
	public void ordenar(Criterio criterio) {
		switch(criterio) {
		case NOMBRE:
			lista.sort(new Comparator<Persona>() {

				@Override
				public int compare(Persona o1, Persona o2) {
					return o1.getNombre().compareTo(o2.getNombre());
				}
				
			});
		break;
		case DNI:
			lista.sort(new Comparator<Persona>() {//clase anónima

				@Override
				public int compare(Persona o1, Persona o2) {
					return o1.getDNI()-o2.getDNI();
				}
				
			});
			break;
		case FECHA:
			lista.sort(new Comparator<Persona>() {

				@Override
				public int compare(Persona o1, Persona o2) {
					return o1.getFecha().compareTo(o2.getFecha());
				}
				
			});
			break;
		}
	}
	
	@Override
	public String toString() {
		return lista.toString();
	}
}
