package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import academia.*;

/**
 * Modulo de la clase ControladorPanelControlador. Se encarga de realizar casi
 * al completo todas la funcionalidad de la aplicacion excepto algunos metodos
 * como los de entrar, o salir cerrando la ventana
 * 
 * @author Javier Senit y Carlos Marti
 *
 */
public class ControladorPanelControlador {

	private PanelControlador vista;
	private AcademiaLopez academia;

	/**
	 * Constructor de la clase ControladorPanelControlador
	 * 
	 * @param vista
	 *            vista principal del panel controlador
	 * @param academia
	 *            academia
	 */
	public ControladorPanelControlador(PanelControlador vista, AcademiaLopez academia) {
		this.academia = academia;
		this.vista = vista;
	}

	/**
	 * Funcion que desconecta a un usuario de la academia
	 * 
	 * @throws FileNotFoundException
	 *             file de academia no encontrado
	 * @throws IOException
	 *             IOException
	 */
	public void desconectar() throws FileNotFoundException, IOException {
		academia.desconectar();
		VistaLogin vista = new VistaLogin();
		ControladorLogin controlaLogin = new ControladorLogin(vista, academia);
		vista.setControlador(controlaLogin);
		this.vista.setVisibilidad(false);
	}

	/**
	 * Funcion que crea una asignatura en la academia
	 * 
	 * @param titulo
	 *            titulo de la asignatura
	 * @param visibilidad
	 *            visibilidad de la asignatura
	 */
	public void crearAsignatura(String titulo, Visibilidad visibilidad) {

		academia.crearAsignaturas(titulo);
		academia.buscarAsignatura(titulo).setVisibilidad(visibilidad);
	}

	/**
	 * Funcion que obtiene todas las asignaturas de la academia
	 * 
	 * @return lista con todas las asignaturas
	 */
	public List<String> getnomAsignaturas() {

		List<String> nombresAsig = new ArrayList<String>();
		if (AcademiaLopez.getAsignaturas() != null) {
			for (Asignaturas a : AcademiaLopez.getAsignaturas()) {
				nombresAsig.add(a.getTitulo());
			}
		} else {
			nombresAsig.add("");
		}
		return nombresAsig;
	}

	/**
	 * Funcion que obtiene todas las matriculas de la academia
	 * 
	 * @return lista con todas las matriculas
	 */
	public List<String> getnomMatriculas() {

		List<String> nombresMatr = new ArrayList<String>();
		if (AcademiaLopez.getAsignaturas() != null) {
			for (Matriculado a : AcademiaLopez.getMatriculas()) {
				if (a.getEstado().equals(EstadoAlumno.PENDIENTE)) {
					nombresMatr.add(a.getUsuario().getNia() + "/" + a.getAsignatura().getTitulo());
				}
			}
		} else {
			nombresMatr.add("");
		}

		return nombresMatr;
	}

	/**
	 * Funcion que carga todos los datos de la academia
	 */
	public void cargarDatos() {
		// Solicitud Matriculas
		for (String n : getnomMatriculas()) {

			vista.getPanelhomeprofesor().getModel().addElement(n);
		}

		for (String n : getnomAlumnos()) {
			vista.getPanelhomeprofesor().getCombobox().addItem(n);
		}

		for (String n : getnomAsignaturas()) {
			vista.getPanelhomeprofesor().getModelo().addElement(n);

		}

		for (String n : getnomAsignaturas()) {
			Matriculado m = academia.buscarMatricula(n, academia.getUsuarioOnline().getNia());
			if (academia.buscarAsignatura(n).getVisibilidad().equals(Visibilidad.VISIBLE)
					&& (m == null || m.getEstado().equals(EstadoAlumno.DENEGADO))) {
				vista.getPanelhomealumno().getModel().addElement(n);
			}
		}

		for (String n : getnomAsignaturas()) {
			Matriculado m = academia.buscarMatricula(n, academia.getUsuarioOnline().getNia());
			if (m != null) {
				if (m.getEstado().equals(EstadoAlumno.ADMITIDO)
						&& academia.buscarAsignatura(n).getVisibilidad().equals(Visibilidad.VISIBLE)) {
					vista.getPanelhomealumno().getModelo().addElement(n);

				}
			}
		}

	}

	/**
	 * Funcion que carga todos los temas en la vista del alumno
	 * 
	 * @param asignatura
	 *            asignatura de la cual se cargan los temas
	 */
	public void cargarTemasAlumno(String asignatura) {
		for (String m : getnomTemas(asignatura)) {
			if (academia.buscarAsignatura(asignatura).buscarTemas(m).getVisibilidad().equals(Visibilidad.VISIBLE)) {
				vista.getPanelasignaturaalumno().getModel().addElement(m);
			}

		}

	}

	/**
	 * Funcion que carga todos los temas en la vista del profesor
	 * 
	 * @param asignaturas
	 *            asignatura de la cual se cargan los temas
	 */
	public void cargarTemasProfesor(String asignaturas) {

		for (String m : getnomTemas(asignaturas)) {
			vista.getPanelasignatura().getModel().addElement(m);
			;

		}

	}

