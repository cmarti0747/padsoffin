package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
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
				if (a.getEstado().equals(EstadoAlumno.PENDIENTE)){
					nombresMatr.add(a.getUsuario().getNia() + "/" + a.getAsignatura().getTitulo());
				}
			}
		} else {
			nombresMatr.add("");
		}
			
		return nombresMatr;
	}
		

	public void cargarDatos() {
		//Solicitud Matriculas
		for (String n : getnomMatriculas()) {
			
			vista.getPanelhomeprofesor().getModel().addElement(n);
		}

		for (String n : getnomAlumnos()) {
			vista.getPanelhomeprofesor().getCombobox().addItem(n);
		}

		for (String n : getnomAsignaturas()) {
			Asignaturas a = academia.buscarAsignatura(n);
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
				if (m.getEstado().equals(EstadoAlumno.ADMITIDO) && 
						academia.buscarAsignatura(n).getVisibilidad().equals(Visibilidad.VISIBLE)) {
					vista.getPanelhomealumno().getListamisasignaturas().addItem(n);
					;
				}
			}
		}
		
		

	}
	
	public void cargarTemasAlumno(String asignatura){
			for (String m : getnomTemas(asignatura)) {
				if(academia.buscarAsignatura(asignatura).buscarTemas(m).getVisibilidad().equals(Visibilidad.VISIBLE)){
				vista.getPanelasignaturaalumno().getModel().addElement(m);
				}

			}

		}
	public void cargarTemasProfesor(String asignaturas){
		
		
			for (String m : getnomTemas(asignaturas)) {
				vista.getPanelasignatura().getModel().addElement(m);;

			}

		
		
		
	}

	private List<String> getnomTemas(String n) {
		List<String> nombresTemas = new ArrayList<String>();
		Asignaturas a = academia.buscarAsignatura(n);
		if (a != null && a.getTemas() != null) {
			for (Temas t : a.getTemas()) {
				nombresTemas.add(t.getTitulo());
			}
		}else{
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

	public void crearTema(String asignatura,String titulo, Visibilidad visibilidad) {

		academia.buscarAsignatura(asignatura).crearTemas(titulo);
		academia.buscarAsignatura(asignatura).buscarTemas(titulo).setVisibilidad(visibilidad);
		
	}

	public void eliminarTema(String tema, String asignatura) {
		Temas t = academia.buscarAsignatura(asignatura).buscarTemas(tema);
		academia.buscarAsignatura(asignatura).eliminarTema(t);
		
	}

	public void cambiarVisAsignatura(String asignatura) {
		
		Visibilidad visi = academia.buscarAsignatura(asignatura).getVisibilidad();
		if(visi.equals(Visibilidad.INVISIBLE)){
			academia.buscarAsignatura(asignatura).setVisibilidad(Visibilidad.VISIBLE);
		}else{
			academia.buscarAsignatura(asignatura).setVisibilidad(Visibilidad.INVISIBLE);
		}
	}

	public Visibilidad visibilidadAsignatura(String asignatura) {
		
		return academia.buscarAsignatura(asignatura).getVisibilidad();
	}

	public void alumnosMatriculados(String asignatura) {
		for(Matriculado a:AcademiaLopez.getMatriculas()){
			Alumno al = academia.buscarAlumno(a.getUsuario().getNia());
			if(a.getAsignatura().getTitulo().equals(asignatura) && al !=null){
				String nombre = al.getNombre() + 
						" "+al.getApellidos();
				vista.getPanelasignatura().getCombobox().addItem(nombre);
			}
		}
		
	}

}
