package academia;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Modulo que se encarga de gestionar las matriculas
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class Matriculado implements Serializable {

	
	private static final long serialVersionUID = -2693479497488502293L;
	private EstadoAlumno estado;
	private Usuario usuario;
	private Asignaturas asignatura;


	/**
	 * Constructor de la clase Matriculado
	 * @param usuario: Usuario matriculado
	 * @param asignatura: Asignatura en la que se matricula
	 */
	public Matriculado(Usuario usuario, Asignaturas asignatura) {
		this.estado = EstadoAlumno.PENDIENTE;
		this.usuario = usuario;
		this.asignatura = asignatura;
	}

	/**
	 * Funcion que obtiene el estado de la matricula
	 * @return Estado de la matricula
	 */
	public EstadoAlumno getEstado() {
		return estado;
	}

	/**
	 * Funcion que modifica el estado de una matricula
	 * @param estado: Nuevo estado
	 */
	public void setEstado(EstadoAlumno estado) {
		this.estado = estado;
	}

	/**
	 * Funcion que obtiene el usuario de una matricula
	 * @return Usuario de la matricula
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * Funcion que modifica el usuario de la matricula
	 * @param usuario: Usuario nuevo
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Funcion que obtiene la asignatura de la matricula
	 * @return Asignatura de la matricula
	 */
	public Asignaturas getAsignatura() {
		return this.asignatura;
	}

	/**
	 * Funcion que modifica la asignatura de una matricula
	 * @param asignatura: Nueva asignatura
	 */
	public void setAsignatura(Asignaturas asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	/**
	 * Funcion que imprime los datos de un matriculado
	 * @return Cadena con todos los datos de un matriculado
	 */
	public String toString() {
		return "Matriculado [estado=" + estado + ", usuario=" + usuario + ", asignatura=" + asignatura + "]\n";
	}

}