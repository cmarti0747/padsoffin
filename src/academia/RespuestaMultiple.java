package academia;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Modulo que se encarga de gestionar las respuestas de las preguntas tipo multiple
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class RespuestaMultiple extends Respuesta implements Serializable{


	private static final long serialVersionUID = 1L;
	private int nia;
	private int[] respuestas;

	
	/**
	 * Constructor de la clase RespuestaMultiple
	 * @param nia: NIA del alumno que responde
	 * @param respuestas: Respuestas dadas por el alumno
	 */
	public RespuestaMultiple(int nia, int[] respuestas) {

		this.nia = nia;
		this.respuestas = respuestas;
	}

	/**
	 * Funcion que obtiene el NIA del alumno que responde a la pregunta
	 * @return Alumno que responde a la pegunta
	 */
	public int getNia() {
		return nia;
	}

	/**
	 * Funcion que modifica el nia del alumno que responde
	 * @param nia: Nuevo nia
	 */
	public void setNia(int nia) {
		this.nia = nia;
	}

	/**
	 * Funcion que obtiene el conjunto de respuestas dadas por el alumno
	 * @return Respuestas dadas por el alumno
	 */
	public int[] getRespuestas() {
		
		return respuestas;
	}

	/**
	 * Funcion que modifica las respuestas dadas por el alumno
	 * @param respuestas: Nuevas respuestas
	 */
	public void setRespuestas(int[] respuestas) {
		this.respuestas = respuestas;
	}
	

	@Override
	/**
	 * Funcion que imprime los datos de una repsuesta multiple
	 * @return Cadena con todos los datos de una respuesta multiple
	 */
	public String toString() {
		return "RespuestaMultiple [nia=" + nia + ", respuestas=" + Arrays.toString(respuestas) + "]\n";
	}

}
