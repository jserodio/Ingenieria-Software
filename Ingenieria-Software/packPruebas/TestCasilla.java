package packPruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Casilla;
import packModelo.ListaCasillas;
import packModelo.Mina;
import packModelo.SinMina;

public class TestCasilla {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetAbierta() {
		Casilla c1=new SinMina();
		c1.setAbierta();
		assertTrue(c1.getAbierta());
		
		Casilla c2=new Mina();
		c2.setAbierta();
		assertTrue(c2.getAbierta());
		
	}

	@Test
	public void testGetFlag() {
		Casilla c1=new SinMina();
		assertFalse(c1.getFlag());
		c1.setFlag(true);
		assertTrue(c1.getFlag());
		
		Casilla c2=new Mina();
		assertFalse(c2.getFlag());
		c2.setFlag(true);
		assertTrue(c2.getFlag());
	}

	@Test
	public void testSetFlag() {
		Casilla c1=new SinMina();
		c1.setFlag(true);
		assertTrue(c1.getFlag());
		
		Casilla c2=new Mina();
		c2.setFlag(true);
		assertTrue(c2.getFlag());
	}

	@Test
	public void testGetAbierta() {
		Casilla c1=new SinMina();
		c1.setAbierta();
		assertTrue(c1.getAbierta());
		
		Casilla c2=new Mina();
		c2.setAbierta();
		assertTrue(c2.getAbierta());
	}

	@Test
	public void testGetVecinos() {
		Casilla c1=new SinMina();
		ListaCasillas l=new ListaCasillas();
		l.anadir(new SinMina());
		l.anadir(new Mina());
		c1.setVecinos(l);
		assertFalse(c1.getVecinos().getListaCasillas().isEmpty());
	}

	@Test
	public void testSetVecinos() {
		Casilla c1=new SinMina();
		assertTrue(c1.getVecinos().getListaCasillas().isEmpty());
		ListaCasillas l=new ListaCasillas();
		l.anadir(new SinMina());
		l.anadir(new Mina());
		c1.setVecinos(l);
		assertFalse(c1.getVecinos().getListaCasillas().isEmpty());
		
	}
	
	@Test
	public void testMarcarYdesmarcar(){
		Casilla c1=new SinMina();
		//Poner flag
		assertTrue(c1.marcarYdesmarcar());
		//Quitar flag
		assertFalse(c1.marcarYdesmarcar());
	}

}
