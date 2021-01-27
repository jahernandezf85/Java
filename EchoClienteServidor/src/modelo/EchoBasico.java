package modelo;

import java.util.Random;

public class EchoBasico implements Echo {

	private int maxRandomSize = 100;
	
	@Override
	public String responder(String entrada) {
		return entrada + " " + generarRandom();
	}

	@Override
	public int generarRandom() {
		return new Random().nextInt(maxRandomSize);
	}
	
}
