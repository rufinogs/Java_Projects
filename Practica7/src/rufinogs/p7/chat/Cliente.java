/* Clase del Cliente */
package rufinogs.p7.chat;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

/**
 * @author rufinogs
 *
 */
@SuppressWarnings("deprecation")
public class Cliente {

	public static void main(String[] args) {
		try {

			// Cargamos dinamica de clases
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager()); // Registramos el stub del cliente
			}

			// Se lee de la entrada lo que escribe el ususario
			System.out.println("Introduce tu nombre y pulsa Enter:");
			String nombre = pedirLinea();
			InterfazChat cliente = new Chat(nombre); 

			// Localizamos el recurso remoto
			InterfazChat server = (InterfazChat) Naming.lookup("rmi://localhost/Chat"); // nombre del skeleton
			String mensajes = "[" + cliente.getName() + "] conectado";
			server.send(mensajes);

			System.out.println("[System] Objeto remoto del Chat esta preparado:");
			server.setClient(cliente);

			while (true) {
				String mensaje = pedirLinea(); // Pedimos que escribe el mensaje por el terminal
				mensaje = "[El usuario " + cliente.getName() + " escribio] " + mensaje;
				server.send(mensaje); // Mandamos el mensaje al servidor
			}

		} catch (Exception e) {
			System.out.println("[System] Fallo en el cliente: " + e);
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
