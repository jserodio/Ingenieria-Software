package org.asalbidegoitia.ejerTablero;

public abstract class TableroBuilder {
	protected Tablero tablero;
	public Tablero getTablero(){
		return tablero;
	}
	public void construirTablero(){
		tablero = new Tablero();
	}
}

public class BuilderN1 extends TableroBuilder{
	
}
public class BuilderN2 extends TableroBuilder{
	
}
public class BuilderN3 extends TableroBuilder{
	
}