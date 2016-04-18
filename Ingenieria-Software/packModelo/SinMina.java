package packModelo;

public class SinMina extends Casilla {
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
	
	public void abrirCasilla(){
		this.setAbierta();
		if(!this.getVecinos().getListaCasillas().isEmpty()){
			if(getNumVecinosMina()==0){
				this.abrirVecinos();
			}
		}
	}
	
	public void abrirVecinos(){
		this.getVecinos().abrirCasillas();
	}
	
	public int obtenerNumVecinosMina(){
		return this.getVecinos().vecinosConMina();
	}
	
}