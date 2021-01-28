package modelo;

import java.util.List;

public interface Acumulador {
	
	public Double sumar(List<Double> acumulador);
	
	public Double media(List<Double> acumulador);
	
	public Double maximo(List<Double> acumulador);
	
	public Double minimo(List<Double> acumulador);
	
	}
