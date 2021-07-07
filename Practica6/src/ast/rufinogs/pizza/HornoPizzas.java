/**
 * 
 */
package ast.rufinogs.pizza;

/**
 * Clase de los Hornos de Pizzas
 * 
 * @author rufinogs
 *
 */
public class HornoPizzas extends Thread {
	private Pizzas p;
	private int numero;
	private int tiempo = 1000;

	/**
	 * Constructor de los Hornos
	 * 
	 * @param pi asi accedemos a la lista de las pizzas que hay.
	 * 
	 * @param pnumero es el numero que debe tener el Horno
	 */
	public HornoPizzas(Pizzas pi, int pnumero) {
		p = pi;
		numero = pnumero;
		setName("HORNO nº " + numero); // Se le asigna un nombre al hilo de los Hornos
		start();
	}

	/**
	 * Ira llamando al metodo cogerPizza hasta que no haya ninguna o se hayan
	 * quemado
	 */
	public void run() {
		int numero;
		boolean pizrepart; // True si se reparte

		while (true) {
			if ((numero = p.cogerPizza()) == -1) // Si devuelve -1 indica de que no hay
													// mas pizzas en el almacen
				break;
			do {
				try {
					Thread.sleep(tiempo);
				} catch (Exception e) {

				}
				pizrepart = p.cocerPizza(numero);
			} while (!pizrepart);
		}
	}
}
