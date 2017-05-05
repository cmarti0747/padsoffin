package tester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import academia.*;

public class PreguntaLibreTest {

	PreguntaLibre pl;

	@Before
	public void before() {
		pl = new PreguntaLibre("Enunciado", 3.0, "Solucion");
		
	}
	
	
	
	
	@Test
	public void testEnviarRespuesta() {
		
		Respuesta resp = new RespuestaLibre ( 1234, "cadena");
		assertFalse(pl.enviarRespuesta(resp, 1234));

	}

	@Test
	public void testGetSolucion() {
		
		assertEquals("Solucion", pl.getSolucion());
	}

	@Test
	public void testSetSolucion() {
		pl.setSolucion("Solucionaux");
		
		assertEquals("Solucionaux", pl.getSolucion());
	}

	@Test
	public void testAnyadirRespuesta() {
		assertFalse(pl.anyadirRespuesta(1234, "cadena"));

	}

	@Test
	public void testCorregirPregunta() {
		pl.corregirPregunta("cadena");
		assertFalse(pl.corregirPregunta("cadena"));
	}

}
