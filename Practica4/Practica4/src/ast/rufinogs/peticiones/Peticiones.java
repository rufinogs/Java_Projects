/**
 * 
 */
package ast.rufinogs.peticiones;

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

import ast.rufinogs.alumnos.Alumno;
import ast.rufinogs.peticiones.cola.Cola;
import ast.rufinogs.profesores.Profesor;

/**
 * @author rufino
 *
 */
public class Peticiones {
	private int id;
	private Profesor profesor;
	public Alumno alumno;
	private String asunto;

	/**
	 * Clase Peticiones
	 */
	public Peticiones() {
		// TODO Auto-generated constructor stub
	}

	public Peticiones(int id, Profesor profesor, Alumno alumno, String asunto) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.profesor = profesor;
		this.alumno = alumno;
		this.asunto = asunto;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the alumno
	 */
	public Alumno getAlumno() {
		return alumno;
	}

	/**
	 * @param alumno the alumno to set
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	/**
	 * @return the profesor
	 */
	public Profesor getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	/**
	 * @return the peticion
	 */
	public int getid() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setid(int id) {
		this.id = id;
	}

	/**
	 * @return the asunto
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * @param asunto the asunto to set
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * 
	 * @return la forma en la que quiero que se escriban las peticiones
	 */
	public String toString() {
		return "Peticion de tutoria nº" + this.id + " del " + this.alumno + ". Pide la tutoria con asunto " + "'"
				+ this.asunto + "'" + " con el profesor " + this.profesor;
	}

	/**
	 * 
	 * @return La forma en la que quiero que se escriba en el fichero
	 */
	public String toFile() {
		return this.alumno.toFile() + ";" + this.asunto + ";" + this.profesor.toFile();
	}

	/**
	 * 
	 * @param
	 * @throws IOException lee del fichero
	 */
	public void readFich() throws IOException {
		try {
			InputStream stream = new FileInputStream("peticiones.txt");
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
	 * 
	 * @param cola
	 * @throws IOException escribe en el fichero
	 */
	public void writeFich(Cola cola) throws IOException {
		try {
			OutputStream stream = new FileOutputStream("peticiones.txt");
			Writer lector = new OutputStreamWriter(stream, "UTF-8");
			BufferedWriter bw = new BufferedWriter(lector);

			while (!cola.getQueue().isEmpty()) {
				bw.write(cola.poll().toFile() + "\n");
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
