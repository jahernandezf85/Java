package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import modelo.Calculo;

public class Hilo extends Thread {

	private Socket socket;
	private HashMap<String, Integer> operaciones;
	private final String PROTOCOLO;
	private Calculo calc;
	
	Hilo(Socket socket, Calculo calc){
		super();
		this.socket= socket;
		this.calc = calc;
		operaciones = new HashMap();
		operaciones.put("sumar" , 2);
		operaciones.put("restar" , 2);
		operaciones.put("multiplicar" , 2);
		operaciones.put("absoluto" , 1);
		operaciones.put("dividir", 2);
		operaciones.put("salir" , 0);
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<String, Integer> pareja: operaciones.entrySet()) {
			sb.append(pareja.getKey());
			sb.append(":");
			sb.append(pareja.getValue());
			sb.append("#");
		}
		PROTOCOLO = sb.toString();
	}
	
	@Override
	public void run() {
		BufferedReader entrada= null;
		BufferedWriter salida = null;
		try {
			 entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			salida.write(PROTOCOLO);
			salida.newLine();
			salida.flush();
			Operacion operacion = leerOperacion(entrada);
			
			while(!operacion.nombre.equals("salir")) {
				String resultado= "Resultado:";
				switch(operacion.nombre.trim()) {
				case "sumar":
					resultado += calc.sumar(operacion.operandos[0], operacion.operandos[1]);
					break;
				case "restar":
					resultado += calc.restar(operacion.operandos[0], operacion.operandos[1]);
					break;
				case "multiplicar":
					resultado += calc.multiplicar(operacion.operandos[0], operacion.operandos[1]);
					break;
				case "absoluto":
					resultado += calc.valorAbsoluto(operacion.operandos[0]);
					break;
				case "dividir":
					resultado += operacion.operandos[0]/operacion.operandos[1];
						
				}
				salida.write(resultado);
				salida.newLine();
				salida.flush();
				operacion = leerOperacion(entrada);
			}
			
		} catch (IOException  e) {
			System.out.println("Error en la comunicación con el cliente");
		}catch(IllegalArgumentException e){
			try {
				salida.write("ERROR:"+e.getMessage());
				salida.newLine();
				salida.flush();
			} catch (IOException e1) {
				
			}
			
		}finally {
		
			try {
				socket.close();
			} catch (IOException e) {
			
			}
		}
	

	}

	private Operacion leerOperacion(BufferedReader entrada) throws IOException {
		String lectura = entrada.readLine();
		String [] trozos = lectura.split(":"); //sumar:1:3
		if(trozos.length==0) throw new IllegalArgumentException("Parámetros incorrectos");
		if(!operaciones.containsKey(trozos[0])) throw new IllegalArgumentException("Operación incorrectos");
		int op = operaciones.get(trozos[0]);
		if(trozos.length != op+1)throw new IllegalArgumentException("Parámetros incorrectos");
		return new Operacion(trozos);
	}
	
	
	class Operacion{
		String nombre;
		double[] operandos;
		Operacion(String[] trozos){
			nombre = trozos[0];
			operandos = new double[trozos.length-1];
			for(int i =1; i< trozos.length; i++) {
				operandos[i-1]= Double.parseDouble(trozos[i]);
				int a =0;
			
			}
		}
	}
}
