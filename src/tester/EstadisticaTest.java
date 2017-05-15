package tester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import academia.*;

public class EstadisticaTest {

	Estadistica est;

	@Before
	public void before() {
		est = new Estadistica();
	}

	@Test
	public void testGetNumContestadosCorrectos() {
	assertEquals(0, est.getNumContestadosCorrectos());
	}

	@Test
	public void testSetNumContestadosCorrectos() {
		est.setNumContestadosCorrectos(1);
		assertEquals(1, est.getNumContestadosCorrectos());
	}

	@Test
	public void testGetNumContestadosIncorrectos() {
		assertEquals(0, est.getNumContestadosIncorrectos());
	}

	@Test
	public void testSetNumContestadosIncorrectos() {
		est.setNumContestadosIncorrectos(1);
		assertEquals(1, est.getNumContestadosIncorrectos());
	}

	@Test
	public void testGetSinContestar() {
		assertEquals(0, est.getSinContestar());
	}

	@Test
	public void testSetSinContestar() {
		est.setSinContestar(1);
		assertEquals(1, est.getSinContestar());
	}

	@Test
	public void testSumarContestadosIncorrectos() {
		est.sumarContestadosIncorrectos();
		assertEquals(1, est.getNumContestadosIncorrectos());
	}

	@Test
	public void testRestarContestadosIncorrectos() {
	est.restarContestadosIncorrectos();
	assertEquals(-1, est.getNumContestadosIncorrectos());
	}

	@Test
	public void testSumarContestadosCorrectos() {
		est.sumarContestadosCorrectos();
		assertEquals(1, est.getNumContestadosCorrectos());
	}

	@Test
	public void testRestarContestadosCorrectos() {
		est.restarContestadosCorrectos();
		assertEquals(-1, est.getNumContestadosCorrectos());
	}

	@Test
	public void testRestarSinContestar() {
		est.restarSinContestar();
		assertEquals(-1, est.getSinContestar());
	}

	@Test
	public void testSumarSinContestar() {
		est.sumarSinContestar();
		assertEquals(1, est.getSinContestar());
	}

}
