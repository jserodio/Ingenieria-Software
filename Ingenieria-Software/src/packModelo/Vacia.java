package packModelo;

public class Vacia extends Casilla {
	public Vacia(){
		super();
	}
	public void setAbierta(){
		super.setAbierta();
		this.abrirVecinos();
	}
	public void abrirVecinos(){
		this.getVecinos().abrirCasillas();
	}
	
}
