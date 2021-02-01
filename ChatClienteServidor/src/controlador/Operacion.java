package controlador;

import java.util.ArrayList;
import java.util.List;

public class Operacion {
	private String accion;
	private List<String> parametros;
	
	Operacion(String accion, List<String> parametros){
		this.accion = accion;
		this.parametros = parametros;
	}
	
	Operacion(String accion){
		this.accion = accion;
		parametros = new ArrayList<String>();	
	}
	
	Operacion(){
		parametros = new ArrayList<String>();
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public List<String> getParametros() {
		return parametros;
	}

	public void setParametros(List<String> parametros) {
		this.parametros = parametros;
	}
	
	public Operacion addParametro(String parametro) {
		parametros.add(parametro);
		return this;
	}
	
}
