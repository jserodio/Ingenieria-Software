package org.buscaminas;

import java.util.ArrayList;
import java.util.Iterator;

public class Vacia extends Casilla {
	
	public Vacia(){
		super();
	}
	public void setAbierta(){
		super.setAbierta();
		this.abrirVecinos();
	}
	public void abrirVecinos(){
		ArrayList<Casilla> vecinos=this.getVecinos();
		Iterator<Casilla> it=vecinos.iterator();
		Casilla c=null;
		while(it.hasNext()){
			c=it.next();
			if(c instanceof Vacia||c instanceof Numero){
				c.setAbierta();
			}
		}
	}

}
