/**
 * 
 */
package ast.rufinogs.peticiones.main;

import java.io.IOException;

import ast.rufinogs.alumnos.Alumno;
import ast.rufinogs.alumnos.Erasmus;
import ast.rufinogs.alumnos.Nuevo;
import ast.rufinogs.alumnos.Repetidor;
import ast.rufinogs.alumnos.array.ArrayAlumnos;
import ast.rufinogs.peticiones.Peticiones;
import ast.rufinogs.peticiones.cola.Cola;
import ast.rufinogs.profesores.Profesor;
import ast.rufinogs.profesores.array.Arrayprof;

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
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Creamos la Cola
		Cola queue = new Cola();
		// Creamos los diferentes arrays, el de alumnos y el de profesores
		ArrayAlumnos listal = new ArrayAlumnos();
		Arrayprof listprof = new Arrayprof();
		Alumno al = new Alumno();
		Profesor pr = new Profesor();
		Peticiones pet = new Peticiones();

		// Creamos los alumnos
		Nuevo alumno1 = new Nuevo("Pepe", "Garcia", 47468905, "Telem", 345678, 4);
		Nuevo alumno2 = new Nuevo("Daniel", "Hervas", 89894567, "Telem", 123456, 3);
		Repetidor alumno3 = new Repetidor("Arturo", "Fernandez", 44432123, "Telem", 987653, 5);
		Repetidor alumno4 = new Repetidor("Luis", "Rodriguez", 49495069, "teleco", 908556, 8);
		Repetidor alumno5 = new Repetidor("Julio", "Garcia", 47473004, "Telem", 1467899, 9);
		Erasmus alumno6 = new Erasmus("Rufino", "Garcia", 89876543, "sistemas", 4356879, 10);

		// Añadimos los alumnos al array de alumnos
		listal.add(alumno1);
		listal.add(alumno2);
		listal.add(alumno3);
		listal.add(alumno4);
		listal.add(alumno5);
		listal.add(alumno6);

		// Creamos los profesores
		Profesor profesor1 = new Profesor(8, "Manuel", "Marchena Gómez", 206, "Redes de Ordenador");
		Profesor profesor2 = new Profesor(9, "Cristian", "Jara Corros", 203, "Ampliación de Redes");
		Profesor profesor3 = new Profesor(9, "Pepe", "Jimenez Sanchez", 207, "Servicos Operativos");

		// Añadimos los profesores al array de profesores
		listprof.add(profesor1);
		listprof.add(profesor2);
		listprof.add(profesor3);

		// Creamos las peticiones
		Peticiones pet1 = new Peticiones(1, profesor1, alumno6, "duda");
		Peticiones pet2 = new Peticiones(2, profesor1, alumno1, "Tutoria redes");
		Peticiones pet3 = new Peticiones(3, profesor2, alumno2, "duda java");
		Peticiones pet4 = new Peticiones(4, profesor1, alumno3, "Compartir pantalla");
		Peticiones pet5 = new Peticiones(5, profesor1, alumno4, "Sacar el portocolo TCP");
		Peticiones pet6 = new Peticiones(6, profesor3, alumno5, "duda de redes");

		// Añadimos las peticiones a la cola
		queue.add(pet1);
		queue.add(pet2);
		queue.add(pet3);
		queue.add(pet4);
		queue.add(pet5);
		queue.add(pet6);

		System.out.println("GESTION DE TUTORIAS:");

		System.out.println();

		System.out.println("Las tutorias de hoy en funcion de la prioridad son: ");

		// Pintamos todas las peeticiones de la cola
		queue.allPet();

		System.out.println();
		// Escribimos en el fichero
		al.writeFich(listal.toFile());
		// Leemos del fichero
		al.readFich();

		System.out.println();
		// Escribimos en el fichero
		pr.writeFich(listprof.toFile());
		// Leemos del fichero
		pr.readFich();

		System.out.println();
		// Escribimos en el fichero
		pet.writeFich(queue);
		// Leemos del fichero
		pet.readFich();

	}
}
