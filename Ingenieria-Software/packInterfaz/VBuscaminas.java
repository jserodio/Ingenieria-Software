package packInterfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;

public class VBuscaminas {

	private JFrame frame;
	private JLabel lblTablero;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the application.
	 */
	public VBuscaminas() {	
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
	}
}
