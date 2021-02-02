package ejercicio0;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Padron extends ArrayList<Persona> {

	public static final int NOMBRE=1;
	public static final int DNI=2;
	public static final int EDAD=3;
	
	@Override
	public boolean add(Persona nueva) {
		if(this.contains(nueva)) return false;
		return super.add(nueva);
	}
	
	public void ordenar(int criterio) {
		switch(criterio) {
		case NOMBRE:
			this.sort(new ComparadorNombre());
			break;
		case DNI:
			this.sort(new Comparator<Persona>() {//clase anónima

				@Override
				public int compare(Persona o1, Persona o2) {
					return o1.getDNI()-o2.getDNI();
				}
				
			});
			break;
		case EDAD:
			this.sort(new Comparator<Persona>() {

				@Override
				public int compare(Persona o1, Persona o2) {
					return o1.getFecha().compareTo(o2.getFecha());
				}
				
			});
			break;
		}
	}
}

class ComparadorNombre implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}
	
}