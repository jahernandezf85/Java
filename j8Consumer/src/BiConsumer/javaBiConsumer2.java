package BiConsumer;

import java.util.function.BiConsumer;

public class javaBiConsumer2 {

	public static void main(String[] args) {
		suma(1,2, (x,y) -> System.out.println(x + y));
		suma("Node", ".js", (x, y) -> System.out.println(x+y));

	}
	
	static <T> void suma(T a1, T a2, BiConsumer<T,T> c) {
		c.accept(a1, a2);
	}

}
