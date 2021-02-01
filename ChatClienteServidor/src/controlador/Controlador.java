package controlador;

import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.Usuarios;

public class Controlador {
	private ServerSocket socket;
	private List<String> usuarios;
	private Color[] coloresUser;
	private Color colorUser;
	private Usuarios users;
	private HashMap<String, List<String>> msgsUsers;
	
	public Controlador() {
		
			try {
				socket = new ServerSocket(1001);
				usuarios = new ArrayList<String>();
				coloresUser = new Color[5];
				coloresUser[0] = Color.blue;
				coloresUser[1] = Color.black;
				coloresUser[2] = Color.darkGray;
				coloresUser[3] = Color.orange;
				coloresUser[4] = Color.pink;
				msgsUsers = new HashMap<String, List<String>>();
				int contadorUsuarios = 0;
				
			} catch (IOException e) {
				System.out.println("[ERROR]: No se puede crear el socket en el puerto 1001");
			}
	}
	
	public void ejecutar() {
		System.out.println("Servidor conectado y en escucha en el puerto 1001");
		while(true) {
			try {
				Socket conexion = socket.accept();
				new Hilo(conexion, colorUser, msgsUsers).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private int asignarColor(int contador) {
		colorUser = coloresUser[contador];
		return contador++;
	}
	
	public static void main(String[] args) {
		new Controlador().ejecutar();
	}
}
