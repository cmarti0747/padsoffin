
package academia;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Modulo que se encarga de gestionar los ejercicios de un tema
 * 
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class Ejercicio implements Serializable {

	private static final long serialVersionUID = -781010444471135361L;
	private String titulo;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double nota;
	private Visibilidad visibilidad;
	private ArrayList<Preguntas> preguntas = new ArrayList<Preguntas>();
	private ArrayList<Resultado> resultados = new ArrayList<Resultado>();
	private ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
	private Estadistica estadisticas;
	private double peso;
	private int numPregunta = 0;

	/**
	 * Constructor de la clase Ejercicio
	 * 
	 * @param titulo:
	 *            Titulo del ejercicio
	 * @param fechaInicio:
	 *            Fecha de inicio del ejercicio
	 * @param fechaFin:
	 *            Fecha de finalizacion del ejercicio
	 * @param nota:
	 *            Nota del ejercicio
	 */
	public Ejercicio(String titulo, LocalDate fechaInicio, LocalDate fechaFin, double nota,double peso) {
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.nota = nota;
		this.visibilidad = academia.Visibilidad.INVISIBLE;
		this.estadisticas = new Estadistica();
		this.peso=peso;
	}

	/**
	 * Funcion que modifica los atributos de un ejercicio
	 * 
	 * @param titulo:
	 *            Nuevo titulo
	 * @param fechaInicio:
	 *            Nueva fecha de inicio
	 * @param fechaFin:
	 *            Nueva fecha de finalizacion
	 * @param nota:
	 *            Nueva nota
	 * @param visibilidad:
	 *            Nueva visibilidad
	 */
	public void modificarEjercicio(String titulo, LocalDate fechaInicio, LocalDate fechaFin, double nota,
			Visibilidad visibilidad) {
		if (this.esModificable() == true) {
			this.setTitulo(titulo);
			this.setFechaInicio(fechaInicio);
			this.setNota(nota);
			this.setVisibilidad(visibilidad);
		}
		this.setFechaFin(fechaFin);
	}

	/**
	 * Funcion que obtiene una lista de preguntas de un ejercicio
	 * 
	 * @return Lista de preguntas
	 */
	public ArrayList<Preguntas> getPreguntas() {
		return preguntas;
	}

	/**
	 * Funcion que crea una nueva pregunta de tipo libre y la a�ade a la lista
	 * de preguntas
	 * 
	 * @param enunciado:
	 *            Enunciado de la pregunta
	 * @param ponderacion:
	 *            Ponderacion de la pregunta
	 * @param solucion:
	 *            Solucion de la pregunta
	 */
	public void crearPreguntaLibre(String enunciado, double ponderacion, String solucion, boolean aleatorio) {
		Preguntas p;
		if (ponderacion == 0) {
			p = new PreguntaLibre(enunciado, solucion);
		} else {
			p = new PreguntaLibre(enunciado, ponderacion, solucion);
		}

		this.preguntas.add(p);

		if (aleatorio == true) {
			Collections.shuffle(this.preguntas);
		}

	}

	/**
	 * Funcion que crea una nueva pregunta de tipo unica y la a�ade a la lista
	 * de preguntas
	 * 
	 * @param enunciado:
	 *            Enunciado de la pregunta
	 * @param ponderacion:
	 *            Ponderacion de la pregunta
	 * @param solucion:
	 *            Solucion de la pregunta
	 */
	public void crearPreguntaUnica(String enunciado, double ponderacion, int solucion, boolean aleatorio,List<String> opciones) {
		Preguntas p;
		if (ponderacion == 0) {
			p = new PreguntaUnica(enunciado, solucion,opciones);
		} else {
			p = new PreguntaUnica(enunciado, ponderacion, solucion,opciones);
		}

		this.preguntas.add(p);
		if (aleatorio == true) {
			Collections.shuffle(this.preguntas);
		}
	}

	/**
	 * Funcion que crea una nueva pregunta de tipo multiple y la a�ade a la
	 * lista de preguntas
	 * 
	 * @param enunciado:
	 *            Enunciado de la pregunta
	 * @param ponderacion:
	 *            Ponderacion de la pregunta
	 * @param solucion:
	 *            Soluciones de la pregunta
	 */
	public void crearPreguntaMultiple(String enunciado, double ponderacion, int[] solucion, boolean aleatorio,List<String> opciones) {
		Preguntas p;
		if (ponderacion == 0) {
			p = new PreguntaMultiple(enunciado, solucion,opciones);
		} else {
			p = new PreguntaMultiple(enunciado, ponderacion, solucion,opciones);
		}

		this.preguntas.add(p);
		if (aleatorio == true) {
			Collections.shuffle(this.preguntas);
		}
	}

	/**
	 * Funcion que calcula la nota obtenida en un ejercicio
	 */
	public void calcularNota() {
		double nota = 0, pond = 0;
		int i = 0;
		for (i = 0; i < preguntas.size(); i++) {
			nota += preguntas.get(i).getNota();
			pond += preguntas.get(i).getPonderacion();
		}
		nota = (10 * nota) / pond;
		this.setNota(nota);
	}

	/**
	 * Funcion que modifica la visibilidad de un ejercicio
	 * 
	 * @param visibilidad:
	 *            Nueva visibilidad
	 */
	public void setVisibilidad(Visibilidad visibilidad) {
		int i = 0;

		if (visibilidad == academia.Visibilidad.INVISIBLE) {
			this.visibilidad = visibilidad;
			for (i = 0; i < preguntas.size(); i++) {
				preguntas.get(i).setVisibilidad(visibilidad);
			}
		} else if (visibilidad == academia.Visibilidad.VISIBLE_COMENZADO
				|| visibilidad == academia.Visibilidad.VISIBLE_CONTESTADO
				|| visibilidad == academia.Visibilidad.VISIBLE_NOCOMENZADO
				|| visibilidad == academia.Visibilidad.VISIBLE_TERIMNADO
				||visibilidad == academia.Visibilidad.VISIBLE
				|| visibilidad == academia.Visibilidad.INVISIBLE) {
			this.visibilidad = visibilidad;
		}
	}

	/**
	 * Funcion que cancela un ejercicio
	 * 
	 * @return true
	 */
	public boolean cancelarEjercicio() {
		return true;
	}

	/**
	 * Funcion que termina un ejercicio
	 */
	public void terminarEjercicio(ArrayList<Respuesta> respuestas, int nia) {
	
		for (int i = 0; i < this.preguntas.size(); i++) {
			if (this.preguntas.get(i).enviarRespuesta(respuestas.get(i), nia) == true) {
				estadisticas.sumarContestadosCorrectos();
			} else {
				estadisticas.sumarContestadosIncorrectos();
			}

		}
		this.calcularNota();
		anyadirResultado(nia, this.nota);
		for(int i =0;i<preguntas.size();i++){
			preguntas.get(i).setNota(0);
		}
		
		this.setVisibilidad(academia.Visibilidad.VISIBLE_CONTESTADO);
		estadisticas.restarSinContestar();
		this.nota=0;
	}

	/**
	 * Funcion que permite comprobar si un ejercicio se puede realizar
	 * 
	 * @return true si se puede, false si no
	 */
	public boolean realizarEjercicio() {
		if (this.getVisibilidad() == academia.Visibilidad.VISIBLE_COMENZADO
				|| this.getVisibilidad() == academia.Visibilidad.VISIBLE_CONTESTADO) {
			return true;
		}
		return false;
	}

	/**
	 * Funcion que permite comprobar si un ejercicio es eliminable
	 * 
	 * @return true si se puede, false si no
	 */
	public boolean esEliminable() {
		if (this.visibilidad == academia.Visibilidad.VISIBLE_NOCOMENZADO
				|| this.visibilidad == academia.Visibilidad.VISIBLE
				|| this.visibilidad == academia.Visibilidad.INVISIBLE) {
			return true;
		}
		return false;
	}

	/**
	 * Funcion que permite comprobar si un ejercicio es modificable
	 * 
	 * @return true si se puede, false si no
	 */
	public boolean esModificable() {
		if (this.visibilidad == academia.Visibilidad.VISIBLE_NOCOMENZADO
				|| this.visibilidad == academia.Visibilidad.INVISIBLE) {
			return true;
		}
		return false;
	}

	/**
	 * Funcion que obtiene el titulo de un ejercicio
	 * 
	 * @return Titulo del ejercicio
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Funcion que modifica el titulo de un ejercicio
	 * 
	 * @param titulo:
	 *            Nuevo titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Funcion que obtiene la fecha de inicio de un ejercicio
	 * 
	 * @return Fecha de inicio
	 */
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Funcion que modifica la fecha de inicio de un ejercicio
	 * 
	 * @param fechaInicio:
	 *            Nueva fecha de inicio
	 */
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Funcion que obtiene la fecha de finalizacion de un ejercicio
	 * 
	 * @return Fecha de finalizacion
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	/**
	 * Funcion que modifica la fecha de finalizacion de un ejercicio
	 * 
	 * @param fechaFin:
	 *            Nueva fecha de finalizacion
	 */
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Funcion que obtiene la nota de un ejercicio
	 * 
	 * @return Nota del ejercicio
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * Funcion que modifica la nota de un ejercicio
	 * 
	 * @param nota:
	 *            Nueva nota
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}

	/**
	 * Funcion que obtiene la visibilidad de un ejercicio
	 * 
	 * @return Visibilidad de un ejercicio
	 */
	public Visibilidad getVisibilidad() {
		return visibilidad;
	}

	/**
	 * Funcion que aniade un resultado a la lista de resultados del ejercicio
	 * 
	 * @param nia:
	 *            nia del alumno que responde
	 * @param nota:
	 *            nota del alumno
	 */

	public void anyadirResultado(int nia, double nota) {
		Resultado resul = new Resultado(nia, nota);
		this.resultados.add(resul);
	}

	/**
	 * Funcion que obtiene la lista de resultados del ejercicio
	 * 
	 * @return lista de resultados
	 */
	public ArrayList<Resultado> getResultados() {
		return resultados;
	}

	/**
	 * funcion que modifica la lista de resultados del ejercicio
	 * 
	 * @param resultados:
	 *            nuevo resultado
	 */
	public void setResultados(ArrayList<Resultado> resultados) {
		this.resultados = resultados;
	}

	/**
	 * funcion que modifica la lista de preguntas del ejercicio
	 * 
	 * @param preguntas:
	 *            nueva pregunta
	 */
	public void setPreguntas(ArrayList<Preguntas> preguntas) {
		this.preguntas = preguntas;
	}

	public void MostrarEstadisticas() {

		for (int i = 0; i < AcademiaLopez.getMatriculas().size(); i++) {
			for (int j = 0; j < AcademiaLopez.getMatriculas().get(i).getAsignatura().getTemas().size(); j++) {
				for (int k = 0; k < AcademiaLopez.getMatriculas().get(i).getAsignatura().getTemas().get(j)
						.getEjercicios().size(); k++) {
						estadisticas.sumarSinContestar();
					

				}

			}
			
		}
		System.out.println(estadisticas);

	}
	
	
	

	public void setNumPregunta(int numPregunta) {
		this.numPregunta = numPregunta;
	}

	public Estadistica getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(Estadistica estadisticas) {
		this.estadisticas = estadisticas;
	}

	public double getPeso() {
		return peso;
	}
	
	public Preguntas buscarPregunta(String enunciado){
		for(Preguntas p: preguntas){
			if(p.getEnunciado().equals(enunciado)){
				return p;
			}
		}
		return null;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void eliminarPregunta(String enunciado){
		List<Preguntas> aeliminar = new ArrayList<Preguntas>();
		for(Preguntas p: preguntas){
			if(p.getEnunciado().equals(enunciado)){
				aeliminar.add(p);
			}
		}
		preguntas.removeAll(aeliminar);
		
	}
	
	public void anyadirRespuesta(int i, Respuesta res){
		if(respuestas.get(i).equals(null)){
			respuestas.add(i, res);
		}
		respuestas.remove(i);
		respuestas.add(i, res);
	}
	
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}

	public int getNumPregunta() {
		return numPregunta;
	}

	@Override
	/**
	 * Funcion que imprime los datos de un ejercicio
	 * 
	 * @return Cadena con todos los datos de un ejercicio
	 */
	public String toString() {
		return "Ejercicio [titulo=" + titulo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", nota="
				+ nota + ", visibilidad=" + visibilidad + ", preguntas=" + preguntas + "]\n";
	}

}