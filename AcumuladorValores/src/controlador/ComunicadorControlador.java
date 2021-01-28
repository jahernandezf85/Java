package controlador;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

import modelo.AcumuladorBasico;


public class ComunicadorControlador {
	private ServerSocket socket;
	private HashMap<String, HashMap<String, List<Double>>> userAcumulador;
	private AcumuladorBasico acumulador;
	
	
	public ComunicadorControlador() {
		try {
			socket = new ServerSocket(1001);
			userAcumulador = new HashMap<String, HashMap<String, List<Double>>>();
			acumulador = new AcumuladorBasico();
			
			
			
		} catch (IOException e) {
			System.out.println("[ERROR]: No se ha podido crear el socket");
		}
	}
	
	public void ejecutar() {
		System.out.println("[LOG]: Servidor listo y a la escucha en el puerto 1001");
		while(true) {
			try {
				Socket conexion = socket.accept();
				new Hilo(conexion, userAcumulador, acumulador).start();

			} catch (IOException e) {
				System.out.println("[ERROR] Imposible establecer la conexion");
			}
		}
	}
	
	public static void main(String[] args) {
		new ComunicadorControlador().ejecutar();
	}
}


