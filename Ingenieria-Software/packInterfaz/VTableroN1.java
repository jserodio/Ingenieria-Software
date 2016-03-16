package packInterfaz;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import packModelo.Buscaminas;

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
		    	
		    	frame.getContentPane().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						if (Buscaminas.getBuscaminas().getTablero().descubrirCasilla(fila, columna)){
						
						}
					}
				});
			}
		}
	}
}
