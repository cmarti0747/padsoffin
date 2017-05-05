package tester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import academia.RespuestaMultiple;
import academia.*;
public class RespuestaUnicaTest {
	
	RespuestaUnica ru;

	@Before
	public void before() {
		
		ru = new RespuestaUnica(1234, 1);

	}


	@Test
	public void testGetNia() {
		assertEquals(1234, ru.getNia());
	}

	@Test
	public void testSetNia() {
		ru.setNia(4321);
		assertEquals(4321, ru.getNia());
	}

	@Test
	public void testGetRespuestas() {
		
		assertEquals(1, ru.getRespuestas());
	}

	@Test
	public void testSetRespuestas() {
		ru.setRespuestas(2);
		
		assertEquals(2, ru.getRespuestas());
	}

}
