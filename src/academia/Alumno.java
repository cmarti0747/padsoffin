package academia;

import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Modulo que se encarga de gestionar los alumnos
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */
public class Alumno extends Usuario {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellidos;
	private String email;

	/**
	 * Constructor de la clase Alumno
	 * @param nia: Nia del alumno a crear
	 * @param pass: Contrasenia del alumno a crear
	 * @param nombre: Nombre del alumno a crear
	 * @param apellidos: Apellidos del alumno a crear
	 * @param email: Correo del alumno a crear
	 */
	public Alumno(int nia, String pass, String nombre, String apellidos, String email) {
		super(nia, pass);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}

	/**
	 * Funcion que solicita la inscripcion en una asignatura de la lista de asignaturas de la academia
	 */
	public boolean solicitudAsignatura(Asignaturas asignatura) {
		Matriculado matriculado = new Matriculado(this, asignatura);
		if (AcademiaLopez.isAsignaturas().contains(asignatura)) {
			for (int i = 0; i < AcademiaLopez.getMatriculas().size(); i++) {
				if(AcademiaLopez.getMatriculas().get(i).getUsuario().equals(this) 
						&& AcademiaLopez.getMatriculas().get(i).getAsignatura().equals(asignatura)) {
					if( AcademiaLopez.getMatriculas().get(i).getEstado().equals(EstadoAlumno.DENEGADO)){
						 AcademiaLopez.getMatriculas().get(i).setEstado(EstadoAlumno.PENDIENTE);
						return true;
					}else{
					System.out.println("Ya has hecho una solicitud de esta asignatura");
					return false;
					}
				}

			}
			
			AcademiaLopez.getMatriculas().add(matriculado);
				try {
					EmailSystem.send(this.email,"Solicitud Asignatura", "Su solicitud a la asignatura" + asignatura.getTitulo() + "ha sido enviada");
				} catch (InvalidEmailAddressException e) {
					
					e.printStackTrace();
				} catch (FailedInternetConnectionException e) {
					
					e.printStackTrace();
				}
			
		}
		return true;

	}

	/**
	 * Funcion que obtiene el nombre de un alumno
	 * @return Nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Funcion que modifica el nombre de un alumno
	 * @param nombre: Nombre nuevo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Funcion que obtiene los apellidos de un alumno
	 * @return Apellidos del alumno
	 */
	public String getApellidos() {
		return apellidos;
	}

	
	/**
	 * Funcion que modifica los apellidos de un alumno
	 * @param apellidos: Apellidos nuevos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Funcion que obtiene el correo de un alumno
	 * @return Correo del alumno
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Funcion que modifica el correo de un alumno
	 * @param email: Correo nuevo
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Funcion heredada de la clase Usuario
	 */
	public void aceptarAsignaturas(Matriculado c){
		
	}
	
	/**
	 * Funcion heredada de la clase Usuario
	 */
	public void denegarAsignaturas(Matriculado c){
		
	}

	@Override
	/**
	 * Funcion que imprime los datos de un alumno
	 * @return Cadena con los datos del alumno
	 */
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", nia "+ this.getNia()+", pass " + this.getPass()+"]\n";
	}

}