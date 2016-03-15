package packPruebas;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Casilla;
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
		//Abrir casilla con ningún vecino
		SinMina c1=new SinMina();
		c1.abrirCasilla();
		assertTrue(c1.getAbierta());
		//Abrir casilla con vecinos sin minas
		SinMina c2=new SinMina();
		ListaCasillas l= new ListaCasillas();
		l.anadir(new SinMina());
		l.anadir(new SinMina());
		l.anadir(new SinMina());
		c2.setVecinos(l);
		c2.abrirCasilla();
		assertTrue(c2.getAbierta());
		assertTrue(c2.getVecinos().getListaCasillas().get(0).getAbierta());
		assertTrue(c2.getVecinos().getListaCasillas().get(1).getAbierta());
		assertTrue(c2.getVecinos().getListaCasillas().get(2).getAbierta());
		//Abrir casilla con algún vecino con mina
		SinMina c3=new SinMina();
		ListaCasillas l1= new ListaCasillas();
		l1.anadir(new SinMina());
		l1.anadir(new SinMina());
		l1.anadir(new Mina());
		c3.setVecinos(l1);
		c3.abrirCasilla();
		assertTrue(c3.getAbierta());
		assertTrue(c3.getVecinos().getListaCasillas().get(0).getAbierta());
		assertTrue(c3.getVecinos().getListaCasillas().get(1).getAbierta());
		assertFalse(c3.getVecinos().getListaCasillas().get(2).getAbierta());
		
	}

	@Test
	public void testAbrirVecinos() {
		//Abrir vecinos siendo la lista de vecinos vacía
		SinMina c1=new SinMina();
		c1.abrirCasilla();
		assertTrue(c1.getVecinos().getListaCasillas().isEmpty());
		//Abrir vecinos sin minas
		SinMina c2=new SinMina();
		ListaCasillas l1= new ListaCasillas();
		l1.anadir(new SinMina());
		l1.anadir(new SinMina());
		l1.anadir(new SinMina());
		c1.setVecinos(l1);
		c1.abrirVecinos();
		assertTrue(c1.getVecinos().getListaCasillas().get(0).getAbierta());
		assertTrue(c1.getVecinos().getListaCasillas().get(1).getAbierta());
		assertTrue(c1.getVecinos().getListaCasillas().get(2).getAbierta());
		//Abrir vecinos habiendo un vecino con mina 
		SinMina c3=new SinMina();
		ListaCasillas l2= new ListaCasillas();
		l2.anadir(new SinMina());
		l2.anadir(new Mina());
		l2.anadir(new SinMina());
		c1.setVecinos(l2);
		c1.abrirVecinos();
		assertTrue(c1.getVecinos().getListaCasillas().get(0).getAbierta());
		assertFalse(c1.getVecinos().getListaCasillas().get(1).getAbierta());
		assertTrue(c1.getVecinos().getListaCasillas().get(2).getAbierta());
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
