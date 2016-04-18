package packInterfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import packModelo.Buscaminas;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VLogin {

	private JFrame frame;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VLogin window = new VLogin();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblUser());
		frame.getContentPane().add(getTxtUser());
		frame.getContentPane().add(getLblPassword());
		frame.getContentPane().add(getTxtPassword());
		frame.getContentPane().add(getBtnLogin());
	}
	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("User");
			lblUser.setBounds(94, 85, 46, 14);
		}
		return lblUser;
	}
	private JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setText("User");
			txtUser.setBounds(171, 82, 86, 20);
			txtUser.setColumns(10);
		}
		return txtUser;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(94, 116, 46, 14);
		}
		return lblPassword;
	}
	private JTextField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JTextField();
			txtPassword.setText("Password");
			txtPassword.setBounds(171, 113, 86, 20);
			txtPassword.setColumns(10);
		}
		return txtPassword;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(!txtUser.getText().equals("")){
						Buscaminas.getBuscaminas().setUsuario(txtUser.getText());
					}
					new VElegirNivel();	// llamada a la ventana
				}
			});
			btnLogin.setBounds(126, 158, 116, 42);
		}
		return btnLogin;
	}
	
}
