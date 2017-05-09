package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import academia.*;

public class ControladorPanelControlador {

	private PanelControlador vista;
	private AcademiaLopez academia;

	public ControladorPanelControlador(PanelControlador vista, AcademiaLopez academia) {
		this.academia = academia;
		this.vista = vista;
	}

	public void desconectar() throws FileNotFoundException, IOException {
		academia.desconectar();
		VistaLogin vista = new VistaLogin();
		ControladorLogin controlaLogin = new ControladorLogin(vista, academia);
		vista.setControlador(controlaLogin);
		this.vista.setVisibilidad(false);
	}

	public void crearAsignatura(String titulo, Visibilidad visibilidad) {

		academia.crearAsignaturas(titulo);
		academia.buscarAsignatura(titulo).setVisibilidad(visibilidad);
	}

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

	public void cargarTemasAlumno(String asignatura) {
		for (String m : getnomTemas(asignatura)) {
			if (academia.buscarAsignatura(asignatura).buscarTemas(m).getVisibilidad().equals(Visibilidad.VISIBLE)) {
				vista.getPanelasignaturaalumno().getModel().addElement(m);
			}

		}

	}

	public void cargarTemasProfesor(String asignaturas) {

		for (String m : getnomTemas(asignaturas)) {
			vista.getPanelasignatura().getModel().addElement(m);
			;

		}

	}

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

	public boolean buscarAsignatura(String s) {
		if (academia.buscarAsignatura(s) != null) {
			return true;
		}
		return false;
	}

	public void aceptarMatricula(String[] trozos) {
		String asignatura = trozos[1];
		int nia = Integer.parseInt(trozos[0]);
		academia.getUsuarioOnline().aceptarAsignaturas(academia.buscarMatricula(asignatura, nia));

	}

	public void denegarMatricula(String[] trozos) {
		String asignatura = trozos[1];
		int nia = Integer.parseInt(trozos[0]);
		academia.getUsuarioOnline().denegarAsignaturas(academia.buscarMatricula(asignatura, nia));

	}

	public int login() {
		if (academia.getUsuarioOnline().equals(academia.getProfesor())) {
			return 0;
		}
		return 1;
	}

	public boolean pedirMatricula(String asignatura) {
		if (academia.getUsuarioOnline().solicitudAsignatura(academia.buscarAsignatura(asignatura)) == true) {
			return true;
		} else {
			return false;
		}

	}

	public void crearTema(String asignatura, String titulo, Visibilidad visibilidad) {

		academia.buscarAsignatura(asignatura).crearTemas(titulo);
		academia.buscarAsignatura(asignatura).buscarTemas(titulo).setVisibilidad(visibilidad);

	}

	public void eliminarTema(String tema, String asignatura) {
		Temas t = academia.buscarAsignatura(asignatura).buscarTemas(tema);
		academia.buscarAsignatura(asignatura).eliminarTema(t);

	}

	public void cambiarVisAsignatura(String asignatura) {

		Visibilidad visi = academia.buscarAsignatura(asignatura).getVisibilidad();
		if (visi.equals(Visibilidad.INVISIBLE)) {
			academia.buscarAsignatura(asignatura).setVisibilidad(Visibilidad.VISIBLE);
		} else {
			academia.buscarAsignatura(asignatura).setVisibilidad(Visibilidad.INVISIBLE);
		}
	}

	public Visibilidad visibilidadAsignatura(String asignatura) {

		return academia.buscarAsignatura(asignatura).getVisibilidad();
	}

	public void alumnosMatriculados(String asignatura) {
		for (Matriculado a : AcademiaLopez.getMatriculas()) {
			Alumno al = academia.buscarAlumno(a.getUsuario().getNia());
			if (a.getAsignatura().getTitulo().equals(asignatura) && al != null
					&& a.getEstado().equals(EstadoAlumno.ADMITIDO)) {
				String nombre = al.getNombre() + " " + al.getApellidos();
				vista.getPanelasignatura().getCombobox().addItem(nombre);
			}
		}

	}

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

