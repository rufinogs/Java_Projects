/**
 * 
 */
package rufinogs.p5.act2.cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Clase del Cliente UDP
 * 
 * @author rufinogs
 *
 */
public class ClienteUDP {

	// Los argumentos proporcionan el mensaje y el nombre del servidor
	public static void main(String args[]) {

		try {
			DatagramSocket socketUDP = new DatagramSocket();
			InetAddress hostServidor = InetAddress.getByName(args[0]);
			int puertoServidor = 6789;
			// Este comando hace que espere 5000 milisegundos y si tarda mas de eso lanza
			// una excepcion
			socketUDP.setSoTimeout(5000);
			String mensajes;

			// Start
			System.out.println();
			System.out.println("CHAT (Client)");
			System.out.println("IP Servidor: " + args[0] + " Puerto Servidor: " + puertoServidor);
			System.out.println("Para finalizar la conexion escriba 'salir'");
			System.out.println("Nota: Si introduce el comando 'fecha' se le mostrara la fecha y hora correspondientes");
			System.out.println();
			// Construimos el datagrama para enviarle el mesanje al servidor
			do {
				// pedimos al usuario por pantalla el mensaje que quiera enviar al servidor
				System.out.println("Introduzca el mensaje:");
				mensajes = pedirLinea();
				byte[] mensajes_byte = mensajes.getBytes();
				DatagramPacket petcliente = new DatagramPacket(mensajes_byte, mensajes_byte.length, hostServidor,
						puertoServidor);

				// Enviamos el datagrama
				socketUDP.send(petcliente);

				// Construimos el DatagramPacket que contendrá la respuesta
				byte[] bufer = new byte[1000];
				DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);

				socketUDP.receive(respuesta);

				// Enviamos la respuesta del servidor a la salida estandar
				System.out.println(
						"Respuesta: " + new String(respuesta.getData(), respuesta.getOffset(), respuesta.getLength()));

			} while (!mensajes.equals("salir"));

			System.out.println();
			System.out.println("Sesion cerrada. Hasta luego!");
			System.out.println();

			// Cerramos el socket
			socketUDP.close();

		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
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
}