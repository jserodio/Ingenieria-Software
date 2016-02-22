package org.jserodio.ejerTablero;

import javax.swing.JFrame;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tablero extends JFrame{
	public Tablero() {
		
		setBounds(100, 100, 500, 500);
		
		getContentPane().setLayout(new MigLayout("", "[12.5%][12.5%][12.5%][12.5%][12.5%][12.5%][12.5%][12.5%]", "[12.5%][12.5%][12.5%][12.5%][12.5%][12.5%][12.5%][12.5%]"));
		getContentPane().add(getB11(), "cell 0 0,grow");
		getContentPane().add(getB12(), "cell 1 0,grow");
		getContentPane().add(getB13(), "cell 2 0,grow");
		getContentPane().add(getB14(), "cell 3 0,grow");
		getContentPane().add(getB15(), "cell 4 0,grow");
		getContentPane().add(getB16(), "cell 5 0,grow");
		getContentPane().add(getB17(), "cell 6 0,grow");
		getContentPane().add(getB18(), "cell 7 0,grow");
		getContentPane().add(getB21(), "cell 0 1,grow");
		getContentPane().add(getB22(), "cell 1 1,grow");
		getContentPane().add(getB23(), "cell 2 1,grow");
		getContentPane().add(getB24(), "cell 3 1,grow");
		getContentPane().add(getB25(), "cell 4 1,grow");
		getContentPane().add(getB26(), "cell 5 1,grow");
		getContentPane().add(getB27(), "cell 6 1,grow");
		getContentPane().add(getB28(), "cell 7 1,grow");
		getContentPane().add(getB31(), "cell 0 2,grow");
		getContentPane().add(getB32(), "cell 1 2,grow");
		getContentPane().add(getB33(), "cell 2 2,grow");
		getContentPane().add(getB34(), "cell 3 2,grow");
		getContentPane().add(getN35(), "cell 4 2,grow");
		getContentPane().add(getB36(), "cell 5 2,grow");
		getContentPane().add(getB37(), "cell 6 2,grow");
		getContentPane().add(getB38(), "cell 7 2,grow");
		getContentPane().add(getB41(), "cell 0 3,grow");
		getContentPane().add(getB42(), "cell 1 3,grow");
		getContentPane().add(getB43(), "cell 2 3,grow");
		getContentPane().add(getB44(), "cell 3 3,grow");
		getContentPane().add(getB45(), "cell 4 3,grow");
		getContentPane().add(getB46(), "cell 5 3,grow");
		getContentPane().add(getB47(), "cell 6 3,grow");
		getContentPane().add(getB48(), "cell 7 3,grow");
		getContentPane().add(getB51(), "cell 0 4,grow");
		getContentPane().add(getB52(), "cell 1 4,grow");
		getContentPane().add(getB53(), "cell 2 4,grow");
		getContentPane().add(getB54(), "cell 3 4,grow");
		getContentPane().add(getB55(), "cell 4 4,grow");
		getContentPane().add(getB56(), "cell 5 4,grow");
		getContentPane().add(getB57(), "cell 6 4,grow");
		getContentPane().add(getB58(), "cell 7 4,grow");
		getContentPane().add(getB61(), "cell 0 5,grow");
		getContentPane().add(getB62(), "cell 1 5,grow");
		getContentPane().add(getB63(), "cell 2 5,grow");
		getContentPane().add(getB64(), "cell 3 5,grow");
		getContentPane().add(getB65(), "cell 4 5,grow");
		getContentPane().add(getB66(), "cell 5 5,grow");
		getContentPane().add(getB67(), "cell 6 5,grow");
		getContentPane().add(getB68(), "cell 7 5,grow");
		getContentPane().add(getB71(), "cell 0 6,grow");
		getContentPane().add(getB72(), "cell 1 6,grow");
		getContentPane().add(getB73(), "cell 2 6,grow");
		getContentPane().add(getB74(), "cell 3 6,grow");
		getContentPane().add(getB75(), "cell 4 6,grow");
		getContentPane().add(getB76(), "cell 5 6,grow");
		getContentPane().add(getB77(), "cell 6 6,grow");
		getContentPane().add(getB78(), "cell 7 6,grow");
		getContentPane().add(getB81(), "cell 0 7,grow");
		getContentPane().add(getB82(), "cell 1 7,grow");
		getContentPane().add(getB83(), "cell 2 7,grow");
		getContentPane().add(getB84(), "cell 3 7,grow");
		getContentPane().add(getB85(), "cell 4 7,grow");
		getContentPane().add(getB86(), "cell 5 7,grow");
		getContentPane().add(getB87(), "cell 6 7,grow");
		getContentPane().add(getB88(), "cell 7 7,grow");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton b11;
	private JButton b12;
	private JButton b13;
	private JButton b14;
	private JButton b15;
	private JButton b16;
	private JButton b17;
	private JButton b18;
	private JButton b21;
	private JButton b22;
	private JButton b23;
	private JButton b24;
	private JButton b25;
	private JButton b26;
	private JButton b27;
	private JButton b28;
	private JButton b31;
	private JButton b32;
	private JButton b33;
	private JButton b34;
	private JButton n35;
	private JButton b36;
	private JButton b37;
	private JButton b38;
	private JButton b41;
	private JButton b42;
	private JButton b43;
	private JButton b44;
	private JButton b45;
	private JButton b46;
	private JButton b47;
	private JButton b48;
	private JButton b51;
	private JButton b52;
	private JButton b53;
	private JButton b54;
	private JButton b55;
	private JButton b56;
	private JButton b57;
	private JButton b58;
	private JButton b61;
	private JButton b62;
	private JButton b63;
	private JButton b64;
	private JButton b65;
	private JButton b66;
	private JButton b67;
	private JButton b68;
	private JButton b71;
	private JButton b72;
	private JButton b73;
	private JButton b74;
	private JButton b75;
	private JButton b76;
	private JButton b77;
	private JButton b78;
	private JButton b81;
	private JButton b82;
	private JButton b83;
	private JButton b84;
	private JButton b85;
	private JButton b86;
	private JButton b87;
	private JButton b88;

	private JButton getB11() {
		if (b11 == null) {
			b11 = new JButton("");
			b11.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b11;
	}
	private JButton getB12() {
		if (b12 == null) {
			b12 = new JButton("");
			b12.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b12;
	}
	private JButton getB13() {
		if (b13 == null) {
			b13 = new JButton("");
			b13.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b13;
	}
	private JButton getB14() {
		if (b14 == null) {
			b14 = new JButton("");
			b14.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b14;
	}
	private JButton getB15() {
		if (b15 == null) {
			b15 = new JButton("");
			b15.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b15;
	}
	private JButton getB16() {
		if (b16 == null) {
			b16 = new JButton("");
			b16.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b16;
	}
	private JButton getB17() {
		if (b17 == null) {
			b17 = new JButton("");
			b17.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b17;
	}
	private JButton getB18() {
		if (b18 == null) {
			b18 = new JButton("");
			b18.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b18;
	}
	private JButton getB21() {
		if (b21 == null) {
			b21 = new JButton("");
			b21.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
				}
			});
		}
		return b21;
	}
	private JButton getB22() {
		if (b22 == null) {
			b22 = new JButton("");
			b22.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b22;
	}
	private JButton getB23() {
		if (b23 == null) {
			b23 = new JButton("");
			b23.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b23;
	}
	private JButton getB24() {
		if (b24 == null) {
			b24 = new JButton("");
			b24.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b24;
	}
	private JButton getB25() {
		if (b25 == null) {
			b25 = new JButton("");
			b25.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b25;
	}
	private JButton getB26() {
		if (b26 == null) {
			b26 = new JButton("");
			b26.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b26;
	}
	private JButton getB27() {
		if (b27 == null) {
			b27 = new JButton("");
			b27.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b27;
	}
	private JButton getB28() {
		if (b28 == null) {
			b28 = new JButton("");
			b28.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b28;
	}
	private JButton getB31() {
		if (b31 == null) {
			b31 = new JButton("");
			b31.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b31;
	}
	private JButton getB32() {
		if (b32 == null) {
			b32 = new JButton("");
			b32.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b32;
	}
	private JButton getB33() {
		if (b33 == null) {
			b33 = new JButton("");
			b33.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b33;
	}
	private JButton getB34() {
		if (b34 == null) {
			b34 = new JButton("");
			b34.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b34;
	}
	private JButton getN35() {
		if (n35 == null) {
			n35 = new JButton("");
			n35.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return n35;
	}
	private JButton getB36() {
		if (b36 == null) {
			b36 = new JButton("");
			b36.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b36;
	}
	private JButton getB37() {
		if (b37 == null) {
			b37 = new JButton("");
			b37.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b37;
	}
	private JButton getB38() {
		if (b38 == null) {
			b38 = new JButton("");
			b38.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b38;
	}
	private JButton getB41() {
		if (b41 == null) {
			b41 = new JButton("");
			b41.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b41;
	}
	private JButton getB42() {
		if (b42 == null) {
			b42 = new JButton("");
			b42.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b42;
	}
	private JButton getB43() {
		if (b43 == null) {
			b43 = new JButton("");
			b43.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b43;
	}
	private JButton getB44() {
		if (b44 == null) {
			b44 = new JButton("");
			b44.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b44;
	}
	private JButton getB45() {
		if (b45 == null) {
			b45 = new JButton("");
			b45.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b45;
	}
	private JButton getB46() {
		if (b46 == null) {
			b46 = new JButton("");
			b46.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b46;
	}
	private JButton getB47() {
		if (b47 == null) {
			b47 = new JButton("");
			b47.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b47;
	}
	private JButton getB48() {
		if (b48 == null) {
			b48 = new JButton("");
			b48.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b48;
	}
	private JButton getB51() {
		if (b51 == null) {
			b51 = new JButton("");
			b51.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b51;
	}
	private JButton getB52() {
		if (b52 == null) {
			b52 = new JButton("");
			b52.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b52;
	}
	private JButton getB53() {
		if (b53 == null) {
			b53 = new JButton("");
			b53.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b53;
	}
	private JButton getB54() {
		if (b54 == null) {
			b54 = new JButton("");
			b54.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b54;
	}
	private JButton getB55() {
		if (b55 == null) {
			b55 = new JButton("");
			b55.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b55;
	}
	private JButton getB56() {
		if (b56 == null) {
			b56 = new JButton("");
			b56.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b56;
	}
	private JButton getB57() {
		if (b57 == null) {
			b57 = new JButton("");
			b57.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b57;
	}
	private JButton getB58() {
		if (b58 == null) {
			b58 = new JButton("");
			b58.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b58;
	}
	private JButton getB61() {
		if (b61 == null) {
			b61 = new JButton("");
			b61.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b61;
	}
	private JButton getB62() {
		if (b62 == null) {
			b62 = new JButton("");
			b62.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b62;
	}
	private JButton getB63() {
		if (b63 == null) {
			b63 = new JButton("");
			b63.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b63;
	}
	private JButton getB64() {
		if (b64 == null) {
			b64 = new JButton("");
			b64.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b64;
	}
	private JButton getB65() {
		if (b65 == null) {
			b65 = new JButton("");
			b65.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b65;
	}
	private JButton getB66() {
		if (b66 == null) {
			b66 = new JButton("");
			b66.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b66;
	}
	private JButton getB67() {
		if (b67 == null) {
			b67 = new JButton("");
			b67.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b67;
	}
	private JButton getB68() {
		if (b68 == null) {
			b68 = new JButton("");
			b68.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b68;
	}
	private JButton getB71() {
		if (b71 == null) {
			b71 = new JButton("");
			b71.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b71;
	}
	private JButton getB72() {
		if (b72 == null) {
			b72 = new JButton("");
			b72.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b72;
	}
	private JButton getB73() {
		if (b73 == null) {
			b73 = new JButton("");
			b73.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b73;
	}
	private JButton getB74() {
		if (b74 == null) {
			b74 = new JButton("");
			b74.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b74;
	}
	private JButton getB75() {
		if (b75 == null) {
			b75 = new JButton("");
			b75.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b75;
	}
	private JButton getB76() {
		if (b76 == null) {
			b76 = new JButton("");
			b76.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b76;
	}
	private JButton getB77() {
		if (b77 == null) {
			b77 = new JButton("");
			b77.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b77;
	}
	private JButton getB78() {
		if (b78 == null) {
			b78 = new JButton("");
			b78.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b78;
	}
	private JButton getB81() {
		if (b81 == null) {
			b81 = new JButton("");
			b81.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b81;
	}
	private JButton getB82() {
		if (b82 == null) {
			b82 = new JButton("");
			b82.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b82;
	}
	private JButton getB83() {
		if (b83 == null) {
			b83 = new JButton("");
			b83.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b83;
	}
	private JButton getB84() {
		if (b84 == null) {
			b84 = new JButton("");
			b84.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b84;
	}
	private JButton getB85() {
		if (b85 == null) {
			b85 = new JButton("");
			b85.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b85;
	}
	private JButton getB86() {
		if (b86 == null) {
			b86 = new JButton("");
			b86.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b86;
	}
	private JButton getB87() {
		if (b87 == null) {
			b87 = new JButton("");
			b87.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b87;
	}
	private JButton getB88() {
		if (b88 == null) {
			b88 = new JButton("");
			b88.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return b88;
	}
}
