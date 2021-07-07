
/**
 * Clase que crea la Interfaz del cliente
 */

import java.rmi.*;
import java.util.List;

/**
 * @author rufinogs
 *
 */
public interface ServerChatIF extends Remote {

	public String getServerName() throws RemoteException;

	public void addCliente(ClienteChatIF client) throws RemoteException;

	public void sendToAllUsers(String msg) throws RemoteException;

	public List<ClienteChatIF> getClients() throws RemoteException;

	public void deleteClient(String usuario) throws RemoteException;

	public int size() throws RemoteException;
}
