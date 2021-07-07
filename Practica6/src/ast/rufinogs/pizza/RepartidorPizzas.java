package ast.rufinogs.pizza;

/**
 * 
 * Clase de los Repartidores de Pizzas
 * @author rufinogs
 *
 */

public class RepartidorPizzas extends Thread { 
	private Pizzas p;
	private int numero;
	private int tiempo = 5000;

	/**
	 * Constructor de los Repartidores
	 * 
	 * @param pi instancia de las pizzas
	 * @param pnumero será el numero del repartidor
	 *             
	 */
	public RepartidorPizzas(Pizzas pi, int pnumero) {
		p = pi; 
		numero = pnumero;
		setName("REPARTIDOR nº " + numero); // Se asigna un nombre al hilo de repartidores
		start();
	}

	public void run() {
		boolean hay; // True si hay pizzas
		do { 
			try {
				Thread.sleep((int) (Math.random() * tiempo)); // Llama a repartir pizzas de forma aleatoria
			} catch (Exception e) {
				System.err.println("Error");
				e.printStackTrace();
			}
			// Si no quedan pizzas no se entra en el bucle
			hay = p.repartirPizza(); // Se llama a la funcion repartir y si quedan aun por repartir se guarda el
										// valor.
		} while (hay);
	}
}