	public void eliminarApuntes(String titulo) {
		Temas t = academia.buscarTema(vista.getPaneltema().getNombreTema().getText());
		if (t != null) {
			t.eliminarApuntes(academia.buscarApuntes(titulo));

		} else {
			t = academia.buscarSubtemas(vista.getPaneltema().getNombreTema().getText());
			t.eliminarApuntes(academia.buscarApuntes(titulo));
		}

	}

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

	public void abrirApuntes(String titulo) {
		Apuntes ap = academia.buscarApuntes(titulo);

		vista.getPanelapuntes().getTextofield().setText(ap.getTexto());
		vista.getPanelapuntes().getTitulofield().setText(ap.getTitulo());
	}

	public void abrirApuntesAlumno(String titulo) {
		Apuntes ap = academia.buscarApuntes(titulo);

		vista.getPanelapuntesalumno().getTextofield().setText(ap.getTexto());
		vista.getPanelapuntesalumno().getTitulo().setText(ap.getTitulo());
		vista.getPanelapuntesalumno().getTextofield().setEditable(false);
	}

	public Visibilidad visibilidadTema(String tema) {
		Temas t = academia.buscarTema(tema);
		if (t == null) {
			t = academia.buscarSubtemas(tema);
		}
		return t.getVisibilidad();
	}

	public void cambiarVisTema(String titulo) {
		if (academia.buscarTema(titulo).getVisibilidad().equals(Visibilidad.INVISIBLE)) {
			academia.buscarTema(titulo).setVisibilidad(Visibilidad.VISIBLE);
		} else {
			academia.buscarTema(titulo).setVisibilidad(Visibilidad.INVISIBLE);
		}

	}

	public void crearSubtema(String titulo, Visibilidad visibilidad, String tema) {
		if (academia.buscarTema(tema) == null) {
			academia.buscarSubtemas(tema).crearSubTemas(titulo);
			academia.buscarSubtemas(titulo).setVisibilidad(visibilidad);
		} else {
			academia.buscarTema(tema).crearSubTemas(titulo);
			academia.buscarSubtemas(titulo).setVisibilidad(visibilidad);
		}

	}

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

	public String buscartemaPadre(String titulo) {
		Temas t = academia.buscarTemaPadre(titulo);
		if (t == null) {
			return null;
		}
		return t.getTitulo();
	}

	public void eliminarSubtemas(String tema, String titulo) {
		Temas t = academia.buscarTema(tema);
		if (t == null) {
			academia.buscarSubtemas(tema).eliminarSubTema(academia.buscarSubtemas(titulo));
		} else {
			t.eliminarSubTema(academia.buscarSubtemas(titulo));
		}

	}

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

	public Visibilidad visibilidadApuntes(String titulo) {
		return academia.buscarApuntes(titulo).getVisibilidad();
	}

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
	
	

	public void crearPreguntaLibre(String enunciado, String solucion, double ponderacion, Visibilidad visibilidad) {
		academia.buscarEjercicio("titulo").crearPreguntaLibre(enunciado, ponderacion, solucion, false);
		academia.buscarEjercicio("titulo").buscarPregunta(enunciado).setVisibilidad(visibilidad);

	}

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

	public void crearPreguntaMultiple(String enunciado, Double ponderacion, int[] soluciones, List<String> opciones,
			Visibilidad visibilidad) {
		academia.buscarEjercicio("titulo").crearPreguntaMultiple(enunciado, ponderacion, soluciones, false, opciones);
		academia.buscarEjercicio("titulo").buscarPregunta(enunciado).setVisibilidad(visibilidad);

	}

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

	public void crearPreguntaTest(String enunciado, Double ponderacion, int solucion, List<String> opciones,
			Visibilidad visibilidad) {
		academia.buscarEjercicio("titulo").crearPreguntaUnica(enunciado, ponderacion, solucion, false, opciones);
		academia.buscarEjercicio("titulo").buscarPregunta(enunciado).setVisibilidad(visibilidad);

	}

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

	public void eliminarEjercicios(String titulo) {
		Temas t = academia.buscarTema(vista.getPaneltema().getNombreTema().getText());
		if (t != null) {
			t.eliminarEjercicio(academia.buscarEjercicio(titulo));

		} else {
			t = academia.buscarSubtemas(vista.getPaneltema().getNombreTema().getText());
			t.eliminarEjercicio(academia.buscarEjercicio(titulo));
		}

	}

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

