package tester;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import academia.Profesor;

public class ProfesorTest {

	Profesor profesor;

	@Before
	public void before() {
		profesor = new Profesor(1234, "miPass", "Javi", "Senit");
	}

	@Test
	public void testgetNia() {
		assertEquals(1234, profesor.getNia());
	}

	@Test
	public void testgetPass() {
		assertEquals("miPass", profesor.getPass());
	}

	@Test
	public void testgetNombre() {
		assertEquals("Javi", profesor.getNombre());
	}

	@Test
	public void testgetApellidos() {
		assertEquals("Senit", profesor.getApellidos());
	}

	@Test
	public void testsetNia() {

		profesor.setNia(4321);

		assertEquals(4321, profesor.getNia());
	}

	@Test
	public void testsetPass() {

		profesor.setPass("miOtraPass");

		assertEquals("miOtraPass", profesor.getPass());
	}

	@Test
	public void testsetNombre() {

		profesor.setNombre("Carlos");

		assertEquals("Carlos", profesor.getNombre());
	}

	@Test
	public void testsetApellidos() {
		profesor.setApellidos("Marti");

		assertEquals("Marti", profesor.getApellidos());
	}

}
