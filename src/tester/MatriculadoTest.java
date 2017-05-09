package tester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import academia.*;

public class MatriculadoTest {
Alumno alumno2;
	Matriculado mat;
	Asignaturas asignatura;
	Usuario alumno;
	
	@Before
	public void before() {
		asignatura = new Asignaturas("Titulo1");
		alumno = new Alumno(1234, "miPass", "Javi", "Senit","Javi.Senit@estudiante.com");
		mat = new Matriculado(alumno, asignatura);
		
	}
	

	@Test
	public void testGetUsuario() {
		
		
		assertEquals(alumno, mat.getUsuario());
	}

	@Test
	public void testSetUsuario() {
		Usuario alumno2 = new Alumno(1234, "miPass", "Javi", "Senit","Javi.Senit@estudiante.com");
		mat.setUsuario(alumno2);
		assertEquals(alumno2, mat.getUsuario());
	}

	@Test
	public void testGetAsignatura() {
		assertEquals(asignatura, mat.getAsignatura());
	}

	@Test
	public void testSetAsignatura() {
	Asignaturas	asignatura = new Asignaturas("Titulo1");
		mat.setAsignatura(asignatura);
		assertEquals(asignatura, mat.getAsignatura());
	}


}
