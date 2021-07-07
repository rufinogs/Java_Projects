/**
 * 
 */
package ast.rufinogs.alumnos;

/**
 * @author rufinogs
 *
 */

public class Nuevo extends Alumno {
	static int Precio_Nuevo = 60;

	/**
	 * Clase Alumno Nuevo
	 */

	public Nuevo(String nombre, String apellidos, int dni, String grado, int expediente, int nota) {
		super(nombre, apellidos, dni, grado, expediente, nota, Precio_Nuevo);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
