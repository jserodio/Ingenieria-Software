package packModelo;

import java.util.Random;

public class Tablero {

	private int nivel;
	private int columnas;
	private int filas;
	private Casilla[][] matriz;

	public Tablero(int pNivel){
		nivel = pNivel;
		switch (pNivel){
		case 1:	filas=7; columnas=10;
		break;
		case 2: filas=10; columnas=15;
		break;
		case 3: filas=12; columnas=25;
		break;
		default:	//falla
		break;
		}
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
		int numMinas = columnas*nivel;
		int minasIntroducidas=1;
		Random rnd=new Random();		
		while(minasIntroducidas <= numMinas){
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
		int col=0;
		boolean salir=false;
		int fil=0;
		while(fil<=filas-1&&salir==false){
			while(col<=columnas-1&&salir==false){
				if(matriz[fil][col].equals(pCasilla)){
					salir=true;
				}
				col++;
			}
			fil++;
			col=0;
		}
		return col;
	}
	
	public int getFilaXCasilla(Casilla pCasilla){
		int col=0;
		boolean salir=false;
		int fil=0;
		while(fil<=filas-1&&salir==false){
			while(col<=columnas-1&&salir==false){
				if(matriz[fil][col].equals(pCasilla)){
					salir=true;
				}
				col++;
			}
			fil++;
			col=0;
		}
		return fil;
	}
	
	public Casilla crearCasilla (String pTipo){
		Casilla miCasilla = FabricaCasilla.getFabricaCasilla().crearCasilla(pTipo);	
		return miCasilla;
	}

	public boolean descubrirCasilla(int pFila, int pColumna){
		Casilla pCasilla=obtenerCasilla(pFila,pColumna);
		boolean finaliza=false;
		// imprimo la casilla para ver que he pulsado
		System.out.println(pCasilla);
		if(!pCasilla.equals(null)){
			if(pCasilla instanceof SinMina){
				((SinMina)pCasilla).abrirCasilla();
				return finaliza;
			} else {
				return ((Mina)pCasilla).finalizarJuego();				
			}
		}
		else{
			return finaliza;
		}
	}
	
	public Casilla obtenerCasilla(int pFila, int pColumna){
		Casilla c=matriz[pFila][pColumna];
		return c;
		
	}
	
	public void obtenerVecinos(){
		int fil=0;
		int numVecinosMina;
		int col=0;
		Casilla c=null;
		while(fil<=filas-1){
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
			col=0;
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
	
	
}