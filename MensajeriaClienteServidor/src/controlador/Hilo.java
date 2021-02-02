package controlador;

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

import modelo.Datos;

public class Hilo extends Thread{
	private Socket socket;
	private Datos datos;
	private HashMap<String, Integer> operaciones;
	private final String PROTOCOLO;
	String user;
	private ControladorChat padre;
	
	public Hilo(Socket socket, Datos datos, ControladorChat padre) {
		this.socket = socket;
		this.datos = datos;
		operaciones = new HashMap<String, Integer>();
		operaciones.put("login", 2);
		operaciones.put("sendMensaje", 2);
		operaciones.put("logout", 1);
		PROTOCOLO = new Gson().toJsonTree(operaciones).toString();
		this.padre = padre;
		
	}
	
	@Override
	public void run() {
		BufferedReader entrada= null;
		BufferedWriter salida = null;
		try {
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			salida.write(PROTOCOLO);
			salida.newLine();
			salida.flush();
			String respuesta;
			Operacion op = leerOperacion(entrada);
			while(!op.getOperacion().equals("logout")) {
				if(op.getOperacion().equals("login") || datos.getConectedUsers().contains(op.getOperandos().get(0))) {
					System.out.println((op.getOperandos().get(0).toString() + " - " +  op.getOperandos().get(1).toString()));
					boolean loginOk = datos.login(op.getOperandos().get(0), op.getOperandos().get(1));
					if(!loginOk) {
						salida.write("Error");
						salida.newLine();
						salida.flush();
						
					
					}else {
					user = op.getOperandos().get(0);
					respuesta = "login:" + user + ":" + op.getOperandos().get(1);
					salida.write(respuesta);
					salida.newLine();
					salida.flush();
					}
					switch(op.getOperacion()) {
					case "sendMensaje":
						datos.addMsgsUsers(op.getOperandos().get(0), op.getOperandos().get(1));
						respuesta = "msg:" + user + ":" + op.getOperandos().get(1);
						padre.sendMensaje(respuesta);
						break;
					}
					op = leerOperacion(entrada);
				}
			}
			respuesta = "logout:" + user;
			salida.write(respuesta);
			salida.newLine();
			salida.flush();
		} catch (IOException  e) {
			System.out.println("[LOG]: El usuario se ha desconectado del servidor");
		} finally {
			if(!user.equals("")) {
				datos.logout(user);
			}
			try {
				socket.close();
			} catch (IOException e) {
			
			}
		}
		
	}
	
	private Operacion leerOperacion(BufferedReader entrada) throws IOException {
		List<String> operandos = new ArrayList<String>();
		String op = "";
		JsonElement doc = new JsonParser().parse(entrada.readLine());
		if(doc.isJsonObject()) {
			JsonObject valor = doc.getAsJsonObject();
			if (valor.has("operacion")) op = valor.get("operacion").getAsString();
			if (valor.has("operandos") && valor.get("operandos").isJsonArray()) {
				for(JsonElement e : valor.get("operandos").getAsJsonArray()) {
					operandos.add(e.getAsString());
				}
			}
		}		
		return new Operacion(op, operandos);
	}
	
	public void sendMensaje(String mensaje) {
		
		try {
			BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			salida.write(mensaje);
			salida.newLine();
			salida.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[ERROR]: Conexion con el cliente perdida");
		}
		
		
		
	}
}

