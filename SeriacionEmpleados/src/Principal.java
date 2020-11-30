import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal {
	
	public static void crear() {
		File fichero = new File("C:\\Users\\ache_\\OneDrive\\Documentos\\datos\\seriacionEmpleados.dat");
		
		Empleado perez = new Empleado(1,"Jose","Perez");
		Empleado ruiz = new Empleado(2,"Juan","Ruiz");
		Empleado rayo = new Empleado(3,"Ana","Rayo");
		Empleado nuevo = new Empleado(4,"Manuel", "Dominguez");
		
		if(fichero.exists()) {
			try(MiObjectOutputStream oos = new MiObjectOutputStream(new FileOutputStream(fichero, true));){
				
				
				oos.writeObject(nuevo);
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));){
				
				oos.writeObject(perez);
				oos.writeObject(ruiz);
				oos.writeObject(rayo);
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void lectura() throws ClassNotFoundException {
		File fichero = new File("C:\\Users\\ache_\\OneDrive\\Documentos\\datos\\seriacionEmpleados.dat");
		
		if(!(fichero.exists() && fichero.isFile() && fichero.canRead())) {
			System.out.println("Error de lectura del fichero");
			return;
		}
		
		Empleado empleado;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));){
			
			while(true) {
				empleado = (Empleado) ois.readObject();
				System.out.println(empleado);
			}
			
		}catch(IOException e) {
			
		}
	}
	public static void main(String[] args) throws ClassNotFoundException {
		
		crear();
		lectura();
	}

}
