package org.buscaminas;

public class SinMina extends Casilla {
	private int num;
	
	public SinMina(){
		
	}
	public int getNum(){
		return num;
	}
	public void setNum(int pNum){
		num=pNum;
	}
	
	public void setAbierta(){
		super.setAbierta();
		if(getNum()==0){
			this.abrirVecinos();
		}
	}
	public void abrirVecinos(){
		this.getVecinos().abrirCasillas();
	}
	public int vecinosConMina(){
		return this.getVecinos().vecinosConMina();
	}
}
