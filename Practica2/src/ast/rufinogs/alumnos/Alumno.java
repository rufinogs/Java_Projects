package ast.rufinogs.alumnos;

/**
 * @author rufinogs
 *
 */
public class Alumno {
	private String nombre;
	private String apellidos;
	private int dni;
	private String grado;
	private int expediente;
	private int nota;
	private int price;

	private int tipoalumno;

	/**
	 * Clase Alumno
	 */
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public Alumno(String nombre, String apellidos, int dni, String grado, int expediente, int nota, int price) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.grado = grado;
		this.expediente = expediente;
		this.nota = nota;
		this.price = price;

	}

	/**
	 * public String changeGrado (String grado) {
	 * 
	 */

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
	 * @return the grado
	 */
	public String getGrado() {
		return grado;
	}

	/**
	 * @param grado the grado to set
	 * @return
	 */
	public String setGrado(String grado) {
		return this.grado = grado;
	}

	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * @return the expediente
	 */
	public int getExpediente() {
		return expediente;
	}

	/**
	 * @param expediente the expediente to set
	 */
	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}

	/**
	 * @return the nota
	 */
	public int getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(int nota) {
		this.nota = nota;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return Tipoalumno
	 */

	public int getTipoalumno() {
		return tipoalumno;
	}

	/**
	 * Me devuelve un String del alumno
	 */

	public String toString() {
		return "Alumno: " + this.nombre + " " + this.apellidos + " con DNI: " + this.dni + " cursando el grado de "
				+ this.grado + " y con numero de expediente " + this.expediente;

	}

	/**
	 * @param tipoalumno the tipoalumno to set
	 */

	public void setTipoalumno(int tipoalumno) {
		this.tipoalumno = tipoalumno;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
