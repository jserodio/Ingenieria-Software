package packInterfaz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import packModelo.Buscaminas;
import packModelo.Sesion;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VLogin {

	private JFrame frmIdentificarse;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JButton btnLogin;
	private JLabel lblIdentifcate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VLogin window = new VLogin();
					window.frmIdentificarse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIdentificarse = new JFrame();
		frmIdentificarse.setIconImage(Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/assets/icono.png")));
		frmIdentificarse.getContentPane().setBackground(Color.WHITE);
		frmIdentificarse.setTitle("Identificarse");
		frmIdentificarse.setBounds(100, 100, 500, 400);
		frmIdentificarse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frmIdentificarse.getSize();
		//Tamaño del frame actual (ancho x alto)
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height; 
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width; 
		}
		frmIdentificarse.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frmIdentificarse.getContentPane().setLayout(new MigLayout("", "[20%][22.5%][15%][15%][22.5%]", "[25%][25%][25%][25%]"));
		frmIdentificarse.getContentPane().add(getLblIdentifcate(), "cell 1 0 3 1,alignx center");
		frmIdentificarse.getContentPane().add(getLblUser(), "cell 1 1,alignx center,aligny center");
		frmIdentificarse.getContentPane().add(getTxtUser(), "cell 2 1 2 1,growx,aligny center");
		frmIdentificarse.getContentPane().add(getLblPassword(), "cell 1 2,alignx center,aligny center");
		frmIdentificarse.getContentPane().add(getTxtPassword(), "cell 2 2 2 1,growx,aligny center");
		frmIdentificarse.getContentPane().add(getBtnLogin(), "cell 0 3 5 1,grow");
		// Visualizar la ventana
		frmIdentificarse.setVisible(true);
	}
	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("User");
			lblUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblUser;
	}
	private JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setHorizontalAlignment(SwingConstants.CENTER);
			txtUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtUser.setText("User");
			txtUser.setColumns(10);
		}
		return txtUser;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblPassword;
	}
	private JTextField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JTextField();
			txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
			txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtPassword.setText("Password");
			txtPassword.setColumns(10);
		}
		return txtPassword;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.setIcon(new ImageIcon(VLogin.class.getResource("/assets/icono.png")));
			btnLogin.setBackground(Color.WHITE);
			btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(!txtUser.getText().equals("")&&!txtPassword.getText().equals("")||!txtUser.getText().equals("User")&&!txtPassword.getText().equals("Password")){
						Sesion.getSesion().setUsuario(txtUser.getText());
						Sesion.getSesion().setPass(txtPassword.getText());
						Sesion.getSesion().iniciar();
						new VElegirNivel();	// llamada a la ventana
						frmIdentificarse.dispose();
					}
				}
			});
		}
		return btnLogin;
	}
	
	private JLabel getLblIdentifcate() {
		if (lblIdentifcate == null) {
			lblIdentifcate = new JLabel("Identif\u00EDcate");
			lblIdentifcate.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblIdentifcate;
	}
}
