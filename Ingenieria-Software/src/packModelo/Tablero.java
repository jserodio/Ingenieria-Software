package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

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
		
		int filRandom;
		int colRandom;
		int numMinas = columnas*nivel;
		int minasIntroducidas=0;
		while(minasIntroducidas <= numMinas){
				filRandom = (int) Math.random()*(filas);
				colRandom = (int) Math.random()*(columnas);	
				while (matriz[fil][col] instanceof Mina){
					filRandom = (int) Math.random()*(filas);
					colRandom = (int) Math.random()*(columnas);	
				}
				matriz[filRandom][colRandom]= this.crearCasilla("mina");
								
				
				minasIntroducidas++;
		}
		fil=0;
		col=0;
		while(fil<=filas){
			while(col<=columnas){
				this.obtenerVecinosCasillaX(matriz[fil][col]);
			}
		}

	}
	
	public Casilla crearCasilla (String pTipo){
		Casilla miCasilla = FabricaCasilla.getFabricaCasilla().crearCasilla(pTipo);	
		return miCasilla;
	}

	public boolean descubrirCasilla(int pFila, int pColumna){
		Casilla pCasilla=obtenerCasilla(pFila,pColumna);
		boolean finaliza=false;
		if(!pCasilla.equals(null)){
			if(pCasilla instanceof Vacia){
				((Vacia)pCasilla).setAbierta();
				return finaliza;
			}
			else if(pCasilla instanceof Mina){
				return ((Mina)pCasilla).finalizarJuego();
				
			}
			else if(pCasilla instanceof Numero){
				((Numero)pCasilla).setAbierta();
				return finaliza;
			}
			else{
				return finaliza;
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
		int col=0;
		Casilla c=null;
		while(fil<=filas){
			while(col<=columnas){
				c=matriz[fil][col];
				this.obtenerVecinosCasillaX(c);
				col++;
			}
			fil++;
			col=0;
		}
	}
	public void obtenerVecinosCasillaX(Casilla pCasilla){
		ListaCasillas vecinos=null;
		vecinos.borrar();
		int col=getColumna(pCasilla);
		int fil=getFila(pCasilla);
		if(fil-1<0&&col-1<0){
			Casilla c1=matriz[fil][col+1];
			Casilla c2=matriz[fil+1][col+1];
			Casilla c3=matriz[fil+1][col+1];
			vecinos.añadir(c1);
			vecinos.añadir(c2);
			vecinos.añadir(c3);
		}
		else if(fil-1<0&&(col-1>=0&&col+1<=columnas)){			
			Casilla c1=matriz[fil][col-1];
			Casilla c2=matriz[fil][col+1];
			Casilla c3=matriz[fil+1][col-1];
			Casilla c4=matriz[fil+1][col];
			Casilla c5=matriz[fil+1][col+1];
			vecinos.añadir(c1);
			vecinos.añadir(c2);
			vecinos.añadir(c3);
			vecinos.añadir(c4);
			vecinos.añadir(c5);
		}
		else if(fil-1<0&&col+1>columnas){
			Casilla c1=matriz[fil][col-1];
			Casilla c2=matriz[fil+1][col-1];
			Casilla c3=matriz[fil+1][col];
			vecinos.añadir(c1);
			vecinos.añadir(c2);
			vecinos.añadir(c3);
		}
		else if((fil-1>=0&&fil+1<=filas)&&col-1<0){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col+1];
			Casilla c3=matriz[fil][col+1];
			Casilla c4=matriz[fil+1][col];
			Casilla c5=matriz[fil+1][col+1];
			vecinos.añadir(c1);
			vecinos.añadir(c2);
			vecinos.añadir(c3);
			vecinos.añadir(c4);
			vecinos.añadir(c5);
		}
		else if((fil-1>=0&&fil+1<=filas)&&(col-1>=0&&col+1<=columnas)){
			Casilla c1=matriz[fil-1][col-1];
			Casilla c2=matriz[fil-1][col];
			Casilla c3=matriz[fil-1][col+1];
			Casilla c4=matriz[fil][col-1];
			Casilla c5=matriz[fil][col+1];
			Casilla c6=matriz[fil+1][col-1];
			Casilla c7=matriz[fil+1][col];
			Casilla c8=matriz[fil+1][col+1];
			vecinos.añadir(c1);
			vecinos.añadir(c2);
			vecinos.añadir(c3);
			vecinos.añadir(c4);
			vecinos.añadir(c5);
			vecinos.añadir(c6);
			vecinos.añadir(c7);
			vecinos.añadir(c8);
		}
		else if((fil-1>=0&&fil+1<=filas)&&col+1>columnas){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col-1];
			Casilla c3=matriz[fil][col-1];
			Casilla c4=matriz[fil+1][col-1];
			Casilla c5=matriz[fil+1][col];
			vecinos.añadir(c1);
			vecinos.añadir(c2);
			vecinos.añadir(c3);
			vecinos.añadir(c4);
			vecinos.añadir(c5);
		}
		else if(fil+1>filas&&col-1<0){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col+1];
			Casilla c3=matriz[fil][col+1];
			vecinos.añadir(c1);
			vecinos.añadir(c2);
			vecinos.añadir(c3);
		}
		else if(fil+1>filas&&(col-1>=0&&col+1<=columnas)){
			Casilla c1=matriz[fil][col-1];
			Casilla c2=matriz[fil-1][col-1];
			Casilla c3=matriz[fil-1][col];
			Casilla c4=matriz[fil-1][col+1];
			Casilla c5=matriz[fil][col+1];
			vecinos.añadir(c1);
			vecinos.añadir(c2);
			vecinos.añadir(c3);
			vecinos.añadir(c4);
			vecinos.añadir(c5);
		}
		else if(fil+1>filas&&col+1>columnas){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col-1];
			Casilla c3=matriz[fil][col-1];
			vecinos.añadir(c1);
			vecinos.añadir(c2);
			vecinos.añadir(c3);
		}
		pCasilla.setVecinos(vecinos);
	}
	public int getColumna(Casilla pCasilla){
		int col=0;
		boolean salir=false;
		int fil=0;
		while(fil<=filas&&salir==false){
			while(col<=columnas&&salir==false){
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
	public int getFila(Casilla pCasilla){
		int col=0;
		boolean salir=false;
		int fil=0;
		while(fil<=filas&&salir==false){
			while(col<=columnas&&salir==false){
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
}
