package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaCasillas {
	
	private ArrayList<Casilla> listaCasillas;
	
	public ListaCasillas(){
		listaCasillas=new ArrayList<Casilla>();
	}
	
	public ArrayList<Casilla> getListaCasillas(){
		return listaCasillas;
	}
	
	public void abrirCasillas(){
		Iterator<Casilla> it=listaCasillas.iterator();
		Casilla c;
		while(it.hasNext()){
			c=it.next();
			if(c instanceof SinMina && c.getAbierta()==false && c.getFlag()==false){
				((SinMina)c).abrirCasilla();
			}
		}
	}
	
	public int vecinosConMina(){
		Iterator<Casilla> it=listaCasillas.iterator();
		int num=0;
		Casilla c;
		while(it.hasNext()){
			c=it.next();
			if(c instanceof Mina){
				num++;
			}
		}
		return num;
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