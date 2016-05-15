package packInterfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class VDialogoDerrota {

	private JFrame frmGameOver;
	private JTextArea txtrenhorabuenaHasGanado;
	private JButton btnContinuar;

	/**
	 * Create the application.
	 */
	public VDialogoDerrota() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameOver = new JFrame();
		frmGameOver.setAlwaysOnTop(true);
		frmGameOver.setIconImage(Toolkit.getDefaultToolkit().getImage(VDialogoDerrota.class.getResource("/assets/icono.png")));
		frmGameOver.getContentPane().setBackground(Color.WHITE);
		frmGameOver.setBounds(100, 100, 374, 241);
		frmGameOver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGameOver.getContentPane().setLayout(null);
		frmGameOver.getContentPane().add(getTxtrenhorabuenaHasGanado());
		frmGameOver.getContentPane().add(getBtnContinuar());
		frmGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frmGameOver.getSize();
		//Tamaño del frame actual (ancho x alto)
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height; 
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width; 
		}
		frmGameOver.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frmGameOver.getContentPane().setLayout(null);
		frmGameOver.getContentPane().add(getTxtrenhorabuenaHasGanado());
		frmGameOver.getContentPane().add(getBtnContinuar());
		
		frmGameOver.setVisible(true);
	}
	private JTextArea getTxtrenhorabuenaHasGanado() {
		if (txtrenhorabuenaHasGanado == null) {
			txtrenhorabuenaHasGanado = new JTextArea();
			txtrenhorabuenaHasGanado.setBackground(Color.WHITE);
			txtrenhorabuenaHasGanado.setEditable(false);
			txtrenhorabuenaHasGanado.setFont(new Font("Tahoma", Font.PLAIN, 40));
			txtrenhorabuenaHasGanado.setText("Game Over");
			txtrenhorabuenaHasGanado.setBounds(76, 64, 214, 64);
		}
		return txtrenhorabuenaHasGanado;
	}
	private JButton getBtnContinuar() {
		if (btnContinuar == null) {
			btnContinuar = new JButton("Continuar");
			btnContinuar.setBounds(144, 169, 89, 23);
		}
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new VDialogo();
				frmGameOver.dispose();
			}
		});
		return btnContinuar;
	}
}

