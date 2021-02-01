import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CreadorJson {

	
	JsonElement crearJson() {
		List<Persona> personas = new ArrayList();
		Persona p1 = new Persona("pepito", 14);
		p1.add(1111).add(2222);
		personas.add(p1);
		Persona p2 = new Persona("juanito", 12);
		p2.add(00001).add(66666);
		personas.add(p2);
		
		return new Gson().toJsonTree(personas);
	}
	
	List<Persona> leerDesdeJson(String texto){
		JsonElement doc = new JsonParser().parse(texto);
		List<Persona> lista = new ArrayList();
		if(doc.isJsonArray()) {
			for(JsonElement elemento: doc.getAsJsonArray()) {
				if(elemento.isJsonObject()) {
					JsonObject valor = elemento.getAsJsonObject();
					String nombre ="";
					int edad = 0;
					if(valor.has("nombre")) nombre = valor.get("nombre").getAsString();
					if(valor.has("edad")) edad = valor.get("edad").getAsInt();
					Persona p = new Persona(nombre, edad);
					if(valor.has("telefonos") && valor.get("telefonos").isJsonArray()) {
						for(JsonElement e: valor.getAsJsonArray("telefonos")) {
							p.add(e.getAsInt());
						}
					}
					lista.add(p);
				}
			}
		}
		return lista;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(new CreadorJson().crearJson());
		FileWriter salida = new FileWriter(new File("salida.txt"));
		salida.write(new CreadorJson().crearJson().toString());;
		salida.close();
		String txt = new CreadorJson().crearJson().toString();
		System.out.println(new CreadorJson().leerDesdeJson(txt));
	}
}


class Persona{
	private String nombre;
	private int edad;
	private List<Integer> telefonos;
	
	Persona(){
		telefonos = new ArrayList();
	}
	
	

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.telefonos = new ArrayList();;
	}



	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public List<Integer> getTelefonos() {
		return telefonos;
	}
	
	public Persona add(int tel) {
		telefonos.add(tel);
		return this;
	}



	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", telefonos=" + telefonos + "]";
	}
	
	
}