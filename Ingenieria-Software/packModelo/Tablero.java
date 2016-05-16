package packModelo;

import java.awt.Color;
import java.util.Random;

import packInterfaz.VTableroCasillas;

public class Tablero {

	private int columnas;
	private int filas;
	private int numFlags;
	private int numMaxMinas;
	private Casilla[][] matriz;
	private Casilla casillaActual;

	public Tablero(int pFilas, int pColumnas, int pNivel){
		this.filas = pFilas;
		this.columnas = pColumnas;
		//inicializar la matriz
		matriz= new Casilla[filas][columnas];
		
		//Llenar la matriz de casillas sinMinas
		String pTipo;
		int fil=0;
		int col=0;
		while(fil<=filas-1){
			while(col<=columnas-1){
				pTipo = "sinMina";
				matriz[fil][col] = this.crearCasilla(pTipo);
				col++;
			}
			fil++;
			col=0;
		}
		//Meter casillas con minas aleatoriamente en la matriz
		int filRandom=0;
		int colRandom=0;
		this.numFlags = 0;
		this.numMaxMinas = columnas*pNivel;
		int minasIntroducidas=1;
		Random rnd=new Random();		
		while(minasIntroducidas <= numMaxMinas){
				filRandom = (int)(rnd.nextDouble() * filas);
				colRandom = (int)(rnd.nextDouble() * columnas);
				while(matriz[filRandom][colRandom] instanceof Mina){
					filRandom = (int)(rnd.nextDouble() * filas);
					colRandom = (int)(rnd.nextDouble() * columnas);
				}
				matriz[filRandom][colRandom]= this.crearCasilla("mina");
				minasIntroducidas++;
		}
		this.imprimirMatriz();
		//Obtener los vecinos de cada casilla
		this.obtenerVecinos();
	}
	
	private void imprimirMatriz(){
		for (int x=0; x < matriz.length; x++) {
			  System.out.print("|");
			  for (int y=0; y < matriz[x].length; y++) {
			    System.out.print (matriz[x][y]);
			    if (y!=matriz[x].length-1) System.out.print("\t");
			  }
			  System.out.println("|");
		}
	}
	
	public int getColumnas(){
		return this.columnas;
	}
	
	public int getFilas(){
		return this.filas;
	}
	
	public int getColumnaXCasilla(Casilla pCasilla){
		int columna=0;
		
		boolean salir=false;
		int fil=0;
		while(fil<=filas-1&&salir==false){
			int col=0;
			while(col<=columnas-1&&salir==false){
				if(matriz[fil][col].equals(pCasilla)){
					columna = col;
					salir=true;
				}
				col++;
			}
			fil++;
		}
		return columna;
	}
	
	public int getFilaXCasilla(Casilla pCasilla){
		int fila = 0;
		
		boolean salir=false;
		int fil=0;
		while(fil<=filas-1&&salir==false){
			int col=0;
			while(col<=columnas-1&&salir==false){
				if(matriz[fil][col].equals(pCasilla)){
					fila = fil;
					salir=true;
				}
				col++;
			}
			fil++;
		}
		return fila;
	}
	
	public Casilla crearCasilla (String pTipo){
		Casilla miCasilla = FabricaCasilla.getFabricaCasilla().crearCasilla(pTipo);	
		return miCasilla;
	}

	public int descubrirCasilla(int pFila, int pColumna){
		Casilla pCasilla=obtenerCasilla(pFila,pColumna);
		int result=1;
		if(!pCasilla.equals(null)){
			if(pCasilla instanceof SinMina){
				((SinMina)pCasilla).abrirCasilla();
				if(comprobarVictoria()){
					result=2;//Ganar
					return result;
				}
				else{
					return result;//Continuar
				}
			} else {
				((Mina)pCasilla).finalizarJuego();
				result=0;
				return result;//Perder				
			}
		}
		else{
			return result;
		}
	}
	
	public Casilla obtenerCasilla(int pFila, int pColumna){
		Casilla c=matriz[pFila][pColumna];
		return c;	
	}
	
	public void obtenerVecinos(){
		int fil=0;
		int col=0;
		int numVecinosMina;
		Casilla c=null;
		while(fil<=filas-1){
			col=0;
			while(col<=columnas-1){
				c=matriz[fil][col];
				this.obtenerVecinosCasillaX(c,fil,col);
				if (c instanceof SinMina){
					numVecinosMina=((SinMina)c).obtenerNumVecinosMina();
					((SinMina) c).setNumVecinosMina(numVecinosMina);
				}
				col++;
			}
			fil++;
		}
	}
	
