package pruebas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPruebas {

	private ServerSocket sv;
	private BufferedReader entrada;
	private BufferedWriter salida;
	
	public ServidorPruebas() {
		try {
			sv = new ServerSocket(1001);

		} catch (IOException e) {
			System.out.println("Imposible conectar el servidor en el puerto 1001");
		}
	}
	
	
	void ejecutar(){
		System.out.println("Servidor en escucha en el puerto 1001");
		while(true) {
			try {
				Socket socket = sv.accept();
				entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				String frase = entrada.readLine();
				System.out.println("El cliente ha enviado: "+frase);
				salida.write("mensaje recibido");
				salida.newLine();
				salida.flush();
			} catch (IOException e) {
				System.out.println("Error en la comunicación");
			}
		}
	}
	
	public static void main(String[] args) {
		new ServidorPruebas().ejecutar();
	}
}
