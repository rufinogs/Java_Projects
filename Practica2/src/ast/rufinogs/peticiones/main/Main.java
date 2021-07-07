/**
 * 
 */
package ast.rufinogs.peticiones.main;

import ast.rufinogs.alumnos.Erasmus;
import ast.rufinogs.alumnos.Nuevo;
import ast.rufinogs.alumnos.Repetidor;
import ast.rufinogs.alumnos.array.Array;
import ast.rufinogs.peticiones.Peticiones;
import ast.rufinogs.peticiones.cola.Cola;
import ast.rufinogs.profesores.Profesor;
import ast.rufinogs.ptofesores.array.Arrayprof;

/**
 * @author rufinogs
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creamos la cola, el array de los alumnos y de los profesores

		Cola queue = new Cola();
		Array list = new Array();
		Arrayprof listprof = new Arrayprof();

		// Se crean los diferentes alumnos

		Nuevo alumno1 = new Nuevo("Pepe", "Garcia", 47468905, "Telem", 345678, 4);
		Nuevo alumno2 = new Nuevo("Daniel", "Hervas", 89894567, "Telem", 123456, 3);
		Repetidor alumno3 = new Repetidor("Arturo", "Fernandez", 44432123, "Telem", 987653, 5);
		Repetidor alumno4 = new Repetidor("Luis", "Rodriguez", 49495069, "teleco", 908556, 8);
		Repetidor alumno5 = new Repetidor("Julio", "Garcia", 47473004, "Telem", 1467899, 9);
		Erasmus alumno6 = new Erasmus("Rufino", "Garcia", 89876543, "sistemas", 4356879, 10);

		// Añadimos los alumnos al array de alumnos

		list.add(alumno1);
		list.add(alumno2);
		list.add(alumno3);
		list.add(alumno4);
		list.add(alumno5);
		list.add(alumno6);

		// Creamos los diferentes profesores

		Profesor profesor1 = new Profesor(8, "Manuel", "Marchena Gómez", 206, "Política");
		Profesor profesor2 = new Profesor(9, "Cristian", "Jara Corros", 203, "Política");

		// Añadimos los alumnos al array de profesores

		listprof.add(profesor1);
		listprof.add(profesor2);

		// Creamos las peticiones

		Peticiones pet1 = new Peticiones(1, profesor1, alumno1, "duda");
		Peticiones pet2 = new Peticiones(2, profesor2, alumno4, "Tutoria redes");
		Peticiones pet3 = new Peticiones(3, profesor1, alumno3, "duda java");

		// Añadimos las peticiones a la cola

		queue.add(pet1);
		queue.add(pet2);
		queue.add(pet3);

		System.out.println("GESTION DE TUTORIAS:");

		System.out.println();

		System.out.println("Todas las tutorias del dia de hoy son: ");

		System.out.println();

		// Imprimos todas las peticiones de tutoria de la cola con prioridad

		queue.allPet();
	}
}
