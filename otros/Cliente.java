package vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Cliente {
	private Socket socket;
	private BufferedReader entrada;
	private BufferedWriter salida;
	private TreeMap<Integer, String> operaciones;
	
	
	public Cliente() {
		try {
			socket=new Socket("localhost",1001);
			operaciones= new TreeMap<Integer, String>();
			entrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String protocolo=entrada.readLine();
			String[] operacionesLeidas = protocolo.split("#");
			for (int i = 0; i < operacionesLeidas.length; i++) {
				String partes[]=operacionesLeidas[i].split(":");
				operaciones.put(Integer.parseInt(partes[0]),partes[1]);
			}
			
		}catch (IOException e) {
			System.out.println("Error al conectarse al servidor en el puerto 1001");
		}	
	}
	
	
	void ejecutarCliente() {
		
		int opcion=0;
		do {
			for(Entry<Integer, String> ele: operaciones.entrySet()) {
				System.out.println(ele);
			}
			System.out.println("Elige una opción. Escriba el número de la opción que desea realizar.");
			opcion=new Scanner(System.in).nextInt();
			if (!(opcion>=1 && opcion<=5)) 
				System.out.println("No has elegido una opción en el rango seleccionado.\n");	
			if(opcion>=1 && opcion<=4){
				try {
					salida.write(opcion);
					salida.flush();
					System.out.println("Introduce la cadena que quieres convertir");
					String cadena=new Scanner(System.in).nextLine();
					salida.write(cadena);
					salida.newLine();
					salida.flush();
					System.out.println(entrada.readLine()+"\n");
				} catch (IOException e) {
					System.out.println("Error al conectarse al servidor en el puerto 1001");
				}
			}else {
				try {
					salida.write(opcion);
					salida.flush();
				} catch (IOException e) {
					System.out.println("Error en la opción 4");
				}
				
			}
		}while(opcion!=5);
		System.out.println("Gracias por usar nuestro problema con arquitectura de tres capas");
	}
	
	public static void main(String[] args) {
		new Cliente().ejecutarCliente();
	}

}
