package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.EchoBasico;

public class Controlador {

	private ServerSocket socket;
	private EchoBasico echo;
	
	public Controlador() {
		try {
			socket = new ServerSocket(1001);
			echo = new EchoBasico();
		} catch (IOException e) {
			System.out.println("[ERROR]:Imposible crear el socket en el puerto 1001");
		}
	}
		
	public void ejecutar() {
		System.out.println("[LOG]:Servidor conectado y la espera");
		while(true) {
			try {
				Socket conexion = socket.accept();
				BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(conexion.getOutputStream()));
				
				String lectura = entrada.readLine();
				
				String respuesta = echo.responder(lectura);
				
				salida.write(respuesta);
				salida.newLine();
				salida.flush();
			} catch (IOException e) {
				System.out.println("[ERROR]: No se ha podido establecer la conexión");
			}
			
		}
	}
	
	public static void main(String[] args) {
		new Controlador().ejecutar();
	}
		
	
}
