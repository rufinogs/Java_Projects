/**
 * 
 */
package ast.rufinogs.ptofesores.array;

import java.util.ArrayList;

import ast.rufinogs.profesores.Profesor;

/**
 * @author rufino
 *
 */
public class Arrayprof {
	ArrayList<Profesor> profesores = new ArrayList<Profesor>();
	/**
	 * Clase Array de profesores
	 */
	public Arrayprof() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param p añade un profesor al Array
	 */

	public void add(Profesor p) {
		this.profesores.add(p);
	}

	/**
	 * 
	 * @return size of Array
	 */

	public int size() {
		return this.profesores.size();
	}

	/**
	 * 
	 * @param i
	 * @return Get profesor
	 */
	public Profesor get(int i) {
		return this.profesores.get(i);
	}

	/**
	 * @return Accede al toString() del profesor
	 */
	public String toString() {
		return this.profesores.toString();
	}

	/**
	 * 
	 * @param i
	 * @return remove the profesor
	 */
	public Profesor remove(int i) {
		return this.profesores.remove(i);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
