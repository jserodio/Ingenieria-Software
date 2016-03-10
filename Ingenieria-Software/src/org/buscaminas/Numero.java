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
		int num=this.vecinosConMina();
	}
	public int vecinosConMina(){
		return this.getVecinos().vecinosConMina();
	}
}
