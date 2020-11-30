import clases.*;

public class ejer02 {
	
	public static void imprimir(Persona[] personas) {
		for(int i=0;i<personas.length;i++) {
			System.out.println(i+" "+personas[i]);
		}
	}
	
	public static void imprimir(Animal[] animal) {
		for(int i=0;i<animal.length;i++) {
			System.out.println(i+" "+animal[i]);
		}
	}
	
	public static void imprimir(Persona[][] personas) {
		for(int i=0;i<personas.length;i++) {
			imprimir(personas[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Persona p1 = new Persona("Jose", "c\\abc", "123", 45);
		Animal a1 = new Animal("gato", 3);
		
		System.out.println(p1);
		System.out.println(a1);
		
		Persona[] familiar = new Persona[5];
		
		Persona[][] familiares = new Persona[2][5];
		
		
		
		familiar[0]=new Persona("Juan","C\\asdf","123", 20);
		familiar[1]=new Persona("Jose","C\\rews","134", 34);
		familiar[2]=new Persona("Andres","c\\asdgf","4342",43);
		familiar[3]=new Persona("Julio","c\\asdji","41552", 25);
		familiar[4]=new Persona("maria","C\\asdfj","9853", 23);
		
		familiares[0] = familiar;
		familiares[1] = familiar;
		
		imprimir(familiares);
		
		System.out.println("===================================");
		
		imprimir(familiar);
		
		Animal[] zoo = new Animal[] {new Animal("Perro", 3), new Animal("Gato", 2), new Animal("Hamster", 1)};
		
		imprimir(zoo);
		

	}
}
