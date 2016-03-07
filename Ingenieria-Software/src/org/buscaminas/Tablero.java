package org.buscaminas;

public class Tablero {
	public Tablero(){
	}
	public Casilla crearCasilla (String tipo){
		Casilla miCasilla = FabricaCasilla.getFabricaCasilla().crearCasilla(tipo);
			
		return miCasilla;
	}
	



}