	/**
	 * Funcion que obtiene el nombre de todos los temas
	 * 
	 * @param n
	 *            asignatura a la que pertenecen los temas
	 * @return lista con todos los temas
	 */
	private List<String> getnomTemas(String n) {
		List<String> nombresTemas = new ArrayList<String>();
		Asignaturas a = academia.buscarAsignatura(n);
		if (a != null && a.getTemas() != null) {
			for (Temas t : a.getTemas()) {
				nombresTemas.add(t.getTitulo());
			}
		} else {
			nombresTemas.add("");
		}

		return nombresTemas;
	}

	/**
	 * Funcion que obtiene el nombre de alumnos que pertenecen a la academia
	 * 
	 * @return lista con todos los alumno de la academia
	 */
	private List<String> getnomAlumnos() {
		List<String> nombresAl = new ArrayList<String>();
		if (academia.getAlumnos() != null) {
			for (Alumno a : academia.getAlumnos()) {
				nombresAl.add(a.getNombre() + " " + a.getApellidos());
			}
		} else {
			nombresAl.add("");
		}
		return nombresAl;
	}

	/**
	 * Funcion que busca un asignatura por su titulo
	 * 
	 * @param s
	 *            titulo de la asignatura
	 * @return true si esta, false si no
	 */
	public boolean buscarAsignatura(String s) {
		if (academia.buscarAsignatura(s) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Funcion que acepta la solicitud de un alumno
	 * 
	 * @param trozos
	 *            string de la asignatura y del nia separados mediante un spli
	 *            para su uso
	 */
	public void aceptarMatricula(String[] trozos) {
		String asignatura = trozos[1];
		int nia = Integer.parseInt(trozos[0]);
		academia.getUsuarioOnline().aceptarAsignaturas(academia.buscarMatricula(asignatura, nia));

	}

	/**
	 * Funcion que deniega la solicitud de un alumno
	 * 
	 * @param trozos
	 *            string de la asignatura y del nia separados mediante un split
	 *            para su uso
	 */
	public void denegarMatricula(String[] trozos) {
		String asignatura = trozos[1];
		int nia = Integer.parseInt(trozos[0]);
		academia.getUsuarioOnline().denegarAsignaturas(academia.buscarMatricula(asignatura, nia));

	}

	/**
	 * Funcion que auntentica a un usuario en la aplicacion
	 * 
	 * @return 0 si es profesor, 1 si es alumno
	 */
	public int login() {
		if (academia.getUsuarioOnline().equals(academia.getProfesor())) {
			return 0;
		}
		return 1;
	}

	/**
	 * Funcion que se encarga de realizar la solicitud de una asignatura por
	 * parte de un alumno
	 * 
	 * @param asignatura
	 *            asignatura de la cual se quiere matricular
	 * @return true si se ha podido realiza, false si no
	 */
	public boolean pedirMatricula(String asignatura) {
		if (academia.getUsuarioOnline().solicitudAsignatura(academia.buscarAsignatura(asignatura)) == true) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Funcion que crea un tema en una asignatura
	 * 
	 * @param asignatura
	 *            asignatura donde se quere crear el tema
	 * @param titulo
	 *            titulo del tema
	 * @param visibilidad
	 *            visibilidad del tema
	 */
	public void crearTema(String asignatura, String titulo, Visibilidad visibilidad) {

		academia.buscarAsignatura(asignatura).crearTemas(titulo);
		academia.buscarAsignatura(asignatura).buscarTemas(titulo).setVisibilidad(visibilidad);

	}

	/**
	 * Funcion que elimina un tema de una asignatura
	 * 
	 * @param tema
	 *            tema el cual se quiere eliminar
	 * @param asignatura
	 *            asignatura donde se encuentra el tema a eliminar
	 */
	public void eliminarTema(String tema, String asignatura) {
		Temas t = academia.buscarAsignatura(asignatura).buscarTemas(tema);
		academia.buscarAsignatura(asignatura).eliminarTema(t);

	}

	/**
	 * Funcion que cambia la visibilidad de una asignatura
	 * 
	 * @param asignatura
	 *            asignatura de la cual se quiere cambiar la visibilidad
	 */
	public void cambiarVisAsignatura(String asignatura) {

		Visibilidad visi = academia.buscarAsignatura(asignatura).getVisibilidad();
		if (visi.equals(Visibilidad.INVISIBLE)) {
			academia.buscarAsignatura(asignatura).setVisibilidad(Visibilidad.VISIBLE);
		} else {
			academia.buscarAsignatura(asignatura).setVisibilidad(Visibilidad.INVISIBLE);
		}
	}

	/**
	 * Funcion que devuelve la visibilidad de una asignatura
	 * 
	 * @param asignatura
	 *            asignatura de la cual se quiere saber la visibiliad
	 * @return visibilidad de la asignatura
	 */
	public Visibilidad visibilidadAsignatura(String asignatura) {

		return academia.buscarAsignatura(asignatura).getVisibilidad();
	}

	/**
	 * Funcion que aniade al aniade al combobox del panel de una asignatura
	 * todos los alumnos matriculados en ella
	 * 
	 * @param asignatura
	 *            asignatura en la que estan matriculados los alumnos
	 */
	public void alumnosMatriculados(String asignatura) {
		for (Matriculado a : AcademiaLopez.getMatriculas()) {
			Alumno al = academia.buscarAlumno(a.getUsuario().getNia());
			if (a.getAsignatura().getTitulo().equals(asignatura) && al != null
					&& (a.getEstado().equals(EstadoAlumno.ADMITIDO) || a.getEstado().equals(EstadoAlumno.EXPULSADO))) {
				String nombre = al.getNombre() + " " + al.getApellidos();
				vista.getPanelasignatura().getCombobox().addItem(nombre);
			}
		}

	}

	/**
	 * Funcion que crea apuntes en un tema
	 * 
	 * @param titulo
	 *            titulo del apunte
	 * @param texto
	 *            texto que contendra el apunte
	 * @param visibilidad
	 *            visibilidad del apunte
	 */
	public void crearApuntes(String titulo, String texto, Visibilidad visibilidad) {

		Temas t = academia.buscarTema(vista.getPaneltema().getNombreTema().getText());
		if (t != null) {
			t.crearApuntes(titulo, texto);
			t.buscarApuntes(titulo).setVisibilidad(visibilidad);
		} else {
			t = academia.buscarSubtemas(vista.getPaneltema().getNombreTema().getText());
			t.crearApuntes(titulo, texto);
			t.buscarApuntes(titulo).setVisibilidad(visibilidad);
		}

	}

	/**
	 * Funcion que elimina apuntes de un tema
	 * 
	 * @param titulo
	 *            titulo del apunte a eliminar
	 */
	public void eliminarApuntes(String titulo) {
		Temas t = academia.buscarTema(vista.getPaneltema().getNombreTema().getText());
		if (t != null) {
			t.eliminarApuntes(academia.buscarApuntes(titulo));

		} else {
			t = academia.buscarSubtemas(vista.getPaneltema().getNombreTema().getText());
			t.eliminarApuntes(academia.buscarApuntes(titulo));
		}

	}

	/**
	 * Funcion que carga en la vista del profesor los apuntes de un tema
	 * 
	 * @param tema
	 *            tema del cual son los apuntes
	 */
	public void cargarApuntesProfesor(String tema) {
		Temas te = academia.buscarTema(tema);
		if (te == null) {
			Temas t = academia.buscarSubtemas(tema);

			if (t.getApuntes() != null) {
				for (Apuntes n : t.getApuntes()) {

					vista.getPaneltema().getlApuntes().addElement(n.getTitulo());

				}
			}
		} else {
			for (Apuntes n : te.getApuntes()) {
				vista.getPaneltema().getlApuntes().addElement(n.getTitulo());
			}
		}

	}

	/**
	 * Funcion que carga los apuntes de un tema en la vista del alumno
	 * 
	 * @param tema
	 *            tema del cual son los apuntes
	 */
	public void cargarApuntesAlumno(String tema) {
		Temas te = academia.buscarTema(tema);
		if (te == null) {
			Temas t = academia.buscarSubtemas(tema);

			if (t.getApuntes() != null) {
				for (Apuntes n : t.getApuntes()) {
					if (n.getVisibilidad().equals(Visibilidad.VISIBLE)) {
						vista.getPaneltemaalumno().getlApuntes().addElement(n.getTitulo());
					}

				}
			}
		} else {
			for (Apuntes n : te.getApuntes()) {
				if (n.getVisibilidad().equals(Visibilidad.VISIBLE)) {
					vista.getPaneltemaalumno().getlApuntes().addElement(n.getTitulo());
				}
			}
		}

	}

	/**
	 * Funcion que abre apuntes den la vista del profesor que ya estan creados
	 * con anterioridad
	 * 
	 * @param titulo
	 *            titulo de los apuntes
	 */
	public void abrirApuntes(String titulo) {
		Apuntes ap = academia.buscarApuntes(titulo);

		vista.getPanelapuntes().getTextofield().setText(ap.getTexto());
		vista.getPanelapuntes().getTitulofield().setText(ap.getTitulo());
	}

	/**
	 * Funcion que abre apuntes en la vista de un alumno que ya estan creados
	 * con anterioridad
	 * 
	 * @param titulo
	 *            titulo de los apuntes
	 */
	public void abrirApuntesAlumno(String titulo) {
		Apuntes ap = academia.buscarApuntes(titulo);

		vista.getPanelapuntesalumno().getTextofield().setText(ap.getTexto());
		vista.getPanelapuntesalumno().getTitulo().setText(ap.getTitulo());
		vista.getPanelapuntesalumno().getTextofield().setEditable(false);
	}

	/**
	 * Funcion devuelve la visibilidad de un tema
	 * 
	 * @param tema
	 *            tema del cual se quiere saber la visibilidad
	 * @return visibilidad del tema
	 */
	public Visibilidad visibilidadTema(String tema) {
		Temas t = academia.buscarTema(tema);
		if (t == null) {
			t = academia.buscarSubtemas(tema);
		}
		return t.getVisibilidad();
	}

	/**
	 * Funcion que cambia la visibilidad de un tema
	 * 
	 * @param titulo
	 *            titulo dle tema dle cual se quiere cambiar la visibilidad
	 */
	public void cambiarVisTema(String titulo) {
		if (academia.buscarTema(titulo).getVisibilidad().equals(Visibilidad.INVISIBLE)) {
			academia.buscarTema(titulo).setVisibilidad(Visibilidad.VISIBLE);
		} else {
			academia.buscarTema(titulo).setVisibilidad(Visibilidad.INVISIBLE);
		}

	}

	/**
	 * Funcion que crea un subtema de un tema
	 * 
	 * @param titulo
	 *            titulo del subtema
	 * @param visibilidad
	 *            visibilidad del subtema
	 * @param tema
	 *            tema del cual se hace el subtema
	 */
	public void crearSubtema(String titulo, Visibilidad visibilidad, String tema) {
		if (academia.buscarTema(tema) == null) {
			academia.buscarSubtemas(tema).crearSubTemas(titulo);
			academia.buscarSubtemas(titulo).setVisibilidad(visibilidad);
		} else {
			academia.buscarTema(tema).crearSubTemas(titulo);
			academia.buscarSubtemas(titulo).setVisibilidad(visibilidad);
		}

	}

	/**
	 * Funcion que carga subtemas en la vista del profesor
	 * 
	 * @param titulo
	 *            titulo del tema se cual se quieren cargar los subtemas
	 */
	public void cargarSubtemasProfesor(String titulo) {
		Temas t = academia.buscarTema(titulo);
		if (t != null) {
			for (Temas n : t.getSubtemas()) {
				vista.getPaneltema().getlSubtemas().addElement(n.getTitulo());
			}
		} else {
			t = academia.buscarSubtemas(titulo);
			for (Temas n : t.getSubtemas()) {
				vista.getPaneltema().getlSubtemas().addElement(n.getTitulo());
			}
		}

	}

	/**
	 * Funcion que carga los subtemas en la vista de un alumno
	 * 
	 * @param titulo
	 *            titulo del tema del cual se quieren cargar subtemas
	 */
	public void cargarSubtemasAlumno(String titulo) {
		Temas t = academia.buscarTema(titulo);
		if (t != null) {
			for (Temas n : t.getSubtemas()) {
				if (n.getVisibilidad().equals(Visibilidad.VISIBLE)) {
					vista.getPaneltemaalumno().getlSubtemas().addElement(n.getTitulo());
				}
			}
		} else {
			t = academia.buscarSubtemas(titulo);
			for (Temas n : t.getSubtemas()) {
				if (n.getVisibilidad().equals(Visibilidad.VISIBLE)) {
					vista.getPaneltemaalumno().getlSubtemas().addElement(n.getTitulo());
				}
			}
		}

	}

	/**
	 * Funcion que busca el tema padre de un tema
	 * 
	 * @param titulo
	 *            titulo del tema del cual se quiere buscar el padre
	 * @return titulo del tema padre
	 */
	public String buscartemaPadre(String titulo) {
		Temas t = academia.buscarTemaPadre(titulo);
		if (t == null) {
			return null;
		}
		return t.getTitulo();
	}

	/**
	 * Funcion que elimina subtemas de temas
	 * 
	 * @param tema
	 *            tema del cual se quiere borrar el subtema
	 * @param titulo
	 *            titulo del subtema a eliminar
	 */
	public void eliminarSubtemas(String tema, String titulo) {
		Temas t = academia.buscarTema(tema);
		if (t == null) {
			academia.buscarSubtemas(tema).eliminarSubTema(academia.buscarSubtemas(titulo));
		} else {
			t.eliminarSubTema(academia.buscarSubtemas(titulo));
		}

	}

	/**
	 * Funcion que modifica unos apuntes ya creados
	 * 
	 * @param titulo
	 *            titulo de los apuntes a modificar
	 */
	public void modificarApuntes(String titulo) {
		String titulonuevo = vista.getPanelapuntes().getTitulofield().getText();
		String textonuevo = vista.getPanelapuntes().getTextofield().getText();
		boolean visibilidad = vista.getPanelapuntes().getCheck1().isSelected();
		if (visibilidad == true) {
			academia.buscarApuntes(titulo).modificarApunte(titulonuevo, textonuevo, Visibilidad.VISIBLE);
		} else {
			academia.buscarApuntes(titulo).modificarApunte(titulonuevo, textonuevo, Visibilidad.INVISIBLE);

		}

	}

	/**
	 * Funcion que devuelve la visibilidad de unos apuntes
	 * 
	 * @param titulo
	 *            titulo de los apuntes
	 * @return visibilidad de los apuntes
	 */
	public Visibilidad visibilidadApuntes(String titulo) {
		return academia.buscarApuntes(titulo).getVisibilidad();
	}

	/**
	 * Funcion que cambia la visibilida de los apuntes de un tema
	 * 
	 * @param apuntes
	 *            apuntes de los cuales se quiere cambiar la visibilidad
	 */
	public void cambiarVisApuntes(String apuntes) {
		Apuntes a = academia.buscarApuntes(apuntes);
		if (a != null) {
			if (a.getVisibilidad().equals(Visibilidad.VISIBLE)) {
				a.setVisibilidad(Visibilidad.INVISIBLE);
			} else {
				a.setVisibilidad(Visibilidad.VISIBLE);
			}

		}
	}

	/**
	 * Funcion que cambia la visibilidad de un subtema
	 * 
	 * @param titulo
	 *            titulo del subtema
	 */
	public void cambiarVisSub(String titulo) {
		Temas t = academia.buscarSubtemas(titulo);
		if (t != null) {
			if (t.getVisibilidad().equals(Visibilidad.VISIBLE)) {
				t.setVisibilidad(Visibilidad.INVISIBLE);
			} else {
				t.setVisibilidad(Visibilidad.VISIBLE);
			}
		}

	}

	/**
	 * Funcion que crea una pregunta de tipo libre
	 * 
	 * @param enunciado
	 *            enunciado de la pregunta
	 * @param solucion
	 *            solucion de la pregunta
	 * @param ponderacion
	 *            ponderacion de la pregunta
	 * @param visibilidad
	 *            visibiliad de la pregunta
	 */
	public void crearPreguntaLibre(String enunciado, String solucion, double ponderacion, Visibilidad visibilidad) {
		academia.buscarEjercicio("titulo").crearPreguntaLibre(enunciado, ponderacion, solucion, false);
		academia.buscarEjercicio("titulo").buscarPregunta(enunciado).setVisibilidad(visibilidad);

	}

	/**
	 * Funcion que crea un ejercicio
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 * @param fechaInicio
	 *            fecha de inicio del ejercicio
	 * @param fechaFin
	 *            fecha fin del ejercicio
	 * @param peso
	 *            peso del ejercicio
	 */
	public void crearEjercicio(String titulo, LocalDate fechaInicio, LocalDate fechaFin, double peso) {
		String tema = vista.getPaneltema().getNombreTema().getText();
		Temas t = academia.buscarTema(tema);
		if (t != null) {
			t.crearEjercicio(titulo, fechaInicio, fechaFin, 0, peso);
		} else {
			t = academia.buscarSubtemas(tema);
			t.crearEjercicio(titulo, fechaInicio, fechaFin, 0, peso);
		}

	}

	/**
	 * Funcion que crea preguntas de tipo multiple
	 * 
	 * @param enunciado
	 *            enunciado de la pregunta
	 * @param ponderacion
	 *            ponderacion de la pregunta
	 * @param soluciones
	 *            soluciones posibles a la pregunta
	 * @param opciones
	 *            opciones de la pregunta
	 * @param visibilidad
	 *            visibilidad de la pregunta
	 */
	public void crearPreguntaMultiple(String enunciado, Double ponderacion, int[] soluciones, List<String> opciones,
			Visibilidad visibilidad) {
		academia.buscarEjercicio("titulo").crearPreguntaMultiple(enunciado, ponderacion, soluciones, false, opciones);
		academia.buscarEjercicio("titulo").buscarPregunta(enunciado).setVisibilidad(visibilidad);

	}

	/**
	 * Funcion que cancela la creacion de un ejercicio
	 * 
	 * @param tema
	 *            tema del cual estas cancelando el ejercicio
	 */
	public void cancelarCrearEjercicio(String tema) {
		Temas t = academia.buscarTema(tema);
		if (vista.getPanelcrearEjercicio().getCrearEjercicio().getText().equals("Crear Ejercicio")) {
			if (t != null) {
				t.eliminarEjercicio(t.buscarEjercicio("titulo"));
			} else {
				t = academia.buscarSubtemas(tema);
				t.eliminarEjercicio(t.buscarEjercicio("titulo"));
			}
		} else {

			if (t != null) {
				t.buscarEjercicio("titulo").setTitulo(vista.getPaneltema().getEjercicios().getSelectedValue());
			} else {
				t = academia.buscarSubtemas(tema);
				t.buscarEjercicio("titulo").setTitulo(vista.getPaneltema().getEjercicios().getSelectedValue());

			}
		}

	}

	/**
	 * Funcion que crea inicializa un ejercicio de uno creado anteriormente para
	 * el correcto funcionamiento
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 * @param fechainicio
	 *            fecha de inicio del ejercicio
	 * @param fechafin
	 *            fecha final del ejercicio
	 * @param peso
	 *            peso del ejercicio
	 * @param visibilidad
	 *            visibilidad del ejercicio
	 */
	public void crearEjercicioFin(String titulo, LocalDate fechainicio, LocalDate fechafin, Double peso,
			Visibilidad visibilidad) {
		String tema = vista.getPaneltema().getNombreTema().getText();
		Temas t = academia.buscarTema(tema);

		if (t != null) {
			t.buscarEjercicio("titulo").setTitulo(titulo);
			t.buscarEjercicio(titulo).setFechaInicio(fechainicio);
			t.buscarEjercicio(titulo).setFechaFin(fechafin);
			t.buscarEjercicio(titulo).setPeso(peso);
			t.buscarEjercicio(titulo).setVisibilidad(visibilidad);
		} else {
			t = academia.buscarSubtemas(tema);
			t.buscarEjercicio("titulo").setTitulo(titulo);
			t.buscarEjercicio(titulo).setFechaInicio(fechainicio);
			t.buscarEjercicio(titulo).setFechaFin(fechafin);
			t.buscarEjercicio(titulo).setPeso(peso);
			t.buscarEjercicio(titulo).setVisibilidad(visibilidad);
		}

	}

	/**
	 * Funcion que crea una pregunta tipo test
	 * 
	 * @param enunciado
	 *            enunciado de la pregunta
	 * @param ponderacion
	 *            ponderacion de la pregunta
	 * @param solucion
	 *            solucion de la pregunta
	 * @param opciones
	 *            opciones de la pregunta
	 * @param visibilidad
	 *            visibilidad de la pregunta
	 */
	public void crearPreguntaTest(String enunciado, Double ponderacion, int solucion, List<String> opciones,
			Visibilidad visibilidad) {
		academia.buscarEjercicio("titulo").crearPreguntaUnica(enunciado, ponderacion, solucion, false, opciones);
		academia.buscarEjercicio("titulo").buscarPregunta(enunciado).setVisibilidad(visibilidad);

	}

	/**
	 * Funcion que carga en la vista de un profesor todos los ejercicios de un
	 * tema
	 * 
	 * @param titulo
	 *            titulo del tema
	 */
	public void cargarEjerciciosProfesor(String titulo) {
		Temas t = academia.buscarTema(titulo);
		if (t != null) {
			for (Ejercicio n : t.getEjercicios()) {
				if (n.getVisibilidad().equals(Visibilidad.VISIBLE_CONTESTADO) == false) {
					if (n.getFechaInicio().isBefore(LocalDate.now()) || n.getFechaInicio().isEqual((LocalDate.now()))) {
						n.setVisibilidad(Visibilidad.VISIBLE_COMENZADO);
					}
					if (n.getFechaFin().isBefore(LocalDate.now())) {
						n.setVisibilidad(Visibilidad.VISIBLE_TERIMNADO);

					}
				}
				vista.getPaneltema().getlEjercicios().addElement(n.getTitulo());

			}
		} else {
			t = academia.buscarSubtemas(titulo);
			for (Ejercicio n : t.getEjercicios()) {
				if (n.getVisibilidad().equals(Visibilidad.VISIBLE_CONTESTADO) == false) {
					if (n.getFechaInicio().isBefore(LocalDate.now()) || n.getFechaInicio().isEqual((LocalDate.now()))) {

						n.setVisibilidad(Visibilidad.VISIBLE_COMENZADO);
					}
					if (n.getFechaFin().isBefore(LocalDate.now())) {
						n.setVisibilidad(Visibilidad.VISIBLE_TERIMNADO);

					}
				}
				vista.getPaneltema().getlEjercicios().addElement(n.getTitulo());

			}
		}

	}

	/**
	 * Funcion que se encarga de cargar en la vista del alumno todos los
	 * ejercicios que estan a su disposicion
	 * 
	 * @param titulo
	 *            titulo del tema de los ejercicios
	 */
	public void cargarEjerciciosAlumno(String titulo) {
		Temas t = academia.buscarTema(titulo);
		if (t != null) {
			for (Ejercicio n : t.getEjercicios()) {
				if (n.getVisibilidad().equals(Visibilidad.VISIBLE_CONTESTADO) == false) {
					if (n.getFechaInicio().isBefore(LocalDate.now()) || n.getFechaInicio().isEqual((LocalDate.now()))) {
						n.setVisibilidad(Visibilidad.VISIBLE_COMENZADO);
					}
					if (n.getFechaFin().isBefore(LocalDate.now())) {
						n.setVisibilidad(Visibilidad.VISIBLE_TERIMNADO);

					}
				}
				if (n.getVisibilidad().equals(Visibilidad.INVISIBLE) == false) {
					vista.getPaneltemaalumno().getlEjercicios().addElement(n.getTitulo());
				}

			}
		} else {
			t = academia.buscarSubtemas(titulo);
			for (Ejercicio n : t.getEjercicios()) {
				if (n.getVisibilidad().equals(Visibilidad.VISIBLE_CONTESTADO) == false) {
					if (n.getFechaInicio().isBefore(LocalDate.now()) || n.getFechaInicio().isEqual((LocalDate.now()))) {
						n.setVisibilidad(Visibilidad.VISIBLE_COMENZADO);
					}
					if (n.getFechaFin().isBefore(LocalDate.now())) {
						n.setVisibilidad(Visibilidad.VISIBLE_TERIMNADO);

					}
				}
				if (n.getVisibilidad().equals(Visibilidad.INVISIBLE) == false) {
					vista.getPaneltemaalumno().getlEjercicios().addElement(n.getTitulo());
				}
			}
		}

	}

	/**
	 * Funcion que elimina un ejercicio
	 * 
	 * @param titulo
	 *            titulo del ejercicio a eliminar
	 */
	public void eliminarEjercicios(String titulo) {
		Temas t = academia.buscarTema(vista.getPaneltema().getNombreTema().getText());
		if (t != null) {
			t.eliminarEjercicio(academia.buscarEjercicio(titulo));

		} else {
			t = academia.buscarSubtemas(vista.getPaneltema().getNombreTema().getText());
			t.eliminarEjercicio(academia.buscarEjercicio(titulo));
		}

	}

	/**
	 * Funcion que abre un ejercicio ya creado con sus campos actualizados a
	 * como se quedaron anteriormente
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 */
	public void abrirEjercicio(String titulo) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		ArrayList<Preguntas> preguntas = e.getPreguntas();
		String ponderacion = String.valueOf(e.getPeso());
		vista.getPanelcrearejercicio().setPonderacionfield(ponderacion);
		vista.getPanelcrearejercicio().setFechafinfield(e.getFechaFin().toString());
		vista.getPanelcrearejercicio().setFechainiciofield(e.getFechaInicio().toString());
		for (Preguntas p : preguntas) {
			vista.getPanelcrearejercicio().getModelo().addElement(p.getEnunciado());
		}
		e.setTitulo("titulo");

	}

	/**
	 * Funcion que elimina una pregunta de un ejercicio
	 * 
	 * @param titulo
	 *            titulo dle ejercicio
	 * @return true si se ha eliminado, false si no
	 */
	public boolean eliminarPregunta(String titulo) {
		if (academia.buscarEjercicio("titulo").esEliminable() == true) {
			academia.buscarEjercicio("titulo").eliminarPregunta(titulo);
			return true;
		}
		return false;

	}

	/**
	 * Funcion que cambia la visibilidad de un ejercicio
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 */
	public void cambiarVisE(String titulo) {
		Ejercicio t = academia.buscarEjercicio(titulo);
		if (t != null) {
			if (t.getVisibilidad().equals(Visibilidad.INVISIBLE)) {
				t.setVisibilidad(Visibilidad.VISIBLE_NOCOMENZADO);
			} else {
				t.setVisibilidad(Visibilidad.INVISIBLE);
			}
		}

	}

	/**
	 * Funcion que se encarga de permitir a un alumno entrar a la realizacion de
	 * un ejercicio
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 * @return true si puede realizarlo, false si no
	 */
	public boolean realizarEjercicio(String titulo) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		if (e != null && e.getVisibilidad().equals(Visibilidad.VISIBLE_COMENZADO)) {
			for (Preguntas p : e.getPreguntas()) {
				vista.getPanelpreguntalibre().getlPreguntas().addElement(p.getEnunciado());
			}

			return true;
		}
		return false;
	}

	/**
	 * Funcion que compara los tipos de preguntas que existen para devolver la
	 * clase que es una pregunta
	 * 
	 * @param titulo
	 *            titulo dle ejercicio
	 * @param enunciado
	 *            enunciado de la pregunta
	 * @return clase de la pregunta
	 */
	public String comprobarClase(String titulo, String enunciado) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		Preguntas p = e.buscarPregunta(enunciado);
		Class<? extends Preguntas> c = p.getClass();
		String clase = c.getName();

		return clase;

	}

