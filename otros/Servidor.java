package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import modelo.Procesado;

public class Servidor {
	private ServerSocket sSocket;
	private BufferedReader entrada;
	private BufferedWriter salida;
	private TreeMap protocoloMapa;
	private String protocolo;
	
	
	Servidor(){
		try {
			sSocket=new ServerSocket(1001);
			TreeMap<Integer,String> protocoloMapa= new TreeMap<Integer,String>();
			protocoloMapa.put(1,"capitalizar todas las palabras");
			protocoloMapa.put(2, "capitalizar la primera palaabra");
			protocoloMapa.put(3, "mayúsculas");
			protocoloMapa.put(4, "minúscula");
			protocoloMapa.put(5, "salir");
			
			StringBuilder sb = new StringBuilder();
			for(Entry<Integer, String> pareja: protocoloMapa.entrySet()) {
				sb.append(pareja.getKey());
				sb.append(":");
				sb.append(pareja.getValue());
				sb.append("#");	
			}	
			protocolo = sb.toString();
			
		} catch (IOException e) {
			System.out.println("Error al conectar al servidor en el puerto 1001");
		}	
	}
	
	void ejecutarServidor() {
		while(true) {
			System.out.println("Servidor a la escucha");
			
			try {
				Socket socket=sSocket.accept();
				entrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				salida=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				salida.write(protocolo);
				salida.newLine();
				salida.flush();
				int lectura=entrada.read();
				if(lectura==5){
					System.out.println("El usuario no quiere hacer más operaciones");
				}else {
					String operacionRealizada= leerOperacion(entrada,lectura);
					salida.write(operacionRealizada);
					salida.newLine();
					salida.flush();
					System.out.println("el servidor envió el calculo al cliente");
				}
				
			}catch(IOException e) {
				System.out.println("problema de comunicación con el cliente");
			}
		}
		
	}
	
	public String leerOperacion(BufferedReader entrada,int opcion) {
		try {
			Procesado proceso=new Procesado();
			String cadena=entrada.readLine();
			switch(opcion) {
			case 1:
				return proceso.capitalizar(cadena);
			case 2:
				return proceso.capitalizarPrimeraPalabra(cadena);
			case 3:
				return proceso.mayuscula(cadena);
			case 4:
				return proceso.minuscula(cadena);
			}
		} catch (IOException e) {
			System.out.println("Error al leer la información del cliente");
		}
		return null;
	}
	
	public static void main(String[] args) {
		new Servidor().ejecutarServidor();
	}

}
