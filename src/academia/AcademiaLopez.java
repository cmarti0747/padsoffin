package academia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Modulo que se encarga de gestionar la academia
 * @author Javie Senit Velasco y Carlos Marti Gonzalez
 *
 */

public class AcademiaLopez implements Serializable {

	private static final long serialVersionUID = 1L;
	private static List<Asignaturas> asignaturas;
	private List<Alumno> alumnos;
	private static List<Matriculado> matriculas;
	private Profesor profesor;
	

	boolean online;
	Usuario usuarioOnline;
	
	
/**
 * Contructor de la clase AcademiaLopez
 */
	public AcademiaLopez() {
			this.online=false;
			matriculas = new ArrayList<Matriculado>();
			alumnos = new ArrayList<Alumno>();
			asignaturas = new ArrayList<Asignaturas>();
			this.usuarioOnline=null;
	}

	@SuppressWarnings({ "unchecked" })
	/**
	 * Funcion que se encarga del inicio de sesion de un usuario en la academia
	 * @param nia: Nia de identificacion
	 * @param pass: Contrasenia de identificacion
	 * @return Usuario autenticado
	 * @throws FileNotFoundException: Error que salta si no se ha encontrado el .obj
	 * @throws ClassNotFoundException: Error que salta si no ha encotrado una clase
	 */
	public Usuario loggin(int nia, String pass) throws FileNotFoundException, IOException, ClassNotFoundException {
		if(this.online==true){
			System.out.println("Ya hay un usuario conectado");
			return null;
		}
		File f = new File("academia.obj");
		if (f.exists() == true) {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("academia.obj"));
			asignaturas = (List<Asignaturas>) entrada.readObject();
			alumnos = (List<Alumno>) entrada.readObject();
			matriculas = (List<Matriculado>) entrada.readObject();
			profesor = (Profesor) entrada.readObject();
			entrada.close();
			
			if (nia == profesor.getNia() && pass.equals(profesor.getPass()) == true) {
				this.online=true;
				this.usuarioOnline=this.profesor;
				System.out.println("Inicio de sesion\n" +this.profesor);
				return this.profesor;
			} else {
				for (int i = 0; i < alumnos.size(); i++) {
					if (nia == alumnos.get(i).getNia() && pass.equals(alumnos.get(i).getPass()) == true) {
						this.online=true;
						this.usuarioOnline=this.alumnos.get(i);
						System.out.println("Inicio de sesion\n" +this.alumnos.get(i));
						return this.alumnos.get(i);
					}
				}
			}
		} else {
			cargarUsuarios();
			if (nia == profesor.getNia() && pass.equals(profesor.getPass()) == true) {
				this.online=true;
				this.usuarioOnline=this.profesor;
				System.out.println("Inicio de sesion\n" +this.profesor);
				return this.profesor;
			} else {
				for (int i = 0; i < alumnos.size(); i++) {
					if (nia == alumnos.get(i).getNia() && pass.equals(alumnos.get(i).getPass()) == true ) {
						this.online=true;
						this.usuarioOnline=this.alumnos.get(i);
						System.out.println("Inicio de sesion\n" +this.alumnos.get(i));
						return this.alumnos.get(i);
					}
				}
			}

		}
		return null;

	}

	/**
	 * Funcion que busca un alumno de una lista
	 * @param nia: Nia del alumno a buscar
	 * @return Alumno buscado
	 */
	public Alumno buscarAlumno(int nia) {

		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNia() == nia) {
				System.out.println(alumnos.get(i));
				return alumnos.get(i);
			}
		}
		return null;
	}

	/**
	 * Funcion que busca una asignatura de una lista
	 * @param titulo: Ttulo de la asignatura a buscar
	 * @return: Asignatura buscada
	 */
	public Asignaturas buscarAsignatura(String titulo) {

		for (int i = 0; i < asignaturas.size(); i++) {
			if (asignaturas.get(i).getTitulo().equals(titulo)) {
				System.out.println(asignaturas.get(i));
				return asignaturas.get(i);
			}
		}
		return null;
	}
	
	
	public Matriculado buscarMatricula(String asignatura,int nombre) {

		for (int i = 0; i < matriculas.size(); i++) {
			if (matriculas.get(i).getAsignatura().getTitulo().equals(asignatura) && 
					matriculas.get(i).getUsuario().getNia() == nombre) {
				System.out.println(matriculas.get(i));
				return matriculas.get(i);
			}
		}
		return null;
	}
	
	public Temas buscarTema(String titulo){
		for(Asignaturas a: asignaturas){
			return a.buscarTemas(titulo);
		}
		return null;
	}
	
	public Apuntes buscarApuntes(String titulo){
		for(Asignaturas a : asignaturas){
			for(Temas t: a.getTemas()){
				 return t.buscarApuntes(titulo);
				}
			}
		return null;
	}
	
	public Temas buscarSubtemas(String titulo){
		for(Asignaturas a : asignaturas){
			for(Temas t: a.getTemas()){
				Temas st = t.buscarSubtemas(titulo);
				if(st!=null){
					 if(st.getTitulo().equals(titulo)){
						 return st;
					 }
				}
				}
			}
		return null;
	}
	
	public Ejercicio buscarEjercicio(String titulo){
		for(Asignaturas a : asignaturas){
			for(Temas t: a.getTemas()){
				return t.buscarEjercicio(titulo);
					 
				 }
				}
	return null;
	}
	
	public Temas buscarTemaPadre(String titulo){
		for(Asignaturas a : asignaturas){
			for(Temas t: a.getTemas()){
				Temas st = t.buscarSubtemasPadre(titulo);
				if(st!=null){
						 return st;
					 
				}
				}
			}
		return null;
		
	}

	/**
	 * Funci�n que desconecta a un usuario de la academia y guarda los cambios
	 * @return null
	 * @throws FileNotFoundException: Error que salta si no se ha encontrado el .obj
	 */
	public Usuario desconectar() throws FileNotFoundException, IOException {
	
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("academia.obj"));
		salida.writeObject(asignaturas);
		salida.writeObject(alumnos);
		salida.writeObject(matriculas);
		salida.writeObject(profesor);
		salida.close();
		this.usuarioOnline=null;
		this.online=false;
		System.out.println("Se ha desconectado correctamente");
		return null;
	}

	/**
	 * Funcion que devuelve una lista de asignaturas
	 * @return Lista de asignaturas
	 */
	public static List<Asignaturas> isAsignaturas() {
		return asignaturas;
	}

	/**
	 * Funcion que crea una asignatura
	 * @param titulo: Titulo de la asignatura
	 */
	public void crearAsignaturas(String titulo) {
		Asignaturas asignatura = new Asignaturas(titulo);
		if(AcademiaLopez.asignaturas.contains(asignatura)==true){
			System.out.println("Ya esta creada esa asignatura");
			return;
		}
		AcademiaLopez.asignaturas.add(asignatura);

	}

	/**
	 * Funcion que obtiene una lista de alumnos
	 * @return Lista de alumnos
	 */
	public List<Alumno> getAlumnos() {
		return Collections.unmodifiableList(this.alumnos);
	}

	/**
	 * Funcion que obtiene una lista de matriculas
	 * @return Lista de matriculas
	 */
	public static List<Matriculado> getMatriculas() {
		return matriculas;
	}

	/**
	 * Funcion que a�ade un alumno a la lista de alumnos
	 * @param a: Alumno a aniadir
	 */
	public void anyadirAlumno(Alumno a) {
		this.alumnos.add(a);
	}

	/**
	 * Funcion que carga de un fichero los usuarios de la academia
	 */
	public void cargarUsuarios() throws IOException {

		String s1, nombre, apellidos, correo, contrasena;
		int nia;
		BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"));

		while ((s1 = br.readLine()) != null) {

			StringTokenizer st = new StringTokenizer(s1, ";");
			nombre = st.nextToken();
			apellidos = st.nextToken();
			correo = st.nextToken();
			nia = Integer.parseInt(st.nextToken());
			contrasena = st.nextToken();

			Alumno alumno = new Alumno(nia, contrasena, nombre, apellidos, correo);
			this.anyadirAlumno(alumno);
		}
		br.close();
		Profesor p = new Profesor(1234, "prof", "Oscar", "Delgado");
		profesor = p;
	}

	public Usuario getUsuarioOnline() {
		return usuarioOnline;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	
	

	public static List<Asignaturas> getAsignaturas() {
		return asignaturas;
	}

	@Override
	/**
	 * Funcion que imrpime los datos de la clase AcademiaLopez
	 * @return Cadena con los datos de la academia
	 */
	public String toString() {
		return "AcademiaLopez [asignaturas=" + asignaturas + ", alumnos=" + alumnos + "\n" + ",matriculas=" + matriculas
				+ ", profesor=" + profesor + "]\n";
	}

}