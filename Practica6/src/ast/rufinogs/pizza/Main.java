package ast.rufinogs.pizza;

/**
 * Clase que implementa el thread de ejecucion. Va a crear los hornos y los
 * repartidores de pizzas.
 * 
 * @author rufinogs
 *
 */

public class Main {
	public static void main(String[] args) {
		final int numtotHornos = 5; // Constante con el numero total de Hornos disponibles
		final int numtotRepartidores = 5; // Constante con el numero total de Repartidores disponibles

		Pizzas pixsas = new Pizzas(); // instanciamos la clase pizzas

		/// bucle que crea 5 hilos de HornoPizzas, le pasamos
		// las pizzas e i para saber el numero del hilo
		for (int idHilo = 1; idHilo <= numtotHornos; idHilo++)
			new HornoPizzas(pixsas, idHilo);// Instacia de Horno

		// bucle que crea 5 hilos de RepartidorPizzas, le pasamos
		// las pizzas e i para saber el numero del hilo
		for (int idHilo = 1; idHilo <= numtotRepartidores; idHilo++)
			new RepartidorPizzas(pixsas, idHilo); // Instancia de Repartid
	}
}
