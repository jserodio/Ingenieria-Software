package packInterfaz;

import javax.swing.JInternalFrame;
import packModelo.Buscaminas;
import packModelo.ListaCasillas;
import packModelo.SinMina;
import packModelo.Tablero;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class VTableroCasillas {

	private JInternalFrame frame;
	private int nivel;
	private static int ROWMAX;
	private static int COLMAX;

	public VTableroCasillas(JInternalFrame internalFrame, int pNivel) {	
		this.frame = internalFrame;
		this.nivel = pNivel;
		initialize();
	}
	
	public JInternalFrame getFrame() {
		return frame;
	}

	private void initialize() {
		
		switch(nivel) {
		case 1:
			ROWMAX = 7;
			COLMAX = 10;
			break;
		case 2:
			ROWMAX = 10;
			COLMAX = 15;
			break;
		case 3:
			ROWMAX = 12;
			COLMAX = 25;
			break;
		}
		
		
		for (int row = 0; row<ROWMAX; row++) {
			for (int col = 0; col<COLMAX; col++) {
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
						if (!tablero.descubrirCasilla(fila, columna)){
							
							b.setVisible(false); // poner en blanco el boton de la casilla
							SinMina casilla = (SinMina) tablero.obtenerCasilla(fila, columna);
							casilla.setAbierta();
							// RECORRER LOS VECIONS DE ALGUNA FORMA PARA ABRIR CASILLAS
							// DE FORMA AUTOMATICA
							
							if (casilla.getNumVecinosMina() != 0){
								JLabel lbl = new JLabel(""+casilla.getNumVecinosMina());
								frame.add(lbl, "cell "+ columna +" "+ fila +", alignx center,aligny center");
								System.out.println(casilla.getNumVecinosMina());
							}
						} else {
							// devuelve false entonces game over
							System.out.println("game over");
							//frame.setEnabled(false);
							frame.removeAll();
						}
					}
				});
			}
		}
	}
	
}
