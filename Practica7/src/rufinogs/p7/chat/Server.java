/* Clase del servidor */
package rufinogs.p7.chat;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * @author rufinogs
 *
 */
@SuppressWarnings("deprecation")
public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			// Carga dinamica de clases
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			// Se lee de la entrada lo que escribe el ususario
			System.out.println("Introduzca su nombre y pulse Enter:");
			String nombre = pedirLinea();
			Chat server = new Chat(nombre);

			// Creacion del registro
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT); // puerto
			Naming.rebind("rmi://localhost/Chat", server); // nombre del stub

			System.out.println("[System] Objeto remoto del Chat esta preparado:");

			while (true) {
				String mensaje = pedirLinea();
				if (server.getClient() != null) {
					InterfazChat client = server.getClient();
					mensaje = "[El usuario " + server.getName() + " escribio] " + mensaje;
					client.send(mensaje);
				}
			}

		} catch (Exception e) {
			System.out.println("[System] Fallo en el servidor: " + e);
			e.printStackTrace();
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