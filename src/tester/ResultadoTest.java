package tester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import academia.*;

public class ResultadoTest {

	Resultado res;

	@Before
	public void before() {
		res = new Resultado(1234,3.0 );
	}
	
	
	
	@Test
	public void testGetNia() {
		assertEquals(1234, res.getNia());
	}

	@Test
	public void testSetNia() {
		res.setNia(4321);
		assertEquals(4321, res.getNia());
	}

	@Test
	public void testGetNota() {
		assertEquals(3.0, res.getNota(), 0);
	}

	@Test
	public void testSetNota() {
		res.setNota(4.5);
		assertEquals(4.5, res.getNota(),0);
	}

}