	/**
	 * Funcion que guarda todas la respuesta a una pregunta libre dada por el
	 * alumno
	 */
	public void guardarRespuestaLibre() {
		String respuesta = vista.getPanelpreguntalibre().getTextofield().getText();
		Respuesta res = new RespuestaLibre(academia.getUsuarioOnline().getNia(), respuesta);
		Ejercicio e = academia.buscarEjercicio(vista.getPaneltemaalumno().getEjercicios().getSelectedValue());
		int num = e.getNumPregunta();
		e.anyadirRespuesta(num, res);
	}

	/**
	 * Funcion que devuelve la visibilidad de un ejercicio
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 * @return visibilidad de un ejercicio como string
	 */
	public String visibilidadEjercicio(String titulo) {
		return academia.buscarEjercicio(titulo).getVisibilidad().toString();
	}

	/**
	 * Funcion que finaliza un ejercicio mostrando por pantalla la nota obtenida
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 * @return nota del ejercicio
	 */
	public double terminarEjercicio(String titulo) {
		academia.buscarEjercicio(titulo).setNumPregunta(0);
		academia.buscarEjercicio(titulo).terminarEjercicio(academia.buscarEjercicio(titulo).getRespuestas(),
				academia.getUsuarioOnline().getNia());
		for (Resultado r : academia.buscarEjercicio(titulo).getResultados()) {
			if (r.getNia() == academia.getUsuarioOnline().getNia()) {
				return r.getNota();
			}
		}
		return 0;

	}

