package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * Módulo de la clase VistaLogin
 * 
 * @author Javier Senit y Carlos Marti
 *
 */
public class VistaLogin {
	private JFrame ventana;
	private Container contenedor;
	private JButton entrar, salir;
	private JLabel nia, pass, icon, icono, academia;
	private JTextField niaField;
	private JPasswordField passField;
	private SpringLayout layout;
	private JPanel NiaPasswordField, ExitField;
	String nia2;
	char[] password;
	ControladorLogin controlador;

	/**
	 * Constructor de la clase VistaLogin
	 */
	public VistaLogin() {
		// crear ventana
		ventana = new JFrame("Academia");
		// obtener contenedor, asignar layout
		contenedor = ventana.getContentPane();
		contenedor.setLayout(new BorderLayout());

		entrar = new JButton("Entrar");
		salir = new JButton("Salir");

		niaField = new JTextField(10);
		passField = new JPasswordField(10);

		layout = new SpringLayout();

		password = passField.getPassword();

		nia = new JLabel("NIA:");
		nia.setFont(new Font("Arial", 0, 25));
		pass = new JLabel("PASSWORD:");
		pass.setFont(new Font("Arial", 0, 25));

		icon = new JLabel("");
		icon.setIcon(new ImageIcon("src/imagenes/user.png"));

		NiaPasswordField = new JPanel();
		NiaPasswordField.setLayout(layout);

		layout.putConstraint("HorizontalCenter", nia, -100, "HorizontalCenter", NiaPasswordField);
		layout.putConstraint("VerticalCenter", nia, 0, "VerticalCenter", NiaPasswordField);

		// La izquierda de field estará a 5 pixels desde el borde derecho (EAST)
		// de label
		layout.putConstraint(SpringLayout.WEST, niaField, 117, SpringLayout.EAST, nia);
		// El norte de field estará a 5 pixels desde el norte del contenedor
		layout.putConstraint(SpringLayout.NORTH, niaField, 0, SpringLayout.NORTH, nia);

		// La izquierda de label2 estará a 0 pixels (alineada) del borde
		// izquierdo de label
		layout.putConstraint(SpringLayout.WEST, pass, 0, SpringLayout.WEST, nia);

		// El norte de label2 estará a 5 pixels del borde inferior (SOUTH) de
		// label
		layout.putConstraint(SpringLayout.NORTH, pass, 8, SpringLayout.SOUTH, nia);
		// La izquierda de field2 alienada con la izquierda de field
		layout.putConstraint(SpringLayout.WEST, passField, 0, SpringLayout.WEST, niaField);

		// El norte de field2, 5 pixels más abajo de field
		layout.putConstraint(SpringLayout.NORTH, passField, 21, SpringLayout.SOUTH, niaField);

		// El norte de field2, 5 pixels más abajo de field
		layout.putConstraint(SpringLayout.WEST, passField, 10, SpringLayout.EAST, pass);

		// La izquierda de field estará a 5 pixels desde el borde derecho (EAST)
		// de label
		layout.putConstraint(SpringLayout.EAST, icon, -150, SpringLayout.WEST, nia);
		// La izquierda de field estará a 5 pixels desde el borde derecho (EAST)
		// de label
		layout.putConstraint(SpringLayout.SOUTH, icon, 100, SpringLayout.NORTH, nia);

		// La izquierda de field estará a 5 pixels desde el borde derecho (EAST)
		// de label
		layout.putConstraint(SpringLayout.NORTH, entrar, 50, SpringLayout.SOUTH, passField);
		// La izquierda de field estará a 5 pixels desde el borde derecho (EAST)
		// de label
		layout.putConstraint(SpringLayout.WEST, entrar, 75, SpringLayout.WEST, pass);

		// La izquierda de field estará a 5 pixels desde el borde derecho (EAST)
		// de label
		layout.putConstraint(SpringLayout.NORTH, salir, 50, SpringLayout.SOUTH, passField);
		// La izquierda de field estará a 5 pixels desde el borde derecho (EAST)
		// de label
		layout.putConstraint(SpringLayout.WEST, salir, 10, SpringLayout.EAST, entrar);

		NiaPasswordField.add(icon);
		NiaPasswordField.add(nia);
		NiaPasswordField.add(niaField);
		NiaPasswordField.add(pass);
		NiaPasswordField.add(passField);
		NiaPasswordField.add(entrar);
		NiaPasswordField.add(salir);
		NiaPasswordField.setPreferredSize(new Dimension(500, 500));
		NiaPasswordField.setVisible(true);
		NiaPasswordField.setBackground(new Color(0, 255, 255));

		ExitField = new JPanel();
		ExitField.setLayout(new BorderLayout());
		icono = new JLabel();
		academia = new JLabel("Academia Lopez");
		academia.setFont(new Font("Arial", Font.PLAIN, 70));
		icono.setIcon(new ImageIcon("src/imagenes/descarga.png"));
		ExitField.setBackground(new Color(255, 255, 255));
		ExitField.add(icono, BorderLayout.WEST);
		ExitField.add(academia, BorderLayout.CENTER);
		ExitField.add(salir, BorderLayout.EAST);

		/**
		 * Funcion que aniade una funcion al boton de entrar
		 * 
		 */
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nia2 = niaField.getText();
				password = passField.getPassword();
				try {
					controlador.entrar();

				} catch (FileNotFoundException e1) {
					JOptionPane.showInputDialog("Se ha producido un error");
				} catch (ClassNotFoundException e1) {
					JOptionPane.showInputDialog("Se ha producido un error");
				} catch (IOException e1) {
					JOptionPane.showInputDialog("Se ha producido un error");
				}
			}
		});

		
		/**
		 * Funcion que aniade una funcion al boton de salir
		 * 
		 */
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.salir();
				} catch (IOException e1) {
					JOptionPane.showInputDialog("Error al desconectar");
				}
			}

		});
		// añadir componentes al contenedor
		contenedor.add(ExitField, BorderLayout.NORTH);
		contenedor.add(NiaPasswordField, BorderLayout.CENTER);

		// mostrar ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(1020, 850);
		ventana.setVisible(true);
	}

	/**
	 * Funcion que obtiene la ventana de VistaLogin
	 * @return Ventana de VistaLogin
	 */
	public JFrame getVentana() {
		return ventana;
	}

	/**
	 * Funcion que obtiene el contenedor de VistaLogin
	 * @return Contenedor de VistaLogin
	 */
	public Container getContenedor() {
		return contenedor;
	}

	/**
	 * Funcion que obtiene el boton de entrar de VistaLogin
	 * @return Boton de entrar de VistaLogin
	 */
	public JButton getEntrar() {
		return entrar;
	}

	/**
	 * Funcion que obtiene el boton de salir de VistaLogin
	 * @return Boton de salir de VistaLogin
	 */
	public JButton getSalir() {
		return salir;
	}

	/**
	 * Funcion que obtiene el nia introducido en VistaLogin
	 * @return Nia de VistaLogin
	 */
	public JLabel getNia() {
		return nia;
	}

	/**
	 * Funcion que obtiene el pass introducido en VistaLogin
	 * @return Pass de VistaLogin
	 */
	public JLabel getPass() {
		return pass;
	}

	/**
	 * Funcion que obtiene el icono introducido en VistaLogin
	 * @return icono de VistaLogin
	 */
	public JLabel getIcon() {
		return icon;
	}

	/**
	 * Funcion que obtiene el icono introducido en VistaLogin
	 * @return icono de VistaLogin
	 */
	public JLabel getIcono() {
		return icono;
	}

	/**
	 * Funcion que obtiene el label de Academia Lopez introducido en VistaLogin
	 * @return Label de Academia Lopez de VistaLogin
	 */
	public JLabel getAcademia() {
		return academia;
	}

	/**
	 * Funcion que obtiene el nia introducido en VistaLogin
	 * @return Nia de VistaLogin
	 */
	public JTextField getNiaField() {
		return niaField;
	}

	/**
	 * Funcion que obtiene el pass introducido en VistaLogin
	 * @return pass de VistaLogin
	 */
	public JPasswordField getPassField() {
		return passField;
	}

	/**
	 * Funcion que obtiene el layout introducido en VistaLogin
	 * @return layout de VistaLogin
	 */
	public SpringLayout getLayout() {
		return layout;
	}

	/**
	 * Funcion que obtiene el panel introducido en VistaLogin
	 * @return panel de VistaLogin
	 */
	public JPanel getNiaPasswordField() {
		return NiaPasswordField;
	}

	/**
	 * Funcion que obtiene el panel donde está el boton de salir introducido en VistaLogin
	 * @return panel con boton de salir de VistaLogin
	 */
	public JPanel getExitField() {
		return ExitField;
	}

	/**
	 * Funcion que obtiene el pass introducido en VistaLogin
	 * @return pass de VistaLogin
	 */
	public char[] getPassword() {
		return password;
	}

	/**
	 * Funcion que modifica el controlador introducido en VistaLogin
	 * @param contr nuevo controlador
	 * @return nuevo controlador de VistaLogin
	 */
	public void setControlador(ControladorLogin contr) {
		this.controlador = contr;

	}

	/**
	 * Funcion que obtiene el nia introducido en VistaLogin
	 * 
	 * @return nia de VistaLogin
	 */
	public String getNia2() {
		return nia2;
	}

	/**
	 * Funcion que obtiene el controlador introducido en VistaLogin
	 * @
	 * @return controlador de VistaLogin
	 */
	public ControladorLogin getControlador() {
		return controlador;
	}

	/**
	 * Funcion que modifica la visibilidad introducida en VistaLogin
	 * @param visibilidad nuevo controlador
	 * @return nueva visibilidad de VistaLogin
	 */
	public void setVisibilidad(boolean visibilidad) {
		ventana.setVisible(visibilidad);

	}

}
