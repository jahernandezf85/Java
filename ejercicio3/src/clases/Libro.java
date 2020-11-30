package clases;

public class Libro {

		private String isbn;
		private String autor;
		private String titulo;
		private String editorial;
		private int anno;
		public Libro(String isbn, String autor, String titulo, String editorial, int anno) {
			super();
			this.isbn = isbn;
			this.autor = autor;
			this.titulo = titulo;
			this.editorial = editorial;
			this.anno = anno;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public String getAutor() {
			return autor;
		}
		public void setAutor(String autor) {
			this.autor = autor;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getEditorial() {
			return editorial;
		}
		public void setEditorial(String editorial) {
			this.editorial = editorial;
		}
		public int getAnno() {
			return anno;
		}
		public void setAnno(int anno) {
			this.anno = anno;
		}
		@Override
		public String toString() {
			return "Libro [isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + ", editorial=" + editorial
					+ ", anno=" + anno + "]";
		}
		
		
}

