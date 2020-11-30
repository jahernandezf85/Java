package ejercicio1;

import java.io.*;

public class Leer {
	
	public static String dato() {
		String sdato = "";
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader flujoE = new BufferedReader(isr);
			sdato = flujoE.readLine();
			
		}catch(IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return sdato;
	}

}
