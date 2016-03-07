package org.buscaminas;

public class FabricaCasilla {
	private static FabricaCasilla miFabricaCasilla;
	private FabricaCasilla(){
	}
	public static FabricaCasilla getFabricaCasilla(){
		if (miFabricaCasilla == null){
			miFabricaCasilla = new FabricaCasilla();
		}
		return miFabricaCasilla;
	}
	public Casilla crearCasilla(String tipo){
		Casilla miCasilla = null;
		
		
		return miCasilla;
	}
}
