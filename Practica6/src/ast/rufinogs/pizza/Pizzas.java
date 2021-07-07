package ast.rufinogs.pizza;

/**
 * Clase que implementa las pizzas
 * 
 * @author rufinogs
 *
 */

public class Pizzas {
	private int maxPizzHorno = 3; // número máximo de pizzas cociendose a la vez por horno
	private int maxPizzas = 100; // número máximo de pizzas en stock
	private int maxCoccion = 5; // tiempo máximo de cocción de pizzas, en segundos
	private int nPizza = 1; // número o id correspondiente a una pizza, inicialmente 1
	private int cociendoAhora = 0; // cuántas pizzas se están cociendo ahora mismo

	/**
	 * El contenido de cada posición de este array será: 
	 * - 0: no se ha metido la pizza en horno 
	 * - 1..maxCoccion: tiempo que lleva la pizza cociéndose 
	 * - maxCoccion+1: pizza quemada 
	 * - maxCoccion+2: pizza extraida para ser repartida
	 */
	private int pizzas[]; // Array de enteros vacio

	/**
	 * Constructor de Pizzas, crea el array con maxPizzas (100) posiciones 
	 */
	public Pizzas() { 
		pizzas = new int[maxPizzas];
		for (int i = 0; i < maxPizzas; i++)
			pizzas[i] = 0; // ponemos el estado de las pizzas a "sin hornear"
	}

	/**
	 * Método que devuelve la siguiente pizza del stock, si no quedan devuelve -1
	 * 
	 * @return la siguiente pizza del stock, si no queda ninguna pizza mas devuelve -1
	 */
	public synchronized int cogerPizza() {
		// Si el horno esta lleno no podremos meter mas pizzas por lo que tendremos que
		// esperar y
		// lanzar la excepcion de que el horno esta lleno diciendo que ha alcanzo su 
		// maximo de capacidad
		while (cociendoAhora == maxPizzHorno && nPizza != maxPizzas + 1) {
			try {
				wait();
			} catch (Exception e) {
				System.out.println("Error maximo alcanzado");
				e.printStackTrace();
			}
		}
		// Si no hay mas pizzas en el almacen devolvemos -1
		if (nPizza == maxPizzas) {
			return -1;
		}
		if (nPizza == maxPizzas + 1)
			return -1;

		// En el caso de que quden pizzas por coger, se cambia el estado de una de las pizzas del
		// almacen a 1.
		pizzas[nPizza - 1] = 1;
		System.out.println("PIZZA nº " + nPizza + " introducida en el " + Thread.currentThread().getName());
		cociendoAhora++;
		notifyAll(); // Despierto todos los threads dormidos
		return nPizza++;
	}

	/**
	 * Método que extrae una pizza del horno, para ser repartida, si no quedan
	 * devuelve false
	 * 
	 * @return Si quedan pizzas devuelve true y si no quedan devuelve false
	 */
	public synchronized boolean repartirPizza() {
		// Mientras no haya ninguna pizza cociendos o en el alamacen lo paramos/dormimos
		while (cociendoAhora == 0 && nPizza != maxPizzas + 1) {
			try {
				wait();
			} catch (Exception e) {
				System.out.println("Error maxima capacidad de pizzas alcanzado");
				e.printStackTrace();
			}
		}
		// Si el numero de pizzas a alcanzo el maximo ha terminado el horario de trabajo y
		// devolvemos false a repartir
		if (nPizza == maxPizzas) {
			return false;
		}
		// Si en el array de pizzas hay alguna que esta introducida en el horno con un 
		// valor entre 0..maxCoccion, se actualizara el estado de la pizza a entregada,
		// se despierta/notifica a todos los hilos.
		for (int i = 0; i < maxPizzas; i++) {
			if (pizzas[i] > 0 && pizzas[i] <= maxCoccion) {
				System.out.println("La PIZZA nº " + (i + 1) + " la entrega el " + Thread.currentThread().getName());
				pizzas[i] = maxCoccion + 2;
				cociendoAhora--;
				notifyAll();
				break;
			}
		}
		return true;// Al devolver true podemos saber que quedan pizzas aun por repartir
	}

	/**
	 * Método que cuece las pizzas en el horno
	 * 
	 * @param numero de la pizza que el horno va a cocer
	 * @return false si la pizzas se estan cociendo
	 */
	public synchronized boolean cocerPizza(int numero) {
		// Si la pizza indicada está por debajo de maxCoccion, le subimos un
		// minuto al marcador de horneado y sino devuelve true
		if (pizzas[numero - 1] <= maxCoccion)
			pizzas[numero - 1]++;
		else
			return true;

		// Si la pizza indicada ha superado maxCoccion, indicamos que se ha
		// quemado, devolvemos true y sino devolvemos false indicando el estado de la
		// pizza
		if (pizzas[numero - 1] == maxCoccion + 1) {
			cociendoAhora--;
			System.out.println("La PIZZA nº " + numero + " esta QUEMADA");
			notifyAll();
			return true;
		} else {
			System.out.println("La PIZZA nº " + numero + " esta COCIENDOSE (" + pizzas[numero - 1] + " minutos)");
			return false;
		}
	}
}