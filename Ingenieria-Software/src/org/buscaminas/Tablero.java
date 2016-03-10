package org.buscaminas;

import java.util.ArrayList;
import java.util.Iterator;

public class Tablero {
	private int columnas;
	private int filas;
	private Casilla[][] matriz;
	public Tablero(int pFilas, int pColumnas){
		filas=pFilas;
		columnas=pColumnas;
		String pTipo;
		int fil=0;
		int col=0;
		while(fil<=filas){
			while(col<=columnas){
				int numeroAleatorio = (int) (Math.random()*3+1);
				if(numeroAleatorio==1){
					pTipo="vacia";
					matriz[fil][col]=this.crearCasilla(pTipo);
				}
				else if(numeroAleatorio==2){
					pTipo="numero";
					matriz[fil][col]=this.crearCasilla(pTipo);
				}
				else if(numeroAleatorio==3){
					pTipo="mina";
					matriz[fil][col]=this.crearCasilla(pTipo);
				}
				col++;
			}
			fil++;
			col=0;
		}
		fil=0;
		col=0;
		while(fil<=filas){
			while(col<=columnas){
				this.obtenerVecinosCasillaX(matriz[fil][col]);
				col++;
			}
			fil++;
			col=0;
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
