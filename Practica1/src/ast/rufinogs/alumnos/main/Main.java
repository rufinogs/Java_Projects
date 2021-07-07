/**
 * 
 */
package ast.rufinogs.alumnos.main;

import ast.rufinogs.alumnos.Repetidor;
import ast.rufinogs.alumnos.array.Array;
import ast.rufinogs.alumnos.Erasmus;
import ast.rufinogs.alumnos.Nuevo;

/**
 * @author rufino
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static int Total(Array lista) {
		int total = 0;
		for (int i = 0; i < lista.size(); i++) {
			total += lista.get(i).getPrice(i);
		}
		return total;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Creamos el Array
		Array lista = new Array();

		// Creamos los alumnos
		Nuevo alumno1 = new Nuevo("Pepe", "Garcia", 47468905, "Telem", 345678, 4);
		Nuevo alumno2 = new Nuevo("Daniel", "Hervas", 89894567, "Telem", 123456, 3);
		Repetidor alumno3 = new Repetidor("Arturo", "Fernandez", 44432123, "Telem", 987653, 5);
		Repetidor alumno4 = new Repetidor("Luis", "Rodriguez", 49495069, "Telem", 908556, 8);
		Repetidor alumno5 = new Repetidor("Julio", "Garcia", 47473004, "Telem", 1467899, 9);
		Erasmus alumno6 = new Erasmus("Rufino", "Garcia", 89876543, "Telem", 4356879, 10);

		// Añadimos los alumnos al array
		lista.add(alumno1);
		lista.add(alumno2);
		lista.add(alumno3);
		lista.add(alumno4);
		lista.add(alumno5);
		lista.add(alumno6);

		System.out.println("Precio total de los Alumnos es: " + Total(lista));
		System.out.println("El grado del alumno es: " + alumno4.getGrado());
		System.out.println("El grado del alumno es: " + alumno1.getGrado());
		System.out.println(
				"Se cambia la titulacion del alumno " + lista.get(1).getNombre() + " a " + lista.Change(alumno1));

	}

}