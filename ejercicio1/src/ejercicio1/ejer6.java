package ejercicio1;

import java.util.Scanner;

public class ejer6 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int menu() {
		int opc;
		
		System.out.println("********CALCULADORA***********");
		System.out.println("1.- Suma");
		System.out.println("2.- Resta");
		System.out.println("3.- Multiplicacion");
		System.out.println("4.- Division");
		System.out.println("");
		System.out.println("0.- Salir");
		System.out.println("******************************");
		System.out.println("Eliga una opcion: ");
		
		opc = sc.nextInt();
		
		return opc;
	}
	
	public static void main(String[] args) {

		int opc=0;
			
		do {
			opc=menu();
										
			switch(opc) {
				case 1:
					Operaciones.sumar();
					break;
				case 2:
					Operaciones.restar();
					break;
				case 3:
					Operaciones.multiplicar();
					break;
				case 4:
					Operaciones.dividir();
					break;
				case 0:
					System.out.println("Hasta la proxima...");
					break;
				default:
					System.out.println("Opcion no valida");
					Operaciones.esperar();
					break;
			}
		}while(opc!=0);
		
		
	}

}
