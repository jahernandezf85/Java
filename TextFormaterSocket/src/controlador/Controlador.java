package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.TextFormaterBasico;

public class Controlador {
	private ServerSocket socket;
	private TextFormaterBasico textFormater;
	private String protocolo;
	private String[] opc;
	
	public Controlador() {
		try {
			socket = new ServerSocket(1001);
			textFormater = new TextFormaterBasico();
		} catch (IOException e) {
			System.out.println("[ERROR]:Imposible crear el socket en el puerto 1001");
		}
		opc = new String[4];
		opc[0] = "A Mayusculas";
		opc[1] = "A Minusculas";
		opc[2] = "Capitalizar";
		opc[3] = "Salir";
		
		protocolo = generarProtocolo(opc);
		
		
	}
	
	public void ejecutar() {
		System.out.println("[LOG]:Servidor conectado y la espera");
		while(true) {
			try {
				Socket conexion = socket.accept();
				BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(conexion.getOutputStream()));
				
				
				salida.write(protocolo);
				salida.newLine();
				salida.flush();
				
				String mensaje = entrada.readLine();
				
				while(!mensaje.split(":")[0].equals("Salir")) {
					String resultado = "Resultado: ";
					String texto = mensaje.split(":")[1];
					switch(mensaje.split(":")[0]) {
					case "A Mayusculas":
						resultado += textFormater.mayusculas(texto);
						break;
					case "A Minusculas":
						resultado += textFormater.minusculas(texto);
						break;
					case "Capitalizar":
						resultado += textFormater.capitalizar(texto);
						break;
					}
					
					salida.write(resultado);
					salida.newLine();
					salida.flush();
					
					mensaje = entrada.readLine();
				}
			} catch (IOException e) {
				System.out.println("[ERROR]: No se ha podido establecer la conexión");
			}
			
		}
	}
	private String generarProtocolo(String[] opc) {
		StringBuilder sb = new StringBuilder();
		
		for(String opcion:opc) {
			sb.append(opcion);
			sb.append(":texto");
			sb.append("#");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		new Controlador().ejecutar();
	}
}


