package academia;

import java.io.Serializable;

/**
 * Modulo que se encarga de gestionar los usuarios
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */

public abstract class Usuario implements Serializable {

	
	private static final long serialVersionUID = 6915882533596579576L;
	private int nia;
	private String pass;

	/**
	 * Constructor de la clase Usuario
	 * @param nia: nia del usuario
	 * @param pass: contrasenia del usuario
	 */
	public Usuario(int nia, String pass) {
		this.nia = nia;
		this.pass = pass;
	}

	/**
	 * funcion que obtiene el nia de un usuario
	 * @return nia del usuario
	 */
	public int getNia() {
		return nia;
	}

	/**
	 * funcion que modifica el nia de un usuario
	 * @param nia: nuevo nia
	 */
	public void setNia(int nia) {
		this.nia = nia;
	}

	/**
	 * funcion que obtiene la contrasenia del usuaio
	 * @return contrasenia del usuaio
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * funcion que modifica la contrasenia de un usuario
	 * @param pass: nueva contrasenia
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	public abstract boolean solicitudAsignatura(Asignaturas a);
	public abstract void aceptarAsignaturas(Matriculado c);
	public abstract void denegarAsignaturas(Matriculado c);
	
	public abstract String getEmail();

	@Override
	/**
	 * funcion que imprime los datos de un usuario
	 * @return cadena con todos los datos de un usuario
	 */
	public String toString() {
		return "Usuario [nia=" + nia + ", pass=" + pass + "]\n";
	}

}