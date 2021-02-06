package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.GestionTienda;
import modelo.Producto;

public class ControladorTienda {
	GestionTienda gestion;
	
	public ControladorTienda(){
		gestion = new GestionTienda();
	}
	
	private void add(String nombre, int codigo, int cantidad, LocalDate fechaCaducidad ) {
		Producto p = new Producto(nombre, codigo, cantidad, fechaCaducidad);
		gestion.add(p);
	}
	
	public void IngresarProducto() {
		System.out.println("Introduce el nombre del producto: ");
		String nombre = new Scanner(System.in).nextLine();
		System.out.println("Introduce el codigo de lote: ");
		int codigo = new Scanner(System.in).nextInt();
		System.out.println("Introduce la cantidad: ");
		int cantidad = new Scanner(System.in).nextInt();
		System.out.println("Introduzca la fecha de caducidad (dd/mm/aaaa");
		String cadenaFecha = new Scanner(System.in).nextLine();
		int dia, mes, ano;
		String[] parte = cadenaFecha.split("/");
		dia = Integer.parseInt(parte[0]);
		mes = Integer.parseInt(parte[1]);
		ano = Integer.parseInt(parte[2]);
		
		LocalDate fechaCaducidad = LocalDate.of(ano, mes, dia);
		this.add(nombre, codigo, cantidad, fechaCaducidad);
	}
	
	public void vender(String nombre, int cantidad) {
		if(gestion.vender(nombre, cantidad)) {
			System.out.println("Venta realizada correctamente.");
		} else {
			System.out.println("El producto " + nombre + " no existe.");
		}
	}
	
	public void tirarCaducados(LocalDate fecha) {
		List<Producto> caducados = new ArrayList<Producto>();
		caducados = gestion.tirarCaducados(fecha);
		System.out.println("Productos caducados: ");
		
		for(Producto p : caducados) {
			System.out.println(p.toString());
		}
	}
	
	public void visualizarStock() {
		System.out.println((gestion.visualizarStock()).toString());
	}
}
