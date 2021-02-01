import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class CreadorDoc {

	
	public CreadorDoc() {
		
	}
	//marshalling
	Document formarDocumento() {
		
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
			Node raiz = doc.createElement("Empresa");
	
			doc.appendChild(raiz);
			Node direccion = doc.createElement("Direccion");
			Node calle = doc.createElement("Calle");
			calle.appendChild(doc.createTextNode("calle sesamo"));
			direccion.appendChild(calle);
			/*Element CP = doc.createElement("CP");
			CP.setAttribute(name, value);*/
			Node  CP = doc.createElement("CP");
			((Element) CP).setAttribute("cp", "28053");
			direccion.appendChild(CP);
			raiz.appendChild(direccion);
			Node empleado = leerEmpleado(doc);
			while(empleado!= null) {
				raiz.appendChild(empleado);
				empleado = leerEmpleado(doc);
			}
			
			return doc;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	Node leerEmpleado(Document doc) {
		Node empleado = null;
		System.out.println("Nombre de empleado:");
		String nombre = new Scanner(System.in).nextLine();
		if(!nombre.equals("")) {
			System.out.println("Sueldo de empleado:");
			String sueldo = new Scanner(System.in).nextLine();
			empleado = doc.createElement("Empleado");
			Node nNombre = doc.createElement("Nombre");
			nNombre.appendChild(doc.createTextNode(nombre));
			Node nSueldo = doc.createElement("Sueldo");
			nSueldo.appendChild(doc.createTextNode(sueldo));
			empleado.appendChild(nNombre);
			empleado.appendChild(nSueldo);
		}
		return empleado;
	}
	
	
	void imprimirXML(OutputStream salida, Document doc) {
        Source source = new DOMSource(doc);
        //Indicamos donde lo queremos almacenar
        Result result = new StreamResult(salida); //nombre del archivo
        Transformer transformer;	
		try {
			transformer = TransformerFactory.newInstance().newTransformer(); 
			transformer.transform(source, result);
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     
	}

public static void main(String[] args) throws FileNotFoundException {
	CreadorDoc cd= new CreadorDoc();
	
	cd.imprimirXML(new FileOutputStream(new File("empresa.xml")), cd.formarDocumento());
}
}
