/**
 * 
 */
package ast.rufinogs.profesores;

/**
 * @author rufino
 *
 */
public class Profesor {
	private int identificador;
	private String nombre;
	private String apellidos;
	private int despacho;
	private String asignatura;

	/**
	 * Clase Profesor
	 */
	public Profesor() {
		// TODO Auto-generated constructor stub
	}

	public Profesor(int identificador, String nombre, String apellidos, int despacho, String asignatura) {
		// TODO Auto-generated constructor stub
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.despacho = despacho;
		this.asignatura = asignatura;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the despacho
	 */
	public int getDespacho() {
		return despacho;
	}

	/**
	 * @param despacho the despacho to set
	 */
	public void setDespacho(int despacho) {
		this.despacho = despacho;
	}

	/**
	 * @return the asignatura
	 */
	public String getAsignatura() {
		return asignatura;
	}

	/**
	 * @param asignatura the asignatura to set
	 */
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return toString de los profesores
	 */

	public String toString() {
		return "con identificador " + this.identificador + ", con despacho nº " + this.despacho
				+ ", con nombre y apellidos " + this.nombre + " " + this.apellidos;

	}

}
