package modelo;

public class CalculoBasico implements Calculo{

	@Override
	public double sumar(double op1, double op2) {
		return op1 + op2;
	}

	@Override
	public double restar(double op1, double op2) {
		return op1 - op2;
	}

	@Override
	public double multiplicar(double op1, double op2) {
		return op1*op2;
	}

	@Override
	public double valorAbsoluto(double op) {
		return Math.abs(op);
	}

}
