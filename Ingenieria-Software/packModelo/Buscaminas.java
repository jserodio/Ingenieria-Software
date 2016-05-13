package packModelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import packInterfaz.VTableroCasillas;

public class Buscaminas {

	private static Buscaminas miBuscaminas=null;
	private TableroBuilder tableroBuilder;

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
		return Buscaminas.getBuscaminas().getTablero().getNumMaxMinas();
	}
	
	public void marcarYdesmarcarCasilla(int pFila, int pColumna){
		Buscaminas.getBuscaminas().getTablero().marcarYdesmarcarCasilla(pFila, pColumna);
	}
	
	public ArrayList<Partida> getRanking(){
		  ArrayList<Partida> rank=new ArrayList<Partida>();
		  Conexion.conectar();
		  ResultSet rs = null;
		  String cadena = "SELECT * FROM ranking ORDER BY points DESC";
		  Statement st = Conexion.conexion();
		  rs = Conexion.consultaDatos(st, cadena);
		  if(rs.equals(null)){
			  return null;
		  }
		  else{
			  String nombre;
			  int puntos;
			  try {
				while(rs.next()){
					  nombre=rs.getString("user");
					  puntos=rs.getInt("points");
					  rank.add(new Partida(nombre,puntos));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return rank;  
		  }
	}
	
	public void insertarPartida(String pUser, int pPoints){
		  String cadena = "INSERT INTO ranking VALUES(user=" +pUser+" AND points="+ pPoints+")";
		  Statement st = Conexion.conexion();
		  Conexion.consultaActualiza(st, cadena);
		  Conexion.cerrar(st);
	}
	
	public void anadirObservador(VTableroCasillas pTablero){
		this.getTablero().anadirObservador(pTablero);
	}
	
}