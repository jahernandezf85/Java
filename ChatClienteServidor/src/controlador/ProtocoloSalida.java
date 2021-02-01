package controlador;

public class ProtocoloSalida {
		
	private String opcion;
	private int nParametros;
	
	ProtocoloSalida(String opcion, int nParametros){
		this.opcion = opcion;
		this.nParametros = nParametros;
	}
	
	public String getOpcion() {
		return opcion;
	}
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	public int getnParametros() {
		return nParametros;
	}
	public void setnParametros(int nParametros) {
		this.nParametros = nParametros;
	}
	@Override
	public String toString() {
		return opcion + ":" + nParametros;
	}
	
	
	
	

}
