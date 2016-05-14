package packModelo;

import java.util.Observable;

public abstract class Casilla extends Observable {
	private boolean flag;
	private boolean abierta;
	protected ListaCasillas vecinos;
	
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
	
	public boolean marcarYdesmarcar(){
		boolean marcado;
		if(this.getFlag()){
			this.setFlag(false);
			marcado=false;
		}
		else{
			this.setFlag(true);
			marcado=true;
		}
		return marcado;
	}
}