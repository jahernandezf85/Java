package ejercicio1;

public class ejer4 {
	
	public static void imprimir(int n) {
		for(int i=0;i<=10;i++) {
			System.out.print((i*n) + "\t");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		
		int nmeses = meses.length;
		System.out.println(nmeses);
		for(int i=0; i < meses.length;i++) {
			System.out.println(i+" "+meses[i]);
		}
		
		for (String mes : meses) {
			System.out.println(mes);
		}
	}

}
