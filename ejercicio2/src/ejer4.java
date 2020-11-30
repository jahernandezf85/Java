import java.util.ArrayList;

import clases.Producto;

public class ejer4 {
	
	public static void imprimir(ArrayList<Integer> li) {
		int i=0;
		for(Integer n:li) {
			System.out.println((i++)+" "+n);
		}
	}
	
	public static void imprimir2(ArrayList<Integer> li) {
		for(int i=0;i<li.size();i++) {
			System.out.println(i+" "+li.get(i));
		}
	}
	
	public static void imprimir_productos(ArrayList<Producto> li) {
		int i=0;
		System.out.println("\nImpresion de productos:\n");
		for(Producto p:li) {
			System.out.println((i++)+" "+p);
		}
	}
	
	public static float dime_precio(ArrayList<Producto> li, String producto) {
		for(Producto item : li)
			if(item.getNombre().compareToIgnoreCase(producto) == 0) {
				return item.getPrecio();
			}
		return -1f;
	}

	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		lista.add(10);
		lista.add(20);
		lista.add(30);
		lista.add(40);
		lista.add(50);
		lista.add(60);
		
		
		imprimir2(lista);
		
		lista.remove(1); 
		
		imprimir2(lista);
		
		lista.clear();
		
		lista.add(10);
		lista.add(20);
		lista.add(30);
		lista.add(40);
		lista.add(50);
		lista.add(60);
		
		System.out.println(lista.get(1));
		
		imprimir2(lista);
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(new Producto("Manzana", 1.5f, 30));
		productos.add(new Producto("Peras", 1.0f, 22));
		productos.add(new Producto("Kiwi", 2.5f, 45));
		productos.add(new Producto("Limones", 2.4f, 58));
		productos.add(new Producto("Melocotes", 2f, 23));
		productos.add(new Producto("Naranjas", 3.5f, 22));
		
		imprimir_productos(productos);
		
		float precio = dime_precio(productos, "Limones");
		if(precio==-1f) {
			System.out.println("El producto no existe");
		}else {
			System.out.println("El precio es: " + precio);
		}
				
		productos.add(1, new Producto("Cerezas", 2.3f, 22));
		
		imprimir_productos(productos);
		
		productos.set(1, new Producto("Sandias", 4.5f, 60));
		
		imprimir_productos(productos);
	}
}
