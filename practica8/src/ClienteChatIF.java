
/**
 * Clase que crea la Interfaz del cliente
 */

import java.rmi.*;

/**
 * @author rufinogs
 *
 */

public interface ClienteChatIF extends Remote {

	public String getUserNameCliente() throws RemoteException;

	public void recibirMensajes(String mensaje) throws RemoteException;

}
