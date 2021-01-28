package vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Vista {
	private Socket socket;
	private BufferedReader entrada= null;
	private BufferedWriter salida = null;
	private HashMap<Integer, String> opciones;
	private HashMap<Integer, String> listaDeAcumuladores;
	
	Vista(){
		try {
			socket = new Socket("localhost", 1001);
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			opciones = new HashMap<Integer, String>();
			listaDeAcumuladores = new HashMap<Integer, String>();
		} catch (IOException e) {
			System.out.println("[ERROR]: No se ha podido establecer la conexion con el servidor");
		}
		
	}
	
	public void ejecutar() {
		String protocolo;
		try {
			salida.write(login());
			salida.newLine();
			salida.flush();
			
			protocolo = entrada.readLine();
			int sel = generarMenu(protocolo);
			
			while(sel != 0) {
				String valor="";
				if(opciones.containsKey(sel)) {
					int acumulador=0;
					
					if(opciones.get(sel).equals("Añadir"))
					{
						acumulador = generarListaAcumuladores(protocolo, true);
						valor = solicitarValor();
					}else {
						acumulador = generarListaAcumuladores(protocolo, false);
						if (acumulador == -1) {
							System.out.println("No hay acumuladores disponibles. Seleccione añadir y cree uno nuevo");
							sel = generarMenu(protocolo);
							continue;
						}
					}
					String mensaje = opciones.get(sel) + ":" + listaDeAcumuladores.get(acumulador) + valor;
					salida.write(mensaje);
					salida.newLine();
					salida.flush();
					
					System.out.println(entrada.readLine());
				}else {
					System.out.println("Opcion no valida.");
					sel = generarMenu(protocolo);
					continue;
				}
				
				protocolo = entrada.readLine();
				sel = generarMenu(protocolo);
				
			}
			
			salida.write(opciones.get(0));
			salida.newLine();
			salida.flush();
			
		} catch (IOException e) {
			System.out.println("[ERROR]: Se ha perdido la conexion con el servidor");
		}
		
		
	}
	
	
	private String solicitarValor() {
		String valor;
		System.out.println("Introduzca el valor: ");
		valor = Integer.toString(new Scanner(System.in).nextInt());
		return ":" + valor;
	}

	private int generarListaAcumuladores(String protocolo, boolean add) {
		int seleccion = 0;
		System.out.println("---- LISTA DE ACUMULADORES ----");
		if(protocolo.split("@").length > 1) {
			String menu = protocolo.split("@")[1];
			String[] partes = menu.split("#");
			System.out.println("Seleccione el Acumulador sobre el que actuar:");
			
			for(int i = 0;i<partes.length;i++) {
				listaDeAcumuladores.put(i+1, partes[i]);
				System.out.println(i+1 + ".- " + partes[i]);
			}
		}else {
			if(!add) return -1;
		}
		if(add) {
			System.out.println("0.- Nuevo");

			}
		System.out.println("Seleccione un acumulador: ");
		seleccion = new Scanner(System.in).nextInt();
		if (seleccion ==0 && add) {
			System.out.println("Introduzca un nombre para el nuevo acumulador: ");
			String nombre = new Scanner(System.in).nextLine();
			listaDeAcumuladores.put(listaDeAcumuladores.size(), nombre);
			seleccion = listaDeAcumuladores.size()-1;
		}
		return seleccion;
	}

	private int generarMenu(String protocolo) {
		int seleccion = 0;
		int sal=1;
		String opcSalir = "";
		String menu = protocolo.split("@")[0];
		String[] partes = menu.split("#");
		System.out.println(" ----- Acumuladores ----- ");
		for(int i=0;i<partes.length;i++) {
			if(!partes[i].split(":")[0].toUpperCase().equals("SALIR")) {
				opciones.put(i+sal, partes[i].split(":")[0]);
				System.out.println(i+sal + ".- " + partes[i].split(":")[0]);
			}else {
				opciones.put(0, partes[i].split(":")[0]);
				opcSalir = ("0.- " + partes[i].split(":")[0]);
				sal=0;
			}
		}
		System.out.println(opcSalir);
		System.out.println("Seleccion una opcion: ");
		seleccion = new Scanner(System.in).nextInt();
		return seleccion;
	}
	
	private String login() {
		System.out.println("Introduzca el nombre de usuario: ");
		return new Scanner(System.in).nextLine();
	}
	public static void main(String[] args) {
		new Vista().ejecutar();
	}
}
