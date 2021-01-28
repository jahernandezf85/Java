package modelo;

import java.util.List;

public class AcumuladorBasico implements Acumulador {

	@Override
	public Double sumar(List<Double> acumulador) {
		double resultado = 0;
		for(double num: acumulador) {
			resultado += num;
		}
		return resultado;
	}

	@Override
	public Double media(List<Double> acumulador) {
		double resultado = 0;
		for(double num: acumulador) {
			resultado += num;
		}
		resultado = resultado / acumulador.size();
		return resultado;
	}

	@Override
	public Double maximo(List<Double> acumulador) {
		double resultado = Double.MIN_VALUE;
		for(double num: acumulador) {
			if(num>resultado) {
				resultado = num;
			}
		}
		return resultado;
	}

	@Override
	public Double minimo(List<Double> acumulador) {
		double resultado = Double.MAX_VALUE;
		for(double num: acumulador) {
			if(num<resultado) {
				resultado = num;
			}
		}
		return resultado;
	}

}
