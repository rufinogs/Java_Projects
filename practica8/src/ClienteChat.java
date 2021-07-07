
/**
 * Clase que introduce el chat del cliente
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author rufinogs
 *
 */

public class ClienteChat extends UnicastRemoteObject implements ClienteChatIF {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private ServerChatIF server;

	public ClienteChat(String nombre, ServerChatIF server) throws RemoteException {
		this.nombre = nombre;
		this.server = server;

		// Registramos el cliente
		server.addCliente(this);

		// Creamos el mensaje que sera enviado a todos los usuarios
		String mensaje = "[" + this.nombre + "] conectado";
		server.sendToAllUsers(mensaje); // Mandamos el mensaje del cliente conectado a todos los usuarios

	}

	@Override
	/**
	 * Metodo que obtiene el nombre del cliente
	 * 
	 * @throws RemoteException
	 */
	public String getUserNameCliente() throws RemoteException {
		return this.nombre;
	}

	@Override
	/**
	 * Metodo que recibe los mensajes y los pinta
	 * 
	 * @param mensaje
	 * @throws RemoteException
	 */
	public void recibirMensajes(String mensaje) throws RemoteException {
		System.out.println(mensaje);

	}

}