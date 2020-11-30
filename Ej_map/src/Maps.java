import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Maps {
	
	public static void Ejemplo_HashMap() {
		System.out.println("************* HashMap ***************");
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "Casillas");
		map.put(3, "Pique");
		map.put(11, "Capdevila");
		map.put(16, "Busquets");
		map.put(18, "Pedrito");
		map.put(7, "Villa");
		map.put(15, "Ramos");
		map.put(5, "Puyol");
		map.put(14, "Xabi Alonso");
		map.put(8,  "Xavi Hernandez");
		map.put(6, "Iniesta");
		
		System.out.println("********************* HashMap : Iteradores ******************");
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
		}
		/*********************************************************************************/
		System.out.println("********************* HashMap : Valores ******************");
		for(String item : map.values()) {
			System.out.println(item);
		}
		/*********************************************************************************/
		System.out.println("********************* HashMap : KeySet ******************");
		for(int item : map.keySet()) {
			System.out.println("Clave=" + item + " Valor=" + map.get(item));
		}
		/*********************************************************************************/

	}

	public static void main(String[] args) {

		Ejemplo_HashMap();
		
	}

}
