package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Datos {
		private HashMap<String, String> dataUsers;
		private HashMap<String, List<String>> msgsUsers;
		private List<String> conectedUsers;
		private final int nMensajes;
	
		public Datos(){
			dataUsers = new HashMap<String, String>();
			dataUsers.put("user1", "pass1");
			dataUsers.put("user2", "pass2");
			dataUsers.put("user3", "pass3");
			dataUsers.put("user4", "pass4");
			msgsUsers = new HashMap<String, List<String>>();
			conectedUsers = new ArrayList<String>();
			nMensajes = 50;	
		}
		
		public HashMap<String, List<String>> getMsgsUsers(){
			return msgsUsers;
		}
		
		public List<String> getConectedUsers(){
			return conectedUsers;
		}
		
		public void addMsgsUsers(String user, String msg) {
			List<String> listaMsgs = new ArrayList<String>();
			listaMsgs.add(msg);
			if(msgsUsers.containsKey(user)) {
				listaMsgs = msgsUsers.get(user);
				if(listaMsgs.size() >= nMensajes) {
					listaMsgs.remove(0);
					listaMsgs.add(msg);
				}
			}
			msgsUsers.put(user, listaMsgs);
		}
		
		public void addConectedUser(String user) {
			conectedUsers.add(user);
		}
		
		public void removeConectedUser(String user) {
			conectedUsers.remove(user);
		}
		
		public boolean login(String user, String pass) {
			boolean loginCorrecto = false;
			if(dataUsers.containsKey(user) && dataUsers.get(user).equals(pass)) {
				loginCorrecto = true;
				addConectedUser(user);
			}
			return loginCorrecto;
		}
		
		public void userMsg(String user, String msg) {
			addMsgsUsers(user, msg);
		}
		
		public void logout(String user) {
			removeConectedUser(user);
		}
}
