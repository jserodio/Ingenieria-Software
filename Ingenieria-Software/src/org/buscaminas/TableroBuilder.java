package org.buscaminas;

public abstract class TableroBuilder {
	protected Tablero tablero;

	public abstract void construirTablero();

	public Tablero getTablero() {
		return tablero;
	}

}


