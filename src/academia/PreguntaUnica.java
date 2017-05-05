package academia;

import java.util.ArrayList;

/**
 * Modulo que se encarga de gestionar las preguntas de tipo unica
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class PreguntaUnica extends Preguntas {

	
	private static final long serialVersionUID = -6851216462100371793L;
	private int solucion;
	private ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

	/**
	 * Constructor de la clase PreguntaLibre
	 * @param enunciado: Enunciado de la pregunta
	 * @param ponderacion: Ponderacion de la pregunta
	 * @param solucion: Solucion de la pregunta
	 */
	public PreguntaUnica(String enunciado, double ponderacion, int solucion) {
		super(enunciado, ponderacion);
		this.solucion = solucion;

	}

	/**
	 * Constructor de la clase PreguntaLibre sin ponderacion
	 * @param enunciado: Enunciado de la pregunta
	 * @param solucion: Solucion de la pregunta
	 */
	public PreguntaUnica(String enunciado, int solucion) {
		this(enunciado, 1, solucion);

	}

	
	/**
	 * Funcion que obtiene la solucion de la pregunta
	 * @return Solucion de la pregunta
	 */
	public int isSolucion() {
		return solucion;
	}

	/**
	 * Funcion que modifica la solucion de la pregunta
	 * @param solucion: Nueva solucion
	 */
	public void setSolucion(int solucion) {
		this.solucion = solucion;
	}

	/**
	 * Funcion que aniade a la lista de respuesta de la pregunta una respuesta
	 * @param nia: NIA del alumno que responde
	 * @param respuesta: Respuesta dada por el alumno
	 */
	public boolean anyadirRespuesta(int nia, int respuesta) {
		Respuesta respuestas = new RespuestaUnica(nia, respuesta);
		if(this.corregirPregunta(respuesta)==true){
		this.respuestas.add(respuestas);
		return true;
		}
		return false;
	}

	/**
	 * Funcion que corrige la pregunta
	 * @param respuesta: Respuesta dada por el alumno
	 * @return true si es correcta, false si no
	 */
	public boolean corregirPregunta(int respuesta) {
		if (this.solucion == respuesta) {
			this.calcularPonderacion();
			return true;
		}
		return false;
	}
	
	/**
	 * Funcion que aniade una respuesta dada por un alumno a la lista de respuestas de la pregunta
	 * @return true si se ha enviado, false si no
	 */
	public boolean enviarRespuesta(Respuesta respuesta,int nia){
		RespuestaUnica ru = (RespuestaUnica) respuesta;
		if(this.anyadirRespuesta(nia, ru.getRespuestas())==true){
			return true;
		}
		return false;
	}

	@Override
	/**
	 * Funcion que imprime los datos de la pregunta
	 * @return Cadena con todos los datos de la pregunta
	 */
	public String toString() {
		return "PreguntaUnica [solucion=" + solucion + ", respuestas=" + respuestas + "]\n";
	}

}