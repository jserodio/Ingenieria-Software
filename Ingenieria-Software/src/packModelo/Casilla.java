package packModelo;

public abstract class Casilla {
	
	private boolean flag = false;;
	private boolean abierta = false;
	private ListaCasillas vecinos = null;
	
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
	public void eliminarVecinosAbiertos(){
		vecinos.eliminarCasillasAbiertas();
	}
}