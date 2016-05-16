package packInterfaz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import packModelo.Buscaminas;
import packModelo.Partida;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VRanking {

	private JFrame frame;
	private JTextArea txtArea;
	private JLabel lblRankingDeJugadores;
	private JButton btnContinuar;
	private JButton btnSalir;

	/**
	 * Create the application.
	 */
	public VRanking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VRanking.class.getResource("/assets/icono.png")));
		frame.setBackground(Color.WHITE);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 500, 400);
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
		frame.getContentPane().add(getTxtArea());
		frame.getContentPane().add(getLblRankingDeJugadores());
		frame.getContentPane().add(getBtnSalir());
		this.generarRanking(getTxtArea());
		frame.setVisible(true);
	}
	private void generarRanking(JTextArea p) {
		// TODO Auto-generated method stub
		ArrayList<Partida> rank=new ArrayList<Partida>();
		rank = Buscaminas.getBuscaminas().getRanking();
		Iterator<Partida> it = rank.iterator();
		int pPosicion = 1;
		p.append("    Posición                  Usuario                  Puntuación\n");
		p.append("------------------------------------------------------------------------- \n");
		while(it.hasNext()&&pPosicion<=10){
			Partida partida = it.next();
			String pUsuario = partida.getNombre();
			int pPuntuacion = partida.getPuntuacion();
			p.append("     "+pPosicion +"                                 "+pUsuario+"                            "+pPuntuacion+"\n" );						
			pPosicion++;
		}
	}

	private JTextArea getTxtArea() {
		if (txtArea == null) {
			txtArea = new JTextArea();
			txtArea.setLineWrap(true);
			txtArea.setEditable(false);
			txtArea.setBounds(22, 47, 434, 230);
		}
		return txtArea;
	}
	private JLabel getLblRankingDeJugadores() {
		if (lblRankingDeJugadores == null) {
			lblRankingDeJugadores = new JLabel("Ranking de Jugadores");
			lblRankingDeJugadores.setHorizontalAlignment(SwingConstants.CENTER);
			lblRankingDeJugadores.setBackground(Color.WHITE);
			lblRankingDeJugadores.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRankingDeJugadores.setBounds(138, 11, 223, 32);
		}
		return lblRankingDeJugadores;
	}

	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(293, 291, 89, 23);
		}
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		return btnSalir;
	}
}
