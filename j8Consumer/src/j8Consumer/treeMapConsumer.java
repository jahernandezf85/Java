package j8Consumer;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Consumer;

public class treeMapConsumer {

	public static void main(String[] args) {
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		map.put("Madrid", 10);
		map.put("Barcelona", 20);
		map.put("Sevilla", 30);
		
		Consumer<TreeMap<String, Integer>> c1 = new Consumer<TreeMap<String, Integer>>(){

			@Override
			public void accept(TreeMap<String, Integer> t) {
				for(Entry<String, Integer> b:t.entrySet()) {
					System.out.println(b.getKey() + " - " + b.getValue());
				}
									
			}
		};
		
		c1.accept(map);
		
		System.out.println();
		System.out.println();
		/*********************************************************************************************/
		Consumer<TreeMap<String,Integer>> c2 = (t) ->{
			for(Entry<String, Integer> b:t.entrySet()) {
				System.out.println(b.getKey() + " - " + b.getValue());
			}
		};

		c2.accept(map);
		
		System.out.println();
		System.out.println();
		Consumer<TreeMap<String,Integer>> modificar = (t) ->{
			for(String clave:t.keySet()) {
				t.put(clave, t.get(clave)+5);
			}
		};
		modificar.accept(map);
		c2.accept(map);
	}

}
