package academia;

import java.util.ArrayList;

/**
 * Modulo que se encarga de gestionar las preguntas de tipo libre
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class PreguntaLibre extends Preguntas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3088734892288562693L;
	private String solucion;
	private ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();


	/**
	 * Constructor de la clase PreguntaLibre
	 * @param enunciado: Enunciado de la pregunta
	 * @param ponderacion: Ponderacion de la pregunta
	 * @param solucion: Solucion de la pregunta
	 */
	public PreguntaLibre(String enunciado, double ponderacion, String solucion) {
		super(enunciado, ponderacion);
		this.solucion = solucion;

	}

	/**
	 * Constructor de la clase PreguntaLibre sin ponderacion
	 * @param enunciado: Enunciado de la pregunta
	 * @param solucion: Solucion de la pregunta
	 */
	public PreguntaLibre(String enunciado, String solucion) {
		this(enunciado, 1, solucion);

	}

	/**
	 * Funcion que obtiene la solucion de la pregunta
	 * @return Solucion de la pregunta
	 */
	public String getSolucion() {
		return solucion;
	}

	/**
	 * Funcion que modifica la solucion de una pregunta
	 * @param solucion: Nueva solucion
	 */
	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	/**
	 * Funcion que aniade respuestas a la lista de respuestas de la asignatura
	 * @param nia: NIA del alumno que responde
	 * @param respuesta: Respuesta que da
	 */
	public boolean anyadirRespuesta(int nia, String respuesta) {
		Respuesta respuestas = new RespuestaLibre(nia, respuesta);
		if(this.corregirPregunta(respuesta)==true){
		this.respuestas.add(respuestas);
			return true;
		}
		this.respuestas.add(respuestas);
		return false;
	}

	/**
	 * Funcion que corrige una pregunta
	 * @param respuesta: Respuesta dada por un alumno
	 * @return true si es correcta, flase si no
	 */
	public boolean corregirPregunta(String respuesta) {
		if (this.solucion.equals(respuesta)) {
			this.calcularPonderacion();
			return true;
		}
		
		return false;
	}
	
	/**
	 * funcion que llama a aniadirRespuesta para enviar las respuestas
	 * @return true si se ha enviado, false si no
	 */
	public boolean enviarRespuesta(Respuesta respuesta,int nia){
		RespuestaLibre rm = (RespuestaLibre) respuesta;
		if(this.anyadirRespuesta(nia, rm.getRespuestas())==true){
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
		return "PreguntaLibre [solucion=" + solucion + ", respuestas=" + respuestas + "]\n";
	}

}