package academia;

import java.util.ArrayList;
import java.util.List;

import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Modulo que se encarga de gestionar el profesor de la academia
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class Profesor extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7392111517370525469L;
	private String nombre;
	private String apellidos;
	private List<Asignaturas> asignaturas = new ArrayList<Asignaturas>();

	/**
	 * Constructor de la clase Profesor
	 * @param nia:NIA del profesor
	 * @param pass:Contraseña del profesor
	 * @param nombre: Nombre del profesor
	 * @param apellidos: Apellidos del profesor
	 */
	public Profesor(int nia, String pass, String nombre, String apellidos) {
		super(nia, pass);
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	/**
	 * Funcion que obtiene el nombre de un profesor
	 * @return Nombre del profesor
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Funcion que modifica el nombre de un profesor
	 * @param nombre: Nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Funcion que obtiene los apellidos de un profesor
	 * @return Apellidos del profesor
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Funcion que modifica los apellidos de un profesor
	 * @param apellidos: Nuevos apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Funcion que obtiene la lista de asignaturas de un profesor
	 * @return Lista de asignaturas del profesor
	 */
	public List<Asignaturas> isAsignaturas() {
		return asignaturas;
	}

	/**
	 * Funcion heredada de la clase Usuario que cambia el estado de una matricula a true y el estado de pendiente a false
	 */
	public void aceptarAsignaturas(Matriculado matricula) {
		for (int i = 0; i < AcademiaLopez.getMatriculas().size(); i++) {
			if (AcademiaLopez.getMatriculas().get(i).equals(matricula)) {
				AcademiaLopez.getMatriculas().get(i).setEstado(EstadoAlumno.ADMITIDO);
				try {
					EmailSystem.send(matricula.getUsuario().getEmail(), "Solicitud de" + matricula.getAsignatura().getTitulo() , "Su solicitud ha sido aceptada");
				} catch (InvalidEmailAddressException e) {
					
					e.printStackTrace();
				} catch (FailedInternetConnectionException e) {
					
					e.printStackTrace();
				}
				break;
				}
			
			}
		return;
	}

	/**
	 * Funcion heredada de la clase Usuario que cambia el estado pendiente de una matricula y el estado a false
	 */
	public void denegarAsignaturas(Matriculado matricula) {
		for (int i = 0; i < AcademiaLopez.getMatriculas().size(); i++) {
			if (AcademiaLopez.getMatriculas().get(i) == matricula) {
				AcademiaLopez.getMatriculas().get(i).setEstado(EstadoAlumno.DENEGADO);
				try {
					EmailSystem.send(matricula.getUsuario().getEmail(), "Solicitud de" + matricula.getAsignatura().getTitulo() , "Su solicitud ha sido denegada");
				} catch (InvalidEmailAddressException e) {
					
					e.printStackTrace();
				} catch (FailedInternetConnectionException e) {
					
					e.printStackTrace();
				}
				break;
			}
		}
		return;
	}
	

	@Override
	/**
	 * Funcion que imprime los datos de un profesor
	 * @return Cadena con todos los datos de un profesor
	 */
	public String toString() {
		return "Profesor [nombre=" + nombre + ", apellidos=" + apellidos + ", asignaturas=" + asignaturas + "]\n";
	}

	@Override
	public boolean solicitudAsignatura(Asignaturas a) {
		return false;
		
	}

	@Override
	public String getEmail() {
		
		return null;
	}

}