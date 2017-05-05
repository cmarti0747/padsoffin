package tester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import academia.*;

public class PreguntaUnicaTest {
	
	PreguntaUnica pu;

	@Before
	public void before() {
		pu = new PreguntaUnica("Enunciado", 3.0, 1);
		
	}
	

	@Test
	public void testEnviarRespuesta() {
		Respuesta resp = new RespuestaUnica (1234, 1);
		assertTrue(pu.enviarRespuesta(resp, 1234));
	}

	@Test
	public void testIsSolucion() {
		assertEquals(1, pu.isSolucion());
	}

	@Test
	public void testSetSolucion() {
	pu.setSolucion(1);
		
		assertEquals(1, pu.isSolucion());
	}

	@Test
	public void testAnyadirRespuesta() {
		assertTrue(pu.anyadirRespuesta(1234, 1));
	}

	@Test
	public void testCorregirPregunta() {
		pu.corregirPregunta(1);
		assertTrue(pu.corregirPregunta(1));
	}

}
