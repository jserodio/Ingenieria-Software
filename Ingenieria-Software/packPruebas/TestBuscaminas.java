package packPruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.BuilderN1;
import packModelo.BuilderN2;
import packModelo.BuilderN3;
import packModelo.Buscaminas;
import packModelo.TableroBuilder;

public class TestBuscaminas {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetTableroBuilder() {
		TableroBuilder builderN1=new BuilderN1();
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		assertEquals(Buscaminas.getBuscaminas().getTablero(),builderN1.getTablero());
	}

	@Test
	public void testGetBuscaminas() {
		assertNotNull(Buscaminas.getBuscaminas());
	}

	@Test
	public void testGetTablero() {
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		assertEquals(Buscaminas.getBuscaminas().getTablero(),builderN1.getTablero());
	}

	@Test
	public void testIniciar() {
		//Iniciar buscaminas nivel 1
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().iniciar(1);
		assertEquals(Buscaminas.getBuscaminas().getTablero().getColumnas(),builderN1.getTablero().getColumnas());
		assertEquals(Buscaminas.getBuscaminas().getTablero().getFilas(),builderN1.getTablero().getFilas());
		//Iniciar buscaminas nivel 2
		TableroBuilder builderN2=new BuilderN2();
		builderN2.construirTablero(2);
		Buscaminas.getBuscaminas().iniciar(2);
		assertEquals(Buscaminas.getBuscaminas().getTablero().getColumnas(),builderN2.getTablero().getColumnas());
		assertEquals(Buscaminas.getBuscaminas().getTablero().getFilas(),builderN2.getTablero().getFilas());
		//Iniciar buscaminas nivel 3
		TableroBuilder builderN3=new BuilderN3();
		builderN3.construirTablero(3);
		Buscaminas.getBuscaminas().iniciar(3);
		assertEquals(Buscaminas.getBuscaminas().getTablero().getColumnas(),builderN3.getTablero().getColumnas());
		assertEquals(Buscaminas.getBuscaminas().getTablero().getFilas(),builderN3.getTablero().getFilas());		
	}

}