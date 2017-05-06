package academia;

import java.io.Serializable;

/**
 * Modulo que se encarga de gestionar los apuntes de un tema
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class Apuntes implements Serializable {

	private static final long serialVersionUID = 8041555106847488535L;
	private String titulo;
	private String texto;
	private Visibilidad visibilidad;

	
	/**
	 * Constructor de la clase Apuntes
	 * @param titulo: Titulo de los apuntes
	 * @param texto: Texto de los apuntes
	 */
	public Apuntes(String titulo, String texto) {
		this.titulo = titulo;
		this.texto = texto;
		this.visibilidad = academia.Visibilidad.INVISIBLE;

	}

	/**
	 * Funcion que modifica los campos de la clase Apuntes
	 * @param titulo: Titulo nuevo
	 * @param texto: Texto nuevo
	 * @param visibilidad: Visibilidad nueva
	 */
	public void modificarApunte(String titulo, String texto, Visibilidad visibilidad) {
		this.setTexto(texto);
		this.setTitulo(titulo);
		this.setVisibilidad(visibilidad);
	}

	/**
	 * Funcion que obtiene el titulo de un apunte
	 * @return Titulo del apunte
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Funcion que modifica el titulo de un apunte
	 * @param titulo: Titulo nuevo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Funcion que obtiene el texto de un apunte
	 * @return: Texto del apunte
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * Funcion que modifica el texto de un apunte
	 * @param texto: Texto nuevo
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	
	/**
	 * Funcion que obtiene la visibilidad de un apunte
	 * @return Visibilidad del apunte
	 */
	public Visibilidad getVisibilidad() {
		return visibilidad;
	}

	/**
	 * Funcion que modifica la visibilidad del apunte
	 * @param visibilidad: Nueva visibilidad
	 */
	public void setVisibilidad(Visibilidad visibilidad) {
		if (visibilidad == academia.Visibilidad.INVISIBLE || visibilidad == academia.Visibilidad.VISIBLE)
			this.visibilidad = visibilidad;
	}

	@Override
	/**
	 * Funcion que imprime los datos de los apuntes
	 * @return Cadena con todos los datos de un apunte
	 */
	public String toString() {
		return "Apuntes [titulo=" + titulo + ", texto=" + texto + ", visibilidad=" + visibilidad + "]\n";
	}

}