package packModelo;



public class Buscaminas {
	private Buscaminas miBuscaminas;
	private TableroBuilder tableroBuilder;
	
	private Buscaminas() {	}
	
	public Buscaminas getBuscaminas(){
        if (miBuscaminas == null){
        	miBuscaminas = new Buscaminas();
        }
		return miBuscaminas;
    }	
	
	private void construirTablero(){
		tableroBuilder.construirTablero();
	}
	
	public void setTableroBuilder(TableroBuilder pTB){
		tableroBuilder = pTB;
	}
	
	
	public Tablero getTablero(){
		construirTablero();
		return tableroBuilder.getTablero();
	}
	
	
	public static void main(String[] args){
		Buscaminas buscaminas = new Buscaminas();
		TableroBuilder builderN1 = new BuilderN1();
//		TableroBuilder builderN2 = new BuilderN2();
//		TableroBuilder builderN3 = new BuilderN3();
		
		buscaminas.setTableroBuilder(builderN1);
//		buscaminas.setTableroBuilder(builderN2);
//		buscaminas.setTableroBuilder(builderN3);
	}
	
	
}
