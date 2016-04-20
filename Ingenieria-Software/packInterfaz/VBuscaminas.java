package packInterfaz;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class VBuscaminas {

	private JFrame frmBuscaminas;
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
		frmBuscaminas = new JFrame();
		frmBuscaminas.setIconImage(Toolkit.getDefaultToolkit().getImage(VBuscaminas.class.getResource("/assets/icono.png")));
		frmBuscaminas.setAlwaysOnTop(true);
		frmBuscaminas.setTitle("Buscaminas!");
		frmBuscaminas.getContentPane().setBackground(Color.WHITE);
		
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
			ANCHOMAX = 1000;
			ALTOMAX = 600;
			break;
		}
		
		frmBuscaminas.setBounds(0, 0, ANCHOMAX, ALTOMAX);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frmBuscaminas.getSize();
		//Tama�o del frame actual (ancho x alto)
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height; 
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width; 
		}
		frmBuscaminas.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		frmBuscaminas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscaminas.getContentPane().setLayout(new MigLayout("", "[1%][98%][1%]", "[50px][700px][50px]"));
		frmBuscaminas.getContentPane().add(getLblTablero(), "cell 0 0 3 1,alignx center,aligny center");
		frmBuscaminas.getContentPane().add(getInternalFrame(), "cell 1 1,grow");
		// Visualizar la ventana
		frmBuscaminas.setVisible(true);
	}

	private JLabel getLblTablero() {
		if (lblTablero == null) {
			lblTablero = new JLabel("Buscaminas");
			lblTablero.setFont(new Font("Tahoma", Font.PLAIN, 40));
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

