package org.buscaminas;

import java.util.ArrayList;
import java.util.Iterator;

public class Tablero {
	private int columnas;
	private int filas;
	private Casilla[][] matriz;
	public Tablero(){
		
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
				this.obtenerVecinosCasillaX(pCasilla);
				((Vacia)pCasilla).setAbierta();
				return finaliza;
			}
			else if(pCasilla instanceof Mina){
				return ((Mina)pCasilla).finalizarJuego();
				
			}
			else if(pCasilla instanceof Numero){
				this.obtenerVecinosCasillaX(pCasilla);
				pCasilla.setAbierta();
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
		ArrayList<Casilla> vecinos=null;
		vecinos.clear();
		int col=getColumna(pCasilla);
		int fil=getFila(pCasilla);
		if(fil-1<0&&col-1<0){
			Casilla c1=matriz[fil][col+1];
			Casilla c2=matriz[fil+1][col+1];
			Casilla c3=matriz[fil+1][col+1];
			vecinos.add(c1);
			vecinos.add(c2);
			vecinos.add(c3);
		}
		else if(fil-1<0&&(col-1>=0&&col+1<=columnas)){			
			Casilla c1=matriz[fil][col-1];
			Casilla c2=matriz[fil][col+1];
			Casilla c3=matriz[fil+1][col-1];
			Casilla c4=matriz[fil+1][col];
			Casilla c5=matriz[fil+1][col+1];
			vecinos.add(c1);
			vecinos.add(c2);
			vecinos.add(c3);
			vecinos.add(c4);
			vecinos.add(c5);
		}
		else if(fil-1<0&&col+1>columnas){
			Casilla c1=matriz[fil][col-1];
			Casilla c2=matriz[fil+1][col-1];
			Casilla c3=matriz[fil+1][col];
			vecinos.add(c1);
			vecinos.add(c2);
			vecinos.add(c3);
		}
		else if((fil-1>=0&&fil+1<=filas)&&col-1<0){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col+1];
			Casilla c3=matriz[fil][col+1];
			Casilla c4=matriz[fil+1][col];
			Casilla c5=matriz[fil+1][col+1];
			vecinos.add(c1);
			vecinos.add(c2);
			vecinos.add(c3);
			vecinos.add(c4);
			vecinos.add(c5);
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
			vecinos.add(c1);
			vecinos.add(c2);
			vecinos.add(c3);
			vecinos.add(c4);
			vecinos.add(c5);
			vecinos.add(c6);
			vecinos.add(c7);
			vecinos.add(c8);
		}
		else if((fil-1>=0&&fil+1<=filas)&&col+1>columnas){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col-1];
			Casilla c3=matriz[fil][col-1];
			Casilla c4=matriz[fil+1][col-1];
			Casilla c5=matriz[fil+1][col];
			vecinos.add(c1);
			vecinos.add(c2);
			vecinos.add(c3);
			vecinos.add(c4);
			vecinos.add(c5);
		}
		else if(fil+1>filas&&col-1<0){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col+1];
			Casilla c3=matriz[fil][col+1];
			vecinos.add(c1);
			vecinos.add(c2);
			vecinos.add(c3);
		}
		else if(fil+1>filas&&(col-1>=0&&col+1<=columnas)){
			Casilla c1=matriz[fil][col-1];
			Casilla c2=matriz[fil-1][col-1];
			Casilla c3=matriz[fil-1][col];
			Casilla c4=matriz[fil-1][col+1];
			Casilla c5=matriz[fil][col+1];
			vecinos.add(c1);
			vecinos.add(c2);
			vecinos.add(c3);
			vecinos.add(c4);
			vecinos.add(c5);
		}
		else if(fil+1>filas&&col+1>columnas){
			Casilla c1=matriz[fil-1][col];
			Casilla c2=matriz[fil-1][col-1];
			Casilla c3=matriz[fil][col-1];
			vecinos.add(c1);
			vecinos.add(c2);
			vecinos.add(c3);
		}
		Iterator<Casilla> it=vecinos.iterator();
		Casilla c=null;
		while(it.hasNext()){
			c=it.next();
			if(c.getAbierta()){
				vecinos.remove(c);
			}
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
