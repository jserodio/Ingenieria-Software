package packPruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import packModelo.BuilderN1;
import packModelo.Buscaminas;
import packModelo.Casilla;
import packModelo.Mina;
import packModelo.TableroBuilder;

public class TestTablero {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testGetColumnas() {
//		TableroBuilder builderN1=new BuilderN1();
//		builderN1.construirTablero();
//		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
//		assertEquals(Buscaminas.getBuscaminas().getTablero().getColumnas(),10);
//	}

//	@Test
//	public void testGetFilas() {
//		TableroBuilder builderN1=new BuilderN1();
//		builderN1.construirTablero();
//		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
//		assertEquals(Buscaminas.getBuscaminas().getTablero().getFilas(),7);
//	}

//	@Test
//	public void testGetColumnaXCasilla() {
//		TableroBuilder builderN1=new BuilderN1();
//		builderN1.construirTablero();
//		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
//		//Primera columna
//		Casilla c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0,0);
//		assertEquals(Buscaminas.getBuscaminas().getTablero().getColumnaXCasilla(c),0);
//		//Ultima columna
//		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6,6);
//		assertEquals(Buscaminas.getBuscaminas().getTablero().getColumnaXCasilla(c),6);
//		
//	}

	@Test
	public void testGetFilaXCasilla() {
		fail("Not yet implemented");
	}

	@Test
	public void testCrearCasilla() {
		fail("Not yet implemented");
	}

//	@Test
//	public void testDescubrirCasilla() {
//		TableroBuilder builderN1=new BuilderN1();
//		builderN1.construirTablero();
//		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
//		Casilla c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 0);
//		if(c instanceof Mina){
//			assertFalse(Buscaminas.getBuscaminas().getTablero().descubrirCasilla(0, 0));		
//		}
//		else{
//			assertTrue(Buscaminas.getBuscaminas().getTablero().descubrirCasilla(0, 0));
//		}
//	}

//	@Test
//	public void testObtenerCasilla() {
//		//Obtener una casilla existente
//		TableroBuilder builderN1=new BuilderN1();
//		builderN1.construirTablero();
//		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
//		Casilla c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0,0);
//		assertEquals(Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 0),c);
//		//Obtener una casilla no existente
//		assertNull(Buscaminas.getBuscaminas().getTablero().obtenerCasilla(8,8));
//	}

//	@Test
//	public void testObtenerVecinos() {
//		TableroBuilder builderN1=new BuilderN1();
//		builderN1.construirTablero();
//		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
//		Buscaminas.getBuscaminas().getTablero().obtenerVecinos();
//		Casilla c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0,0);
//		Casilla c1=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 1);
//		Casilla c2=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1, 0);
//		Casilla c3=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1, 1);
//		assertEquals(c.getVecinos().getListaCasillas().get(0),c1);
//		assertEquals(c.getVecinos().getListaCasillas().get(1),c2);
//		assertEquals(c.getVecinos().getListaCasillas().get(2),c3);
//		
//		
//	}

}

