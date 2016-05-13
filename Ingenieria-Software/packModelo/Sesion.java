package packModelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Sesion extends Observable{

	private static Sesion miSesion;
	private String usuario;
	private String pass;
	private int tiempoTrans = 0;
	private Timer timer;
	
	private Sesion(){
		
	}
	
	public static Sesion getSesion(){
		if (miSesion == null) {
			miSesion = new Sesion();
		}
		return miSesion;
	}
	
	public String getUsuario(){
		return this.usuario;
	}
	
	public void setUsuario(String pUsuario){
		this.usuario = pUsuario;
	}
	
	public String getPass(){
		return this.pass;
	}
	
	public void setPass(String pPassword){
		this.pass = pPassword;
	}
	
	public void iniciar() throws SQLException{
		  Conexion.conectar();
		  ResultSet rs = null;
		  String cadena = "SELECT user, password FROM usuario WHERE user='" +this.usuario+"' AND password='"+this.pass+"';";
		  System.out.println(cadena);
		  Statement st = Conexion.conexion();
		  rs = Conexion.consultaDatos(st, cadena);
		  if(!rs.next()){
			  String cadena1 = "INSERT INTO usuario VALUES('" + this.usuario + "', '" + this.pass + "');";
			  System.out.println(cadena1);
			  Statement st1 = Conexion.conexion();
			  Conexion.consultaActualiza(st1, cadena1);
			  Conexion.cerrar(st1);
		  }
		  else{
			  try {
				while(rs.next()){
					  this.setUsuario(rs.getString("user"));
				  }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
		  Conexion.cerrar(st);
	}
	
	public void iniciarCrono() {
		this.crono();
	}
	
	public void reiniciarCrono() {
		this.tiempoTrans = 0;
	}
	
	private void crono(){
		
        TimerTask  timerTask = new TimerTask() {
            @Override
            public void run() {
                String texto;
                
				tiempoTrans++;
                int segundos =(int)tiempoTrans;
                int minutos =0;
                while(segundos>59){
                    minutos++;
                    segundos = segundos-60;
                }
                if(segundos<10){
                    texto=(""+minutos+":0" + segundos);
                }else{
                texto=(""+minutos+":" + segundos);
                }
                setChanged();
                notifyObservers(texto); // falta pasar el nAyudas
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
}