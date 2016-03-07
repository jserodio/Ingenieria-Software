package org.asalbidegoitia.ejerTablero;

public abstract class TableroBuilder {
	protected Tablero tablero;
	public Tablero getTablero(){
		return tablero;
	}
	public void construirTablero(){
		tablero = new Tablero();
	}
}


