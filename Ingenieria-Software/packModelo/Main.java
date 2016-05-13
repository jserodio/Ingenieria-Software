package packModelo;

import packInterfaz.VElegirNivel;
import packInterfaz.VLogin;

public class Main {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		conexion.conectar();
		new VLogin();
	}

}
