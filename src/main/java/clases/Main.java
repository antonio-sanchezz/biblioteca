/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package clases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main (String [] args) {
    	
    	ArrayList<Libro> catalogo = new ArrayList<Libro>();
    	
    	while(true) {
    		int opcion = menu();
    		switch (opcion) {
			case 1:
				//TODO Alta de Libro
				//titulo:isbn:genero:autor:paginas
				alta(catalogo);
				break;
			case 2:
				listarLibros(catalogo);
				break;
			case 3:
				baja(catalogo);
				break;
			default:
				break;
			}
    	}
    }
    
    private static int menu() {
    	int opcion=0;
    	
    	do {
    		System.out.println("Opciones:");
    		System.out.println("1. Alta de Libro");
    		System.out.println("2. Lista de Libros");
    		System.out.println("3. Baja de Libros");
    		System.out.println("4. Búsqueda de Libros");
    		System.out.println("5. Ordenacion de Libros");
    		System.out.println("Introduce la opcion:");
    	
    		opcion = leerOpcion(5);
    		
    	}while(opcion <=0);
    	
    	return opcion;
    }
    
    private static int leerOpcion(int max) {
    	int opcion = -1;
    	try {
    		Scanner teclado = new Scanner(System.in);
    		opcion=teclado.nextInt();
    		if(opcion>max)
    			opcion=-1;
    	}catch (InputMismatchException e) {
			System.out.println("Opción incorrecta");
		}
    	
    	return opcion;
    }
    
    private static void alta(ArrayList<Libro> catalogo) {
    	//Leer de la entrada
    	String datosLibro = obtenerDatosLibro();
    	//titulo:isbn:genero:autor:paginas
    	//Procesar la entrada
    	Libro libro = procesaEntrada(datosLibro);
    	//Crear el libro con los datos de la entrada
    	catalogo.add(libro);
    	//Meter el libro en el catalogo
    }
    
    private static void baja(ArrayList<Libro> catalogo) {
    	Scanner teclado = new Scanner(System.in);
    	System.out.println("¿Que libro quiere borrar? Indique el indice.");
    	int opcion = teclado.nextInt();
    	
    	// Eliminamos el indice dado.
    	catalogo.remove(opcion);

    }
    
    private static void buscarLibros(ArrayList<Libro> catalogo) {
    	// Mediante ISBN, puede haber varios libros con el mismo ISBN, tenerlo en cuenta a la hora de eliminarlo.
    	// indexOf(Object o)
    }
    
    private static void ordenarLibros(ArrayList<Libro> catalogo) {
    	// catalogo.sort
    	// 1. Titulo - Orden alfabetico, ignorar mayusculas y minusculas.
    	// 2. Una vez hecho el primero, ordenar por numero de paginas. (compare(Object a, Object b))
    }
    
    private static void listarLibros(ArrayList<Libro> catalogo) {
    	for(int i = 0; i < catalogo.size(); i++) {
    		  System.out.println(i + " - " + catalogo.get(i));
    		}
    }
    
    private static String obtenerDatosLibro() {
    	String datos=null;
    	
    	boolean validado=false;
    	while(!validado) {
    		System.out.println("Introduce los datos de un libro.");
    		System.out.println("Usa el formato \"titulo:isbn:genero:autor:paginas\"");
    		try {
    			datos = leerCadena();
    			if(true)//Supongo de momento que valida siempre
    				validado=true;
    		}catch (InputMismatchException e) {
				System.out.println("Datos de entrada no válidos");
			}
    	}
    	
    	return datos;
    }
    
    private static Libro procesaEntrada(String entrada) {
    	Libro libro = null;
    	
    	String [] datos = entrada.split(":");
    	
    	String titulo = datos[0];
    	String isbn = datos[1];
    	Genero genero = Genero.getGenero(datos[2]);
    	String autor = datos[3];
    	Integer paginas = Integer.parseInt(datos[4]);
    	
    	// Celestina:0-3538-1166-1:novela:Fernando:150
    	// Odisea:0-4568-2116-2:novela:Homero:250
    	libro = new Libro(titulo, isbn, genero, autor, paginas);
    	
    	return libro;
    }
    
    private static String leerCadena() {
    	String opcion = null;
    	Scanner teclado = new Scanner(System.in);
        opcion=teclado.nextLine();
    	return opcion;
    }
}
