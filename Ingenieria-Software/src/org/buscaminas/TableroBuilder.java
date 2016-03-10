package org.buscaminas;

public abstract class TableroBuilder {
	protected Tablero tablero;
	
	public Tablero getTablero(){
		return tablero;
	}
	public abstract void construirTablero();

}


