package packModelo;

import java.util.Iterator;

public class SinMina extends Casilla{
	private int numVecinosMina;
	
	public SinMina(){
		
	}
	
	public int getNumVecinosMina(){
		return numVecinosMina;
	}
	
	public void setNumVecinosMina(int pNum){
		numVecinosMina=pNum;
	}
	
	public void setAbierta(){
		super.setAbierta();
	}
	
	public ListaCasillas getVecinosSinMina(){
		ListaCasillas vecinosSinMina = new ListaCasillas();
		Iterator<Casilla> it = vecinos.getListaCasillas().iterator();
		Casilla c;
		while(it.hasNext()){
			c=it.next();
			if(c.getAbierta()==true && c.getFlag()==false){
				vecinosSinMina.anadir(c);
			}
		}
		return vecinosSinMina;
	}
	
	public void abrirCasilla(){
		this.setAbierta();
		if(!this.getVecinos().getListaCasillas().isEmpty()){
			if(getNumVecinosMina()==0){
				this.abrirVecinos();
			}
		}
//		addObserver(this);
		setChanged();
	    notifyObservers();
	}
	
	public void abrirVecinos(){
		this.getVecinos().abrirCasillas();
	}
	
	public int obtenerNumVecinosMina(){
		return this.getVecinos().vecinosConMina();
	}
	
}