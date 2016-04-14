package packInterfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
<<<<<<< HEAD

public class VBuscaminas {

	private JFrame frame;
	private JLabel lblTablero;

	public VBuscaminas() {	
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[33%][33%,grow][33%]", "[33%][33%,grow][33%]"));
		frame.getContentPane().add(getLblTablero(), "cell 0 0 3 1,alignx center,aligny center");
		// Visualizar la ventana
		frame.setVisible(true);
	}

	private JLabel getLblTablero() {
		if (lblTablero == null) {
			lblTablero = new JLabel("Buscaminas");
			lblTablero.setFont(new Font("Tahoma", Font.PLAIN, 60));
		}
		return lblTablero;
=======
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class VBuscaminas {

	private JFrame frame;
	private JLabel lblTablero;
	private JPanel panel;

	public VBuscaminas() {	
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[33%][33%,grow][33%]", "[33%][33%,grow][33%]"));
		frame.getContentPane().add(getLblTablero(), "cell 0 0 3 1,alignx center,aligny center");
		frame.getContentPane().add(getPanel(), "cell 1 1,grow");
		// Visualizar la ventana
		frame.setVisible(true);
	}

	private JLabel getLblTablero() {
		if (lblTablero == null) {
			lblTablero = new JLabel("Buscaminas");
			lblTablero.setFont(new Font("Tahoma", Font.PLAIN, 60));
		}
		return lblTablero;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
		}
		return panel;
>>>>>>> refs/remotes/origin/jserodio
	}
}
