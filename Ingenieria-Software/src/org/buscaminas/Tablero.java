package org.buscaminas;

public class Tablero {
	int columnas;
	int filas;
	Casilla[] matriz;
	
	public Tablero(){
	}
	public Casilla crearCasilla (String tipo){
		Casilla miCasilla = FabricaCasilla.getFabricaCasilla().crearCasilla(tipo);
			
		return miCasilla;
	}
	public void setFilas(int pFilas){
		filas = pFilas;
	}
	public void setColumnas(int pColumnas){
		columnas = pColumnas;
	}



}
