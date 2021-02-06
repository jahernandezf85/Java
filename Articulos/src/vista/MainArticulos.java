package vista;

import java.time.LocalDate;

import controlador.EstructuraArticulos;
import modelo.Articulo;
import modelo.ArticuloRevista;
import modelo.ArticuloWeb;

public class MainArticulos {
	
	public void ejectuar() {
		EstructuraArticulos articulos = new EstructuraArticulos();
		articulos.add(new ArticuloWeb("pepe", "111111", LocalDate.of(2020, 12, 22), "www.todoarticulos.com"));
		articulos.add(new ArticuloWeb("juan", "222222", LocalDate.of(2020, 11, 15), "www.todoarticulos.com"));
		articulos.add(new ArticuloWeb("pepe", "333333", LocalDate.of(2021, 01, 06), "www.articulin.com"));
		articulos.add(new ArticuloWeb("manuel", "333333", LocalDate.of(2019, 01, 06), "www.as.com")); //no se deberia agregar
		articulos.add(new ArticuloRevista("juan", "444444", LocalDate.of(2020, 10, 10), 23));
		articulos.add(new ArticuloRevista("luis", "555555", LocalDate.of(2021, 02, 02), 12));
		articulos.add(new ArticuloRevista("luis", "666666", LocalDate.of(2021, 02, 02), 43));
		articulos.add(new ArticuloRevista("pepe", "777777", LocalDate.of(2020, 12, 05), 3)); //si se deberia agregar
		
		System.out.println(articulos.toString());
		
		System.out.println("=========== Articulos de pepe ===========");
		for(Articulo articulo: articulos.obtenerPorAutor("pepe")) {
			System.out.println(articulo.toString());
		}
		
		System.out.println("========= Articulos Febrero 2021 ========");
		for(Articulo articulo: articulos.obtenerPorFechas(LocalDate.of(2021, 02, 01), LocalDate.of(2021, 03, 01))) {
			System.out.println(articulo.toString());
		}
	}
	
	public static void main(String[] args) {
		new MainArticulos().ejectuar();
	}
	
}