	private void obtenerVecinosCasillaX(Casilla pCasilla,int pFil,int pCol){
		ListaCasillas vecinos = new ListaCasillas();
		vecinos.borrar();
		int col=pCol;
		int fil=pFil;
		if(fil-1<0&&col-1<0){
			Casilla c1=matriz[fil][col+1];
			Casilla c2=matriz[fil+1][col];
			Casilla c3=matriz[fil+1][col+1];
			vecinos.anadir(c1);
			vecinos.anadir(c2);
			vecinos.anadir(c3);
		}
		else if(fil-1<0&&(col-1>=0&&col+1<=columnas-1)){
			Casilla c1=matriz[fil][col-1];
			Casilla c2=matriz[fil][col+1];
			Casilla c3=matriz[fil+1][col-1];
			Casilla c4=matriz[fil+1][col];
			Casilla c5=matriz[fil+1][col+1];
			vecinos.anadir(c1);
			vecinos.anadir(c2);
			vecinos.anadir(c3);
			vecinos.anadir(c4);
			vecinos.anadir(c5);
		}
		else if(fil-1<0&&col+1>columnas-1){
			Casilla c1=matriz[fil][col-1];
			Casilla c2=matriz[fil+1][col-1];
			Casilla c3=matriz[fil+1][col];
			vecinos.anadir(c1);
			vecinos.anadir(c2);
			vecinos.anadir(c3);
		}
		else if((fil-1>=0&&fil+1<=filas-1)&&col-1<0){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col+1];
			Casilla c3=matriz[fil][col+1];
			Casilla c4=matriz[fil+1][col];
			Casilla c5=matriz[fil+1][col+1];
			vecinos.anadir(c1);
			vecinos.anadir(c2);
			vecinos.anadir(c3);
			vecinos.anadir(c4);
			vecinos.anadir(c5);
		}
		else if((fil-1>=0&&fil+1<=filas-1)&&(col-1>=0&&col+1<=columnas-1)){
			Casilla c1=matriz[fil-1][col-1];
			Casilla c2=matriz[fil-1][col];
			Casilla c3=matriz[fil-1][col+1];
			Casilla c4=matriz[fil][col-1];
			Casilla c5=matriz[fil][col+1];
			Casilla c6=matriz[fil+1][col-1];
			Casilla c7=matriz[fil+1][col];
			Casilla c8=matriz[fil+1][col+1];
			vecinos.anadir(c1);
			vecinos.anadir(c2);
			vecinos.anadir(c3);
			vecinos.anadir(c4);
			vecinos.anadir(c5);
			vecinos.anadir(c6);
			vecinos.anadir(c7);
			vecinos.anadir(c8);
		}
		else if((fil-1>=0&&fil+1<=filas-1)&&col+1>columnas-1){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col-1];
			Casilla c3=matriz[fil][col-1];
			Casilla c4=matriz[fil+1][col-1];
			Casilla c5=matriz[fil+1][col];
			vecinos.anadir(c1);
			vecinos.anadir(c2);
			vecinos.anadir(c3);
			vecinos.anadir(c4);
			vecinos.anadir(c5);
		}
		else if(fil+1>filas-1&&col-1<0){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col+1];
			Casilla c3=matriz[fil][col+1];
			vecinos.anadir(c1);
			vecinos.anadir(c2);
			vecinos.anadir(c3);
		}
		else if(fil+1>filas-1&&(col-1>=0&&col+1<=columnas-1)){
			Casilla c1=matriz[fil][col-1];
			Casilla c2=matriz[fil-1][col-1];
			Casilla c3=matriz[fil-1][col];
			Casilla c4=matriz[fil-1][col+1];
			Casilla c5=matriz[fil][col+1];
			vecinos.anadir(c1);
			vecinos.anadir(c2);
			vecinos.anadir(c3);
			vecinos.anadir(c4);
			vecinos.anadir(c5);
		}
		else if(fil+1>filas-1&&col+1>columnas-1){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col-1];
			Casilla c3=matriz[fil][col-1];
			vecinos.anadir(c1);
			vecinos.anadir(c2);
			vecinos.anadir(c3);
		}
		pCasilla.setVecinos(vecinos);
	}

	public Casilla getCasillaActual() {
		return this.casillaActual;
	}

	public void setCasillaActual(Casilla casilla) {
		this.casillaActual = casilla;
	}
	
	public String marcarYdesmarcarCasilla(int pFila, int pColumna){
		Casilla pCasilla=obtenerCasilla(pFila,pColumna);
		boolean marcada=pCasilla.marcarYdesmarcar();
		String rango;
		if(marcada){ // si esta marcadada
			if(this.numFlags<this.numMaxMinas&&this.numFlags>=0){
				this.numFlags=this.numFlags+1;
				System.out.println(this.numFlags);
				rango="Se puede";
				return rango;
			}else{
				System.out.println("Fuera de rango");
				return "Fuera de rango";
			}
		}
		else{ // si no estaba marcada
			if(this.numFlags>0&&this.numFlags<=this.numMaxMinas){
				this.numFlags=this.numFlags-1;
				System.out.println(this.numFlags);
				rango="Se puede";
				return rango;
			}else{
				System.out.println("Fuera de rango");
				return "Fuera de rango";
			}
			
		}
	}
	
	public int getNumMaxMinas(){
		return this.numMaxMinas;
	}
	
	public int getNumFlags() {
		return this.numFlags;
	}
	
	public void setNumFlags(int pNumMinas){
		this.numFlags = pNumMinas;
	}

	public void anadirObservador(VTableroCasillas pTablero) {
		for (int x=0; x < matriz.length; x++) {
			  for (int y=0; y < matriz[x].length; y++) {
			    matriz[x][y].addObserver(pTablero);
			  }
		}
	}
	
	public boolean comprobarVictoria(){
		boolean salir=false;
		boolean ganado=false;
		int col=0;
		int fil=0;
		Casilla c;
		while(fil<=filas-1){
			col=0;
			while(col<=columnas-1){
				c=matriz[fil][col];
				if (c instanceof SinMina && !c.getAbierta()){
					salir=true;
				}
				else if(c instanceof Mina && !c.getFlag()){
					salir=true;
				}
				col++;
			}
			fil++;
		}
		if(!salir){
			ganado=true;
		}
		return ganado;
	}
	
	
}