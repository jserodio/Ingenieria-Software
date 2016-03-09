package org.buscaminas;

import java.util.ArrayList;
import java.util.Iterator;

public class Numero extends Casilla {
	private int num;
	
	public Numero(){
		super();
	}
	
	public void setNum(int pNum){
		num=pNum;
	}
	public void setAbierta(){
		super.setAbierta();
		Iterator<Casilla> it=this.getVecinos().iterator();
		int num=0;
		while(it.hasNext()){
			if(it instanceof Mina){
				num++;
			}
			it.next();
		}
		setNum(num);
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