	public boolean eliminarPregunta(String titulo) {
		if (academia.buscarEjercicio("titulo").esEliminable() == true) {
			academia.buscarEjercicio("titulo").eliminarPregunta(titulo);
			return true;
		}
		return false;

	}

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

	public String comprobarClase(String titulo, String enunciado) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		Preguntas p = e.buscarPregunta(enunciado);
		Class<? extends Preguntas> c = p.getClass();
		String clase = c.getName();

		return clase;

	}

	public void guardarRespuestaLibre() {
		String respuesta = vista.getPanelpreguntalibre().getTextofield().getText();
		Respuesta res = new RespuestaLibre(academia.getUsuarioOnline().getNia(), respuesta);
		Ejercicio e = academia.buscarEjercicio(vista.getPaneltemaalumno().getEjercicios().getSelectedValue());
		int num = e.getNumPregunta();
		e.anyadirRespuesta(num, res);
	}

	public String visibilidadEjercicio(String titulo) {
		return academia.buscarEjercicio(titulo).getVisibilidad().toString();
	}

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

	public int siguientePregunta(String titulo) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		int num = e.getNumPregunta();
		num = num + 1;
		e.setNumPregunta(num);
		return num;
	}
	
	public int anteriorPregunta(String titulo) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		int num = e.getNumPregunta();
		num = num - 1;
		e.setNumPregunta(num);
		return num;
	}

	public void cargarPreguntaLibre(String enunciado, int i, String titulo) {
		Ejercicio e= academia.buscarEjercicio(titulo);
		RespuestaLibre res = (RespuestaLibre) e.getRespuestas().get(i);
		vista.getPanelpreguntalibre().getTextofield().setText(res.getRespuestas());
		
		
	}

	public void cargarOpcionesPreguntaUnica(String titulo, String enunciado) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		PreguntaUnica p =(PreguntaUnica) e.buscarPregunta(enunciado);
		
		for(String enunc: p.getOpciones()){
			vista.getPanelpreguntaunica().getlOpciones().addElement(enunc);
		}
		
	}

	public void guardarRespuestaUnica() {
		int n= vista.getPanelpreguntaunica().getOpciones().getSelectedIndex();
		Respuesta res = new RespuestaUnica(academia.getUsuarioOnline().getNia(), n);
		Ejercicio e = academia.buscarEjercicio(vista.getPaneltemaalumno().getEjercicios().getSelectedValue());
		int num = e.getNumPregunta();
		e.anyadirRespuesta(num, res);
		
	}

	public void cargarPreguntaUnica(String enunciado, int i, String titulo) {
		Ejercicio e= academia.buscarEjercicio(titulo);
		RespuestaUnica res = (RespuestaUnica) e.getRespuestas().get(i);
		vista.getPanelpreguntaunica().getOpciones().setSelectedIndex(res.getRespuestas());
		
		
	}

	public void guardarRespuestaMultiple() {
		int[] n= vista.getPanelpreguntamultiple().getOpciones().getSelectedIndices();
		Respuesta res = new RespuestaMultiple(academia.getUsuarioOnline().getNia(), n);
		Ejercicio e = academia.buscarEjercicio(vista.getPaneltemaalumno().getEjercicios().getSelectedValue());
		int num = e.getNumPregunta();
		e.anyadirRespuesta(num, res);
		
	}

	public void cargarPreguntaMultiple(String enunciado, int i, String titulo) {
		Ejercicio e= academia.buscarEjercicio(titulo);
		RespuestaMultiple res = (RespuestaMultiple) e.getRespuestas().get(i);
		vista.getPanelpreguntamultiple().getOpciones().setSelectedIndices(res.getRespuestas());
		
		
		
	}

	public void cargarOpcionesPreguntaMultiple(String titulo, String enunciado) {
		Ejercicio e = academia.buscarEjercicio(titulo);
		PreguntaMultiple p =(PreguntaMultiple) e.buscarPregunta(enunciado);
		
		for(String enunc: p.getOpciones()){
			vista.getPanelpreguntaunica().getlOpciones().addElement(enunc);
		}
		
	}

}
