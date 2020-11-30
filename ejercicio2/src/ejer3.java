import clases.Producto;

public class ejer3 {
	
	public static void imprimir(Producto[] productos) {
		for(int i=0;i<productos.length;i++) {
			System.out.println(productos[i]);
		}
	}
	
	public static void incrementar(Producto[] productos, float inc) {
		for(int i=0;i<productos.length;i++) {
			productos[i].setPrecio(productos[i].getPrecio()+inc);;
		}
	}
	
	public static void incrementar_existencias(Producto[] productos) {
		for(int i=0;i<productos.length;i++) {
			if(productos[i].getNexistencias() < 50) {
				productos[i].setNexistencias(productos[i].getNexistencias()+25);
			}
		}
	}
	
	public static float dime_precio(Producto[] productos, String nombreProducto) {
		for(int i=0;i<productos.length;i++) {
			if(productos[i].getNombre().compareToIgnoreCase(nombreProducto)==0) {
				return productos[i].getPrecio();
			}
		}
		return -1f;
	}

	public static void ejemplo_continue() {
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				continue;
			}
			System.out.println(i + " es impar.");
		}
	}
	public static void main(String[] args) {
		
		Producto[] p1 = new Producto[5];
		
		p1[0] = new Producto("Peras", 1.59f);
		p1[1] = new Producto("Platanos", 2f, 30);
		p1[2] = new Producto("Uvas", 3.5f, 40);
		p1[3] = new Producto("Manzanas", 2.50f);
		p1[4] = new Producto("Melocotones", 4.5f, 50);
		
		imprimir(p1);
		System.out.println("Realizando incremento e precio");
		incrementar(p1,1f);
		imprimir(p1);
		System.out.println("Realiznaod incremente de existencias");
		incrementar_existencias(p1);
		imprimir(p1);
		
		System.out.println("El precio de las uvas es: " + dime_precio(p1, "uvas"));
		System.out.println("El precio de las mandarinas es: " + dime_precio(p1, "mandarinas"));
		
		ejemplo_continue();
		
	}

}
