package packPruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Mina;

public class TestMina {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testFinalizarJuego() {
		Mina c1=new Mina();
		assertTrue(c1.finalizarJuego());
	}

}
