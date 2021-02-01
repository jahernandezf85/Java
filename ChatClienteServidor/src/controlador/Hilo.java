package controlador;

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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modelo.Usuarios;

public class Hilo extends Thread{
	
	private Socket socket;
	private Color color;
	private List<String> users;
	private List<ProtocoloSalida> protocoloSalida;
	private Usuarios user;
	private HashMap<String, List<String>> msgsUser;
	
	Hilo(Socket socket, Color color, HashMap<String, List<String>> msgsUser){
		super();
		this.socket = socket;
		this.color = color;
		this.user = new Usuarios();
		this.msgsUser = msgsUser;
		protocoloSalida = new ArrayList<ProtocoloSalida>();
		protocoloSalida.add(new ProtocoloSalida("login", 2));
		protocoloSalida.add(new ProtocoloSalida("msg", 2));
		protocoloSalida.add(new ProtocoloSalida("logout", 1));
	}
	
	@Override
	public void run() {
		BufferedReader entrada= null;
		BufferedWriter salida = null;
		 
		try {
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			salida.write(CrearJson(protocoloSalida).toString());
			salida.newLine();
			salida.flush();
			
			Operacion op = leerOperacion(entrada);
			while(op.getAccion().equals("logout")) {
				String opRealizada = "";
				List<String> param = op.getParametros();
				switch(op.getAccion()) {
				case "login":
						boolean login = user.login(param.get(0), param.get(1));
						if(login && msgsUser.containsKey(param.get(0))) {
							user.cargarMensajes(msgsUser.get(param.get(0)));
							opRealizada = "OK:" + color.toString();
						}
					break;
				case "msg":
						user.addMensaje(param.get(0), param.get(1));
					break;
				}
			}
			
		} catch (IOException e) {
			System.out.println("[LOG]: Conexion con el cliente finalizada");
		}
		finally {
			//TODO: realizar logout y esas cosas
		}
		
	}
	
	JsonElement CrearJson(List<ProtocoloSalida> protocolos) {
		return new Gson().toJsonTree(protocolos);
	}
	
	Operacion LeerJson(String jsonEntrada) {
		Operacion lectura = new Operacion();
		Operacion nuevaAccion = new Operacion();
		JsonElement doc = new JsonParser().parse(jsonEntrada);
		if(doc.isJsonObject()) {
			JsonObject valor = doc.getAsJsonObject();
			String  accion= "";
			if(valor.has("accion")) accion = valor.get("accion").getAsString();
			nuevaAccion.setAccion(accion);
			if(valor.has("parametros") && valor.get("parametros").isJsonArray()) {
				for(JsonElement e: valor.getAsJsonArray("parametros")) {
					nuevaAccion.addParametro(e.getAsString());
				}
			}
		}
		return lectura;
	}
	
	private Operacion leerOperacion(BufferedReader entrada) throws IOException {
		return LeerJson(entrada.readLine());

	}
}





