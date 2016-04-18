package packModelo;

import java.util.Observable;

public abstract class Casilla extends Observable {
	private boolean flag;
	private boolean abierta;
	private ListaCasillas vecinos;
	
	public Casilla(){
		flag=false;
		abierta=false;
		vecinos=new ListaCasillas();
	}
	
	public void setAbierta(){
		abierta=true;
	}
	public boolean getFlag(){
		return this.flag;
	}
	
	public void setFlag(boolean pFlag){
		flag=pFlag;
	}
	
	public boolean getAbierta(){
		return abierta;
	}
	
	public ListaCasillas getVecinos(){
		return vecinos;
	}
	public void setVecinos(ListaCasillas pVecinos){
		vecinos=pVecinos;
	}
}