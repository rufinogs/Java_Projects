
/**
 * Clase del Servidor
 */

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * @author rufinogs
 *
 */
public class Server {

	public static void main(String[] args) {
		try {

			// Se lee de la entrada lo que escribe el ususario
			System.out.println();
			System.out.println("Si desea desconectarse introduzca 'exit' y pulse Enter.");
			System.out.println();
			System.out.println("Ahora introduzca su nombre para registrarse y pulse Enter:");
			String nombre = pedirLinea();

			// Creacion del registro
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT); // Creamos el registro
																	// y registramos el puerto

			// Creamos el chat del servidor
			ServerChat server = new ServerChat(nombre);

			Naming.rebind("rmi://localhost/P8", server); // nombre del stub

			System.out.println("[System] Chat Server esta preparado.");
			System.out.println("Esperando a las conexiones de los clientes....");

			while (true) {

				String mensaje = pedirLinea(); // Pedimos que escriba el nombre por el terminal

				if (!mensaje.equals("exit") && !mensaje.equals("Exit")) {
					mensaje = "[" + server.getServerName() + "] " + mensaje;
					server.sendToAllUsers(mensaje); // Mandamos el mensaje a todos los clientes

				} else {
					mensaje = "El servidor [" + server.getServerName() + "] se ha desconectado";
					server.sendToAllUsers(mensaje);
					System.exit(0);

				}
			}

		} catch (Exception e) {
			System.out.println("[System] Fallo en el Chat Server: " + e);
		}
	}

	/**
	 * Lee una linea por consola
	 * 
	 * @return un string con la linea insertada por consola
	 */
	private static String pedirLinea() {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		return teclado.nextLine();
	}
}