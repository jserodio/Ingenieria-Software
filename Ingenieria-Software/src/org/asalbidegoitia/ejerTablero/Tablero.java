package org.asalbidegoitia.ejerTablero;

public class Tablero {
	public Tablero(){
	}
	public Casilla crearCasilla (String tipo){
		Casilla miCasilla = FabricaCasilla.getFabricaCasilla().crearCasilla(tipo);
		
		
		return miCasilla;
	}
public static void main(String[] args){
	Tablero miTablero = new Tablero();
	
}


}
