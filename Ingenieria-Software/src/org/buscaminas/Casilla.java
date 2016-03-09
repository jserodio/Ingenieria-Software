package org.buscaminas;

import java.util.ArrayList;

public abstract class Casilla {
	private boolean flag;
	private boolean abierta;
	private ArrayList<Casilla> vecinos;
	
	public Casilla(){
		flag=false;
		abierta=false;
		vecinos=null;
	}
	
	public void setAbierta(){
		abierta=true;
	}
	
	public boolean getAbierta(){
		return abierta;
	}
	
	public ArrayList<Casilla> getVecinos(){
		return vecinos;
	}
	public void setVecinos(ArrayList<Casilla> pVecinos){
		vecinos=pVecinos;
	}
	
	
	
}