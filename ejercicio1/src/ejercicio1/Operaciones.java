package ejercicio1;

import java.util.Scanner;

public class Operaciones {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void sumar() {
		int num1, num2, resul; 
		num1=pedirOperando("primer");
		num2=pedirOperando("segundo");
		
		resul=num1+num2;
		
		System.out.printf("%d + %d = %d\n", num1,num2,resul);
		
		esperar();
	}
	
	public static void restar() {
		int num1, num2, resul; 
		num1=pedirOperando("primer");
		num2=pedirOperando("segundo");
		
		resul=num1-num2;
		
		System.out.printf("%d - %d = %d\n", num1,num2,resul);
		
		esperar();
	}
	
	public static void multiplicar() {
		int num1, num2, resul; 
		num1=pedirOperando("primer");
		num2=pedirOperando("segundo");
		
		resul=num1*num2;
		
		System.out.printf("%d X %d = %d\n", num1,num2,resul);
	
		esperar();
	}
	
	public static void dividir() {
		int num1, num2;
		float resul;
		num1=pedirOperando("primer");
		num2=pedirOperando("segundo");
		
		resul=(float)num1/(float)num2;
		
		System.out.printf("%d / %d = %.2f\n", num1,num2,resul);
		
		esperar();
	}
	
	public static int pedirOperando(String ordenOperando) {
		int op;
		System.out.println("Introduzca " + ordenOperando + " operando: ");
		op = sc.nextInt();
		return op;
	}
	
	public static void clearScreen() {
		for(int i=0;i<200;i++) System.out.println();
	}
	
	public static void esperar() {
		String basura;
		System.out.println("Pulse Intro para continuar...");
		basura = Leer.dato();
		clearScreen();
	}
}
