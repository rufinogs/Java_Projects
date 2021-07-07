/**
 * 
 */
package ast.rufinogs.peticiones.cola;

import java.util.Comparator;

import ast.rufinogs.peticiones.Peticiones;

/**
 * @author rufinogs
 *
 */
public class ComparadorDeAlumnos implements Comparator<Peticiones> {

	/**
	 * Clase Compara los alumnos
	 */
	public ComparadorDeAlumnos() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}

	/**
	 * @return compara los alumnos en fucnion del precio
	 */
	@Override
	public int compare(Peticiones p1, Peticiones p2) {
		if (p1.alumno.getPrice() < p2.alumno.getPrice())
			return -1;
		else if (p1.alumno.getPrice() > p2.alumno.getPrice())
			return 1;
		else
			return 0;
	}
}
