package packInterfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import packModelo.Buscaminas;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VDialogo {

	private JFrame frmDialogo;
	private JLabel lblDialogo;
	private JButton btnSi;
	private JButton btnNo;


	/**
	 * Create the application.
	 */
	public VDialogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDialogo = new JFrame();
		frmDialogo.setIconImage(Toolkit.getDefaultToolkit().getImage(VDialogo.class.getResource("/assets/icono.png")));
		frmDialogo.setTitle("Quieres volver a jugar?");
		frmDialogo.getContentPane().setBackground(Color.WHITE);
		frmDialogo.setBounds(100, 100, 500, 400);
		frmDialogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frmDialogo.getSize();
		//Tamaño del frame actual (ancho x alto)
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height; 
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width; 
		}
		frmDialogo.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		frmDialogo.getContentPane().setLayout(new MigLayout("", "[50%][50%]", "[33%][33%][33%]"));
		frmDialogo.getContentPane().add(getLblEligeElNivel(), "cell 0 0 2 1,alignx center,aligny center");
		frmDialogo.getContentPane().add(getBtnSi(), "cell 0 2,grow");
		frmDialogo.getContentPane().add(getBtnNo(), "cell 1 2,grow");

		// Visualizar la ventana
		frmDialogo.setVisible(true);
	}

	private JLabel getLblEligeElNivel() {
		if (lblDialogo == null) {
			lblDialogo = new JLabel("Quieres volver a jugar?");
			lblDialogo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblDialogo;
	}

	private JButton getBtnSi() {
		if (btnSi == null) {
			btnSi = new JButton("Si");
			btnSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmDialogo.dispose();
				}
			});
			btnSi.setBackground(Color.WHITE);
		}
		return btnSi;
	}
	private JButton getBtnNo() {
		if (btnNo == null) {
			btnNo = new JButton("No");
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnNo.setBackground(Color.WHITE);
		}
		return btnNo;
	}
}
