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
	private BufferedReader entrada= null;
	private BufferedWriter salida = null;
	private HashMap<Integer, String> opciones = new HashMap();
	
	Cliente(){
		try {
			socket = new Socket("localhost", 1001);
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("[ERROR]: No se ha podido establecer la conexion con el servidor");
		}
		
	}
	
	public void ejecutar() {
		String protocolo;
		try {
			protocolo = entrada.readLine();
			int sel = generarMenu(protocolo);
			
			while(sel != 0) {
				String texto = "";
				if(opciones.containsKey(sel)) {
					System.out.println("Introduzca el texto a formatear: ");
					texto = new Scanner(System.in).nextLine();
					
					salida.write(opciones.get(sel) + ":" + texto);
					salida.newLine();
					salida.flush();
					
					System.out.println(entrada.readLine());
				}else {
					System.out.println("Opcion no valida.");
				}
				
				sel = generarMenu(protocolo);
			}
		} catch (IOException e) {
			System.out.println("[ERROR]: Se ha perdido la conexion con el servidor");
		}
		
		
		
	}
	
	private int generarMenu(String protocolo) {
		
		String[] partes = protocolo.split("#");
		System.out.println(" ----- Formateador de texto ----- ");
		for(int i=0;i<partes.length;i++) {
			if(!partes[i].split(":")[0].toUpperCase().equals("SALIR")) {
				opciones.put(i+1, partes[i].split(":")[0]);
				System.out.println(i+1 + ".- " + partes[i].split(":")[0]);
			}else {
				opciones.put(0, partes[i].split(":")[0]);
				System.out.println("0.- " + partes[i].split(":")[0]);
			}
		}
		System.out.println("Seleccion una opcion: ");
		int opc = new Scanner(System.in).nextInt();
		
		return opc;
		
		
	}
	public static void main(String[] args) {
		new Cliente().ejecutar();
	}
}
