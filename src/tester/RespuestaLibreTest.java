package tester;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import academia.RespuestaLibre;

public class RespuestaLibreTest {

	RespuestaLibre rl;

	@Before
	public void before() {
		rl = new RespuestaLibre(1234, "a b c d");

	}

	@Test
	public void testGetNia() {

		assertEquals(1234, rl.getNia());

	}

	@Test
	public void testSetNia() {
		rl.setNia(4321);
		assertEquals(4321, rl.getNia());
	}

	@Test
	public void testGetRespuestas() {

		assertEquals("a b c d", rl.getRespuestas());
	}

	@Test
	public void testSetRespuestas() {
		rl.setRespuestas("a b c d");
		assertEquals("a b c d", rl.getRespuestas());
	}

}
