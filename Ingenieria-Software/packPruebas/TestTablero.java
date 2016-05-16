package packPruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import packModelo.BuilderN1;
import packModelo.Buscaminas;
import packModelo.Casilla;
import packModelo.ListaCasillas;
import packModelo.Mina;
import packModelo.SinMina;
import packModelo.Tablero;
import packModelo.TableroBuilder;

public class TestTablero {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetColumnas() {
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		assertEquals(Buscaminas.getBuscaminas().getTablero().getColumnas(),10);
	}

	@Test
	public void testGetFilas() {
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		assertEquals(Buscaminas.getBuscaminas().getTablero().getFilas(),7);
	}

	@Test
	public void testGetColumnaXCasilla() {
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		//Primera columna
		Casilla c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0,0);
		assertEquals(Buscaminas.getBuscaminas().getTablero().getColumnaXCasilla(c),0);
		//Ultima columna
		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6,6);
		assertEquals(Buscaminas.getBuscaminas().getTablero().getColumnaXCasilla(c),6);
		
	}

	@Test
	public void testGetFilaXCasilla() {
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		//Primera fila
		Casilla c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0,0);
		assertEquals(Buscaminas.getBuscaminas().getTablero().getFilaXCasilla(c),0);
		//Ultima fila
		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6,6);
		assertEquals(Buscaminas.getBuscaminas().getTablero().getFilaXCasilla(c),6);
		
	}

	@Test
	public void testCrearCasilla() {
		Casilla c=Buscaminas.getBuscaminas().getTablero().crearCasilla("sinMina");
		assertTrue(c instanceof SinMina);
		c=Buscaminas.getBuscaminas().getTablero().crearCasilla("mina");
		assertTrue(c instanceof Mina);
	}

	@Test
	public void testDescubrirCasilla() {
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		Casilla c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 0);
		if(c instanceof Mina){//Perder 
			assertEquals(Buscaminas.getBuscaminas().getTablero().descubrirCasilla(0, 0),0);		
		}
		else{//Continuar
			assertEquals(Buscaminas.getBuscaminas().getTablero().descubrirCasilla(0, 0),1);
		}
		//Ganar Buscaminas
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 0);
		if(c instanceof SinMina){
			Tablero t=Buscaminas.getBuscaminas().getTablero();
			int i=0;
			int j=1;
			while(i<=6){
				while(j<=9){
					c=t.obtenerCasilla(i, j);
					if(c instanceof SinMina){
						c.setAbierta();
					}
					else if(c instanceof Mina){
						c.setFlag(true);
					}
					j++;
				}
				i++;
				j=0;
			}
			assertEquals(t.descubrirCasilla(0, 0),2);
		}
	}

	@Test
	public void testObtenerCasilla() {
		//Obtener una casilla existente
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		Casilla c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0,0);
		assertEquals(Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 0),c);
	}

	@Test
	public void testObtenerVecinos() {
		Casilla c4;
		Casilla c5;
		Casilla c6;
		Casilla c7;
		Casilla c8;
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		Buscaminas.getBuscaminas().getTablero().obtenerVecinos();
		//Obtener Vecinos de una casilla situada en la esquina superior izquierda
		Casilla c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0,0);
		Casilla c1=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 1);
		Casilla c2=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1, 0);
		Casilla c3=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1, 1);
		assertEquals(c.getVecinos().getListaCasillas().get(0),c1);
		assertEquals(c.getVecinos().getListaCasillas().get(1),c2);
		assertEquals(c.getVecinos().getListaCasillas().get(2),c3);
		c.setVecinos(new ListaCasillas());
		//Obtener Vecinos de una casilla situada en el medio de la primera fila
		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0,1);
		c1=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 0);
		c2=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 2);
		c3=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1, 0);
		c4=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1, 1);
		c5=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1, 2);
		assertEquals(c.getVecinos().getListaCasillas().get(0),c1);
		assertEquals(c.getVecinos().getListaCasillas().get(1),c2);
		assertEquals(c.getVecinos().getListaCasillas().get(2),c3);
		assertEquals(c.getVecinos().getListaCasillas().get(3),c4);
		assertEquals(c.getVecinos().getListaCasillas().get(4),c5);
		c.setVecinos(new ListaCasillas());
		//Obtener Vecinos de una casilla situada en la esquina superior derecha
		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0,9);
		c1=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 8);
		c2=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1, 8);
		c3=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1, 9);
		assertEquals(c.getVecinos().getListaCasillas().get(0),c1);
		assertEquals(c.getVecinos().getListaCasillas().get(1),c2);
		assertEquals(c.getVecinos().getListaCasillas().get(2),c3);
		c.setVecinos(new ListaCasillas());
		//Obtener Vecinos de una casilla situada en la primera columna en el medio del tablero
		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1,0);
		c1=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 0);
		c2=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 1);
		c3=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1, 1);
		c4=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(2, 0);
		c5=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(2, 1);
		assertEquals(c.getVecinos().getListaCasillas().get(0),c1);
		assertEquals(c.getVecinos().getListaCasillas().get(1),c2);
		assertEquals(c.getVecinos().getListaCasillas().get(2),c3);
		assertEquals(c.getVecinos().getListaCasillas().get(3),c4);
		assertEquals(c.getVecinos().getListaCasillas().get(4),c5);
		c.setVecinos(new ListaCasillas());
		//Obtener Vecinos de una casilla situada en el medio del tablero
		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(5,5);
		c1=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(4, 4);
		c2=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(4, 5);
		c3=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(4, 6);
		c4=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(5, 4);
		c5=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(5, 6);
		c6=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6, 4);
		c7=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6, 5);
		c8=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6, 6);
		assertEquals(c.getVecinos().getListaCasillas().get(0),c1);
		assertEquals(c.getVecinos().getListaCasillas().get(1),c2);
		assertEquals(c.getVecinos().getListaCasillas().get(2),c3);
		assertEquals(c.getVecinos().getListaCasillas().get(3),c4);
		assertEquals(c.getVecinos().getListaCasillas().get(4),c5);
		assertEquals(c.getVecinos().getListaCasillas().get(5),c6);
		assertEquals(c.getVecinos().getListaCasillas().get(6),c7);
		assertEquals(c.getVecinos().getListaCasillas().get(7),c8);
		c.setVecinos(new ListaCasillas());
		//Obtener Vecinos de una casilla situada en la ultima columna en el medio del tablero
		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1,9);
		c1=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 9);
		c2=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0, 8);
		c3=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(1, 8);
		c4=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(2, 8);
		c5=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(2, 9);
		assertEquals(c.getVecinos().getListaCasillas().get(0),c1);
		assertEquals(c.getVecinos().getListaCasillas().get(1),c2);
		assertEquals(c.getVecinos().getListaCasillas().get(2),c3);
		assertEquals(c.getVecinos().getListaCasillas().get(3),c4);
		assertEquals(c.getVecinos().getListaCasillas().get(4),c5);
		c.setVecinos(new ListaCasillas());
		//Obtener Vecinos de una casilla situada en la esquina inferior izquierda
		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6,0);
		c1=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(5, 0);
		c2=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(5, 1);
		c3=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6, 1);
		assertEquals(c.getVecinos().getListaCasillas().get(0),c1);
		assertEquals(c.getVecinos().getListaCasillas().get(1),c2);
		assertEquals(c.getVecinos().getListaCasillas().get(2),c3);
		c.setVecinos(new ListaCasillas());
		//Obtener Vecinos de una casilla situada en el medio de la ultima fila
		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6,1);
		c1=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6, 0);
		c2=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(5, 0);
		c3=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(5, 1);
		c4=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(5, 2);
		c5=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6, 2);
		assertEquals(c.getVecinos().getListaCasillas().get(0),c1);
		assertEquals(c.getVecinos().getListaCasillas().get(1),c2);
		assertEquals(c.getVecinos().getListaCasillas().get(2),c3);
		assertEquals(c.getVecinos().getListaCasillas().get(3),c4);
		assertEquals(c.getVecinos().getListaCasillas().get(4),c5);
		c.setVecinos(new ListaCasillas());
		//Obtener Vecinos de una casilla situada en la esquina inferior derecha
		c=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6,9);
		c1=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(5, 9);
		c2=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(5, 8);
		c3=Buscaminas.getBuscaminas().getTablero().obtenerCasilla(6, 8);
		assertEquals(c.getVecinos().getListaCasillas().get(0),c1);
		assertEquals(c.getVecinos().getListaCasillas().get(1),c2);
		assertEquals(c.getVecinos().getListaCasillas().get(2),c3);
		c.setVecinos(new ListaCasillas());
	}
	
	@Test
	public void testMarcarYdesmarcarCasilla(){
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		//Poner flag casilla (0,0)
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,0);
		Casilla c = Buscaminas.getBuscaminas().getTablero().obtenerCasilla(0,0);
		System.out.println(c.getFlag());
		assertTrue(c.getFlag());
		assertEquals(Buscaminas.getBuscaminas().getTablero().getNumFlags(), 1);
		//Quitar flag casilla (0,0)
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,0);
		System.out.println(c.getFlag());
		assertFalse(c.getFlag());
		assertEquals(Buscaminas.getBuscaminas().getTablero().getNumFlags(), 0);
		//Poner el maximo numero de flags
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,0);
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,1);
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,2);
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,3);
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,4);
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,5);
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,6);
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,7);
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,8);
		String rango=Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(0,9);
		assertEquals(rango,"Se puede");
		//Poner un flag más de lo permitido
		rango=Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(1,9);
		assertEquals(rango,"Fuera de rango");
	}
	
	
	@Test
	public void testComprobarVictoria(){
		TableroBuilder builderN1=new BuilderN1();
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		//Resolver el buscaminas
		Casilla c;
		Tablero t=Buscaminas.getBuscaminas().getTablero();
		int i=0;
		int j=0;
		while(i<=6){
			while(j<=9){
				c=t.obtenerCasilla(i, j);
				if(c instanceof SinMina){
					c.setAbierta();
				}
				else if(c instanceof Mina){
					c.setFlag(true);
				}
				j++;
			}
			i++;
			j=0;
		}
		assertEquals(t.comprobarVictoria(),true);
		
		//No resolver completamente el buscaminas
		
		builderN1.construirTablero(1);
		Buscaminas.getBuscaminas().setTableroBuilder(builderN1);
		t=Buscaminas.getBuscaminas().getTablero();
		
		i=0;
		j=0;
		while(i<=6){
			while(j<=9){
				c=t.obtenerCasilla(i, j);
				if(c instanceof SinMina){
					c.setAbierta();
				}
				j++;
			}
			i++;
			j=0;
		}
		assertEquals(t.comprobarVictoria(),false);
		
	}
}
