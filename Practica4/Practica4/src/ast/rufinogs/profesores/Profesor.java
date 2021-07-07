/**
 * 
 */
package ast.rufinogs.profesores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author rufino
 *
 */
public class Profesor {
	private int identificador;
	private String nombre;
	private String apellidos;
	private int despacho;
	private String asignatura;

	/**
	 * Clase profesor
	 */
	public Profesor() {
		// TODO Auto-generated constructor stub
	}

	public Profesor(int identificador, String nombre, String apellidos, int despacho, String asignatura) {
		// TODO Auto-generated constructor stub
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.despacho = despacho;
		this.asignatura = asignatura;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the despacho
	 */
	public int getDespacho() {
		return despacho;
	}

	/**
	 * @param despacho the despacho to set
	 */
	public void setDespacho(int despacho) {
		this.despacho = despacho;
	}

	/**
	 * @return the asignatura
	 */
	public String getAsignatura() {
		return asignatura;
	}

	/**
	 * @param asignatura the asignatura to set
	 */
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return toString de los profesores
	 */

	public String toString() {
		return "con identificador " + this.identificador + ", con despacho nº " + this.despacho
				+ ", con nombre y apellidos " + this.nombre + " " + this.apellidos;

	}

	/**
	 * @return formato de los Strings en los que quiero que se guarde los profesores
	 *         en cualquier fichero
	 */

	public String toFile() {
		return this.despacho + "; " + this.nombre + ";" + this.apellidos;

	}

	/**
	 * lee del fichero
	 * 
	 * @throws IOException
	 */

	public void readFich() throws IOException {
		try {
			InputStream stream = new FileInputStream("profesores.txt");
			Reader lector = new InputStreamReader(stream, "UTF-8");
			BufferedReader bw = new BufferedReader(lector);

			String line;
			while ((line = bw.readLine()) != null)
				System.out.println(line);
			bw.close();

		} catch (Exception err) {
			System.out.println(err.getMessage());

		}
	}

	/**
	 * escribe en el fichero
	 * 
	 * @param texto
	 * @throws IOException
	 */
	public void writeFich(ArrayList<String> texto) throws IOException {
		try {
			OutputStream stream = new FileOutputStream("profesores.txt");
			Writer lector = new OutputStreamWriter(stream, "UTF-8");
			BufferedWriter bw = new BufferedWriter(lector);

			for (int i = 0; i < texto.size(); i++) {
				bw.write(texto.get(i));
				bw.newLine();
			}
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
