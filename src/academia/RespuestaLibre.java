package academia;

/**
 * Modulo que se encarga de gestionar las respuestas de las preguntas tipo libre
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class RespuestaLibre extends Respuesta {

	
	private static final long serialVersionUID = 1L;
	private int nia;
	private String respuesta;

	/**
	 * Constructor de la clase RespuestaLibre
	 * @param nia: Nia de la respuesta libre
	 * @param respuesta: Respuesta dada por el alumno
	 */
	public RespuestaLibre(int nia, String respuesta) {
		this.nia = nia;
		this.respuesta = respuesta;
	}

	/**
	 * Funcion que obtiene el NIA del alumno que da la repsuesta
	 * @return
	 */
	public int getNia() {
		return nia;
	}

	/**
	 * Funcion que modifica el NIA del alumno que da la espuesta
	 * @param nia: Nuevo nia
	 */
	public void setNia(int nia) {
		this.nia = nia;
	}

	/**
	 * Funcion que obtiene la repsuesta dada por el alumno
	 * @return Respuesta dada por el alumno
	 */
	public String getRespuestas() {
		return this.respuesta;
	}

	/**
	 * Funcion que modifica la respuesta dada por el alumno
	 * @param respuestas: Nueva respuesta
	 */
	public void setRespuestas(String respuestas) {
		this.respuesta = respuestas;
	}

	@Override
	/**
	 * Funcion que imprime los datos de la respuesta
	 * @return Cadena con todos los datos de la respuesta
	 */
	public String toString() {
		return "RespuestaLibre [nia=" + nia + ", respuesta=" + respuesta + "]\n";
	}

}