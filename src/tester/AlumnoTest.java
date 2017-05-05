package tester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import academia.*;




public class AlumnoTest {

	Alumno alumno;
	

	@Before
	public void before() {
		alumno = new Alumno(1234, "miPass", "Javi", "Senit","Javi.Senit@estudiante.com");
		
	}

	@Test
	public void testsolicitudAsignatura(){
		/*List<Matriculado> matriculas;
		AcademiaLopez aca =new AcademiaLopez ();
		Asignaturas asig = new Asignaturas("PADSOF");
		alumno.solicitudAsignatura(asig);
		Matriculado mat = new Matriculado(alumno, asig);
		

		assertEquals(matriculas.get(0),mat);
		*/
	}
	
	
	@Test
	public void testgetNia() {
		assertEquals(1234, alumno.getNia());
	}

	@Test
	public void testgetPass() {
		assertEquals("miPass", alumno.getPass());
	}

	@Test
	public void testgetNombre() {
		assertEquals("Javi", alumno.getNombre());
	}

	@Test
	public void testgetApellidos() {
		assertEquals("Senit", alumno.getApellidos());
	}

	@Test
	public void testsetNia() {

		alumno.setNia(4321);

		assertEquals(4321, alumno.getNia());
	}

	@Test
	public void testsetPass() {

		alumno.setPass("miOtraPass");

		assertEquals("miOtraPass", alumno.getPass());
	}

	@Test
	public void testsetNombre() {

		alumno.setNombre("Carlos");

		assertEquals("Carlos", alumno.getNombre());
	}

	@Test
	public void testsetApellidos() {
		alumno.setApellidos("Marti");

		assertEquals("Marti", alumno.getApellidos());
	}

}
