package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class GestionTienda extends TreeMap<String, GestionProductos>{
		
	public void add(Producto p) {
		GestionProductos productos = new GestionProductos();
		if(this.containsKey(p.getNombre()))
			productos = this.get(p.getNombre());
		productos.anadir(p);
		this.put(p.getNombre(), productos);
	}
	
	public boolean vender(String nombre, int cantidad) {
		GestionProductos productos;
		if(this.containsKey(nombre)) {
			productos = this.get(nombre);
			int xVender = productos.vender(cantidad);
			if  (xVender == 0) 
				System.out.println("Se han vendido los productos.");
			else
				System.out.println("Faltan " + xVender + " productos por vender que no tenemos en Stock");
			return true;
		}
		return false;
	}
	
	public List<Producto> tirarCaducados(LocalDate fecha) {
		List<Producto> caducados = new ArrayList<Producto>();
		for(GestionProductos productos : this.values()) {
			caducados.addAll(productos.tirarCaducados(fecha));
		}
		return caducados;
	}
	
	public StringBuilder visualizarStock() {
		StringBuilder sb = new StringBuilder();
		for(GestionProductos productos : this.values() ) {
			sb.append(productos.toString() + "\n");
		}
		return sb;
	}
}
