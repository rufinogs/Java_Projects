/**
 * 
 */
package ast.rufinogs.alumnos;

/**
 * @author rufinogs
 *
 */
public class Repetidor extends Alumno {
	static int Precio_Repetidor = 70;

	/**
	 * 
	 */
	public Repetidor() {
		this.setPrice(70);
		// TODO Auto-generated constructor stub
	}

	public Repetidor(String nombre, String apellidos, int dni, String grado, int expediente, int nota) {
		super(nombre, apellidos, dni, grado, expediente, nota, Precio_Repetidor);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
