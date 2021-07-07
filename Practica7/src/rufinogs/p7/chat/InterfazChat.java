package rufinogs.p7.chat;

/* InterfazChat es la clase remota:
- Hereda de Remote
- Está definida como un interfaz.
- Necesita de una clase que la implemente (Chat). */

import java.rmi.*;

/**
 * @author rufinogs
 *
 */

public interface InterfazChat extends Remote {
	
	public String getName() throws RemoteException;

	public void send(String msg) throws RemoteException;

	public void setClient(InterfazChat c) throws RemoteException;

	public InterfazChat getClient() throws RemoteException;
}
