package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

/**
 * Módulo de la clase PanelHomeAlumno
 * 
 * @author Javier Senit y Carlos Marti
 *
 */
public class PanelHomeAlumno extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel labelmisasignaturaas, logeadocomo, labeltodasasignaturas;
	private JList<String> todasasignaturas,listamisasignaturas;
	private JButton pedirmatricula;
	private DefaultListModel<String> model,modelo;
	JScrollPane barraDesplazamiento, barradesplazamiento2;
	
	/**
	 * Constructor de la clase PanelHomeAlumno
	 */
	public PanelHomeAlumno(){
		
		model = new DefaultListModel<String>();
		todasasignaturas = new JList<String>(model);
		
		todasasignaturas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		todasasignaturas.setFont(new Font("Arial", 0, 25));
		barraDesplazamiento = new JScrollPane(todasasignaturas); 
		barraDesplazamiento.setPreferredSize(new Dimension(500,400));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		
		pedirmatricula = new JButton("Solicitar");
		
		modelo = new DefaultListModel<String>();
		listamisasignaturas = new JList<String>(modelo);
		
		listamisasignaturas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		listamisasignaturas.setFont(new Font("Arial", 0, 25));
		barradesplazamiento2 = new JScrollPane(listamisasignaturas); 
		barradesplazamiento2.setPreferredSize(new Dimension(300,300));
		barradesplazamiento2.getViewport().setBackground(Color.WHITE);
		
		
		
		labelmisasignaturaas = new JLabel("Mis asignaturas");
		labelmisasignaturaas.setFont(new Font("Arial",0,20));
		
		labeltodasasignaturas = new JLabel("Asignaturas disponibles para matricularse");
		labeltodasasignaturas.setFont(new Font("Arial",0,20));
		
		logeadocomo = new JLabel("Conectado como: ");
		logeadocomo.setFont(new Font("Arial",0,35));
		
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", logeadocomo, 0, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", logeadocomo, -250, "VerticalCenter", this);
		
		layout.putConstraint(SpringLayout.NORTH, labelmisasignaturaas, 25, SpringLayout.SOUTH, logeadocomo);
		layout.putConstraint(SpringLayout.EAST, labelmisasignaturaas, -200, SpringLayout.WEST, logeadocomo);
		
		layout.putConstraint(SpringLayout.NORTH, barradesplazamiento2, 25, SpringLayout.SOUTH, labelmisasignaturaas);
		layout.putConstraint(SpringLayout.WEST, barradesplazamiento2, 0, SpringLayout.WEST, labelmisasignaturaas);
		
		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento, 0, SpringLayout.NORTH, barradesplazamiento2);
		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento, 10, SpringLayout.EAST, barradesplazamiento2);
		
		layout.putConstraint(SpringLayout.SOUTH, labeltodasasignaturas, -25, SpringLayout.NORTH, listamisasignaturas);
		layout.putConstraint(SpringLayout.WEST, labeltodasasignaturas, 0, SpringLayout.WEST, barraDesplazamiento);
		
		
		layout.putConstraint(SpringLayout.NORTH, pedirmatricula, 10, SpringLayout.SOUTH, barraDesplazamiento);
		layout.putConstraint(SpringLayout.WEST, pedirmatricula, 0, SpringLayout.WEST, barraDesplazamiento);
		
		add(logeadocomo);
		add(labelmisasignaturaas);
		add(barradesplazamiento2);
		add(labeltodasasignaturas);
		add(barraDesplazamiento);
		add(pedirmatricula);
		
		setBackground(new Color(0, 255, 255));
		setVisible(true);
		
	}

	/**
	 * Funcion que devuelve todas las asignaturas de una lista
	 * @return todas las asignaturas de una lista
	 */
	public JList<String> getTodasasignaturas() {
		return todasasignaturas;
	}



	/**
	 * Funcion que devuelve el boton de pedir matricula
	 * @returnboton de pedir matricula
	 */

	public JButton getPedirmatricula() {
		return pedirmatricula;
	}




	/**
	 * Funcion que devuelve el modelo de una lista
	 * @return modelo de una lista
	 */
	public DefaultListModel<String> getModel() {
		return model;
	}


	/**
	 * Funcion que devuelve el label de asignaturas
	 * @return label de asignaturas
	 */
	public JLabel getLabelmisasignaturaas() {
		return labelmisasignaturaas;
	}

	/**
	 * Funcion que devuelve el label de logeadocomo
	 * @return label de logeadocomo
	 */
	public JLabel getLogeadocomo() {
		return logeadocomo;
	}

	/**
	 * Funcion que devuelve el label de todas las asignaturas
	 * @return label de todas las asignaturas
	 */
	public JLabel getLabeltodasasignaturas() {
		return labeltodasasignaturas;
	}

	/**
	 * Funcion que devuelve la lista de todas mis asignaturas
	 * @return lista de todas mis asignaturas
	 */
	public JList<String> getListamisasignaturas() {
		return listamisasignaturas;
	}

	/**
	 * Funcion que devuelve la el modelo de una lista
	 * @return modelo de una lista
	 */
	public DefaultListModel<String> getModelo() {
		return modelo;
	}

	/**
	 * Funcion que devuelve la lista scroll de asignaturaas disponibles
	 * @return lista scroll de asignaturas disponibles
	 */
	public JScrollPane getBarraDesplazamiento() {
		return barraDesplazamiento;
	}

	/**
	 * Funcion que devuelve la lista scroll de asignaturaas 
	 * @return lista scroll de asignaturas 
	 */
	public JScrollPane getBarradesplazamiento2() {
		return barradesplazamiento2;
	}
	
	
	
	
	
	
	
	
}
