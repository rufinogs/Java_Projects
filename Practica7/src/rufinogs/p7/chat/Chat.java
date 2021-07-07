package rufinogs.p7.chat;

/* Chat es la clase que implementa el interfaz remoto (InterfazChat).
Hereda de UnicastRemoteObject. */

import java.rmi.*;
import java.rmi.server.*;

/**
 * @author rufinogs
 *
 */

public class Chat extends UnicastRemoteObject implements InterfazChat {

	private static final long serialVersionUID = 1L;
	public String name;
	public InterfazChat client = null;

	/**
	 * @param n
	 * @throws RemoteException
	 */
	public Chat(String n) throws RemoteException {
		super();
		this.name = n;
	}

	/**
	 * Metodo que obtiene el nombre
	 * 
	 * @throws RemoteException
	 */
	public String getName() throws RemoteException {
		return this.name;
	}

	/**
	 * Metodo que introduce el cliente en la interfaz
	 * 
	 * @param c
	 * @throws RemoteException
	 */
	public void setClient(InterfazChat c) throws RemoteException {
		client = c;
	}

	/**
	 * Metodo que obtiene el cliente de la interfaz
	 * 
	 * @throws RemoteException
	 */
	public InterfazChat getClient() throws RemoteException {
		return this.client;
	}

	/**
	 * Metodo que envia el mensaje
	 * 
	 * @param mensaje
	 * @throws RemoteException
	 */
	public void send(String mensaje) throws RemoteException {
		System.out.println(mensaje);
	}
}