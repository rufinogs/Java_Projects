/**
 * 
 */
package ast.rufinogs.profesores;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
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
	 * @throws IOException lee del fichero
	 */

	public void readFich() throws IOException {
		Charset charset = Charset.forName("UTF-8");
		Path filePath = FileSystems.getDefault().getPath("profesor.txt");

		BufferedReader bufferedReader = Files.newBufferedReader(filePath, charset);
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
	}

	/**
	 * @param texto
	 * @throws IOException escribe en el fichero
	 */
	public void writeFich(ArrayList<String> texto) throws IOException {
		Charset charset = Charset.forName("UTF-8");
		Path filePath = FileSystems.getDefault().getPath("profesor.txt");

		BufferedWriter bw = Files.newBufferedWriter(filePath, charset);

		for (int i = 0; i < texto.size(); i++) {
			bw.write(texto.get(i));
			bw.newLine();
		}
		bw.close();
	}
}
