package ejercicio1;

public class ejer7 {
	
	public static void imprimir(Persona persona) {
		System.out.println(persona);
	}
	
	public static void imprimir(Animal animal) {
		System.out.println(animal);
	}

	public static void main(String[] args) {
		
		Persona p1 = new Persona("Jose", "C\\ abc", "123", 45);
		Persona p2 = new Persona("Juan", "c\\ hhhh", "2345");
		
		System.out.println(p1.getNombre());
		System.out.println(p1.getDireccion());
		System.out.println(p1.getTelefono());
		System.out.println(p1.getEdad());
		
		p1.setNombre("Jose Andres");
		p1.setEdad(55);
		
		imprimir(p1); 
		imprimir(p2);
		
		System.out.println("\n\n=====================================\n\n");
		
		System.out.println(p2.getNombre());
		System.out.println(p2.getDireccion());
		System.out.println(p2.getTelefono());
		System.out.println(p2.getEdad());
		
		Animal a1 = new Animal("Perro caniche", 7);
		Animal a2 = new Animal("Gato Siames", 3);
		
		a1.setEdad(8);
		a2.setRaza("Gato xxx");
		
		imprimir(a1);
		imprimir(a2);
	}

}
