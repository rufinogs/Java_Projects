/**
 * 
 */
package rufinogs.p5.act3.multicast;

import java.net.*;
import java.util.Scanner;
import java.io.*;

/**
 * Clase del Multicast
 * @author rufinogs
 *
 */
public class Multicast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// args[0] es el mensaje enviado al grupo y args[1] es la direccion del grupo
		try {
			//Se crea el socket y el nombre del grupo principal que escribira los mensajes
			InetAddress grupo = InetAddress.getByName(args[1]);
			@SuppressWarnings("resource")
		    MulticastSocket socket = new MulticastSocket(6789);

			// Se une al grupo
			socket.joinGroup(grupo);

			// Se ejecuta un Thread de forma paralela el programa que escuchara los mensajes
			new Thread(new Listener(args[1], 6789)).start();

			System.out.println("Bienvenido al chat " + args[0].toString() + ". A empezar a escribir!.");
			
			while (true) {
				// Envia el mensaje pedido por el terminal
				String mensaje = args[0].toString() + ": " + pedirLinea();
				byte[] m = mensaje.getBytes();
				DatagramPacket mensajeSalida = new DatagramPacket(m, m.length, grupo, 6789);
				socket.send(mensajeSalida);
			}
			
		} catch (SocketException e) {
			System.out.println("Socket:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		}
	}

	// Metodo que nos permiter quedarnso con lo que escirbe el usuario por pantalla
	private static String pedirLinea() {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		return teclado.nextLine();
	}

}
