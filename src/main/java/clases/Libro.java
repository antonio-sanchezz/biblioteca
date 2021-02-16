package clases;

import java.util.Comparator;

public class Libro implements Comparable<Libro>, Comparator<Libro> {

	private String titulo;
	private String isbn;
	private Genero genero;
	private String autor;
	private Integer paginas;

	public Libro() {

	}

	/**
	 * @param titulo
	 * @param isbn
	 * @param genero
	 * @param autor
	 * @param paginas
	 */
	public Libro(String titulo, String isbn, Genero genero, String autor, Integer paginas) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.genero = genero;
		this.autor = autor;
		this.paginas = paginas;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the genero
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the paginas
	 */
	public Integer getPaginas() {
		return paginas;
	}

	/**
	 * @param paginas the paginas to set
	 */
	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	/**
	 * @return devuelve la siguiente cadena "Titulo ISBN Genero Autor Paginas".
	 */
	public String toString() {
		return "Titulo: " + titulo + " ISBN: " + isbn + " Genero: " + genero + " Autor: " + autor + " Paginas: "
				+ paginas;
	}

	@Override
	public int compareTo(Libro o) {

		return (this.titulo).compareToIgnoreCase(o.titulo);
	}

	@Override
	public boolean equals(Object o) {

		boolean validador = false;

		if (!(o instanceof Libro)) {
			throw new ClassCastException("El objeto introducido no es valido");
		} else {
			Libro libro = (Libro) o;
			if (this == o) {
				validador = true;
			} else {
				// Comprobamos si los ISBN son iguales, ignorando mayusculas y minusculas.
				if ((this.isbn).equalsIgnoreCase(libro.isbn)) {
					validador = true;
				}
			}
		}
		return validador;
	}

	@Override
	public int compare(Libro o1, Libro o2) {
		return o1.paginas.compareTo(o2.paginas);
	}

	public String getText() {
		return titulo + "," + isbn + "," + genero + "," + autor + "," + paginas;
	}

}
