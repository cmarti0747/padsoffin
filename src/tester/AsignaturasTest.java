package tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import academia.*;
public class AsignaturasTest {

	Asignaturas asignatura;
Alumno alumno;
	

	@Before
	
		
		
	
	public void before() {
		asignatura = new Asignaturas("Titulo1");
		alumno = new Alumno(1234, "miPass", "Javi", "Senit","Javi.Senit@estudiante.com");

	}

	@Test
	public void testCrearTemas() {
		asignatura.crearTemas("TituloAux");
		assertEquals(1, asignatura.getTemas().size());
		assertEquals("TituloAux", asignatura.getTemas().get(0).getTitulo());

	}

	@Test
	public void testExpulsarAlumno() {
		/*AcademiaLopez aca = new AcademiaLopez();
		Asignaturas asig = new Asignaturas("PADSOF");
		Matriculado mat = new Matriculado(alumno, asig);
		mat.setEstado(true);
		asig.expulsarAlumno(alumno);
		assertEquals(false, mat.getEstado());*/
		

	
		
	}

	@Test
	public void testReadmitirAlumno() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcularMedia() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetVisibilidad() {
		
		
		
		asignatura.setVisibilidad(academia.Visibilidad.VISIBLE);
		assertEquals(academia.Visibilidad.VISIBLE, asignatura.getVisibilidad());

	}

	@Test
	public void testGetTitulo() {
		assertEquals("Titulo1", asignatura.getTitulo());
	}

	@Test
	public void testSetTitulo() {
		asignatura.setTitulo("Titulo2");
		assertEquals("Titulo2", asignatura.getTitulo());
	}

	@Test
	public void testGetNotaMedia() {
		assertEquals(0, asignatura.getNotaMedia(), 0);
	}

	@Test
	public void testSetNotaMedia() {
		asignatura.setNotaMedia(7.5);
		assertEquals(7.5, asignatura.getNotaMedia(), 0);
	}

	@Test
	public void testEliminarTema() {
		asignatura.crearTemas("TituloAux");
		assertEquals(1, asignatura.getTemas().size());
		assertEquals("TituloAux", asignatura.getTemas().get(0).getTitulo());
		asignatura.eliminarTema(asignatura.getTemas().get(0));

		assertEquals(0, asignatura.getTemas().size());
	}

	@Test
	public void testGetVisibilidad() {
		assertEquals(academia.Visibilidad.INVISIBLE, asignatura.getVisibilidad());
	}

}
