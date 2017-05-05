package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JComboBox<String> listamisasignaturas;
	private JLabel labelmisasignaturaas, logeadocomo, labeltodasasignaturas;
	private JList<String> todasasignaturas;
	private JButton pedirmatricula;
	private DefaultListModel<String> model,modelo;
	JScrollPane barraDesplazamiento ;
	
	
	public PanelHomeAlumno(){
		
		model = new DefaultListModel<String>();
		todasasignaturas = new JList<String>(model);
		
		todasasignaturas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		todasasignaturas.setFont(new Font("Arial", 0, 25));
		barraDesplazamiento = new JScrollPane(todasasignaturas); 
		barraDesplazamiento.setPreferredSize(new Dimension(500,400));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		
		pedirmatricula = new JButton("Solicitar");
		
		listamisasignaturas = new JComboBox<String>();
		listamisasignaturas.addItem("PAPAYA");
		
		
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
		
		layout.putConstraint(SpringLayout.NORTH, listamisasignaturas, 25, SpringLayout.SOUTH, labelmisasignaturaas);
		layout.putConstraint(SpringLayout.WEST, listamisasignaturas, 0, SpringLayout.WEST, labelmisasignaturaas);
		
		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento, 0, SpringLayout.NORTH, listamisasignaturas);
		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento, 100, SpringLayout.EAST, listamisasignaturas);
		
		layout.putConstraint(SpringLayout.SOUTH, labeltodasasignaturas, -25, SpringLayout.NORTH, listamisasignaturas);
		layout.putConstraint(SpringLayout.WEST, labeltodasasignaturas, 0, SpringLayout.WEST, barraDesplazamiento);
		
		
		layout.putConstraint(SpringLayout.NORTH, pedirmatricula, 0, SpringLayout.NORTH, barraDesplazamiento);
		layout.putConstraint(SpringLayout.WEST, pedirmatricula, 50, SpringLayout.EAST, barraDesplazamiento);
		
		add(logeadocomo);
		add(labelmisasignaturaas);
		add(listamisasignaturas);
		add(labeltodasasignaturas);
		add(barraDesplazamiento);
		add(pedirmatricula);
		
		setBackground(new Color(0, 255, 255));
		setVisible(true);
		
	}





	public JComboBox<String> getListamisasignaturas() {
		return listamisasignaturas;
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
	
	
	
	
	
}
