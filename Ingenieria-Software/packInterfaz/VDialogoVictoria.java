package packInterfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class VDialogoVictoria {

	private JFrame frame;
	private JTextArea txtrenhorabuenaHasGanado;
	private JButton btnContinuar;

	/**
	 * Create the application.
	 */
	public VDialogoVictoria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTxtrenhorabuenaHasGanado());
		frame.getContentPane().add(getBtnContinuar());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		//Tamaño del frame actual (ancho x alto)
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height; 
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width; 
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTxtrenhorabuenaHasGanado());
		frame.getContentPane().add(getBtnContinuar());
		
		frame.setVisible(true);
	}
	private JTextArea getTxtrenhorabuenaHasGanado() {
		if (txtrenhorabuenaHasGanado == null) {
			txtrenhorabuenaHasGanado = new JTextArea();
			txtrenhorabuenaHasGanado.setBackground(Color.WHITE);
			txtrenhorabuenaHasGanado.setEditable(false);
			txtrenhorabuenaHasGanado.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtrenhorabuenaHasGanado.setText("\u00A1Enhorabuena! Has ganado. \r\n         Puntuaci\u00F3n: ");
			txtrenhorabuenaHasGanado.setBounds(76, 56, 278, 64);
		}
		return txtrenhorabuenaHasGanado;
	}
	private JButton getBtnContinuar() {
		if (btnContinuar == null) {
			btnContinuar = new JButton("Continuar");
			btnContinuar.setBounds(148, 141, 89, 23);
		}
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new VDialogo();
				frame.dispose();
			}
		});
		return btnContinuar;
	}
}
