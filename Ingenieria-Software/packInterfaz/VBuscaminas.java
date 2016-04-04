package packInterfaz;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class VBuscaminas {

	private JFrame frame;
	private JFrame tableroFrame;
	private JPanel panel;
	private JButton button;

	public VBuscaminas() {	
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getPanel(), BorderLayout.NORTH);
		frame.getContentPane().add(getTableroFrame(), BorderLayout.CENTER);
		// Visualizar la ventana
		frame.setVisible(true);
	}
	private JFrame getTableroFrame() {
		if (tableroFrame == null) {
			tableroFrame = new JFrame();
			tableroFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			tableroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
			tableroFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			tableroFrame.setUndecorated(true);
		}
		return tableroFrame;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new MigLayout("", "[33%][33%][33%]", "[]"));
			panel.add(getButton(), "cell 1 0,grow");
		}
		return panel;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.setBackground(Color.WHITE);
			button.setIcon(new ImageIcon(VBuscaminas.class.getResource("/assets/sunglasses.png")));
		}
		return button;
	}
}
