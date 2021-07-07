/**
 * 
 */
package ast.rufinogs.alumnos;

/**
 * @author rufinogs
 *
 */
public class Erasmus extends Alumno {
	static int Precio_Erasmus = 80;

	/**
	 * Clase Alumno de Erasmus
	 */

	public Erasmus(String nombre, String apellidos, int dni, String grado, int expediente, int nota) {
		super(nombre, apellidos, dni, grado, expediente, nota, Precio_Erasmus);

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
