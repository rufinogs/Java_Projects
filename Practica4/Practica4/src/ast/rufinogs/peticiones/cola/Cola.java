/**
 * 
 */
package ast.rufinogs.peticiones.cola;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import ast.rufinogs.peticiones.Peticiones;

/**
 * @author rufinogs
 *
 */
public class Cola {
	/**
	 * Se crea la cola con prioridad
	 */
	Comparator<Peticiones> comparator = new ComparadorDeAlumnos();
	PriorityQueue<Peticiones> queue = new PriorityQueue<Peticiones>(10, comparator);

	/**
	 * Clase cola
	 */
	public Cola() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 * @return añade peticiones a la cola
	 * 
	 */
	public boolean add(Peticiones pet) {
		// TODO Auto-generated method stub
		return this.queue.add(pet);
	}

	/**
	 * 
	 * @return si la cola esta llena o no
	 *
	 */

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.queue.isEmpty();
	}

	/**
	 * 
	 * @return devuelve y borra la cabeza de la cola. Devuelve null, si la cola esta
	 *         vacia
	 */

	public Peticiones poll() {
		// TODO Auto-generated method stub
		return this.queue.poll();
	}

	/**
	 * @return the queue
	 */
	public PriorityQueue<Peticiones> getQueue() {
		return queue;
	}

	/**
	 * @param queue the queue to set
	 */
	public void setQueue(PriorityQueue<Peticiones> queue) {
		this.queue = queue;
	}

	/**
	 * 
	 * @return el tamaño de la cola
	 */
	public int size() {
		// TODO Auto-generated method stub
		return this.queue.size();
	}

	/**
	 * 
	 * devuelve todas peticiones que componen la cola
	 */
	public void allPet() {
		Iterator<Peticiones> it = queue.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "\n");
		}
	}

}
