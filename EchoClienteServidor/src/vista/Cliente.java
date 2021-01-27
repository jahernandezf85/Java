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
		System.out.println("Introduzca el mensaje: ");
		String mensaje = new Scanner(System.in).nextLine();

		try {
			salida.write(mensaje);
			salida.newLine();
			salida.flush();
			
			System.out.println(entrada.readLine());
		} catch (IOException e) {
			System.out.println("[ERROR]: Conexion con el servidor perdida");
		}
		
		
	}
	public static void main(String[] args) {
		new Cliente().ejecutar();
	}
}
