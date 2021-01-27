package vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente {

	private Socket socket;
	private HashMap<String, Integer> operaciones;
	private BufferedReader entrada= null;
	private BufferedWriter salida = null;
	Cliente(){
		try {
			socket = new Socket("localhost", 1001);
			operaciones = new HashMap<String, Integer>();
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String protocolo = entrada.readLine();
			String[] operacionesLeidas = protocolo.split("#");
			for(String op: operacionesLeidas) {
				String [] trozos = op.split(":");
				operaciones.put(trozos[0], Integer.parseInt(trozos[1]));
			}
			
		} catch (IOException e) {
			System.out.println("Error al establecer la conexión con el servidor en el puerto " +1001);
		}
		
	}
	
	void ejecutar() {
		String operacion ="";
		
		do {
			System.out.println("Seleccione una operación: "+operaciones.keySet());
			operacion = new Scanner(System.in).nextLine();
			if(operaciones.containsKey(operacion)) {
				int n= operaciones.get(operacion);
				//String instruccion = new String(operacion);
				//String instruccion = ""+operacion;
				String instruccion = operacion.toString();
				for(int i=0; i<n; i++) {
					instruccion += ":"+ new Scanner(System.in).nextLine();
				}
				try {
					salida.write(instruccion);
					salida.newLine();
					salida.flush();
					String respuesta = entrada.readLine();
					System.out.println(respuesta);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}while(!operacion.equals("salir"));
			
		
	}
	
	public static void main(String[] args) {
		new Cliente().ejecutar();
	}
	
}
