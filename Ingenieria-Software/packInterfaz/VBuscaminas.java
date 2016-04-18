package packInterfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

public class VBuscaminas {

	private JFrame frame;
	private JLabel lblTablero;
	private JInternalFrame internalFrame;
	private int nivel;
	private static int ANCHOMAX = 550;
	private static int ALTOMAX = 550;

	public VBuscaminas(int pNivel) {
		nivel = pNivel;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		
		switch(nivel) {
		case 1:
			ANCHOMAX = 550;
			ALTOMAX = 550;
			break;
		case 2:
			ANCHOMAX = 800;
			ALTOMAX = 600;
			break;
		case 3:
			ANCHOMAX = 1200;
			ALTOMAX = 800;
			break;
		}
		
		frame.setBounds(0, 0, ANCHOMAX, ALTOMAX);
		
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
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[100px][800px][100px]", "[50px][700px][50px]"));
		frame.getContentPane().add(getLblTablero(), "cell 0 0 3 1,alignx center,aligny center");
		frame.getContentPane().add(getInternalFrame(), "cell 1 1,grow");
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
	private JInternalFrame getInternalFrame() {
		if (internalFrame == null) {
			internalFrame = new JInternalFrame();
			// visual
			internalFrame.getContentPane().setBackground(Color.WHITE);
			internalFrame.setBorder(null);
			internalFrame.setFrameIcon(null);
			// eliminar title bar (menu bar)
			((javax.swing.plaf.basic.BasicInternalFrameUI)internalFrame.getUI()).setNorthPane(null);
			// mostrar el miglayout para los botones
			internalFrame.getContentPane().setLayout(new MigLayout("", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]", "[14.28%][14.28%][14.28%][14.28%][14.28%][14.28%][14.28%]"));
			
			
			new VTableroCasillas(internalFrame, nivel);

			internalFrame.setVisible(true);
		}
		return internalFrame;
	}
}

