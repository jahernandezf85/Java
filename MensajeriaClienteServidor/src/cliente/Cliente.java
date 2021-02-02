package cliente;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import SistemaVentanas.SistemaVentanas;
import controlador.Operacion;

public class Cliente extends SistemaVentanas {
	private Socket socket;
	private BufferedReader entrada;
	private BufferedWriter salida;
	private HashMap<String, Integer> oper;
	private Operacion operacion;
	private boolean logeado = false;

	
	Cliente() {
		try {
			socket=new Socket("localhost",1001);
			oper = new HashMap<String, Integer>();
			entrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			oper = leerProtocolo(entrada);
			
		} catch (IOException e) {
			System.out.println("No se ha podido establecer la conexion con el servidor");
		}	
	}
	
	public HashMap<String, Integer> leerProtocolo(BufferedReader entrada) throws JsonSyntaxException, IOException{
		HashMap<String, Integer> salida = new HashMap<String, Integer>();
		JsonElement doc = new JsonParser().parse(entrada.readLine());
		if(doc.isJsonArray()) {
			for(JsonElement element: doc.getAsJsonArray()) {
				if(element.isJsonObject()) {
					JsonObject valor = element.getAsJsonObject();
					salida.put(valor.keySet().toString(), valor.getAsInt());
				}
			}
		}
			
		return salida;	
	}
	
	void ejecutar() {
		/*
		while(true) {
		while(logeado) {
			String mensaje;
			System.out.println("[DEV]: Dentro del bucle");
			try {
				mensaje = entrada.readLine().toString();
				this.addMensaje(mensaje, Color.black);
			} catch (IOException e) {
				System.out.println("Conexion con el servidor perdida");
			}
		}
		}*/
	}
	
	public static void main(String[] args) {
		new Cliente().ejecutar();
	}

	@Override
	public boolean logear(String arg0, String arg1) {
		String op = "login";
		List<String> parametros = new ArrayList<String>();
		parametros.add(arg0);
		parametros.add(arg1);
		
		operacion = new Operacion(op, parametros);
		try {
			
			salida.write(new Gson().toJson(operacion).toString());
			salida.newLine();
			salida.flush();
			
			String resp = entrada.readLine();
			if(!resp.equals("Error")) {
				logeado = true;
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			System.out.println("Conexion con el servidor perdida");
			
		}
		return false;
		
	}

	@Override
	public void logout(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibeMensaje(String arg0) {
		String op = "sendMensaje";
		List<String> parametros = new ArrayList<String>();
		parametros.add(arg0);
		
		operacion = new Operacion(op, parametros);
		try {
			
			salida.write(new Gson().toJson(operacion).toString());
			salida.newLine();
			salida.flush();
			
			String resp = entrada.readLine();
		}catch (IOException e) {
			System.out.println("Conexion con el servidor perdida");
		}
		
	}
	
	
}
