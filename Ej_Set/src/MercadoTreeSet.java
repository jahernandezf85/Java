import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class MercadoTreeSet {
	
	public static void mostrarLista(TreeSet<Producto> lista) {
		System.out.println("Lista del mercado con " + lista.size() + " productos.");
		for(Iterator it = lista.iterator();it.hasNext();) {
			Producto producto = (Producto) it.next();
			System.out.println(producto);
			}
		}
	public static void main(String[] args) {

		Producto pan = new Producto("Pan", 6);
		Producto leche = new Producto("Leche", 2);
		Producto manzanas = new Producto("Manzanas", 5);
		Producto brocoli = new Producto("Brocoli", 2);
		Producto carne = new Producto("Carne", 2);
		Producto res = new Producto("Carne", 3);
		
		TreeSet<Producto> lista = new TreeSet<Producto>();
		
		lista.add(pan);
		lista.add(leche);
		lista.add(manzanas);
		lista.add(brocoli);
		lista.add(carne);
		lista.add(res);
		
		lista.add(new Producto("Carne", 4));
		lista.add(new Producto("Carne", 5));
		lista.add(new Producto("Carne", 6));
		
		mostrarLista(lista);
		
		//for(Producto producto : lista) System.out.println(producto);

		/*lista.remove(manzanas);
		mostrarLista(lista);
		
		lista.clear();
		mostrarLista(lista);*/
	}

}
