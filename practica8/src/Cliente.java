
/**
 * Clase del Cliente
 */
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * @author rufinogs
 *
 */
public class Cliente {

	private static ClienteChat cliente;

	public static void main(String[] args) {
		try {

			// Se lee de la entrada lo que escribe el ususario
			System.out.println();
			System.out.println("Ahora introduzca su nombre para registrarse y pulse Enter:");
			String nombre = pedirLinea();

			// Localizamos el recurso remoto
			ServerChatIF chatServer = (ServerChatIF) Naming.lookup("rmi://localhost/P8");

			if (chatServer.size() == 0) {
				register(nombre, chatServer);
			} else {
				usuarioRepetido(nombre, chatServer);
			}

			System.out.println("[System] Chat Client esta preparado."); // Decimos que el Chat esta listo

			while (true) {
				processData(chatServer);
			}

		} catch (Exception e) {
			System.out.println("[System] Error en el Chat del Cliente: " + e);
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

	/**
	 * Metodo que nos mira en el array de clientes 1 a 1 y compara el nombre
	 * introducido con los de los clientes que se encuentran ya en el chat. En caso
	 * de que se encuentre le pide que introduzca otro. si no esta lo registra y
	 * comineza el chat.
	 * 
	 * @param nombre
	 * @param chatServer
	 * @throws RemoteException
	 */
	private static void usuarioRepetido(String nombre, ServerChatIF chatServer) throws RemoteException {
		// Recorremos el array de los clientes
		boolean repetido = false;
		boolean registrado = false;
		do {
			for (ClienteChatIF client : chatServer.getClients()) {
				// Vemos si el usuario introducido se encuentra
				if (client.getUserNameCliente().equals(nombre)) {
					System.out.println();
					System.out.println("Usuario introducido [" + nombre + "] erroneo");
					System.out.println("Usuario ya introducido en el chat.");
					System.out.println();
					System.out.println("Introduzca otro nombre de usuario para entrar y pulse Enter:");
					String nombre2 = pedirLinea();
					cliente = new ClienteChat(nombre2, chatServer); // Registramos el cliente
					return;
				}
			}

			if (!repetido) {
				System.out.println();
				System.out.println("Registrando cliente...");
				System.out.println();
				System.out.println("Si desea desconectarse introduzca 'exit' y pulse Enter.");
				return;
			}

		} while (registrado == true);
	}

	/**
	 * Metodo que procesa la informacion que escribe el cliente por pantalla y
	 * dependiendo de la plaanra que utilice realiza una accion u otra. En caso de
	 * escribir 'exit' hace una cosa y cualquier otra palabra lo manda a todos los
	 * usuarios del chat. Da informacion del estado del clinete y los mensajes.
	 * 
	 * @param server
	 * @throws RemoteException
	 */
	private static void processData(ServerChatIF server) throws RemoteException {
		String mensaje = pedirLinea(); // Pedimos que escriba el nombre por el terminal

		if (!mensaje.equals("exit") && !mensaje.equals("Exit") && !mensaje.equals("EXIT")) {
			mensaje = "[" + cliente.getUserNameCliente() + "] " + mensaje;
			server.sendToAllUsers(mensaje); // Mandamos el mensaje a todos los clientes
		} else {
			mensaje = "El usuario [" + cliente.getUserNameCliente() + "] se ha desconectado";
			server.sendToAllUsers(mensaje);
			server.deleteClient(cliente.getUserNameCliente()); // borramos el cliente del array
			System.exit(0); // cerramos el hilo del cliente
		}

	}

	/**
	 * Metodo que introduce al cliente en el chat y da informacion de que se ha
	 * registrado.
	 * 
	 * @param nombre
	 * @param chatServer
	 * @throws RemoteException
	 */
	private static void register(String nombre, ServerChatIF chatServer) throws RemoteException {
		cliente = new ClienteChat(nombre, chatServer); // Registramos el cliente
		System.out.println("Registrando cliente...");
		System.out.println();
		System.out.println("Si desea desconectarse introduzca 'exit' y pulse Enter.");
		System.out.println();
	}
}
