import java.util.ArrayList;

import clases.*;

public class ejer5 {
	
	public static void main(String[] args) {
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		Categoria c1 = new Categoria(1, "Frutas");
		Categoria c2 = new Categoria(2, "Verduras");
		productos.add(new Producto("Peras", 3.5f, 25, c1));
		productos.add(new Producto("Uvas", 2.5f, 30, c1));
		productos.add(new Producto("Manzanas", 2.3f, 40, c1));
		productos.add(new Producto("Melocotones", 1.4f, 45, c1));
				
		System.out.println(productos.get(0));
		
		productos.get(0).setCategoria(c2);
		
		System.out.println(productos.get(0));
		
		
	}

}
