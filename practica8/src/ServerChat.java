
/**
 * Clase que introduce el chat del Servidor
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rufinogs
 *
 */

public class ServerChat extends UnicastRemoteObject implements ServerChatIF {

	private static final long serialVersionUID = 1L;
	public String nombre;
	public List<ClienteChatIF> clientes;

	/**
	 * 
	 * @param nombre
	 * @throws RemoteException
	 */
	public ServerChat(String nombre) throws RemoteException {
		this.nombre = nombre;
		this.clientes = new ArrayList<>();
	}

	/**
	 * Metodo que devuelve el tamaño del array de los clientes
	 * 
	 * @return
	 */
	public int size() throws RemoteException {
		return this.clientes.size();
	}

	/**
	 * Metodo que manda a todos los usuarios el mensaje
	 * 
	 * @param mensaje
	 * @throws RemoteException
	 */
	public void sendToAllUsers(String mensaje) throws RemoteException {
		for (ClienteChatIF client : clientes) {
			client.recibirMensajes(mensaje);
		}
		System.out.println(mensaje);
	}

	/**
	 * Metodo que obtiene el nombre del servidor
	 * 
	 * @throws RemoteException
	 */
	public String getServerName() throws RemoteException {
		return this.nombre;
	}

	@Override
	/**
	 * Metodo que registra al cliente
	 * 
	 * @param client
	 * @throws RemoteException
	 */
	public void addCliente(ClienteChatIF client) throws RemoteException {
		this.clientes.add(client);
		System.out.println("Cliente [" + client.getUserNameCliente() + "] añadido");
	}

	/**
	 * Metodo que obtiene al cliente de la lista
	 * 
	 * @throws RemoteException
	 */
	public List<ClienteChatIF> getClients() throws RemoteException {
		return this.clientes;
	}

	/**
	 * Metodo que elimina un cliente del servidor
	 * 
	 * @param usuario
	 * @throws RemoteException
	 */

	public void deleteClient(String usuario) throws RemoteException {
		for (ClienteChatIF client : clientes) {
			if (client.getUserNameCliente().equals(usuario)) {
				System.out.println("El usuario [" + usuario + "] ha sido eliminado");
				clientes.remove(client);
				break;
			}
		}
	}

}
