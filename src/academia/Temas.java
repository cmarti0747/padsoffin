package academia;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Modulo que se encarga de gestionar los temas de las asignaturas
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class Temas implements Serializable{

	private static final long serialVersionUID = 1L;
	private String titulo;
	private Visibilidad visibilidad;
	private ArrayList<Temas> subtemas;
	private ArrayList<Ejercicio> ejercicios;
	private ArrayList<Apuntes> apuntes;

	/**
	 * Constructor de la clase Temas
	 * @param titulo: titulo del tema
	 */
	public Temas(String titulo) {
		this.titulo = titulo;
		this.visibilidad = academia.Visibilidad.INVISIBLE;
		this.subtemas = new ArrayList<Temas>();
		this.ejercicios = new ArrayList<Ejercicio>();
		this.apuntes = new ArrayList<Apuntes>();
	}

	/**
	 * Funcion que obtiene el titulo de un tema
	 * @return titulo del tema
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * funcion que modifica el titulo de tema
	 * @param titulo: nuevo titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * funcion que obtiene la visibilidad de un tema
	 * @return visibilidad de un tema
	 */
	public Visibilidad getVisibilidad() {
		return visibilidad;
	}

	/**
	 * funcion que modifica los atributos de un tema
	 * @param titulo: nuevo titulo
	 * @param visibilidad: nueva visibilidad
	 */
	public void modificarTema(String titulo, Visibilidad visibilidad) {
		this.setVisibilidad(visibilidad);
		this.setTitulo(titulo);
	}

	/**
	 * funcion que elimina un subtema de la lista de subtemas de un tema
	 * @param tema: subtema a eliminar
	 */
	public void eliminarSubTema(Temas tema) {
		this.subtemas.remove(tema);

	}

	/**
	 * funcion que crea un apunte y lo aniade a la lista de apuntes del tema
	 * @param titulo: titulo del apunte
	 * @param texto: texto del apunte
	 */
	public void crearApuntes(String titulo, String texto) {
		Apuntes apunte = new Apuntes(titulo, texto);
		this.apuntes.add(apunte);

	}

	/**
	 * funcion que modifica la visibilidad de un tema
	 * @param visibilidad: nueva visibilidad
	 */
	public void setVisibilidad(Visibilidad visibilidad) {
		int i = 0;
		if (visibilidad == academia.Visibilidad.INVISIBLE) {
			for (i = 0; i < apuntes.size(); i++) {
				apuntes.get(i).setVisibilidad(visibilidad);
			}
			for (i = 0; i < ejercicios.size(); i++) {
				ejercicios.get(i).setVisibilidad(visibilidad);
			}
			for (i = 0; i < subtemas.size(); i++) {
				subtemas.get(i).setVisibilidad(visibilidad);
			}
		}
		this.visibilidad = visibilidad;
	}

	/**
	 * funcion que crea un ejecicio y lo aniade a la lista de ejercicios de un tema
	 * @param titulo: titulo del ejecicio
	 * @param fechaInicio: fecha de iniciacion del ejercicio
	 * @param fechaFin: fecha de finalizacion del ejecicio
	 * @param nota: nota del ejecicio
	 */
	public void crearEjercicio(String titulo, LocalDate fechaInicio, LocalDate fechaFin, double nota,double peso) {
		Ejercicio ejercicio = new Ejercicio(titulo, fechaInicio, fechaFin, nota,peso);
		this.ejercicios.add(ejercicio);

	}

	/**
	 * funcion que elimina de la lista de ejercicios un ejercicio
	 * @param e: ejercicio a eliminar
	 */
	public void eliminarEjercicio(Ejercicio e) {
		if (e.esEliminable() == true) {
			this.ejercicios.remove(e);
		}
	}

	/**
	 * funcion que obtiene la lista de subtemas de un tema
	 * @return lista de subtemas
	 */
	public ArrayList<Temas> getSubtemas() {
		return subtemas;
	}

	/**
	 * funcion que obtiene la lista de apuntes de un tema
	 * @return lista de apuntes
	 */
	public ArrayList<Apuntes> getApuntes() {
		return apuntes;
	}

	/**
	 * funcion que obtiene la lista de ejercicios de un tema
	 * @return lista de ejecicios de un tema
	 */
	public ArrayList<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	/**
	 * funcion que elimina de la lista de apuntes un apunte
	 * @param apunte: apunte a eliminar
	 */
	public void eliminarApuntes(Apuntes apunte) {
		this.apuntes.remove(apunte);
	}

	/**
	 * funcion que crea un nuevo subtema y lo aniade a la lista de subtemas
	 * @param titulo: titulo del subtema a crear
	 */
	public void crearSubTemas(String titulo) {
		Temas tema = new Temas(titulo);
		this.subtemas.add(tema);
	}

	@Override
	/**
	 * funcion que impime los datos de un tema
	 * @return cadena con todos los datos de un tema
	 */
	public String toString() {
		return "Temas [titulo=" + titulo + ", visibilidad=" + visibilidad + ", subtemas=" + subtemas + ", ejercicios="
				+ ejercicios + ", apuntes=" + apuntes + "]\n";
	}

}