package packModelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import packInterfaz.VTableroCasillas;

public class Buscaminas {

	private static Buscaminas miBuscaminas=null;
	private TableroBuilder tableroBuilder;
	private String usuario;

	public void setTableroBuilder(TableroBuilder tb){
		tableroBuilder = tb;
	}
	private Buscaminas(){
	
	}
	public static Buscaminas getBuscaminas(){
		if(miBuscaminas==null){
			miBuscaminas=new Buscaminas();
		}
		return miBuscaminas;
	}
	public Tablero getTablero(){
		return tableroBuilder.getTablero();
	}
	
	public String getUsuario(){
		return this.usuario;
	}
	
	public void setUsuario(String pUsuario){
		this.usuario = pUsuario;
	}

	public void iniciar(int pNivel){
		//this.setUsuario(pUsuario);
		if(pNivel==1){
			TableroBuilder builderN1 = new BuilderN1();
			builderN1.construirTablero(pNivel);
			this.setTableroBuilder(builderN1);
		}
		else if(pNivel==2){
			TableroBuilder builderN2 = new BuilderN2();
			builderN2.construirTablero(pNivel);
			this.setTableroBuilder(builderN2);
		}
		else{
			TableroBuilder builderN3 = new BuilderN3();
			builderN3.construirTablero(pNivel);
			this.setTableroBuilder(builderN3);
		}
	}
	public boolean descubrirCasilla(int pFila, int pColumna){
		return this.getTablero().descubrirCasilla(pFila, pColumna);
	}
	
	public Casilla obtenerCasilla(int pFila, int pColumna){
		return this.getTablero().obtenerCasilla(pFila, pColumna);
	}
	
	public void setCasillaActual(Casilla casilla) {
		this.getTablero().setCasillaActual(casilla);
	}
	
	public Casilla getCasillaActual() {
		return this.getTablero().getCasillaActual();
	}
	
	public int getFilaXCasilla(Casilla pCasilla){
		return this.getTablero().getFilaXCasilla(pCasilla);
	}
	
	public int getColumnaXCasilla(Casilla pCasilla){
		return this.getTablero().getColumnaXCasilla(pCasilla);
	}
	
	public int getNumMinas(){
		return Buscaminas.getBuscaminas().getTablero().getNumMaxFlags();
	}
	
	public void marcarYdesmarcarCasilla(int pFila, int pColumna){
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(pFila, pColumna);
	}
	
	public void getUser(String pUser, String pPassword){
		  Conexion.conectar();
		  ResultSet rs = null;
		  String cadena = "SELECT user, password FROM usuario WHERE user=" +pUser+" AND password="+ pPassword+"";
		  Statement st = Conexion.conexion();
		  rs = Conexion.consultaDatos(st, cadena);
		  if(rs.equals(null)){
			  String cadena1 = "INSERT INTO usuario VALUES(user=" +pUser+" AND password="+ pPassword+")";
			  Statement st1 = Conexion.conexion();
			  Conexion.consultaActualiza(st1, cadena1);
		  }
		  else{
			  try {
				while(rs.next()){
					  this.setUsuario(rs.getString("user"));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	}
	
	public void anadirObservador(VTableroCasillas pTablero){
		this.getTablero().anadirObservador(pTablero);
	}
	
}