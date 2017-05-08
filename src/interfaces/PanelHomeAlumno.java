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

public class PanelHomeAlumno extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelmisasignaturaas, logeadocomo, labeltodasasignaturas;
	private JList<String> todasasignaturas,listamisasignaturas;
	private JButton pedirmatricula;
	private DefaultListModel<String> model,modelo;
	JScrollPane barraDesplazamiento, barradesplazamiento2;
	
	
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
		barradesplazamiento2.setPreferredSize(new Dimension(500,400));
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
		layout.putConstraint(SpringLayout.EAST, labelmisasignaturaas, -150, SpringLayout.WEST, logeadocomo);
		
		layout.putConstraint(SpringLayout.NORTH, barradesplazamiento2, 25, SpringLayout.SOUTH, labelmisasignaturaas);
		layout.putConstraint(SpringLayout.WEST, barradesplazamiento2, 0, SpringLayout.WEST, labelmisasignaturaas);
		
		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento, 0, SpringLayout.NORTH, barradesplazamiento2);
		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento, 100, SpringLayout.EAST, barradesplazamiento2);
		
		layout.putConstraint(SpringLayout.SOUTH, labeltodasasignaturas, -25, SpringLayout.NORTH, listamisasignaturas);
		layout.putConstraint(SpringLayout.WEST, labeltodasasignaturas, 0, SpringLayout.WEST, barraDesplazamiento);
		
		
		layout.putConstraint(SpringLayout.NORTH, pedirmatricula, 0, SpringLayout.NORTH, barraDesplazamiento);
		layout.putConstraint(SpringLayout.WEST, pedirmatricula, 50, SpringLayout.EAST, barraDesplazamiento);
		
		add(logeadocomo);
		add(labelmisasignaturaas);
		add(barradesplazamiento2);
		add(labeltodasasignaturas);
		add(barraDesplazamiento);
		add(pedirmatricula);
		
		setBackground(new Color(0, 255, 255));
		setVisible(true);
		
	}

	public JList<String> getTodasasignaturas() {
		return todasasignaturas;
	}





	public JButton getPedirmatricula() {
		return pedirmatricula;
	}





	public DefaultListModel<String> getModel() {
		return model;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getLabelmisasignaturaas() {
		return labelmisasignaturaas;
	}

	public JLabel getLogeadocomo() {
		return logeadocomo;
	}

	public JLabel getLabeltodasasignaturas() {
		return labeltodasasignaturas;
	}

	public JList<String> getListamisasignaturas() {
		return listamisasignaturas;
	}

	public DefaultListModel<String> getModelo() {
		return modelo;
	}

	public JScrollPane getBarraDesplazamiento() {
		return barraDesplazamiento;
	}

	public JScrollPane getBarradesplazamiento2() {
		return barradesplazamiento2;
	}
	
	
	
	
	
	
	
	
}
