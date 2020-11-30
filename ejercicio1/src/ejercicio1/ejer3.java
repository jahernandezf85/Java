package ejercicio1;

public class ejer3 {

	public static void imprimir(int n) {
		for(int i=0;i<=10;i++) {
			if(n<10) {
				System.out.print(" " + n + "X" + i + "=" + (i*n) + "\t");
			}else {
				System.out.print(n + "X" + i + "=" + (i*n) + "\t");
			}
		}
		System.out.println("");
	}
	
	public static int multiplicar(int n) {
		return n*33;
	}
	
	public static void main(String[] args) {
		
		/*
		for(int i=0;i<=25;i+=5) {
			System.out.println(i);
		}
		
		int j = 0;
		while(j<=100) {
			System.out.println(j);
			j+=10;
		}
		
		int k=0;
		do {
			System.out.println(k);
			k+=2;
		} while (k<=20);
		*/
		
		for (int i=0; i<=10;i++) {
			imprimir(i);
		}
		
		System.out.println(multiplicar(2));

	}

}
