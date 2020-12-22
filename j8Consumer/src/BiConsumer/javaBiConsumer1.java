package BiConsumer;

import java.util.TreeMap;
import java.util.function.BiConsumer;

public class javaBiConsumer1 {
	
	public static void primero() {
		BiConsumer<Integer, Integer> bic1=new BiConsumer<Integer,Integer>(){

			@Override
			public void accept(Integer t, Integer u) {
				System.out.println(t+u);
			}
		};
		
		bic1.accept(10,25);
		
		BiConsumer<Integer, Integer> bic2=(x,y) -> System.out.println(x+y);
		
		bic2.accept(5, 3);
	}

	public static void segundo() {
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		map.put("Madrid", 10);
		map.put("Barcelona", 20);
		map.put("Sevilla", 30);
		
		BiConsumer<TreeMap<String,Integer>,Integer> bic1 = new BiConsumer<TreeMap<String,Integer>, Integer>(){

			@Override
			public void accept(TreeMap<String, Integer> t, Integer u) {
				for(String clave:t.keySet()) {
					t.put(clave, t.get(clave)+u);
				}
				
			}
			
		};
		bic1.accept(map, 5);
		
		for(String clave:map.keySet()) {
			System.out.println(clave + " - " + map.get(clave));
		}
		
		System.out.println();
		System.out.println();
		/*****************************************************************************************************/
		BiConsumer<TreeMap<String,Integer>, Integer> bic2=(t,u) ->{
			for(String clave:t.keySet()) {
				t.put(clave, t.get(clave)+u);
			}
		};
		
		bic2.accept(map, 3);
		for(String clave:map.keySet()) {
			System.out.println(clave + " - " + map.get(clave));
		}
	}
	public static void main(String[] args) {
		 
		//primero();
		segundo();
		
	}

}
