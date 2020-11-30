
public class ejer1 {

		public static void incrementar(int m) {
			m=m+2;
		}
		
		public static void incrementar(int[] tb) {
			for(int i=0;i<tb.length;i++) {
				tb[i] += 20;
			}
		}
		
		public static void main(String[] args) {
			int n=10;
			
			System.out.println(n);
			incrementar(n);
			System.out.println(n);
			
			
			int[] ta = {1, 2, 3, 4, 5};
			for(int item:ta) {
				System.out.println(item);
			}
			incrementar(ta);
			for(int item:ta) {
				System.out.println(item);
			}
			
			
		}
}
