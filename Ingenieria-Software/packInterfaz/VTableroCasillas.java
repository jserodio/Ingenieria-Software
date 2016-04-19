package packInterfaz;

import javax.swing.JInternalFrame;
import packModelo.Buscaminas;
import packModelo.Casilla;
import packModelo.ListaCasillas;
import packModelo.SinMina;
import packModelo.Tablero;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Color;

public class VTableroCasillas implements Observer {

	private JInternalFrame frame;
	private int nivel;
	private static int ROWMAX;
	private static int COLMAX;
	private int flags;

	public VTableroCasillas(JInternalFrame internalFrame, int pNivel) {	
		this.frame = internalFrame;
		this.nivel = pNivel;
		initialize();
		// add observer bucle de casillas, llamada desde buscaminas
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
		this.flags=this.nivel*COLMAX;
		
		for (int row = 0; row<ROWMAX; row++) {
			for (int col = 0; col<COLMAX; col++) {
				
				JButton b = new JButton();
				b.setName(""+col+row);
				b.setBackground(Color.BLUE);
				
		    	frame.getContentPane().add(b, "cell "+ col +" "+ row +",grow");
		    	
		    	// Se necesita esto para pasarle el parámetro a descubrirCasilla.
		    	final int fila = new Integer(row);
		    	final int columna = new Integer(col);
		    	
		    	b.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						if(SwingUtilities.isRightMouseButton(arg0)){ //Si pulsas boton derecho
							 Buscaminas.getBuscaminas().marcarYdesmarcarCasilla(fila, columna);
								 if(b.getBackground().equals(Color.RED)){
									 b.setBackground(Color.BLUE);
									 VTableroCasillas.this.flags=VTableroCasillas.this.flags+1;
								 
								 }else{
									 b.setBackground(Color.RED);
									 VTableroCasillas.this.flags=VTableroCasillas.this.flags-1;
								 }
						}
						else{
							System.out.println("Click en el boton, fila = "+ fila +", columna = "+ columna);
							Tablero tablero = Buscaminas.getBuscaminas().getTablero();
							if(!b.getBackground().equals(Color.RED)){
								if (!Buscaminas.getBuscaminas().descubrirCasilla(fila, columna)){
										b.setVisible(false); // poner en blanco el boton de la casilla
										SinMina casilla = (SinMina) Buscaminas.getBuscaminas().obtenerCasilla(fila, columna);;
									
										casilla.abrirCasilla();
										tablero.setCasillaActual(casilla);
								
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
						}
						
					}
				});
		    	
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Tablero tablero = Buscaminas.getBuscaminas().getTablero();
		
		SinMina casillaActual = tablero.getCasillaActual();
		
		ListaCasillas listaVecinosSinMina = new ListaCasillas();
		
		listaVecinosSinMina = casillaActual.getVecinosSinMina();
		
		Iterator<Casilla> it = listaVecinosSinMina.getListaCasillas().iterator();
		Casilla c;
		while(it.hasNext()){
			c=it.next();
			String posicion = ""+tablero.getFilaXCasilla(c)+tablero.getColumnaXCasilla(c);
			Component[] components = frame.getContentPane().getComponents();
			for (Component component : components)
			{
			    if (component instanceof JButton)
			    {
			        if (component.getName().equals(posicion)){
			        	component.setVisible(false);
			        }
			    }
			}
		}
	}
	
}
