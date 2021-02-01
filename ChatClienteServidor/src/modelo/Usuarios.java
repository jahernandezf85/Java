package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Usuarios{
	private HashMap<String, String> userPass;
	private List<String> mensajesUser;
	private final int nMensajes;
	private String userActive;

	
	public Usuarios(){
		userPass = new HashMap<String, String>();
		userPass.put("user1", "pass1");
		userPass.put("User2", "pass2");
		userPass.put("user3", "pass3");
		userPass.put("user4", "pass4");
		mensajesUser = new ArrayList<String>();
		nMensajes = 50;
		userActive = "";
		
	}
	
	public void cargarMensajes(List<String> mensajesUser) {
		this.mensajesUser = mensajesUser;
	}

	public boolean login(String user, String pass) {
		boolean usuarioCorrecto = false;
		if(userPass.containsKey(user)) {
			if(userPass.get(user).equals(pass)) {
				usuarioCorrecto = true;
				userActive = user;
				} 
			}
		return usuarioCorrecto;
	}
	

	public void addMensaje(String user, String mensaje) {
		//TODO: test si funciona como pila
		if(mensajesUser.size() <= nMensajes) {
			mensajesUser.add(mensaje);
		} else {
			mensajesUser.remove(0);
		}
	}
	
	public String getUserActive() {
		return userActive;
	}
}
