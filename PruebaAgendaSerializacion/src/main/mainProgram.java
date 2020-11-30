package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.TreeMap;

import clases.Persona;

public class mainProgram {

	static Scanner sc = new Scanner(System.in);
	static final String archivo = "C:\\Workspace\\PruebaAgendaSerializacion\\data\\data.dat";
	
	public static int menu() {
		int select;
		String[] opc = {"1.- Introducir Contacto", "2.- Buscar Contacto", "3.- Mostrar Contactos", "0.- Salir"};
		
		do {
			System.out.println();
			System.out.println("-----------MENU PRINCIPAL-------------");
			for(String opcion: opc) {
				System.out.println(opcion);
			}
			System.out.println();
			System.out.println("Introduzca una opcion: ");
			select = sc.nextInt();
			
			if(select < 0 || select >= opc.length) {
				System.out.println("Opcion no permitidda...");
			}
			
		}while(select < 0 || select >= opc.length);
		
		return select;
	}
	
	public static TreeMap<String, Persona> lecturaFichero() {
		File fichero = new File(archivo);
		TreeMap<String,Persona> agenda = new TreeMap<String, Persona>();
		if(!(fichero.exists() && fichero.isFile() && fichero.canRead())) {
			System.out.println("Error de lectura del fichero. Se podrían sobrescribir los datos");
			return agenda;
		}
		
		Persona persona;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));){
			
			while(true) {
				persona = (Persona) ois.readObject();
				agenda.put(persona.getNombre(), persona);
			}
			
		}catch(IOException | ClassNotFoundException e) {
			
		}
		return agenda; 
	}
	
	public static void escrituraFichero(TreeMap<String,Persona> agenda) {
		File fichero = new File(archivo);
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));){
			for(Persona p:agenda.values()) {
				oos.writeObject(p);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Persona nuevoContacto() {
		String nombre;
		String direccion;
		String telefono;
		
		sc.nextLine();
		System.out.println("Introduzca un nombre: ");
		nombre = sc.nextLine();
		System.out.println("Introduzca dirección: ");
		direccion = sc.nextLine();
		System.out.println("Introduzca telefono: ");
		telefono = sc.nextLine();
		
		return new Persona(nombre, direccion, telefono);
	}
	
	public static void mostrarContactos(TreeMap<String,Persona> agenda) {
		for(Persona p:agenda.values()) {
			System.out.println(p);
			System.out.println();
		}
	}
	
	public static void buscarContacto(TreeMap<String, Persona> agenda) {
		String patron;
		TreeMap<String, Persona> resul = new TreeMap<>();
		sc.nextLine();
		
		System.out.println("¿Que quieres buscar?: ");
		patron = sc.nextLine();
		for(String nombre: agenda.keySet()) {
			if(nombre.startsWith(patron)) {
				resul.put(nombre, agenda.get(nombre));
			}
		}
		if(resul.size()>0) {
			mostrarContactos(resul);
		}else {
			System.out.println("\nNo se han encontrado coincidencias\n");
		}
	}
	public static void main(String[] args) {
		int opc;
		File fichero = new File(archivo);
		TreeMap<String,Persona> agenda = new TreeMap<>();
		if(fichero.exists()) {
			agenda = lecturaFichero();
		}
		do {
			opc = menu();
			
			switch(opc) {
				case 1:
					Persona contacto = nuevoContacto();
					agenda.put(contacto.getNombre(), contacto);
					break;
				case 2:
					buscarContacto(agenda);
					break;
				case 3:
					mostrarContactos(agenda);
					break;
			}
			
		}while(opc!=0);
		
		escrituraFichero(agenda);
	}

}
