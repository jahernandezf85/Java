package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.TreeSet;

public class GestionProductos extends TreeSet<Producto> {
	
	
	public boolean anadir(Producto p) {
		return this.add(p);
	}
	
	public int vender(int cantidad) {
		int faltaXvender = cantidad;
		Producto productoAVender = this.primerPerecedero();
		while(faltaXvender > 0 && productoAVender != null) {
			faltaXvender = productoAVender.vender(faltaXvender);
			if(productoAVender.getCantidad() == 0) {
				this.remove(productoAVender);
			}
			productoAVender = this.primerPerecedero();
		}
		return faltaXvender;
		
	}
	
	public Producto primerPerecedero() {
		LocalDate caducidadMasProxima = LocalDate.MAX;
		Producto primerPerecedero = null;
		for(Object o: this.toArray()) {
			Producto p = (Producto) o;
			if (caducidadMasProxima.isAfter(p.getFechaCaducidad())) { 
				primerPerecedero = p;
				caducidadMasProxima = p.getFechaCaducidad();
			}
		}
		return primerPerecedero;
	}
	
	public List<Producto> tirarCaducados(LocalDate fecha) {
		List<Producto> caducados = new ArrayList<Producto>();
		for (Object o: this.toArray()) {
			Producto p = (Producto) o;
			if(p.getFechaCaducidad().isBefore(fecha)) {
				caducados.add(p);
				this.remove(p);
			}
		}
		return caducados;
	}
}
