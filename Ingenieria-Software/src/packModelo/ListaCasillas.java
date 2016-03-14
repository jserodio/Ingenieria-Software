package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaCasillas {
	
	private ArrayList<Casilla> listaCasillas;
	
	public ListaCasillas(){
		listaCasillas=new ArrayList<Casilla>();
	}
	
	public void abrirCasillas(){
		Iterator<Casilla> it=listaCasillas.iterator();
		Casilla c;
		while(it.hasNext()){
			c=it.next();
			if(c instanceof SinMina && c.getAbierta()==false && c.getFlag()==false){
				((SinMina)c).setAbierta();
			}
		}
	}
	
	public int vecinosConMina(){
		Iterator<Casilla> it=listaCasillas.iterator();
		int num=0;
		while(it.hasNext()){
			if(it instanceof Mina){
				num++;
			}
			it.next();
		}
		return num;
	}
	
	public void eliminarCasillasAbiertas(){
		Iterator<Casilla> it=listaCasillas.iterator();
		Casilla c=null;
		while(it.hasNext()){
			c=it.next();
			if(c.getAbierta()){
				this.eliminarCasilla(c);
			}
		}
	}
	
	public void borrar(){
		listaCasillas.clear();
	}
	public void anadir(Casilla pCasilla){
		listaCasillas.add(pCasilla);
	}
	public void eliminarCasilla(Casilla pCasilla){
		listaCasillas.remove(pCasilla);
	}
	
}
