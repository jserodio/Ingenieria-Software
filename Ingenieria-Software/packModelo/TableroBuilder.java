package packModelo;

public abstract class TableroBuilder {
	protected Tablero tablero;
	
	protected int fil = 0;
	protected int col = 0;
	protected int pNivel = 0;
	
	public void setFila(int pFil) {
		this.fil = pFil;
	}
	
	public void setColumna(int pCol) {
		this.col = pCol;
	}
	
	public Tablero getTablero(){
		return tablero;
	}
	
	protected abstract void setFilColxNivel();
	
	public void construirTablero(int pNivel) {
		setFilColxNivel();
		tablero = new Tablero(fil, col, pNivel);
	}
}


