package academia;

import java.io.Serializable;
import java.util.ArrayList;

import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Modulo que se encarga de gestionar las asignaturas de la academia
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class Asignaturas implements Serializable {

	private static final long serialVersionUID = -684924112210325031L;
	private String titulo;
	private double notaMedia;
	private ArrayList<Temas> temas;

	private Visibilidad visibilidad;

	/**
	 * Constructor de la clase Asignatura
	 * @param titulo: Titulo de la asignatura
	 */
	public Asignaturas(String titulo) {
		this.titulo = titulo;
		this.notaMedia = 0;
		this.visibilidad = academia.Visibilidad.INVISIBLE;
		this.temas = new ArrayList<Temas>();
	}

	/**
	 * Funcion que obtiene una lista de temas de una asignatura
	 * @return Lista de temas de la asignatura
	 */
	public ArrayList<Temas> getTemas() {
		return temas;
	}

	/**
	 * Funcion que modifica la lista de temas de la asignatura
	 * @param temas: Lista nueva
	 */
	public void setTemas(ArrayList<Temas> temas) {
		this.temas = temas;
	}

	/**
	 * Funcion que crea un nuevo tema y lo añade a la lista de temas de la asignatura
	 * @param titulo: Titulo del tema a crear
	 */
	public void crearTemas(String titulo) {
		Temas tema = new Temas(titulo);
		this.temas.add(tema);
	}

	/**
	 * Funcion que calcula la nota media de una asignatura
	 * @return Nota media
	 */
	public double calcularMedia() {
		int total=0;
		for(int i=0;i<temas.size();i++){
			for(int j=0;j<temas.get(i).getEjercicios().size();j++){
				for(int k=0;k<temas.get(i).getEjercicios().get(j).getResultados().size();k++){
					total+=temas.get(i).getEjercicios().get(j).getResultados().get(k).getNota();
				}
				this.notaMedia+=total*(temas.get(i).getEjercicios().get(j).getPeso()/10);
			}
		}
		return this.notaMedia;
	}

	/**
	 * Funcion que modifica la visibilidad de una asignatura, modificando a la vez todas las clases por debajo de asignatura
	 * @param visibilidad: Nueva visibilidad
	 */
	public void setVisibilidad(Visibilidad visibilidad) {
		if (visibilidad == academia.Visibilidad.INVISIBLE) {
			for (int i = 0; i < temas.size(); i++) {
				temas.get(i).setVisibilidad(visibilidad);
			}
			this.visibilidad = visibilidad;
		} else if (visibilidad == academia.Visibilidad.VISIBLE) {
			this.visibilidad = visibilidad;
		}
	}

	/**
	 * Funcion que obtiene el titulo de una asignatura
	 * @return: Titulo de la asignatura
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Funcion que modifica el titulo de una asignatura
	 * @param titulo:Titulo nuevo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Funcion que obtiene la nota media de la asignatura
	 * @return:Nota media
	 */
	public double getNotaMedia() {
		return notaMedia;
	}

	/**
	 * Funcion que modifica la nota media de una asignatura
	 * @param notaMedia: Nueva nota media
	 */
	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	/**
	 * Funcion que elimina un tema de la lista de temas de una asignatura
	 * @param tema: Tema a eliminar
	 */
	public void eliminarTema(Temas tema) {
		this.temas.remove(tema);

	}

	/**
	 * Funcion que cambia el estado de la matricula de un alumno a false indicando que esta expulsado
	 * @param usuario: Alumno a expulsar
	 */
	public void expulsarAlumno(Alumno usuario) {

		for (int i = 0; i < AcademiaLopez.getMatriculas().size(); i++) {
			if (AcademiaLopez.getMatriculas().get(i).getAsignatura() == this
					&& AcademiaLopez.getMatriculas().get(i).getUsuario().equals(usuario)
					&& AcademiaLopez.getMatriculas().get(i).getEstado() == EstadoAlumno.ADMITIDO) {
				AcademiaLopez.getMatriculas().get(i).setEstado(EstadoAlumno.EXPULSADO);
				try {
					EmailSystem.send(AcademiaLopez.getMatriculas().get(i).getUsuario().getEmail(), "Expulsion de" + AcademiaLopez.getMatriculas().get(i).getAsignatura().getTitulo() , "Ha sido expulsado en la asignatura");
				} catch (InvalidEmailAddressException e) {
					
					e.printStackTrace();
				} catch (FailedInternetConnectionException e) {
					
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * Funcion que readmite a un alumno expulsado
	 * @param a: Alumno a readmitir
	 */
	public void readmitirAlumno(Alumno a) {

		for (int i = 0; i < AcademiaLopez.getMatriculas().size(); i++) {
			if (AcademiaLopez.getMatriculas().get(i).getAsignatura() == this
					&& AcademiaLopez.getMatriculas().get(i).getUsuario().equals(a)
					&& AcademiaLopez.getMatriculas().get(i).getEstado() == EstadoAlumno.EXPULSADO) {
				AcademiaLopez.getMatriculas().get(i).setEstado(EstadoAlumno.ADMITIDO);
				try {
					EmailSystem.send(AcademiaLopez.getMatriculas().get(i).getUsuario().getEmail(), "Readmision de" + AcademiaLopez.getMatriculas().get(i).getAsignatura().getTitulo() , "Ha sido readmitido en la asignatura");
				} catch (InvalidEmailAddressException e) {
					
					e.printStackTrace();
				} catch (FailedInternetConnectionException e) {
					
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * Funcion que obtiene la visibilidad de una asignatura
	 * @return: Visibilidad de la asignatura
	 */
	public Visibilidad getVisibilidad() {
		return this.visibilidad;
	}
	
	public Temas buscarTemas(String titulo){
		for (int i = 0; i < temas.size(); i++) {
			if (temas.get(i).getTitulo().equals(titulo)) {
				System.out.println(temas.get(i));
				return temas.get(i);
			}
		}
		return null;
	}
	
	

	@Override
	/**
	 * Funcion que imprime los datos de una asignatura
	 * @return Cadena con todos los datos de una asignatura
	 */
	public String toString() {
		return "Asignaturas [titulo=" + titulo + ", notaMedia=" + notaMedia + ", temas=" + temas + ", visibilidad="
				+ visibilidad + "]\n";
	}

}