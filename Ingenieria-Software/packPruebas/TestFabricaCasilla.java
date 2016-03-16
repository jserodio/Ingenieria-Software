package packPruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Casilla;
import packModelo.FabricaCasilla;
import packModelo.Mina;
import packModelo.SinMina;

public class TestFabricaCasilla {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFabricaCasilla() {
		assertNotNull(FabricaCasilla.getFabricaCasilla());
	}

	@Test
	public void testCrearCasilla() {
		//crear casilla sinMina
		Casilla c1=FabricaCasilla.getFabricaCasilla().crearCasilla("sinMina");
		assertTrue(c1 instanceof SinMina);
		//crear casilla con mina
		Casilla c2=FabricaCasilla.getFabricaCasilla().crearCasilla("mina");
		assertTrue(c2 instanceof Mina);
	}

}
