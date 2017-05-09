package tester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import academia.*;

import academia.PreguntaMultiple;

public class PreguntaMultipleTest {
	
	PreguntaMultiple pm;

	@Before
	public void before() {
		int [] solu ={1,2};
		pm = new PreguntaMultiple("Enunciado", 3.0, solu, null);
		
	
	}
	

	@Test
	public void testEnviarRespuesta() {
		int [] solu ={3,4};
		Respuesta resp = new RespuestaMultiple( 1234, solu);
		assertFalse(pm.enviarRespuesta(resp, 1234));

		
	}

	@Test
	public void testGetSoluciones() {
		assertEquals(2, pm.getSoluciones().size());
		
		
	}

	@Test
	public void testAnyadirSoluciones() {
		int [] solu ={3,4};
pm.anyadirSoluciones(solu);
assertEquals(4,pm.getSoluciones().size());

	}

	@Test
	public void testEliminarSoluciones() {
		int [] solu ={3,4};
		pm.anyadirSoluciones(solu);
		assertEquals(4,pm.getSoluciones().size());
	

		pm.eliminarSoluciones(solu);
		
		assertEquals(2, pm.getSoluciones().size());
	}

	@Test
	public void testAnyadirRespuesta() {
		int [] solu ={3,4};
		
	
	
		assertFalse(pm.anyadirRespuesta(1234, solu));
	}

	@Test
	public void testCorregirPregunta() {
		
		int [] solu ={3,4};
		pm.corregirPregunta(solu);
		assertFalse(pm.corregirPregunta(solu));

	}

}
