/**
 * 
 */
package ast.rufinogs.peticiones;

import ast.rufinogs.alumnos.Alumno;
import ast.rufinogs.profesores.Profesor;

/**
 * @author rufino
 *
 */
public class Peticiones {
	private int id;
	private Profesor profesor;
	public Alumno alumno;
	private String asunto;

	/**
	 * Clase Peticiones
	 */
	public Peticiones() {
		// TODO Auto-generated constructor stub
	}

	public Peticiones(int id, Profesor profesor, Alumno alumno, String asunto) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.profesor = profesor;
		this.alumno = alumno;
		this.asunto = asunto;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the alumno
	 */
	public Alumno getAlumno() {
		return alumno;
	}

	/**
	 * @param alumno the alumno to set
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	/**
	 * @return the profesor
	 */
	public Profesor getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	/**
	 * @return the peticion
	 */
	public int getid() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setid(int id) {
		this.id = id;
	}

	/**
	 * @return the asunto
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * @param asunto the asunto to set
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * 
	 * @return la forma en la que quiero que se escriban las peticiones
	 */
	public String toString() {
		return "Peticion de tutoria nº" + this.id + " del " + this.alumno + ". Pide la tutoria con asunto " + "'"
				+ this.asunto + "'" + " con el profesor " + this.profesor;
	}

}
