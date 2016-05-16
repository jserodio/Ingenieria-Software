package packInterfaz;

import javax.swing.JInternalFrame;
import packModelo.Buscaminas;
import packModelo.Casilla;
import packModelo.SinMina;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.SwingUtilities;
import java.awt.Color;

public class VTableroCasillas implements Observer {

	private JInternalFrame frame;
	private int nivel;
	private JFrame frmBuscaminas;
	private static int ROWMAX;
	private static int COLMAX;
	
	public VTableroCasillas(JInternalFrame internalFrame, int pNivel, JFrame frmBuscaminas) {	
		this.frame = internalFrame;
		this.nivel = pNivel;
		this.frmBuscaminas = frmBuscaminas;
		initialize();
		Buscaminas.getBuscaminas().anadirObservador(this);
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
				b.setName(""+row+col);
				b.setBackground(Color.white);
				
		    	frame.getContentPane().add(b, "cell "+ col +" "+ row +",grow");
		    	
		    	// Se necesita esto para pasarle el parámetro a descubrirCasilla.
		    	final int fila = new Integer(row);
		    	final int columna = new Integer(col);
		    	
		    	b.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						if(SwingUtilities.isRightMouseButton(arg0)){ //Si pulsas boton derecho
							String rango=Buscaminas.getBuscaminas().marcarYdesmarcarCasilla(fila, columna);
							if(rango.equals("Se puede")){
								if(b.getBackground().equals(Color.RED)){
									b.setBackground(Color.white);
								 }else{
									 b.setBackground(Color.RED);
								 }		
							}else if(rango.equals("Ganado")){
								b.setBackground(Color.RED);
								frame.removeAll();
								frame.hide();
								frame.dispose();
								new VDialogoVictoria();
								frmBuscaminas.dispose();
							}
							// comprobar si gana con click derecho
							int estado = Buscaminas.getBuscaminas().descubrirCasilla(fila, columna);
							if(estado==2){
								new VDialogoVictoria();
								frmBuscaminas.dispose();
							}
						}else{
							System.out.println("");
							System.out.println("Click en el boton, fila = "+ fila +", columna = "+ columna);
							if(!b.getBackground().equals(Color.RED)){
								int estado = Buscaminas.getBuscaminas().descubrirCasilla(fila, columna);
								if (estado==0){
									System.out.println(estado);
									new VDialogoDerrota();
									frmBuscaminas.dispose();
								}
								else if(estado==2){
									new VDialogoVictoria();
									frmBuscaminas.dispose();
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
		Casilla casillaActual = Buscaminas.getBuscaminas().getCasillaActual();

		int fila = Buscaminas.getBuscaminas().getFilaXCasilla(casillaActual);
		int columna = Buscaminas.getBuscaminas().getColumnaXCasilla(casillaActual);
		String posicion = ""+fila+columna;
			
		Component[] components = frame.getContentPane().getComponents();
		for (Component component : components)
		{
		    if (component instanceof JButton)
		    {
		        if (component.getName().equals(posicion)){
		        	
					if (((SinMina) casillaActual).getNumVecinosMina() != 0){
						((JButton) component).setIcon(new ImageIcon(VBuscaminas.class.getResource("/assets/"+((SinMina) casillaActual).getNumVecinosMina()+".png")));
					} else {
						component.setVisible(false); // poner en blanco el boton de la casilla
					}
		        }
		    }

		}
	}
	
}