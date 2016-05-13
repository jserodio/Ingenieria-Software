package packModelo;

public class Partida {
	private String nombre;
	private int puntuacion;
	
	public Partida(String pNombre, int pPuntuacion){
		nombre=pNombre;
		puntuacion=pPuntuacion;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	
}
