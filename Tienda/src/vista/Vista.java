package vista;

import java.time.LocalDate;
import java.util.Scanner;

import controlador.ControladorTienda;

public class Vista {
	ControladorTienda controlador;
	
	Vista() {
		controlador = new ControladorTienda();
	}
	
	public void ejecutar() {
		int opc = 0; 
		do {
			mostrarMenu();
			opc = new Scanner(System.in).nextInt();
			
			operaciones(opc);
		} while (opc != 0);
	}

	public static void main(String[] args) {
		new Vista().ejecutar();
	}
	
	public void mostrarMenu() {
		System.out.println(" ===== GESTION DE TIENDA =====");
		System.out.println();
		System.out.println("1.- Añadir Producto");
		System.out.println("2.- Vender Producto");
		System.out.println("3.- Eliminar Caducados");
		System.out.println("4.- Visualizar Stock");
		System.out.println();
		System.out.println("0.- Salir");
		System.out.println(" =============================");
		
		System.out.println("Eliga una opcion: ");
	}
	
	public void operaciones(int opc) {
		switch(opc) {
			case 0:
				break;
			case 1:
				controlador.IngresarProducto();
				break;
			case 2:
				vender();
				break;
			case 3:
				controlador.tirarCaducados(LocalDate.now());
				break;
			case 4:
				controlador.visualizarStock();
				break;
			default:
				System.out.println("Opcion no permitida");
				System.out.println();
		}
	}
	
	public void vender() {
		System.out.println("Introduzca el nombre del producto: ");
		String nombre = new Scanner(System.in).nextLine();
		System.out.println("Introduzca la cantidad: ");
		int cantidad = new Scanner(System.in).nextInt();
		
		
		controlador.vender(nombre, cantidad);
	}
}
