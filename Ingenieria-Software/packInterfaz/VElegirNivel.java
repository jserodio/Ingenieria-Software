package packInterfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import packModelo.Buscaminas;
import packModelo.Sesion;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Window.Type;

public class VElegirNivel {

	private JFrame frmBuscaminasElige;
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
		frmBuscaminasElige = new JFrame();
		frmBuscaminasElige.setIconImage(Toolkit.getDefaultToolkit().getImage(VElegirNivel.class.getResource("/assets/icono.png")));
		frmBuscaminasElige.setTitle("Elegir el nivel");
		frmBuscaminasElige.getContentPane().setBackground(Color.WHITE);
		frmBuscaminasElige.setBounds(100, 100, 500, 400);
		frmBuscaminasElige.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frmBuscaminasElige.getSize();
		//Tamaño del frame actual (ancho x alto)
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height; 
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width; 
		}
		frmBuscaminasElige.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		frmBuscaminasElige.getContentPane().setLayout(new MigLayout("", "[33%][33%][33%]", "[33%][33%][33%]"));
		frmBuscaminasElige.getContentPane().add(getLblEligeElNivel(), "cell 0 0 3 1,alignx center,aligny center");
		frmBuscaminasElige.getContentPane().add(getRdbtnFacil(), "cell 0 1,alignx center,aligny center");
		frmBuscaminasElige.getContentPane().add(getRdbtnMedio(), "cell 1 1,alignx center,aligny center");
		frmBuscaminasElige.getContentPane().add(getRdbtnDificil(), "cell 2 1,alignx center,aligny center");
		frmBuscaminasElige.getContentPane().add(getBtnJugar(), "cell 0 2 3 1,grow");
		// Visualizar la ventana
		frmBuscaminasElige.setVisible(true);
		frmBuscaminasElige.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				new VLogin();
			}
		});
	}

	private JLabel getLblEligeElNivel() {
		if (lblEligeElNivel == null) {
			lblEligeElNivel = new JLabel("Elegir nivel");
			lblEligeElNivel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblEligeElNivel;
	}
	private JRadioButton getRdbtnFacil() {
		if (rdbtnFacil == null) {
			rdbtnFacil = new JRadioButton("Facil");
			rdbtnFacil.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnFacil);
			rdbtnFacil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return rdbtnFacil;
	}
	private JRadioButton getRdbtnMedio() {
		if (rdbtnMedio == null) {
			rdbtnMedio = new JRadioButton("Medio");
			rdbtnMedio.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnMedio);
			rdbtnMedio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return rdbtnMedio;
	}
	private JRadioButton getRdbtnDificil() {
		if (rdbtnDificil == null) {
			rdbtnDificil = new JRadioButton("Dificil");
			rdbtnDificil.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnDificil);
			rdbtnDificil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return rdbtnDificil;
	}
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("Jugar");
			btnJugar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// Comprobar el nivel elegido
					
					Sesion.getSesion().reiniciarCrono();
					
					if (rdbtnFacil.isSelected()){
						Buscaminas.getBuscaminas().iniciar(1);
						new VBuscaminas(1);
					} else if (rdbtnMedio.isSelected()){
						Buscaminas.getBuscaminas().iniciar(2);
						new VBuscaminas(2);
					} else if (rdbtnDificil.isSelected()){
						Buscaminas.getBuscaminas().iniciar(3);
						new VBuscaminas(3);						
					} else {
						
					}
					
					
				}
			});
			btnJugar.setBackground(Color.WHITE);
			btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return btnJugar;
	}
}
