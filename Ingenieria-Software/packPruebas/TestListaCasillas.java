package packPruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.BuilderN1;
import packModelo.Buscaminas;
import packModelo.ListaCasillas;
import packModelo.Mina;
import packModelo.SinMina;
import packModelo.TableroBuilder;

public class TestListaCasillas {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAbrirCasillas() {
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		//abrir casillas sin mina habiendo casillas sin mina en lista casillas
		SinMina c1=new SinMina();
		SinMina c2=new SinMina();
		SinMina c5=new SinMina();
		SinMina c6=new SinMina();
		ListaCasillas l=new ListaCasillas();
		l.anadir(c1);
		l.anadir(c2);
		l.abrirCasillas();
		assertTrue(c1.getAbierta());
		assertTrue(c2.getAbierta());
		
		//abrir casillas sin mina habiendo minas en lista casillas
		l.borrar();
		Mina c3=new Mina();
		SinMina c4=new SinMina();
		l.anadir(c3);
		l.anadir(c4);
		l.abrirCasillas();
		assertFalse(c3.getAbierta());
		assertTrue(c4.getAbierta());
		
		l.borrar();
		l.anadir(c1);
		l.anadir(c2);
		l.anadir(c3);
		l.anadir(c4);
		l.anadir(c5);
		l.anadir(c6);
		l.abrirCasillas();
		assertTrue(c1.getAbierta());
		assertTrue(c2.getAbierta());
		assertFalse(c3.getAbierta());
		assertTrue(c4.getAbierta());
		assertTrue(c5.getAbierta());
		assertTrue(c6.getAbierta());
	}

	@Test
	public void testVecinosConMina() {
		//Ninguna casilla con mina en lista casillas
		int numMina;
		SinMina c1=new SinMina();
		SinMina c2=new SinMina();
		ListaCasillas l=new ListaCasillas();
		l.anadir(c1);
		l.anadir(c2);
		numMina=l.vecinosConMina();
		assertEquals(numMina,0);
		//Una casilla de lista casillas con mina
		Mina c3=new Mina();
		l.anadir(c3);
		numMina=l.vecinosConMina();
		assertEquals(numMina,1);
		//Mas de una casilla de lista casillas con mina
		Mina c4=new Mina();
		l.anadir(c4);
		numMina=l.vecinosConMina();
		assertEquals(numMina,2);
	}

	@Test
	public void testBorrar() {
		//Borrar la lista casillas con una casilla
		SinMina c1=new SinMina();
		ListaCasillas l= new ListaCasillas();
		l.anadir(c1);
		l.borrar();
		assertTrue(l.getListaCasillas().isEmpty());
		//Borrar la lista casillas con m�s de una casilla
		SinMina c2=new SinMina();
		l.anadir(c1);
		l.anadir(c2);
		l.borrar();
		assertTrue(l.getListaCasillas().isEmpty());
	}

	@Test
	public void testAnadir() {
		//a�adir casillas a la lista casillas
		SinMina c1=new SinMina();
		SinMina c2=new SinMina();
		SinMina c3=new SinMina();
		ListaCasillas l=new ListaCasillas();
		assertTrue(l.getListaCasillas().isEmpty());
		l.anadir(c1);
		l.anadir(c2);
		l.anadir(c3);
		assertEquals(l.getListaCasillas().size(),3);

	}

	@Test
	public void testEliminarCasilla() {
		//Eliminar la unica casilla que hay en ListaCasillas
		SinMina c1=new SinMina();
		ListaCasillas l=new ListaCasillas();
		l.anadir(c1);
		l.eliminarCasilla(c1);
		assertEquals(l.getListaCasillas().size(),0);
		
		//Eliminar una casilla de las casillas que hay en ListaCasillas
		SinMina c2=new SinMina();
		l.anadir(c1);
		l.anadir(c2);
		l.eliminarCasilla(c2);
		assertEquals(l.getListaCasillas().size(),1);
		
		//Eliminar una casilla no existente en ListaCasillas
		SinMina c3=new SinMina();
		l.anadir(c2);
		l.eliminarCasilla(c3);
		assertEquals(l.getListaCasillas().size(),2);
		
	}

}
