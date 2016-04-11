package packModelo;

public abstract class TableroBuilder {
	protected Tablero tablero;
	
	private int fil = 0;
	private int col = 0;
	private int pNivel = 0;
	
	public void setFila(int pFil) {
		this.fil = pFil;
	}
	
	public void setColumna(int pCol) {
		this.col = pCol;
	}
	
	public Tablero getTablero(){
		return tablero;
	}
	
	protected abstract void setFilColxNivel(int pNivel);
	
	public void construirTablero(int pNivel) {
		setFilColxNivel(pNivel);
		tablero = new Tablero(fil, col, pNivel);
	}
}


