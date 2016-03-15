package packPruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.ListaCasillas;
import packModelo.Mina;
import packModelo.SinMina;

public class TestSinMina {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetAbierta() {
		SinMina c1=new SinMina();
		c1.setAbierta();
		assertTrue(c1.getAbierta());
	}

	@Test
	public void testGetNumVecinosMina() {
		//Ningun vecino con mina
		SinMina c1=new SinMina();
		ListaCasillas l= new ListaCasillas();
		c1.setVecinos(l);
		int numMina=c1.obtenerNumVecinosMina();
		c1.setNumVecinosMina(numMina);
		assertEquals(0,c1.getNumVecinosMina());
		//Un vecino con mina
		Mina c2=new Mina();
		l.anadir(c2);
		c1.setVecinos(l);
		numMina=c1.obtenerNumVecinosMina();
		c1.setNumVecinosMina(numMina);
		assertEquals(1,c1.getNumVecinosMina());
		//Mas de un vecino con mina
		Mina c3=new Mina();
		l.anadir(c3);
		c1.setVecinos(l);
		numMina=c1.obtenerNumVecinosMina();
		c1.setNumVecinosMina(numMina);
		assertEquals(2,c1.getNumVecinosMina());

	}

	@Test
	public void testSetNumVecinosMina() {
		SinMina c1=new SinMina();
		c1.setNumVecinosMina(2);
		assertEquals(2,c1.getNumVecinosMina());
	}

	@Test
	public void testAbrirCasilla() {
		fail("Not yet implemented");
	}

	@Test
	public void testAbrirVecinos() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerNumVecinosMina() {
		//Ningun vecino con mina
				SinMina c1=new SinMina();
				ListaCasillas l= new ListaCasillas();
				c1.setVecinos(l);
				int numMina=c1.obtenerNumVecinosMina();
				assertEquals(0,numMina);
				//Un vecino con mina
				Mina c2=new Mina();
				l.anadir(c2);
				c1.setVecinos(l);
				numMina=c1.obtenerNumVecinosMina();
				assertEquals(1,numMina);
				//Mas de un vecino con mina
				Mina c3=new Mina();
				l.anadir(c3);
				c1.setVecinos(l);
				numMina=c1.obtenerNumVecinosMina();
				assertEquals(2,numMina);

	}

}
