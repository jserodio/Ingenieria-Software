package packInterfaz;

import net.miginfocom.swing.MigLayout;
import packModelo.Sesion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VBuscaminas implements Observer{

	private JFrame frmBuscaminas;
	private JLabel lblTablero;
	private JInternalFrame internalFrame;
	private int nivel;
	private static int ANCHOMAX = 550;
	private static int ALTOMAX = 550;
	private JTextField textMinas;
	private JTextField textReloj;
	private JButton btnRanking;

	public VBuscaminas(int pNivel) {
		nivel = pNivel;
		initialize();
		Sesion.getSesion().addObserver(this);
	}

	private void initialize() {
		frmBuscaminas = new JFrame();
		frmBuscaminas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscaminas.setIconImage(Toolkit.getDefaultToolkit().getImage(VBuscaminas.class.getResource("/assets/icono.png")));
		frmBuscaminas.setAlwaysOnTop(true);
		frmBuscaminas.setTitle("Buscaminas!");
		frmBuscaminas.getContentPane().setBackground(Color.WHITE);
		frmBuscaminas.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new VDialogo();
			}
		});
		
		switch(nivel) {
		case 1:
			ANCHOMAX = 800;
			ALTOMAX = 640;
			break;
		case 2:
			ANCHOMAX = 850;
			ALTOMAX = 600;
			break;
		case 3:
			ANCHOMAX = 1440;
			ALTOMAX = 800;
			break;
		}
		
		frmBuscaminas.setBounds(0, 0, ANCHOMAX, ALTOMAX);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frmBuscaminas.getSize();
		//Tamaño del frame actual (ancho x alto)
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height; 
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width; 
		}
		frmBuscaminas.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frmBuscaminas.getContentPane().setLayout(new MigLayout("", "[:7.5%:7.5%][:7.5%:7.5%][:7.5%:7.5%][:7.5%:7.5%][40%][:7.5%:7.5%][:7.5%:7.5%][:7.5%:7.5%][:7.5%:7.5%]", "[5%][10%][60%][20%][5%]"));
		frmBuscaminas.getContentPane().add(getBtnRanking(), "cell 0 1,grow");
		frmBuscaminas.getContentPane().add(getTextMinas(), "cell 2 1 2 1,grow");
		frmBuscaminas.getContentPane().add(getLblTablero(), "cell 4 1 2 1,alignx center,aligny center");
		frmBuscaminas.getContentPane().add(getTextReloj(), "cell 6 1 3 1,grow");
		frmBuscaminas.getContentPane().add(getInternalFrame(), "cell 0 2 9 3,grow");
		// Visualizar la ventana
		frmBuscaminas.setVisible(true);
	}

	private JLabel getLblTablero() {
		if (lblTablero == null) {
			lblTablero = new JLabel("Buscaminas");
			lblTablero.setHorizontalAlignment(SwingConstants.CENTER);
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
	private JTextField getTextMinas() {
		if (textMinas == null) {
			textMinas = new JTextField();
			textMinas.setEditable(false);
			textMinas.setHorizontalAlignment(SwingConstants.CENTER);
			textMinas.setFont(new Font("Tahoma", Font.PLAIN, 30));
			textMinas.setText("5");
			textMinas.setColumns(10);
		}
		return textMinas;
	}
	private JTextField getTextReloj() {
		if (textReloj == null) {
			textReloj = new JTextField();
			textReloj.setText("0:01");
			textReloj.setEditable(false);
			textReloj.setHorizontalAlignment(SwingConstants.CENTER);
			textReloj.setFont(new Font("Tahoma", Font.PLAIN, 30));
			textReloj.setColumns(10);
		}
		return textReloj;
	}
	private JButton getBtnRanking() {
		if (btnRanking == null) {
			btnRanking = new JButton("");
			btnRanking.setBackground(new Color(255, 255, 255));
			btnRanking.setForeground(new Color(255, 255, 255));
			btnRanking.setIcon(new ImageIcon(VBuscaminas.class.getResource("/assets/ranking.png")));
			btnRanking.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					//System.exit(0);
					new VRanking();
					frmBuscaminas.dispose();
				}
			});
		}
		return btnRanking;
	}

	@Override
	public void update(Observable arg0, Object pReloj) {

		textReloj.setText(pReloj.toString());
	}
}

