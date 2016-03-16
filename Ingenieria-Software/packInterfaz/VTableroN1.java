package packInterfaz;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import packModelo.Buscaminas;
import packModelo.Casilla;
import packModelo.SinMina;
import packModelo.Tablero;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VTableroN1 {

	private JFrame frame;

	public VTableroN1() {	
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]", "[14.28%][14.28%][14.28%][14.28%][14.28%][14.28%][14.28%]"));
		frame.setVisible(true);

		
		
		for (int row = 0; row<7; row++) {
			for (int col = 0; col<10; col++) {
				JButton b = new JButton();
		    	frame.getContentPane().add(b, "cell "+ col +" "+ row +",grow");
		    	
		    	// Se necesita esto para pasarle el parámetro a descubrirCasilla.
		    	final int fila = new Integer(row);
		    	final int columna = new Integer(col);
		    	
		    	b.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						System.out.println("Click en el boton, fila = "+ fila +", columna = "+ columna);
						Tablero tablero = Buscaminas.getBuscaminas().getTablero();
						if (tablero.descubrirCasilla(fila, columna)){
							// devuelve true si no es game over.
							SinMina casilla = (SinMina) tablero.obtenerCasilla(fila, columna);
							if (casilla.getNumVecinosMina() != 0){
								frame.remove(b);
								System.out.println(casilla.getNumVecinosMina());
							}
						} else {
							// devuelve false entonces game over
							System.out.println("game over");
						}
					}
				});
			}
		}
	}
}
