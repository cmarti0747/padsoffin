package academia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Modulo que se encarga de gestionar las preguntas de tipo multiple
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class PreguntaMultiple extends Preguntas {

	private static final long serialVersionUID = -5058094786278779932L;
	private ArrayList<Integer> soluciones = new ArrayList<Integer>();
	private List<String> opciones = new ArrayList<String>();
	private ArrayList<Respuesta> respuestas= new ArrayList<Respuesta>();

	/**
	 * Constructor de la clase PreguntaLibre
	 * @param enunciado: Enunciado de la pregunta
	 * @param ponderacion: Ponderacion de la pregunta
	 * @param solucion: Soluciones de la pregunta
	 */
	public PreguntaMultiple(String enunciado, double ponderacion, int[] solucion,List<String> opciones) {
		super(enunciado, ponderacion);
		anyadirSoluciones(solucion);
		this.opciones = opciones;
	}

	/**
	 * Constructor de la clase PreguntaLibre sin ponderacion
	 * @param enunciado: Enunciado de la pregunta
	 * @param solucion: Soluciones de la pregunta
	 */
	public PreguntaMultiple(String enunciado, int[] solucion,List<String> opciones) {
		this(enunciado, 1, solucion, opciones);
	}

	/**
	 * Funcion que obtiene la lista de soluciones de la pregunta
	 * @return Lista de soluciones de la pregunta
	 */
	public List<Integer> getSoluciones() {
		return Collections.unmodifiableList(soluciones);
	}

	/**
	 * Funcion que aniade una solucion a la lista de soluciones de la pregunta
	 * @param soluciones: Soluciones dadas por un alumno
	 */
	public void anyadirSoluciones(int[] soluciones) {
		int i = 0;
		for (i = 0; i < soluciones.length; i++) {
			this.soluciones.add(soluciones[i]);
		}
	}

	/**
	 * Funcion que elimina de la lista de soluciones unas soluciones
	 * @param soluciones: Soluciones a eliminar
	 */
	public void eliminarSoluciones(int[] soluciones) {
		for(int i =0;i<soluciones.length;i++){
		this.soluciones.remove(i);
		}
	}

	/**
	 * Funcion que aniade a la lista de respuestas de la pregunta una respuesta
	 * @param nia: NIA del alumno que responde
	 * @param soluciones: Soluciones dadas por el alumno
	 */
	public boolean anyadirRespuesta(int nia, int[] soluciones) {
		Respuesta respuesta = new RespuestaMultiple(nia, soluciones);
		if(this.corregirPregunta(soluciones)==true){
		this.respuestas.add(respuesta);
		return true;
		}
		return false;

	}
	
	/**
	 * funcion que corrige la respuestas dadas por un alumno
	 * @param respuesta: respuestas dadas por el alumno
	 * @return true si se ha corregido bien, false si no
	 */
	public boolean corregirPregunta(int[] respuesta) {
		int a =0;
		int flag=0;
		for(int i =0;i<this.soluciones.size();i++){
			if (this.soluciones.get(i) == respuesta[i]) {
				flag++;
			}
			a++;
		}
		if(flag==a){
			this.calcularPonderacion();
			
			return true;
		}
		return false;
		
	}
	
	/**
	 * funcion que llama a anyadirRespuesta para enviar las respuestas dadas por un alumno
	 * @return true si se ha enviado, false si no
	 */
	public boolean enviarRespuesta(Respuesta respuesta,int nia){
		RespuestaMultiple rm = (RespuestaMultiple) respuesta;
		if(this.anyadirRespuesta(nia, rm.getRespuestas())==true){
			return true;
		}
		return false;
	}
	
	/**
	 * funcion que botiene la lista de respuestas de la pregunta
	 * @return lista de respuestas
	 */
	public List<Respuesta> getRespuestas(){
		return Collections.unmodifiableList(this.respuestas);
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getOpciones() {
		return opciones;
	}

	@Override
	/**
	 * Funcion que imprime los datos de la pregunta
	 * @return Cadena con todos los datos de la pregunta
	 */
	public String toString() {
		return "PreguntaMultiple [soluciones=" + soluciones + " respuestas=" + respuestas + "]\n";
	}

}