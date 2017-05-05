package tester;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import academia.Apuntes;
import academia.Visibilidad;

public class ApuntesTest {

	Apuntes apuntes;

	@Before
	public void before() {
		apuntes = new Apuntes("Titulo1", "Texto1");
	}

	@Test
	public void testModificarApunte() {
		apuntes.setTitulo("Titulo2");
		apuntes.setTexto("Texto2");
		apuntes.setVisibilidad(academia.Visibilidad.VISIBLE_COMENZADO);
		assertEquals("Titulo2", apuntes.getTitulo());
		assertEquals("Texto2", apuntes.getTexto());
		assertEquals(academia.Visibilidad.VISIBLE_COMENZADO, apuntes.getVisibilidad());

	}

	/*
	 * @Test public void testModificarVisibilidad() {
	 * fail("Not yet implemented"); }
	 */

	@Test
	public void testGetTitulo() {
		assertEquals("Titulo1", apuntes.getTitulo());
	}

	@Test
	public void testSetTitulo() {
		apuntes.setTitulo("Titulo2");
		assertEquals("Titulo2", apuntes.getTitulo());
	}

	@Test
	public void testGetTexto() {
		assertEquals("Texto1", apuntes.getTexto());
	}

	@Test
	public void testSetTexto() {
		apuntes.setTexto("Texto2");
		assertEquals("Texto2", apuntes.getTexto());
	}

	@Test
	public void testGetVisibilidad() {

		assertEquals(Visibilidad.INVISIBLE, apuntes.getVisibilidad());
	}

	@Test
	public void testSetVisibilidad() {
		apuntes.setVisibilidad(academia.Visibilidad.VISIBLE_COMENZADO);
		assertEquals(academia.Visibilidad.VISIBLE_COMENZADO, apuntes.getVisibilidad());
	}

}
