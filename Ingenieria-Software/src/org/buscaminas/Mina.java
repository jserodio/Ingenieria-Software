package org.buscaminas;

public class Mina extends Casilla{

	public Mina(){
		super();
	}
	
	public boolean finalizarJuego(){
		super.setAbierta();
		boolean finaliza=true;
		return finaliza;
	}
}
