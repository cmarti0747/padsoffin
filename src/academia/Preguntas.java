package academia;

import java.io.Serializable;

/**
 * Modulo que se encarga de gestionar las preguntas de un ejercicio
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public abstract class Preguntas implements Serializable {


	private static final long serialVersionUID = -3202872126688745881L;
	private String enunciado;
	private Visibilidad visibilidad;
	private double nota;
	private double ponderacion;
	

	/**
	 * Constructor de la clase abstracta Preguntas
	 * @param enunciado: Enunciado de la pregunta
	 * @param ponderacion: Ponderacion de la pregunta
	 */
	public Preguntas(String enunciado, double ponderacion) {
		this.visibilidad = academia.Visibilidad.INVISIBLE;
		this.nota = 0;
		this.enunciado = enunciado;
		this.ponderacion = ponderacion;
	}

	/**
	 * Constructor de la clase Preguntas sin ponderacion
	 * @param enunciado: Enunciado de la pregunta
	 */
	public Preguntas(String enunciado) {
		this(enunciado, 1);
	}

	/**
	 * Funcion que obtiene la nota de la pregunta
	 * @return Nota de la pregunta
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * Funcion que modifica la nota de una pregunta
	 * @param nota: Nueva nota
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}

	/**
	 * Funcion que obtiene el enunciado de la pregunta
	 * @return Enunciado de la pregunta
	 */
	public String getEnunciado() {
		return enunciado;
	}

	/**
	 * Funcion que modifica el enunciado de una pregunta
	 * @param enunciado: Nuevo enunciado
	 */
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	/**
	 * Funcion que obtiene la visiblidad de la pregunta
	 * @return Visibilidad de la pregunta
	 */
	public Visibilidad getVisibilidad() {
		return visibilidad;
	}

	/**
	 * Funcion que calcula la nota con la ponderacion de la pregunta
	 * @return Nota calculada
	 */
	public double calcularPonderacion() {
		
		  this.setNota(ponderacion);
		  return nota;
	}

	/**
	 * Funcion que modifica la visibilidad de una pregunta
	 * @param visibilidad: Nueva visibilidad
	 */
	public void setVisibilidad(Visibilidad visibilidad) {
		if (this.visibilidad == academia.Visibilidad.INVISIBLE
				|| this.visibilidad == academia.Visibilidad.VISIBLE_COMENZADO) {
			this.visibilidad = visibilidad;
		}
	}

	/**
	 * Funcion que obtiene la ponderacion de la pregunta
	 * @return Ponderacion de la pregunta
	 */
	public double getPonderacion() {
		return ponderacion;
	}

	/**
	 * Funcion que modifica la nota ode una pregunta
	 * @param ponderacion: Nueva ponderacion
	 */
	public void setPonderacion(double ponderacion) {
		this.ponderacion = ponderacion;
	}
	
	public abstract boolean enviarRespuesta(Respuesta respuesta,int nia);

	@Override
	/**
	 * Funcion que imprime los datos de la pregunta
	 * @return Cadena con todos los datos de la pregunta
	 */
	public String toString() {
		return "Preguntas [enunciado=" + enunciado + ", visibilidad=" + visibilidad + ", nota=" + nota
				+ ", ponderacion=" + ponderacion + "]\n";
	}

}