import java.util.TreeMap;
import java.io.*;

public class Principal {
	public static void rellenar(TreeMap<String, Producto> productos) {
		productos.put("Manzanas", new Producto("Manzana", 10, 1.5));
		productos.put("Limones", new Producto("Limones", 23, 0.75));
		productos.put("Peras", new Producto("Peras", 27, 1.23));
		productos.put("Naranjas", new Producto("Naranjas", 22, 1.48));
		productos.put("Fresas", new Producto("Fresas", 15, 3.25));
		
	}
	
	public static void escribirFichero(TreeMap<String, Producto> productos, File fichero) {
		try(DataOutputStream dw=new DataOutputStream(new FileOutputStream(fichero));){
			for(Producto p:productos.values()) {
				dw.writeUTF(p.getNombre());
				dw.writeInt(p.getUnidades());
				dw.writeDouble(p.getPrecio());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void lectura(File fichero) {
		if(!(fichero.exists() && fichero.isFile() && fichero.canRead())) {
			System.out.println("El fichero no existe");
			return;
		}
		String nombre;
		int existencias;
		double precio;
		try(DataInputStream dr=new DataInputStream(new FileInputStream(fichero));){
			while(true) {
				nombre = dr.readUTF();
				existencias = dr.readInt();
				precio = dr.readDouble();
				
				System.out.printf("%s %d %10.2f\n", nombre,existencias,precio);
			}
		}catch(IOException e) {
			
		}
	}
	
	public static void main(String[] args) {
		File fichero = new File("C:\\Users\\ache_\\OneDrive\\Documentos\\datos\\datosproductos.dat");
		TreeMap<String, Producto> productos = new TreeMap<>();
		
		rellenar(productos);
		escribirFichero(productos, fichero);
		lectura(fichero);
		
	}
}
