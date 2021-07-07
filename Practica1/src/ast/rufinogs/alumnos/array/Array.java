/**
 * 
 */
package ast.rufinogs.alumnos.array;

import java.util.*;

import ast.rufinogs.alumnos.*;

/**
 * @author rufinogs
 *
 */
public class Array {
	private List<Alumno> alumnos;

	/**
	 * 
	 */
	public Array() {
		// TODO Auto-generated constructor stub
		alumnos = new ArrayList<Alumno>();
	}

	/**
	 * Añade alumnos al array
	 * 
	 * @param a
	 */
	public void add(Alumno a) {
		this.alumnos.add(a);
	}

	/**
	 * 
	 * @return el tamaño del array
	 */
	public int size() {
		return this.alumnos.size();
	}

	/**
	 * 
	 * @param i
	 * @return alumno
	 */
	public Alumno get(int i) {
		return this.alumnos.get(i);
	}

	/**
	 * @return toString() del alumno
	 */
	public String toString() {
		return this.alumnos.toString();
	}

	/**
	 * 
	 * @param posicion
	 * @param a
	 * @return inserta al alumno
	 */
	public boolean ins(int posicion, Alumno a) {
		try {
			if (posicion >= alumnos.size()) {
				return false;
			} else {
				this.alumnos.add(posicion, a);
				return true;
			}
		} catch (Exception IndexOutOfBounds) {
			System.out.println("La posicion es mayor, no es posible");
		}
		return false;
	}

	/**
	 * @param al
	 * @return cambia el grado del alumno
	 */
	public String Change(Alumno al) {
		String NewGrado = new String();
		for (int i = 0; i < alumnos.size(); ++i) {
			NewGrado = alumnos.get(i).setGrado("Tecnologías");
		}
		return NewGrado;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
