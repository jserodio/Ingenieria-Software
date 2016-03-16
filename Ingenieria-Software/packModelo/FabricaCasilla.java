package packModelo;

public class FabricaCasilla {
	private static FabricaCasilla miFabricaCasilla;
	private FabricaCasilla(){
	}
	public static FabricaCasilla getFabricaCasilla(){
		if (miFabricaCasilla == null){
			miFabricaCasilla = new FabricaCasilla();
		}
		return miFabricaCasilla;
	}
	public Casilla crearCasilla(String tipo){
		Casilla miCasilla = null;
		if(tipo.equals("sinMina")){
			miCasilla=new SinMina();
		}
		else{
			miCasilla=new Mina();
		}
		return miCasilla;
	}
}
