/**
 * 
 */
package rufinogs.p5.act2.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase del Servidor UDP
 * 
 * @author rufinogs
 *
 */
public class ServidorUDP {

	public static void main(String args[]) {
		try {
			// Generamos la entrada del servidor
			int puerto = 6789;
			@SuppressWarnings("resource")
			DatagramSocket socketUDP = new DatagramSocket(puerto);
			byte[] bufer = new byte[1000];
			System.out.println("CHAT (Server)");
			System.out.println("Introduce el puerto local: " + puerto);
			System.out.println();

			while (true) {
				// Construimos el DatagramPacket para recibir peticiones
				DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);

				// Leemos una petición del DatagramSocket
				socketUDP.receive(peticion);

				System.out.print("Datagrama recibido del host: " + peticion.getAddress());
				System.out.print(" desde el puerto remoto: " + peticion.getPort() + " con mensaje: ");

				String mensaje = new String(peticion.getData(), peticion.getOffset(), peticion.getLength());
				DatagramPacket respuesta = null;
				if (mensaje.equals("fecha")) {
					System.out.println(mensaje);
					Date date1 = new Date();
					DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");

					Date date2 = new Date();
					DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");

					mensaje = "Fecha (" + dateFormat1.format(date1) + ") Hora (" + dateFormat2.format(date2) + ")";
					respuesta = new DatagramPacket(mensaje.getBytes(), mensaje.length(), peticion.getAddress(),
							peticion.getPort());

				} else {
					// Construimos el DatagramPacket para enviar la respuesta
					System.out.println(mensaje);
					/**
					 * DatagramPacket respuesta = new DatagramPacket(peticion.getData(),
					 * peticion.getLength(),
					 *
					 */
					respuesta = new DatagramPacket(peticion.getData(), peticion.getLength(), peticion.getAddress(),
							peticion.getPort());
				}
				;
				// Enviamos la respuesta, que es un eco
				socketUDP.send(respuesta);
			}

		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		}
	}

}