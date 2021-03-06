package interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * Modulo de la clase PanelCrearAsignatura
 * @author Javier Senit y Carlos Marti
 *
 */
public class PanelCrearAsignatura extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton crear;
	private JTextField titulo;
	private JLabel introduzca, volver;
	private JCheckBox check1;
	
	/**
	 * Constructor de la clase PanelCrearAsignatura
	 */
	public PanelCrearAsignatura(){
		
		crear=new JButton("Crear");
		introduzca = new JLabel("Introduzca el nombre de la asignatura");
		titulo = new JTextField(20);
		volver=new JLabel("Volver");
		
		check1=new JCheckBox("Visbilidad");
        check1.setBounds(10,10,150,30);
        check1.setBackground(new Color(0,255,255));
		introduzca.setFont(new Font("Arial",0,15));
		volver.setFont(new Font("Arial",0,15));
		volver.setForeground(Color.BLUE);
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", titulo, 0, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", titulo, 0, "VerticalCenter", this);
		
		
		layout.putConstraint(SpringLayout.NORTH, crear, 40, SpringLayout.SOUTH, titulo);
	
		layout.putConstraint(SpringLayout.EAST,crear, 0, SpringLayout.EAST, titulo);
		
		layout.putConstraint(SpringLayout.SOUTH, introduzca, -40, SpringLayout.NORTH, titulo);
		
		layout.putConstraint(SpringLayout.WEST, introduzca, 0, SpringLayout.WEST, titulo);
		
		layout.putConstraint(SpringLayout.NORTH, volver, 155, SpringLayout.SOUTH, crear);
		
		layout.putConstraint(SpringLayout.WEST,volver, 300, SpringLayout.EAST, crear);
		
		layout.putConstraint(SpringLayout.WEST, check1, 0, SpringLayout.WEST, titulo);
		
		layout.putConstraint(SpringLayout.NORTH, check1, 0, SpringLayout.NORTH,crear);
		
		setBackground(new Color(0,255,255));
		
		add(check1);
		add(volver);
		add(crear);
		add(titulo);
		add(introduzca);
		
		
		
	}

	/**
	 * Funcion que devuelve el titulo de la asignatura
	 * @return titulo
	 */
	public JTextField getTitulo() {
		return titulo;
	}

	/**
	 * Funcion que devuelve el el checkbox de la visibilidad
	 * @return checkbox de la visibilidad
	 */
	public JCheckBox getCheck1() {
		return check1;
	}

	/**
	 * Funcion que deveulve el boton de crear asignatura
	 * @return boton de crear asignatura
	 */
	public JButton getCrear() {
		return crear;
	}


	/**
	 * Funcion que deveulve el label de volver
	 * @return label de volver
	 */
	public JLabel getVolver() {
		return volver;
	}


	
	
	
	
	
}
