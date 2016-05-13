package packModelo;

import packInterfaz.VElegirNivel;
import packInterfaz.VLogin;

public class Main {

	public static void main(String[] args) {
		Sesion.getSesion().iniciarCrono();
		new VLogin();
	}

}
