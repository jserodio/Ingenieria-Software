package packModelo;

public abstract class Casilla {
	
	private boolean flag = false;;
	private boolean abierta = false;
	private ListaCasillas vecinos = null;
	
	public void setAbierta(){
		abierta=true;
	}
	
	public void setFlag(boolean pFlag){
		flag=pFlag;
	}
	
	public void setVecinos(ListaCasillas pVecinos){
		vecinos=pVecinos;
	}
	
	public boolean getAbierta(){
		return abierta;
	}
	
	public boolean getFlag(){
		return this.flag;
	}
	
	public ListaCasillas getVecinos(){
		return vecinos;
	}

	public void eliminarVecinosAbiertos(){
		vecinos.eliminarCasillasAbiertas();
	}
}