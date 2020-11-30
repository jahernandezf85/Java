package clases;

import java.util.ArrayList;

public class Familia {
	
	private Persona padre;
	private Persona madre;
	private ArrayList<Persona> hijos = new ArrayList<Persona>();;
	
	public Familia(Persona padre, Persona madre) {
		super();
		this.padre = padre;
		this.madre = madre;
	}

	public Familia(Persona padre, Persona madre, ArrayList<Persona> hijos) {
		super();
		this.padre = padre;
		this.madre = madre;
		this.hijos = hijos;
	}

	public Persona getPadre() {
		return padre;
	}

	public void setPadre(Persona padre) {
		this.padre = padre;
	}

	public Persona getMadre() {
		return madre;
	}

	public void setMadre(Persona madre) {
		this.madre = madre;
	}

	public ArrayList<Persona> getHijos() {
		return hijos;
	}

	public void setHijos(ArrayList<Persona> hijos) {
		this.hijos = hijos;
	}
	
	public void nacimiento(Persona hijo) {
		this.hijos.add(hijo);
	}
	
	public boolean fallecimiento(int pos) {
		if(pos<hijos.size()) {
			this.hijos.remove(pos);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Familia [padre=" + padre + ", madre=" + madre + ", hijos=" + hijos + "]";
	}
	
	
}
