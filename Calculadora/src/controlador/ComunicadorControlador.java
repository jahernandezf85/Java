package controlador;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.Calculo;
import modelo.CalculoBasico;

public class ComunicadorControlador {

	
	private ServerSocket socket;
	private Calculo calc;
	
	public ComunicadorControlador() {
		try {
			socket = new ServerSocket(1001);
			calc = new CalculoBasico();
		} catch (IOException e) {
			System.out.println("Imposible crear el socket del servidor en el puerto 1001");
		}
	}
	
	public void ejecutar() {
		System.out.println("Servidor conectado y en escucha en el puerto 1001");
		while(true) {
			try {
				Socket conexion = socket.accept();
				new Hilo(conexion, calc).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		new ComunicadorControlador().ejecutar();
	}
}
