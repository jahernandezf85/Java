package pruebas;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientePruebas {

	private Socket socket;
	private BufferedReader entrada;
	private BufferedWriter salida;
	
	public ClientePruebas(){
		try {
			socket = new Socket("localhost", 1001);
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (IOException e) {
			
			System.out.println("Error al conectar con el servidor en el puerto 1001");
		}
	}
	
	void ejecutar() {
		System.out.println("Escribe el mensaje para el servidor");
		String frase = new Scanner(System.in).nextLine();

		try {
			salida.write(frase);
			salida.newLine();
			salida.flush(); 
			frase = entrada.readLine();
			System.out.println("El servidor ha enviado "+frase);
		} catch (IOException e) {
			System.out.println("Error al enviar el mesanej al servidor");
		}
		
		
	}
	
	public static void main(String[] args) {
		new ClientePruebas().ejecutar();
	}
	
}