	/**
	 * Funcion que calcula cual es la pregunta siguiente a la actual
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 * @return numero de la pregunta buscada
	 */
	public int siguientePregunta(String titulo) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		int num = e.getNumPregunta();
		num = num + 1;
		e.setNumPregunta(num);
		return num;
	}

	/**
	 * Funcion que calcula cual es la pregunta anterior a la actual
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 * @return numero de la pregunta buscada
	 */
	public int anteriorPregunta(String titulo) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		int num = e.getNumPregunta();
		num = num - 1;
		e.setNumPregunta(num);
		return num;
	}

	/**
	 * Funcion que carga las preguntas libres de un ejercicio
	 * 
	 * @param enunciado
	 *            enunciado del ejercicio
	 * @param i
	 *            indice de lapregunta
	 * @param titulo
	 *            titulo del ejercicio
	 */
	public void cargarPreguntaLibre(String enunciado, int i, String titulo) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		RespuestaLibre res = (RespuestaLibre) e.getRespuestas().get(i);
		vista.getPanelpreguntalibre().getTextofield().setText(res.getRespuestas());

	}

	/**
	 * Funcion que carga todas las opciones de una pregunta tipo unica
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 * @param enunciado
	 *            enunciado de la pregunta
	 */
	public void cargarOpcionesPreguntaUnica(String titulo, String enunciado) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		PreguntaUnica p = (PreguntaUnica) e.buscarPregunta(enunciado);

		for (String enunc : p.getOpciones()) {
			vista.getPanelpreguntaunica().getlOpciones().addElement(enunc);
		}

	}

	/**
	 * Funcion que guarda las respuestas dadas por un alumno a una pregunta
	 * unica
	 */
	public void guardarRespuestaUnica() {
		int n = vista.getPanelpreguntaunica().getOpciones().getSelectedIndex();
		Respuesta res = new RespuestaUnica(academia.getUsuarioOnline().getNia(), n);
		Ejercicio e = academia.buscarEjercicio(vista.getPaneltemaalumno().getEjercicios().getSelectedValue());
		int num = e.getNumPregunta();
		e.anyadirRespuesta(num, res);

	}

	/**
	 * Funcion que carga las preguntas unicas de un ejercicio
	 * 
	 * @param enunciado
	 *            enunciado del ejercicio
	 * @param i
	 *            indice de la pregunta unica
	 * @param titulo
	 *            titulo del ejercicio
	 */
	public void cargarPreguntaUnica(String enunciado, int i, String titulo) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		RespuestaUnica res = (RespuestaUnica) e.getRespuestas().get(i);
		vista.getPanelpreguntaunica().getOpciones().setSelectedIndex(res.getRespuestas());

	}

	/**
	 * Funcion que guarda las respuestas dadas por el alumno en una pregunta
	 * multiple
	 */
	public void guardarRespuestaMultiple() {
		int[] n = vista.getPanelpreguntamultiple().getOpciones().getSelectedIndices();
		Respuesta res = new RespuestaMultiple(academia.getUsuarioOnline().getNia(), n);
		Ejercicio e = academia.buscarEjercicio(vista.getPaneltemaalumno().getEjercicios().getSelectedValue());
		int num = e.getNumPregunta();
		e.anyadirRespuesta(num, res);

	}

	/**
	 * Funcion que carga una pregunta multiple
	 * 
	 * @param enunciado
	 *            enunciado del ejercicio
	 * @param i
	 *            indice de la pregunta multiple
	 * @param titulo
	 *            titulo del ejercicio
	 */
	public void cargarPreguntaMultiple(String enunciado, int i, String titulo) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		RespuestaMultiple res = (RespuestaMultiple) e.getRespuestas().get(i);
		vista.getPanelpreguntamultiple().getOpciones().setSelectedIndices(res.getRespuestas());

	}

	/**
	 * Funcion que carga todas las opciones disponibles en una pregunta de tipo
	 * multiple
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 * @param enunciado
	 *            enunciado del ejercicio
	 */
	public void cargarOpcionesPreguntaMultiple(String titulo, String enunciado) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		PreguntaMultiple p = (PreguntaMultiple) e.buscarPregunta(enunciado);

		for (String enunc : p.getOpciones()) {
			vista.getPanelpreguntamultiple().getlOpciones().addElement(enunc);
		}

	}

	/**
	 * Funcion que readmite en una asignatura a un alumno
	 * 
	 * @param alumno
	 *            alumno a readmitir
	 * @param asignatura
	 *            asignatura en la cual readmitir al alumno
	 */
	public void readmitirAlumno(String alumno, String asignatura) {
		String[] partes = alumno.split(" ");
		Alumno b = null;
		for (Alumno a : academia.getAlumnos()) {
			if (a.getNombre().equals(partes[0]) && a.getApellidos().equals(partes[1])) {
				b = a;
				break;
			}
		}

		academia.buscarAsignatura(asignatura).readmitirAlumno(b);

	}

	/**
	 * Funcion que expulsa a un alumno de una asignatura
	 * 
	 * @param alumno
	 *            alumno a expulsar
	 * @param asignatura
	 *            asignatura de la cual expulsar al alumno
	 */
	public void expulsarAlumno(String alumno, String asignatura) {
		String[] partes = alumno.split(" ");
		Alumno b = null;
		for (Alumno a : academia.getAlumnos()) {
			if (a.getNombre().equals(partes[0]) && a.getApellidos().equals(partes[1])) {
				b = a;
				break;
			}
		}

		academia.buscarAsignatura(asignatura).expulsarAlumno(b);

	}

	/**
	 * Funcion que carga las estadisticas de un alumno
	 * 
	 * @param alumno
	 *            alumno del cual se quieren las estadisticas
	 */
	public void cargarEstadistica(String alumno) {
		String[] partes = alumno.split(" ");

		Alumno a = null;
		for (Matriculado m : AcademiaLopez.getMatriculas()) {
			a = (Alumno) m.getUsuario();
			if(academia.buscarAsignatura(m.getAsignatura().getTitulo()).getNotaMedia()==0){
				academia.buscarAsignatura(m.getAsignatura().getTitulo()).calcularMedia();
			}
			
			if (a.getNombre().equals(partes[0]) && a.getApellidos().equals(partes[1])) {
				vista.getPanelestadistica().getModel().addElement("Nombre de la asignatura: "
						+ m.getAsignatura().getTitulo() + "Nota media: " + m.getAsignatura().getNotaMedia());
			}
		}

	}

	/**
	 * Funcion que devuelve la nota de un ejercicio de un alumno
	 * 
	 * @param titulo
	 *            titulo del ejercicio
	 * @return nota del alumno
	 */
	public double getNota(String titulo) {

		Ejercicio ejercicio = academia.buscarEjercicio(titulo);
		int nia = academia.getUsuarioOnline().getNia();

		for (Resultado r : ejercicio.getResultados()) {
			if (r.getNia() == nia) {
				return r.getNota();
			}
		}
		return 0;
	}

	/**
	 * Funcion que cancela un ejercicio
	 * 
	 * @param titulo
	 *            titulo del ejercicio a cancelar
	 */
	public void cancelarEjercicio(String titulo) {

		academia.buscarEjercicio(titulo).getRespuestas().clear();
	}

}
