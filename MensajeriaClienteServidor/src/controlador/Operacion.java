package controlador;

import java.util.List;

public class Operacion {
	private String operacion;
	private List<String> operandos;
	
	public Operacion(String operacion, List<String> operandos){
		this.operacion = operacion;
		this.operandos = operandos;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public List<String> getOperandos() {
		return operandos;
	}

	public void setOperandos(List<String> operandos) {
		this.operandos = operandos;
	}
}
