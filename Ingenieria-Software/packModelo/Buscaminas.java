package packModelo;

public class Buscaminas {

	private static Buscaminas miBuscaminas=null;
	private TableroBuilder tableroBuilder;
	public void setTableroBuilder(TableroBuilder tb){
		tableroBuilder = tb;
	}
	private Buscaminas(){
	
	}
	public static Buscaminas getBuscaminas(){
		if(miBuscaminas==null){
			miBuscaminas=new Buscaminas();
		}
		return miBuscaminas;
	}
	public Tablero getTablero(){
		return tableroBuilder.getTablero();
	}

	public void iniciar(int pNivel){
		if(pNivel==1){
			TableroBuilder builderN1 = new BuilderN1();
			builderN1.construirTablero(pNivel);
			this.setTableroBuilder(builderN1);
		}
		else if(pNivel==2){
			TableroBuilder builderN2 = new BuilderN2();
			builderN2.construirTablero(pNivel);
			this.setTableroBuilder(builderN2);
		}
		else{
			TableroBuilder builderN3 = new BuilderN3();
			builderN3.construirTablero(pNivel);
			this.setTableroBuilder(builderN3);
		}
	}
	public boolean descubrirCasilla(int pFila, int pColumna){
		return this.getTablero().descubrirCasilla(pFila, pColumna);
	}
	
	public Casilla obtenerCasilla(int pFila, int pColumna){
		return this.getTablero().obtenerCasilla(pFila, pColumna);
	}
	
	public void setCasillaActual(SinMina pCasilla) {
		this.getTablero().setCasillaActual(pCasilla);
	}
	
	public SinMina getCasillaActual() {
		return this.getTablero().getCasillaActual();
	}
	
	public int getFilaXCasilla(Casilla pCasilla){
		return this.getTablero().getFilaXCasilla(pCasilla);
	}
	
	public int getColumnaXCasilla(Casilla pCasilla){
		return this.getTablero().getColumnaXCasilla(pCasilla);
	}
	
//	public static void main(String[] args){
//		Buscaminas buscaminas = new Buscaminas();
//		TableroBuilder builderN1 = new BuilderN1();
//		TableroBuilder builderN2 = new BuilderN2();
//		TableroBuilder builderN3 = new BuilderN3();
//		
//		buscaminas.setTableroBuilder(builderN1);
//		buscaminas.setTableroBuilder(builderN2);
//		buscaminas.setTableroBuilder(builderN3);
//	}
	
	
}

