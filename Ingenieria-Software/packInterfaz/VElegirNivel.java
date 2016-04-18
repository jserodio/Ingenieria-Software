package packInterfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import packModelo.Buscaminas;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VElegirNivel {

	private JFrame frame;
	private JLabel lblEligeElNivel;
	private JRadioButton rdbtnFacil;
	private JRadioButton rdbtnMedio;
	private JRadioButton rdbtnDificil;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnJugar;

	/**
	 * Create the application.
	 */
	public VElegirNivel() {	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[33%][33%][33%]", "[33%][33%][33%]"));
		frame.getContentPane().add(getLblEligeElNivel(), "cell 0 0 3 1,alignx center,aligny center");
		frame.getContentPane().add(getRdbtnFacil(), "cell 0 1,alignx center,aligny center");
		frame.getContentPane().add(getRdbtnMedio(), "cell 1 1,alignx center,aligny center");
		frame.getContentPane().add(getRdbtnDificil(), "cell 2 1,alignx center,aligny center");
		frame.getContentPane().add(getBtnJugar(), "cell 0 2 3 1,grow");
		// Visualizar la ventana
		frame.setVisible(true);
	}

	private JLabel getLblEligeElNivel() {
		if (lblEligeElNivel == null) {
			lblEligeElNivel = new JLabel("Elige el nivel");
			lblEligeElNivel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		}
		return lblEligeElNivel;
	}
	private JRadioButton getRdbtnFacil() {
		if (rdbtnFacil == null) {
			rdbtnFacil = new JRadioButton("Facil");
			rdbtnFacil.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnFacil);
			rdbtnFacil.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return rdbtnFacil;
	}
	private JRadioButton getRdbtnMedio() {
		if (rdbtnMedio == null) {
			rdbtnMedio = new JRadioButton("Medio");
			rdbtnMedio.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnMedio);
			rdbtnMedio.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return rdbtnMedio;
	}
	private JRadioButton getRdbtnDificil() {
		if (rdbtnDificil == null) {
			rdbtnDificil = new JRadioButton("Dificil");
			rdbtnDificil.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnDificil);
			rdbtnDificil.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return rdbtnDificil;
	}
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("Jugar");
			btnJugar.addMouseListener(new MouseAdapter() {
				
				public void mouseReleased(MouseEvent arg0) {
					// Comprobar el nivel elegido
					
					if (rdbtnFacil.isSelected()){
						Buscaminas.getBuscaminas().iniciar(1);
						new VTableroN1();
					} else if (rdbtnMedio.isSelected()){
						//Buscaminas.getBuscaminas().iniciar(2);
						//new VTableroN2();
					} else if (rdbtnDificil.isSelected()){
						//Buscaminas.getBuscaminas().iniciar(3);
						//new VTableroN3();						
					} else {
						
					}
						
					
				}
			});
			btnJugar.setBackground(new Color(240, 248, 255));
			btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return btnJugar;
	}
}