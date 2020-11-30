package ejercicio1;

import java.util.Scanner;

public class ejer5 {
	
	public static boolean bisiesto(int anno) {
		if((anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int calcularDias(int mes, int anno) {
		int ndias = -1;
		
		switch(mes) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				ndias=31;
				break;
			case 2:
				ndias=bisiesto(anno)?29:28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				ndias=30;
				break;
			default:
				ndias=-1;
				break;
		}
		
		return ndias;
	}
	public static void main(String[] args) {

		int mes=2;
		int ndias;
		int anno = 2000;
		Scanner sc = new Scanner(System.in);
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		
		for(int i=0;i<5;i++) {
			System.out.print("Introduzca un mes(1-12): ");
			mes = sc.nextInt();
			System.out.print("Introduzca un año: ");
			anno = sc.nextInt();
					
			ndias = calcularDias(mes, anno);
			
			if(ndias!=-1) {
				System.out.println("El mes de " + meses[mes-1] + " del año " + anno + " tiene " + ndias + " dias.");
			}else {
				System.out.println("Los meses tienen que entre 1 y 12");
			}
		}
		
		sc.close();
		
	}

}
