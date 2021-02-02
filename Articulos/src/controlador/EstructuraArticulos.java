package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import modelo.Articulo;

public class EstructuraArticulos {
	private HashMap<String, List<Articulo>> articulos;
	private SortedSet<Articulo> articulosOrd;
	
	public EstructuraArticulos(){
		articulos = new HashMap<String, List<Articulo>>();
		articulosOrd = new TreeSet<Articulo>();	
	}
	
	public boolean add(Articulo articulo) {
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		
		if(articulos.containsKey(articulo.getAutor())) { 
			listaArticulos = articulos.get(articulo.getAutor());
			if(listaArticulos.contains(articulo)) return false;
		}
		
		listaArticulos.add(articulo);
		articulos.put(articulo.getAutor(), listaArticulos);
		articulosOrd.add(articulo);
		return true;
	}
	
	public List<Articulo> obtenerPorAutor(String autor) {
		return articulos.get(autor);
	}
	
	
	public SortedSet<Articulo> obtenerPorFechas(LocalDate fechaInicio, LocalDate fechaFin){
		return articulosOrd.subSet(new Articulo(fechaInicio), new Articulo(fechaFin));
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		for(Articulo articulo : articulosOrd) {
			sb.append(articulo.toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
