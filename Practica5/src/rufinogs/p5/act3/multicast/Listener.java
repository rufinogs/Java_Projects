/**
 * 
 */
package rufinogs.p5.act3.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 * Clase Listener. Clase que nos permite escuchar/recivir los mensajes.
 * @author rufinogs
 *
 */
public class Listener implements Runnable {
	/**
	 * Variables locales
	 */
	private String direccionip;
	private int puerto;

	/**
	 * Constructor para almacenar las variables
	 * @param direccionip 
	 * @param puerto 
	 */
	public Listener(String direccionip, int puerto) {
		// TODO Auto-generated constructor stub
		this.direccionip = direccionip;
		this.puerto = puerto;
	}
	
	/**
	 * Metodo que escucha los mensajes en un hilo paralelo.
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			InetAddress grupo = InetAddress.getByName(direccionip);
			@SuppressWarnings("resource")
			MulticastSocket socket = new MulticastSocket(puerto);
			
			// Se une al grupo
		    socket.joinGroup(grupo);
			
			while (true) {				
				byte[] bufer = new byte[1000];
				DatagramPacket mensajeEntrada = new DatagramPacket(bufer, bufer.length);
				
		    	socket.receive(mensajeEntrada);
		    	
		    	String linea = new String(mensajeEntrada.getData(), 0, mensajeEntrada.getLength());
		    	System.out.println(linea);
			}
		
		} catch (SocketException e) {
		      System.out.println("Socket:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		}
		
	}

}
