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
 * Modulo de la clase PanelCrearSubtema
 * @author Javier Senit y Carlos Marti
 *
 */
public class PanelCrearSubtema extends JPanel{

	
	private static final long serialVersionUID = 1L;
	JButton boton;
	JTextField titulo;
	JLabel introduzca, volver;
	private JCheckBox check1;
	
	/**
	 * Constructor de la clase PanelCrearSubtema
	 */
	public PanelCrearSubtema(){
		
		boton = new JButton("Crear");
		introduzca = new JLabel("Introduzca el nombre del tema");
		titulo = new JTextField(20);
		volver = new JLabel("Volver");
		
		introduzca.setFont(new Font("Arial",0,15));
		volver.setFont(new Font("Arial",0,25));
		volver.setForeground(Color.BLUE);
		
		check1=new JCheckBox("Visbilidad");
        check1.setBounds(10,10,150,30);
        check1.setBackground(new Color(0,255,255));
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", titulo, 0, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", titulo, 0, "VerticalCenter", this);
		
		
		layout.putConstraint(SpringLayout.NORTH, boton, 40, SpringLayout.SOUTH, titulo);
	
		layout.putConstraint(SpringLayout.EAST, boton, 0, SpringLayout.EAST, titulo);
		
		layout.putConstraint(SpringLayout.SOUTH, introduzca, -40, SpringLayout.NORTH, titulo);
		
		layout.putConstraint(SpringLayout.WEST, introduzca, 0, SpringLayout.WEST, titulo);
		
layout.putConstraint(SpringLayout.NORTH, volver, 155, SpringLayout.SOUTH, boton);
		
		layout.putConstraint(SpringLayout.WEST, volver, 300, SpringLayout.EAST, boton);
		
layout.putConstraint(SpringLayout.WEST, check1, 0, SpringLayout.WEST, titulo);
		
		layout.putConstraint(SpringLayout.NORTH, check1, 0, SpringLayout.NORTH,boton);
		
		setBackground(new Color(0,255,255));
		
		add(check1);
		add(volver);
		add(boton);
		add(titulo);
		add(introduzca);
		
		
		
	}

	/**
	 * Funcion que deveulve el boton de crear un tema
	 * @return boton de crear tema
	 */
	public JButton getBoton() {
		return boton;
	}

	/**
	 * Funcion que deveulve el label de volver
	 * @return label de volver
	 */
	public JLabel getVolver() {
		return volver;
	}

	/**
	 * Funcion que devuelve el titulo del subtema
	 * @return titulo
	 */
	public JTextField getTitulo() {
		return titulo;
	}

	/**
	 * Funcion que deveulve el label de introduzca
	 * @return label de introduzca
	 */
	public JLabel getIntroduzca() {
		return introduzca;
	}

	/**
	 * Funcion que devuelve el checkBox de visibilidad
	 * @return checkbox de visibilidad
	 */
	public JCheckBox getCheck1() {
		return check1;
	}
	
	
	
}