package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.AcumuladorBasico;


public class Hilo extends Thread {
	private Socket socket;
	private  HashMap<String, HashMap<String, List<Double>>> userAcumulador;;
	private final String PROTOCOLO;
	private String user;
	private AcumuladorBasico acumulador;
	HashMap<String, List<Double>> acumuladores; 
	
	Hilo(Socket socket,  HashMap<String, HashMap<String, List<Double>>> userAcumulador, AcumuladorBasico acumulador){
		super();
		this.socket = socket;
		this.userAcumulador = userAcumulador;
		this.acumulador = acumulador;
				
		HashMap<String, Integer> opc = new HashMap<String, Integer>();
		opc.put("Añadir", 2);
		opc.put("Suma", 1);
		opc.put("Media", 1);
		opc.put("Maximo", 1);
		opc.put("Minimo", 1);
		opc.put("Salir", 0);
		PROTOCOLO = generarProtocolo(opc);
	}
	
	@Override
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
			user = entrada.readLine();
			
			
			if(userAcumulador.containsKey(user)) {
				acumuladores = userAcumulador.get(user);
			} else {
				acumuladores = new HashMap<String,List<Double>>();
			}
			
						
			salida.write(PROTOCOLO + "@" + generarListaAcumuladores(acumuladores));
			salida.newLine();
			salida.flush();
			
			String operacion = entrada.readLine();
			
			while(!operacion.split(":")[0].equals("Salir")) {
				String resultado = "Resultado: ";
				switch(operacion.split(":")[0]) {
				case "Añadir":
					if(acumuladores.containsKey(operacion.split(":")[1])) {
					acumuladores.get(operacion.split(":")[1]).add(Double.parseDouble(operacion.split(":")[2]));
					} else {
						List<Double> lista = new ArrayList<Double>();
						lista.add(Double.parseDouble(operacion.split(":")[2]));
						acumuladores.put(operacion.split(":")[1], lista);
					}
					resultado += "Acumular " + operacion.split(":")[1];
					for(Double valor: acumuladores.get(operacion.split(":")[1]))
					{
						resultado += " " + valor;

					}
					resultado += "<<<OK!";
					break;
				case "Suma":
					resultado += acumulador.sumar(acumuladores.get(operacion.split(":")[1])).toString();
					break;
				case "Media":
					resultado += acumulador.media(acumuladores.get(operacion.split(":")[1])).toString();
					break;
				case "Maximo":
					resultado += acumulador.maximo(acumuladores.get(operacion.split(":")[1])).toString();
					break;
				case "Minimo":
					resultado += acumulador.minimo(acumuladores.get(operacion.split(":")[1])).toString();
					break;
				
				}
				
				salida.write(resultado);
				salida.newLine();
				salida.flush();
				
				salida.write(PROTOCOLO + "@" + generarListaAcumuladores(acumuladores));
				salida.newLine();
				salida.flush();
				
				operacion = entrada.readLine();
			}
				
		} catch (IOException e) {
			System.out.println("[ERROR]: Conexion con el cliente perdida");
		} finally {
			try {
				socket.close();
				userAcumulador.put(user, acumuladores);
			} catch (IOException e) {
				System.out.println("[ERROR]: hubo algun problema y no se guardaron los datos del cliente");
			}
			
		}
	}
	
	private String generarProtocolo(HashMap<String, Integer> opc) {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> pareja: opc.entrySet()) {
			sb.append(pareja.getKey());
			if(pareja.getValue() >= 1)
				sb.append(":nombreAcumulador");
			if(pareja.getValue() >= 2)
				sb.append(":valor");
			sb.append("#");
			
		}
		
		return sb.toString();
	}
	
	private String generarListaAcumuladores(HashMap<String,List<Double>> acumuladores) {
		StringBuilder sb = new StringBuilder();
		for(String nombreAcumulador:acumuladores.keySet()) {
			sb.append(nombreAcumulador + "#");
		}
		return sb.toString();
	}
}
