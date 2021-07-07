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
public class ArrayAlumnos {
	private List<Alumno> alumnos;

	/**
	 * Clase Array de Alumnos
	 */
	public ArrayAlumnos() {
		// TODO Auto-generated constructor stub
		alumnos = new ArrayList<Alumno>();
	}

	/**
	 * Añade un alumno al array
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
	 * @return Alumno
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
	 * @return todos los alumnos del array
	 */
	public ArrayList<String> toFile() {
		ArrayList<String> list = new ArrayList<String>();
		for (int n = 0; n < alumnos.size(); ++n) {
			String file = this.alumnos.get(n).toFile();
			list.add(file);
		}
		return list;
	}

	/**
	 * 
	 * @param posicion
	 * @param a
	 * @return insertar alumno en la cola
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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
