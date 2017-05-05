package tester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import academia.RespuestaMultiple;


public class RespuestaMultipleTest {
	RespuestaMultiple rm;

	@Before
	public void before() {
		int [] solu ={3,4};
		rm = new RespuestaMultiple(1234, solu);

	}

	@Test
	public void testGetNia() {
		assertEquals(1234, rm.getNia());
	}

	@Test
	public void testSetNia() {
		rm.setNia(4321);
		assertEquals(4321, rm.getNia());
	}

	@Test
	public void testGetRespuestas() {
		
	
		assertEquals(2, rm.getRespuestas().length);
	}

	@Test
	public void testSetRespuestas() {
		int [] solu ={3,4};
		rm.setRespuestas(solu);
		
		assertEquals(solu, rm.getRespuestas());
	}

}
