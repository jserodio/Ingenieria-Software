package org.buscaminas;



public class Buscaminas {
	private Buscaminas miBuscaminas;
	private TableroBuilder tableroBuilder;
	public void setTableroBuilder(TableroBuilder tb){
		tableroBuilder = tb;
	}
	public Tablero getTablero(){
		construirTablero();
		return tableroBuilder.getTablero();
	}
	public void construirTablero(){
		tableroBuilder.construirTablero();
	}
	
	public Buscaminas getBuscaminas(){
        return miBuscaminas;
    }	
	
	public static void main(String[] args){
		Buscaminas buscaminas = new Buscaminas();
		TableroBuilder builderN1 = new BuilderN1();
		TableroBuilder builderN2 = new BuilderN2();
		TableroBuilder builderN3 = new BuilderN3();
		
		buscaminas.setTableroBuilder(builderN1);
		buscaminas.setTableroBuilder(builderN2);
		buscaminas.setTableroBuilder(builderN3);
	}
	
	
}
