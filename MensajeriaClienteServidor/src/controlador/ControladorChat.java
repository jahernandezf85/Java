package controlador;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import modelo.Datos;

public class ControladorChat {
	private ServerSocket socket;
	private Datos datos;
	private List<Hilo> hilos;
	
	ControladorChat(){
		try {
			socket = new ServerSocket(1001);
			datos = new Datos();
			hilos = new ArrayList<Hilo>();
		} catch (IOException e) {
			System.out.println("Imposible crear el socket del servidor en el puerto 1001");
		}
	}
	
	public void ejecutar() {
		System.out.println("Servidor conectado y en escucha en el puerto 1001");
		while(true) {
			try {
				Socket conexion = socket.accept();
				Hilo nuevoHilo = new Hilo(conexion, datos, this);
				nuevoHilo.run();
				hilos.add(nuevoHilo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void sendMensaje(String msg) {
		for(Hilo hilo: hilos) {
			hilo.sendMensaje(msg);
		}
	}
	public static void main(String[] args) {
		new ControladorChat().ejecutar();
	}
	
	
}
