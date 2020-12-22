package BiConsumer;

import java.util.function.BiConsumer;

public class javaBiConsumer1 {

	public static void main(String[] args) {
		
		BiConsumer<Integer, Integer> bic1=new BiConsumer<Integer,Integer>(){

			@Override
			public void accept(Integer t, Integer u) {
				System.out.println(t+u);
			}
		};
		
		bic1.accept(10,25);
	}

}
